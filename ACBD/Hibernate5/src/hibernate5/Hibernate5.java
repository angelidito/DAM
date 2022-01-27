/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate5;

import POJOs.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author dam
 */
public class Hibernate5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        Transaction tx = null;
        Session session;
        
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        int id;
        id = (int) (Math.random() * 10000000);
        
        Progenitor p;
        p = new Progenitor();
        
       
        
        
        session.save(p);
        tx.commit();

        session.close();
    }

}
