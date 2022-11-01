package Bid.util;



import Bid.Model.Bidactive;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Utility {
    static SessionFactory factory;
    public static SessionFactory getSessionFactory() {
        if(factory==null){
            Configuration cfg=new Configuration();
            cfg.addAnnotatedClass(Bidactive.class);
            cfg.configure("hibernet.cfg.xml");
            factory=cfg.buildSessionFactory();
        }
        return factory;
    }
}
