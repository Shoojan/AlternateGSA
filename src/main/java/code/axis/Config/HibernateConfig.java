package code.axis.Config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"code.axis.DTO"})
@EnableTransactionManagement
public class HibernateConfig {

 /*   private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/Db2Excel";
    private final static String DATABASE_DRIVER	= "org.h2.Driver";
    private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
    private final static String DATABASE_USERNAME= "sa";
    private final static String DATABASE_PASSWORD= "";*/

//    private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/alternate_gsa_json";
    private final static String DATABASE_URL = "jdbc:mysql://138.197.105.156:3306/alternate_gsa_json";
    private final static String DATABASE_DRIVER	= "com.mysql.jdbc.Driver";
    private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
    private final static String DATABASE_USERNAME= "root";
//    private final static String DATABASE_PASSWORD= "12345";
    private final static String DATABASE_PASSWORD= "MegaPrime@1992";


    //dataSource bean will be available
    @Bean
    public DataSource getDataSource() {

        BasicDataSource dataSource = new BasicDataSource();

        //Providing the database connection information
        dataSource.setDriverClassName(DATABASE_DRIVER);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USERNAME);
        dataSource.setPassword(DATABASE_PASSWORD);

        return dataSource;

    }

    //sessionFactory bean will be available
    @Bean
    public SessionFactory getSessionFactory(DataSource dataSource) {

        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.addProperties(getHibernateProperties());
        sessionBuilder.scanPackages("code.axis.DTO");

        return sessionBuilder.buildSessionFactory();

    }

    //All the Hibernate properties will be returned.
    private Properties getHibernateProperties() {
        Properties properties = new Properties();

        properties.put("hibernate.dialect", DATABASE_DIALECT);
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");

        return properties;
    }


    //TransactionManager Bean
    @Bean
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }

}
