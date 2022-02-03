/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basket_acceso_datos_5;

import org.hibernate.Session;
import org.hibernate.Transaction;
import POJOS_origen.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dam
 */
public class OrigenDAO {

    private static ArrayList<Jugadores> jugadores = new ArrayList<Jugadores>();
    private static ArrayList<Equipos> equipos = new ArrayList<Equipos>();
    private static ArrayList<Partidos> partidos = new ArrayList<Partidos>();
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

    public static ArrayList<Jugadores> getJugadores() {
        return jugadores;
    }

    public static ArrayList<Equipos> getEquipos() {
        return equipos;
    }

    public static ArrayList<Partidos> getPartidos() {
        return partidos;
    }

}
