
import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;
import java.lang.module.Configuration;
import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vidya
 */
public class CRUDOperation {
    Session session = null;
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    
    public Login getLoginDetails(Login l)
    {
        session = sessionFactory.openSession();
        session.beginTransaction();
        String UNAME = l.getUname();
        String UPASSWORD = l.getPassword();
        String SQL_QUERY = "From Login l where l.uname='" + UNAME + "' and l.password='" + UPASSWORD + "'";
        Query query = (Query) session.createQuery(SQL_QUERY);
        System.out.println("Query Result : "+query);
        for (Iterator it = query.iterate(); it.hasNext();) {
//            System.out.println(it.next());
            Login l1 = (Login) it.next();
            l.setUname(l1.getUname());
            l.setPassword(l1.getPassword());
            l.setValid(true);
        }
        return l;
    }
    
    public boolean signin(Login s){
        boolean result;
        session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            session.save(s);
            result = true;
        }catch(Exception e){
            result = false;
        }
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
