package basket_acceso_datos;

import POJOs_origen.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author angelidito
 */
public class Main {
    
    private ArrayList<Jugadores> jugadores = new ArrayList<Jugadores>();
    private ArrayList<Equipos> equipos = new ArrayList<Equipos>();
    private ArrayList<Partidos> partidos = new ArrayList<Partidos>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        
        
    }
    
    public static void leerJugadores(){
        
    }

}
