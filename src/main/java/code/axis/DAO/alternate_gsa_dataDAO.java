package code.axis.DAO;

import code.axis.DTO.alternate_gsa_data;

import java.util.List;

public interface alternate_gsa_dataDAO {

    List<alternate_gsa_data> listAllGSAData();
    alternate_gsa_data getGSAdata(int id);
    boolean add(alternate_gsa_data gsaData);
    boolean update(alternate_gsa_data gsaData);
    boolean delete(alternate_gsa_data gsaData);
    List<String[]> getgsaNames();
    boolean MakeTesting();

}
