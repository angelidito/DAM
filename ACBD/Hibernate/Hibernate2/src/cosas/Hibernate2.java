/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosas;

import POJOs.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author dam
 */
public class Hibernate2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        Transaction tx = null;
        Session session;
        int id;

        session = NewHibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        for (int i = 0; i < 1000; i++) {
            id = (int) (Math.random() * 10000000);
            Juanes j = new Juanes(id);
            j.setN(id);
            session.save(j);
        }
        tx.commit();

        session.close();
    }

}
