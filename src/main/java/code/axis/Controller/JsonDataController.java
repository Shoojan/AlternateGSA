package code.axis.Controller;

import code.axis.DAO.alternate_gsa_dataDAO;
import code.axis.DTO.alternate_gsa_data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/json")
public class JsonDataController {

    @Autowired
    private alternate_gsa_dataDAO gsaDataDAO;

    @RequestMapping("/allGSAData")
    @ResponseBody
    public List<alternate_gsa_data> getgsaAllData(){
        return gsaDataDAO.listAllGSAData();
    }

}
