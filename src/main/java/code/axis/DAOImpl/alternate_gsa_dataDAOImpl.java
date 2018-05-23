package code.axis.DAOImpl;

import code.axis.DAO.alternate_gsa_dataDAO;
import code.axis.DTO.alternate_gsa_data;
import org.hibernate.SessionFactory;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository("alternate_gsa_dataDAO")
@Transactional
public class alternate_gsa_dataDAOImpl implements alternate_gsa_dataDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<alternate_gsa_data> listAllGSAData() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM alternate_gsa_data", alternate_gsa_data.class)
                .getResultList();
    }

    @Override
    public alternate_gsa_data getGSAdata(int id) {
        return sessionFactory
                .getCurrentSession()
                .get(alternate_gsa_data.class, Integer.valueOf(id));
    }

    @Override
    public boolean add(alternate_gsa_data gsaData) {
        try {
            sessionFactory.getCurrentSession().persist(gsaData);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(alternate_gsa_data gsaData) {
        try {
            sessionFactory.getCurrentSession().update(gsaData);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(alternate_gsa_data gsaData) {
        try {
            sessionFactory.getCurrentSession().delete(gsaData);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<String[]> getgsaNames() {
        AbstractEntityPersister aep = (
                (AbstractEntityPersister) sessionFactory
                        .getSessionFactory()
                        .getClassMetadata(alternate_gsa_data.class)
        );
        String[] properties = aep.getPropertyNames();
        List<String[]> columns = new ArrayList<String[]>();
        for (int nameIndex = 0; nameIndex != properties.length; nameIndex++) {
            System.out.println("Property name: " + properties[nameIndex]);
            String[] column = aep.getPropertyColumnNames(nameIndex);
            columns.add(column);
//            for(int columnIndex=0;columnIndex!=column.length;columnIndex++){
//                System.out.println("Column name: "+column[columnIndex]);
//            }
        }
        return columns;
    }

    public boolean MakeTesting() {

        try {

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
