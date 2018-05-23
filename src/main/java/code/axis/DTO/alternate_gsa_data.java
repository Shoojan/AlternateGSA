package code.axis.DTO;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class alternate_gsa_data {

    /**
     * Private fields
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "cat")
    private String cat;

    @Column(name = "contract_number_ct")
    private String contract_number_ct;

    @Column(name = "gsin")
    private String gsin;

    @Column(name = "product_name_itn")
    private String product_name_itn;

    @Column(name = "modified_date_mdt")
    private String modified_date_mdt;

    @Column(name = "manu_name_mfr")
    private String manu_name_mfr;

    @Column(name = "manu_name_mmfr")
    private String manu_name_mmfr;

    @Column(name = "manu_product_no_mmpno")
    private String manu_product_no_mmpno;

    @Column(name = "manu_product_no_mpno")
    private String manu_product_no_mpno;

    @Column(name = "product_desc_name")
    private String product_desc_name;

    @Column(name = "price_pr")
    private Double price_pr;

    @Column(name = "UNSPC")
    private String unspc;

    @Column(name = "UOM")
    private String uom;

    @Column(name = "USRC")
    private Double usrc;

    @Column(name = "vendor_name_vnd")
    private String vendor_name_vnd;

    @Column(name = "vendor_part_no_vpno")
    private String vendor_part_no_vpno;

    @Column(name = "cleaned_manu_prod_no_mmpno")
    private String cleaned_manu_prod_no_mmpno;

    @Column(name = "cleaned_manu_prod_no_mpno")
    private String cleaned_manu_prod_no_mpno;

    @Column(name = "cleaned_vendor_part_no")
    private String cleaned_vendor_part_no;

    @Column(name = "file_name")
    private String file_name;

    @Column(name = "added_on")
    private Timestamp added_on;

    /**
     * GETTER AND SETTER
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getContract_number_ct() {
        return contract_number_ct;
    }

    public void setContract_number_ct(String contract_number_ct) {
        this.contract_number_ct = contract_number_ct;
    }

    public String getGsin() {
        return gsin;
    }

    public void setGsin(String gsin) {
        this.gsin = gsin;
    }

    public String getProduct_name_itn() {
        return product_name_itn;
    }

    public void setProduct_name_itn(String product_name_itn) {
        this.product_name_itn = product_name_itn;
    }

    public String getModified_date_mdt() {
        return modified_date_mdt;
    }

    public void setModified_date_mdt(String modified_date_mdt) {
        this.modified_date_mdt = modified_date_mdt;
    }

    public String getManu_name_mfr() {
        return manu_name_mfr;
    }

    public void setManu_name_mfr(String manu_name_mfr) {
        this.manu_name_mfr = manu_name_mfr;
    }

    public String getManu_name_mmfr() {
        return manu_name_mmfr;
    }

    public void setManu_name_mmfr(String manu_name_mmfr) {
        this.manu_name_mmfr = manu_name_mmfr;
    }

    public String getManu_product_no_mmpno() {
        return manu_product_no_mmpno;
    }

    public void setManu_product_no_mmpno(String manu_product_no_mmpno) {
        this.manu_product_no_mmpno = manu_product_no_mmpno;
    }

    public String getManu_product_no_mpno() {
        return manu_product_no_mpno;
    }

    public void setManu_product_no_mpno(String manu_product_no_mpno) {
        this.manu_product_no_mpno = manu_product_no_mpno;
    }

    public String getProduct_desc_name() {
        return product_desc_name;
    }

    public void setProduct_desc_name(String product_desc_name) {
        this.product_desc_name = product_desc_name;
    }

    public Double getPrice_pr() {
        return price_pr;
    }

    public void setPrice_pr(Double price_pr) {
        this.price_pr = price_pr;
    }

    public String getUNSPC() {
        return unspc;
    }

    public void setUNSPC(String UNSPC) {
        this.unspc = UNSPC;
    }

    public String getUOM() {
        return uom;
    }

    public void setUOM(String UOM) {
        this.uom = UOM;
    }

    public Double getUSRC() {
        return usrc;
    }

    public void setUSRC(Double USRC) {
        this.usrc = USRC;
    }

    public String getVendor_name_vnd() {
        return vendor_name_vnd;
    }

    public void setVendor_name_vnd(String vendor_name_vnd) {
        this.vendor_name_vnd = vendor_name_vnd;
    }

    public String getVendor_part_no_vpno() {
        return vendor_part_no_vpno;
    }

    public void setVendor_part_no_vpno(String vendor_part_no_vpno) {
        this.vendor_part_no_vpno = vendor_part_no_vpno;
    }

    public String getCleaned_manu_prod_no_mmpno() {
        return cleaned_manu_prod_no_mmpno;
    }

    public void setCleaned_manu_prod_no_mmpno(String cleaned_manu_prod_no_mmpno) {
        this.cleaned_manu_prod_no_mmpno = cleaned_manu_prod_no_mmpno;
    }

    public String getCleaned_manu_prod_no_mpno() {
        return cleaned_manu_prod_no_mpno;
    }

    public void setCleaned_manu_prod_no_mpno(String cleaned_manu_prod_no_mpno) {
        this.cleaned_manu_prod_no_mpno = cleaned_manu_prod_no_mpno;
    }

    public String getCleaned_vendor_part_no() {
        return cleaned_vendor_part_no;
    }

    public void setCleaned_vendor_part_no(String cleaned_vendor_part_no) {
        this.cleaned_vendor_part_no = cleaned_vendor_part_no;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public Timestamp getAdded_on() {
        return added_on;
    }

    public void setAdded_on(Timestamp added_on) {
        this.added_on = added_on;
    }

    @Override
    public String toString() {
        return "alternate_gsa_data{" +
                "id=" + id +
                ", cat='" + cat + '\'' +
                ", contract_number_ct='" + contract_number_ct + '\'' +
                ", gsin='" + gsin + '\'' +
                ", product_name_itn='" + product_name_itn + '\'' +
                ", modified_date_mdt='" + modified_date_mdt + '\'' +
                ", manu_name_mfr='" + manu_name_mfr + '\'' +
                ", manu_name_mmfr='" + manu_name_mmfr + '\'' +
                ", manu_product_no_mmpno='" + manu_product_no_mmpno + '\'' +
                ", manu_product_no_mpno='" + manu_product_no_mpno + '\'' +
                ", product_desc_name='" + product_desc_name + '\'' +
                ", price_pr=" + price_pr +
                ", UNSPC='" + unspc + '\'' +
                ", UOM='" + uom + '\'' +
                ", USRC=" + usrc +
                ", vendor_name_vnd='" + vendor_name_vnd + '\'' +
                ", vendor_part_no_vpno='" + vendor_part_no_vpno + '\'' +
                ", cleaned_manu_prod_no_mmpno='" + cleaned_manu_prod_no_mmpno + '\'' +
                ", cleaned_manu_prod_no_mpno='" + cleaned_manu_prod_no_mpno + '\'' +
                ", cleaned_vendor_part_no='" + cleaned_vendor_part_no + '\'' +
                ", file_name='" + file_name + '\'' +
                ", added_on=" + added_on +
                '}';
    }
}
