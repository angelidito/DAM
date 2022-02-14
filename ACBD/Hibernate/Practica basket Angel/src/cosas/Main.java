/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosas;

import POJOs_basket_destino_hibernate.*;
import bd_basket_origen_JDBC.BasketOrigenDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author dam
 */
public class Main {

    private static ArrayList<Jugadores> jugadores = new ArrayList<Jugadores>();
    private static ArrayList<Equipos> equipos = new ArrayList<Equipos>();
    private static ArrayList<Partidos> partidos = new ArrayList<Partidos>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        BasketOrigenDAO origen;

        try {
            origen = new BasketOrigenDAO();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        equipos = origen.getEquipos();

        jugadores = origen.getJugadores(equipos);

//        for (Equipos equipo : equipos) {
//            System.out.printf("%s - %s\n%s\nPuntos: %s\n\n",
//                equipo.getIdEquipo(),
//                equipo.getNombreEquipo(),
//                equipo.getCiudad(),
//                equipo.getPuntos()
//            );
//        }
//        for (Jugadores j : jugadores) {
//            System.out.printf("%s - %s %s - %s\n\n\n",
//                j.getIdJugador(),
//                j.getNombre(),
//                j.getApellido(),
//                j.getEquipos().getNombreEquipo()
//            );
//        }

        System.out.println("LAS BASES DE DATOS SE LLAMAN basket_origen y basket_destino2");

        guardarDatos();



    }

    private static void guardarDatos() {
        Transaction tx;
        Session session;

        session = MyDestinoHibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        
        for (Equipos equipo : equipos) {
            session.save(equipo);
        }
        for (Jugadores jugador : jugadores) {
            session.save(jugador);
        }

        tx.commit();
        session.close();
    }

}
