package code.axis.Controller;

import code.axis.DAO.alternate_gsa_dataDAO;
import code.axis.POI.POIImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @Autowired
    private alternate_gsa_dataDAO gsaDataDAO;

    @Autowired
    private POIImpl poi;

    @RequestMapping(value = {"/", "/index", "/home"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("mainPage");
        mv.addObject("gsaData",gsaDataDAO.listAllGSAData());
        mv.addObject("ColumnNames",gsaDataDAO.getgsaNames());
        return mv;
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public ModelAndView action(@RequestParam(value = "sheet_name",required = false) String sheetname) {
        if (sheetname.isEmpty()) {
            sheetname = "defaultSheet";
        }
        poi.saveToSheet(gsaDataDAO.listAllGSAData(), sheetname);
        return index();
    }
}
