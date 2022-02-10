/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matise1;

import RAMABD.Obra;
import com.matisse.*;

/**
 *
 * @author dam
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public static void creaObjetos(String hostname, String dbname) {
        MtDatabase db;
        // Conectar
        try {
            db = conectarBD();
            db.open();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        // abrimos transaccion
        db.startTransaction();

        // inserta
        db.a //Muestra cantidad de obras
        System.out.println("\n"
            + Obra.getInstanceNumber(db)
            + "Obras en la base de datos");

        //Commit par aplicar los cambios de la transacción
        db.commit();

        // cerrar conexion
        db.close();
    }

    private static MtDatabase conectarBD() {
        MtDatabase db;

        db = new MtDatabase(
            "localhost",
            "RAMA",
            new MtPackageObjectFactory("", "biblioteca")
        );

        return db;
    }
}
