/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd_basket_origen_JDBC;

import POJOs_basket_destino_hibernate.*;
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
public class BasketOrigenDAO {

    private static Connection conn = null;
    private static ConectorOrigen conector = null;
    private static final String URL = "jdbc:mysql://localhost:3306/basket_origen?zeroDateTimeBehavior=convertToNull";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public BasketOrigenDAO() throws Exception {

        if (conector == null) {
            conector = new ConectorOrigen();
        }
        try {
            if (conn == null || conn.isClosed()) {
                if (conector.establecer(URL, USER, PASSWORD) != -1) {
                    conn = conector.getConexion();
                } else {
                    throw new Exception(
                        "No se ha podido conectar con la base de datos."
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BasketOrigenDAO.class.getName())
                .log(Level.SEVERE, null, ex);
            throw new Exception("Error contructor BasketDAO.");
        }

    }

    public ArrayList<Equipos> getEquipos() {
        ArrayList<Equipos> equipos;
        String selectAllFromEquipos;
        Statement sentencia;
        Equipos equipo;
        ResultSet rs;

        equipos = new ArrayList<>();
        selectAllFromEquipos = "select * from equipos";
        try {
            sentencia = conn.createStatement();
            rs = sentencia.executeQuery(selectAllFromEquipos);
            while (rs.next()) {
                equipo = new Equipos();
                equipo.setIdEquipo(rs.getInt("id_equipo"));
                equipo.setNombreEquipo(rs.getString("nombre_equipo"));
                equipo.setCiudad(rs.getString("ciudad"));
                equipo.setWeb(rs.getString("web"));
                equipo.setPuntos(rs.getInt("puntos"));
                equipos.add(equipo);
            }
            rs.close();
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(BasketOrigenDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return equipos;
    }

    public ArrayList<Jugadores> getJugadores(ArrayList<Equipos> equipos) {
        ArrayList<Jugadores> jugadores;
        String selectAllFromJugadores;
        Statement sentencia;
        Jugadores jugador;
        Equipos equipo;
        ResultSet rs;

        jugadores = new ArrayList<>();
        selectAllFromJugadores = "select * from jugadores";

        try {
            sentencia = conn.createStatement();
            rs = sentencia.executeQuery(selectAllFromJugadores);

            while (rs.next()) {
                equipo = getEquipoWithId(rs.getInt("num_equipo"), equipos);
                jugador = new Jugadores();
                jugador.setIdJugador(rs.getInt("id_jugador"));
                jugador.setNombre(rs.getString("nombre"));
                jugador.setApellido(rs.getString("apellido"));
                jugador.setPuesto(rs.getString("puesto"));
                jugador.setFechaAlta(rs.getDate("fecha_alta"));
                jugador.setSalario(rs.getInt("salario"));
                jugador.setEquipos(equipo);
                jugador.setAltura(rs.getInt("altura"));

                jugadores.add(jugador);
                equipo.getJugadoreses().add(jugador);
            }
            rs.close();
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(BasketOrigenDAO.class.getName())
                .log(Level.SEVERE, null, ex);
        }

        return jugadores;
    }

    private Equipos getEquipoWithId(int num_equipo, ArrayList<Equipos> equipos) {
        for (Equipos e : equipos) {
            if (e.getIdEquipo() == num_equipo) {
                return e;
            }
        }
        return null;

    }
}
