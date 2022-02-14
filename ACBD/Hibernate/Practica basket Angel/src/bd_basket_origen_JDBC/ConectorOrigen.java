package bd_basket_origen_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam
 */
public class ConectorOrigen {

    private Connection conexion;

    private int registrarDriver() {
        int resultado;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            resultado = 0;
        } catch (ClassNotFoundException ex) {
            resultado = -1;
        }
        return resultado;
    }

    private int conectar(String url, String user, String password) {
        int resultado;
        try {
            conexion = DriverManager.getConnection(url, user, password);
            resultado = 0;
        } catch (SQLException ex) {
            Logger.getLogger(ConectorOrigen.class.getName()).log(Level.SEVERE, null, ex);
            resultado = -2;
        }
        return resultado;
    }

    //compruebo si tengo el driver, si lo tengo se conecta, si no no.
    public int establecer(String url, String user, String password) {
        int resultado;
        resultado = registrarDriver();
        if (resultado != -1) {
            resultado = conectar(url, user, password);
        }
        return resultado;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrarBase() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectorOrigen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
