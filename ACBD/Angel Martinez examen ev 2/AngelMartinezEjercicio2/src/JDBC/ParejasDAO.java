package JDBC;

import PAREJAS.*;
import com.matisse.MtDatabase;
import com.matisse.MtPackageObjectFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam
 */
public class ParejasDAO {

    private static Connection conn = null;
    private static ConectorOrigen conector = null;
    private static final String URL = "jdbc:mysql://localhost:3306/mujeres_hombres_matisse?zeroDateTimeBehavior=convertToNull";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public ParejasDAO() throws Exception {

        if (conector == null) {
            conector = new ConectorOrigen();
        }
        try {
            if (conn == null || conn.isClosed()) {
                if (conector.establecer(URL, USER, PASSWORD) != -1) {
                    conn = conector.getConexion();
                } else {
                    throw new Exception("No se ha podido conectar con la base de datos.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParejasDAO.class.getName())
                .log(Level.SEVERE, null, ex);
            throw new Exception("Error contructor BasketDAO.");
        }

    }

    public ArrayList<Hombre> getAndSaveHombres() {
        ArrayList<Hombre> hombres;
        Hombre h;
        MtDatabase db;
        ResultSet rs;
        Statement sentencia;
        String selectAllFromHombre;

        hombres = new ArrayList<>();
        selectAllFromHombre = "select * from hombre";
        try {
            sentencia = conn.createStatement();
            rs = sentencia.executeQuery(selectAllFromHombre);

            // Inicializa conexion
            db = new MtDatabase("localhost", "PAREJAS", new MtPackageObjectFactory("", "PAREJAS"));
            db.open();
            db.startTransaction();
            while (rs.next()) {
                try {
//                    System.out.println("id:" + rs.getInt("id_hombre")
//                        + "; nombre "
//                        + rs.getString("nombre_hombre")
//                        + "; edad: "
//                        + rs.getInt("edad_hombre")
//                        + "; etc..."
//                    );

                    h = new Hombre(db);
                    h.setId_hombre(rs.getInt("id_hombre"));
                    h.setNombre_hombre(rs.getString("nombre_hombre"));
                    h.setEdad_hombre(rs.getInt("edad_hombre"));
                    h.setSalario(rs.getInt("salario"));
                    h.setNum_pagas(rs.getInt("num_pagas"));
                    h.setRetencion(rs.getInt("retencion"));

//                    System.out.println(h.getNombre_hombre());
                    hombres.add(h);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // Finaliza conexion
            db.commit();
            db.close();

            rs.close();
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(ParejasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hombres;
    }

    public ArrayList<Mujer> getAndSaveMujeres(ArrayList<Hombre> hombres) {
        ArrayList<Mujer> mujeres;
        Hombre marido;
        MtDatabase db;
        Mujer m;
        ResultSet rs;
        Statement sentencia;
        String selectAllFromHombre;

        mujeres = new ArrayList<>();
        selectAllFromHombre = "select * from mujer";
        try {
            sentencia = conn.createStatement();
            rs = sentencia.executeQuery(selectAllFromHombre);

            // Inicializa conexion
            db = new MtDatabase("localhost", "PAREJAS", new MtPackageObjectFactory("", "PAREJAS"));
            db.open();
            db.startTransaction();
            while (rs.next()) {
                try {
                    marido = getHombreWithId(rs.getInt("id_marido_fk"), hombres);
//                    System.out.println("id:" + rs.getInt("id_mujer")
//                        + "; nombre "
//                        + rs.getString("nombre_mujer")
//                        + "; edad: "
//                        + rs.getInt("edad_mujer")
//                    );
                    m = new Mujer(db);
                    m.setId_mujer(rs.getInt("id_mujer"));
                    m.setNombre_mujer(rs.getString("nombre_mujer"));
                    m.setEdad_mujer(rs.getInt("edad_mujer"));
                    if (marido != null) {
                        m.setTieneMarido(marido);
                    }

                    mujeres.add(m);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // Finaliza conexion
            db.commit();
            db.close();

            rs.close();
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(ParejasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mujeres;
    }

    private Hombre getHombreWithId(int id, ArrayList<Hombre> hombres) {
        for (int i = 0; i < hombres.size(); i++) {
            if (hombres.get(i).getId_hombre() == id) {
                return hombres.get(i);
            }
        }
        return null;
    }

}
