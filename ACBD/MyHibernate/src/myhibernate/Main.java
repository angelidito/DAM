/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhibernate;

import POJOs.NewHibernateUtil;
import org.hibernate.Transaction;

/**
 *
 * @author dam
 */
public class Main {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {

        Transaction tx = null;
        Session session;
        
        session = NewHibernateUtil.getSessionFactory().openSession();
        
        tx = session.beginTransaction();
        
        Juanes j = new Juanes(123);
        
        session.save(j);
        tx.commit();
        session.close();
    }
    
}
