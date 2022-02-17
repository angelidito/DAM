/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package angelmartinezejercicio2;

import JDBC.ParejasDAO;
import PAREJAS.Hombre;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ParejasDAO origen;

        try {

            origen = new ParejasDAO();

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        // LEER con JDBC lee
        ArrayList<Hombre> hombres = origen.getAndSaveHombres();

        origen.getAndSaveMujeres(hombres);
    }

}
