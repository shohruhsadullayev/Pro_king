package config;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {

    private static SessionFactory ourSessionFactory;

    static {
        openSession();
    }

    private static void openSession() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("config/hibernate.cfg.xml");
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        if (ourSessionFactory.isClosed()){
            openSession();
        }
        return ourSessionFactory.openSession();
    }

}