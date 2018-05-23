package code.axis.POI;

import code.axis.DTO.alternate_gsa_data;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class POIImpl {

    public void saveToSheet(List<alternate_gsa_data> gsaData, String sheetName) {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(sheetName);

        int rownum = 0;
        for (alternate_gsa_data singlegsaData : gsaData) {
//            System.out.println(rownum + " -> " + String.valueOf(singleData.getName()));
            Row row = sheet.createRow(rownum++);
            Object[] objArr = {
                    singlegsaData.getId(),
                    singlegsaData.getCat(),
                    singlegsaData.getContract_number_ct(),
                    singlegsaData.getGsin(),
                    singlegsaData.getProduct_name_itn(),
                    singlegsaData.getModified_date_mdt(),
                    singlegsaData.getManu_name_mfr(),
                    singlegsaData.getManu_name_mmfr(),
                    singlegsaData.getManu_product_no_mmpno(),
                    singlegsaData.getManu_product_no_mpno(),
                    singlegsaData.getProduct_desc_name(),
                    singlegsaData.getPrice_pr(),
                    singlegsaData.getUNSPC(),
                    singlegsaData.getUOM(),
                    singlegsaData.getUSRC(),
                    singlegsaData.getVendor_name_vnd(),
                    singlegsaData.getVendor_part_no_vpno(),
                    singlegsaData.getCleaned_manu_prod_no_mmpno(),
                    singlegsaData.getCleaned_manu_prod_no_mpno(),
                    singlegsaData.getCleaned_vendor_part_no(),
                    singlegsaData.getFile_name(),
                    singlegsaData.getAdded_on()};
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof Date)
                    cell.setCellValue((Date) obj);
                else if (obj instanceof Boolean)
                    cell.setCellValue((Boolean) obj);
                else if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Double)
                    cell.setCellValue((Double) obj);
            }
        }

        try {
            FileOutputStream out = new FileOutputStream(new File("D:\\Java\\DatabaseToExcelProject\\Output\\"+sheetName+".xls"));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully...");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
