/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosas;

import org.hibernate.Session;
import org.hibernate.Transaction;
import POJOs_basket_angel.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dam
 */
public class OrigenDAO {

    private static Transaction tx = null;
    private static Session session;

    public OrigenDAO() throws SQLException {
        openSession();
        //Connection cn = DriverManager.getConnection("jdbc:mysql://servidor_bd:puerto/nombre_bd", "usuario", "contraseña");
        Connection cn;
        cn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/basket_acceso_datos",
            "root",
            "root"
        );
    }

    private void openSession() {
        session = OrigenHibernateUtil.getSessionFactory().openSession();
    }

    public void closeSession() {
        session.close();
    }

}
