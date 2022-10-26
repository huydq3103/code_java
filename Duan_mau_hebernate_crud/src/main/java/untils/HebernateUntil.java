/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package untils;

import domainModel.ChiTietSP;
import domainModel.NSX;
import domainModel.SanPham;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


public class HebernateUntil {

    public static final String HOSTNAME = "localhost";
    public static final String PORT = "1433";
    public static final String DBNAME = "duanmau_2bernate";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "123456";
    private static  SessionFactory FACTORY;

    static {
        try {
            String connectionUrl = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";"
                    + "databaseName=" + DBNAME;
            Configuration conf = new Configuration();

            Properties pros = new Properties();
            pros.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
            pros.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            pros.put(Environment.URL, connectionUrl);
            pros.put(Environment.USER, USERNAME);
            pros.put(Environment.PASS, PASSWORD);
            pros.put(Environment.SHOW_SQL, "true");

            // tao ket noi den db
            conf.setProperties(pros);
            conf.addAnnotatedClass(ChiTietSP.class);// cac mapping voi bang lop
            conf.addAnnotatedClass(SanPham.class);
            conf.addAnnotatedClass(NSX.class);
         
            ServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .applySettings(conf.getProperties()).build();
            FACTORY = conf.buildSessionFactory(registry);
        } catch (Exception e) {
            e.getMessage();
        }

    }

    public static SessionFactory getsSessionFactory() {
        return FACTORY;
    }

    public static void main(String[] args) {
        getsSessionFactory();

    }

}
