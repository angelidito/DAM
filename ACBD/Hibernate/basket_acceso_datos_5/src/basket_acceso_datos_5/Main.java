/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basket_acceso_datos_5;

import POJOS_origen.*;
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
        

    }

}
