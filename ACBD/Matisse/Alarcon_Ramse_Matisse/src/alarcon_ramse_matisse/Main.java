/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarcon_ramse_matisse;

import com.matisse.MtDatabase;
import com.matisse.MtObjectIterator;
import com.matisse.MtPackageObjectFactory;
import inmobiliaria.Cliente;
import inmobiliaria.Ventana;
import inmobiliaria.Vivienda;
import inmobiliaria.Zona;
import java.util.ArrayList;

/**
 *
 * @author alumnoDAM
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ESTO EJECUTARLO SOLO 1 VEZ SI LA BASE DE DATOS ESTA VACIA
        /*
        crearEjemplosViviendas();
        crearEjemplosClientes();
        System.out.println("_____________________________");
         */

        // ESTO ES LA PRACTICA EN SI
        calcularPrecios();
        System.out.println("_____________________________");
        calcularLuminosidad();
        System.out.println("_____________________________");
        calcularAislamiento();
        System.out.println("_____________________________");
        calcularMediaPorZona();
        System.out.println("_____________________________");
        calcularPorcentajeDescuento("123456789A", "Avda. Cantabria 124", 1, "A");
        calcularPorcentajeDescuento("123456789E", "Avda. Cantabria 124", 1, "A");
    }

    private static void crearEjemplosViviendas() {
        // Crear zonas
        crearZona("Norte", 50, 1);
        crearZona("Sur", 20, 2);
        crearZona("Este", 30, 3);
        crearZona("Oeste", 25, 4);
        System.out.println("Zonas de ejemplo creadas!");

        // Crear ventanas
        crearVentana(2, "Norte", true);
        crearVentana(3, "Sur", false);
        crearVentana(5, "Este", true);
        crearVentana(1, "Oeste", false);
        System.out.println("Ventanas de ejemplo creadas!");

        // Crear viviendas y asignar zonas
        crearVivienda(1, "A", 250, "Avda. Cantabria 124", "Norte");
        crearVivienda(1, "B", 275, "Avda. Cantabria 124", "Norte");
        crearVivienda(1, "C", 225, "Avda. Cantabria 124", "Norte");

        crearVivienda(2, "A", 250, "Avda. Cantabria 124", "Norte");
        crearVivienda(2, "B", 275, "Avda. Cantabria 124", "Norte");
        crearVivienda(2, "C", 225, "Avda. Cantabria 124", "Norte");

        crearVivienda(3, "A", 250, "Avda. Cantabria 124", "Norte");
        crearVivienda(3, "B", 275, "Avda. Cantabria 124", "Norte");
        crearVivienda(3, "C", 225, "Avda. Cantabria 124", "Norte");

        crearVivienda(1, "A", 150, "Calle Vitoria 192", "Sur");
        crearVivienda(1, "B", 175, "Calle Vitoria 192", "Sur");
        crearVivienda(1, "C", 125, "Calle Vitoria 192", "Sur");

        crearVivienda(2, "A", 150, "Calle Vitoria 192", "Sur");
        crearVivienda(2, "B", 175, "Calle Vitoria 192", "Sur");
        crearVivienda(2, "C", 125, "Calle Vitoria 192", "Sur");

        crearVivienda(3, "A", 150, "Calle Vitoria 192", "Sur");
        crearVivienda(3, "B", 175, "Calle Vitoria 192", "Sur");
        crearVivienda(3, "C", 125, "Calle Vitoria 192", "Sur");

        crearVivienda(1, "A", 220, "Calle Madrid 124", "Este");
        crearVivienda(1, "B", 225, "Calle Madrid 124", "Este");
        crearVivienda(1, "C", 250, "Calle Madrid 124", "Este");

        crearVivienda(2, "A", 220, "Calle Madrid 124", "Este");
        crearVivienda(2, "B", 225, "Calle Madrid 124", "Este");
        crearVivienda(2, "C", 250, "Calle Madrid 124", "Este");

        crearVivienda(3, "A", 220, "Calle Madrid 124", "Este");
        crearVivienda(3, "B", 225, "Calle Madrid 124", "Este");
        crearVivienda(3, "C", 250, "Calle Madrid 124", "Este");

        crearVivienda(1, "A", 220, "Fuentecillas 12", "Oeste");
        crearVivienda(1, "B", 225, "Fuentecillas 12", "Oeste");
        crearVivienda(1, "C", 250, "Fuentecillas 12", "Oeste");

        crearVivienda(2, "A", 220, "Fuentecillas 12", "Oeste");
        crearVivienda(2, "B", 225, "Fuentecillas 12", "Oeste");
        crearVivienda(2, "C", 250, "Fuentecillas 12", "Oeste");

        crearVivienda(3, "A", 220, "Fuentecillas 12", "Oeste");
        crearVivienda(3, "B", 225, "Fuentecillas 12", "Oeste");
        crearVivienda(3, "C", 250, "Fuentecillas 12", "Oeste");
        System.out.println("Viviendas de ejemplo creadas!");
    }

    private static void crearEjemplosClientes() {
        // Crear clientes
        crearCliente("123456789A", "Jorge", "Lopez", 1, "Avda. Cantabria 124", 1, "A");
        crearCliente("123456789B", "Mario", "Lopez", 1, "Fuentecillas 12", 2, "B");
        crearCliente("123456789C", "Sergio", "Lopez", 1, "Calle Vitoria 192", 3, "C");
        crearCliente("123456789D", "Oscar", "Lopez", 0, "", 0, "");
        crearCliente("123456789E", "Samuel", "Lopez", 0, "", 0, "");
        crearCliente("123456789F", "Diego", "Lopez", 0, "", 0, "");
        System.out.println("Clientes de ejemplo creados!");
    }

    private static void crearZona(String nombre, int valor, int indiceValorizacion) {
        try {
            // Inicializa conexion
            MtDatabase db = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
            db.open();
            db.startTransaction();
            // Crear obras
            Zona zona = new Zona(db);
            zona.setNombre(nombre);
            zona.setValorxmetro(valor);
            zona.setIndicerevalorizacion(indiceValorizacion);
            // Finaliza conexion
            db.commit();
            db.close();
        } catch (Exception a) {
            a.printStackTrace();
        }
    }

    private static void crearVentana(int dimensiones, String orientacion, boolean climalite) {
        try {
            // Inicializa conexion
            MtDatabase db = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
            db.open();
            db.startTransaction();
            // Crear obras
            Ventana ventana = new Ventana(db);
            ventana.setDimensiones(dimensiones);
            ventana.setOrientacion(orientacion);
            ventana.setClimalite(climalite);
            // Finaliza conexion
            db.commit();
            db.close();
        } catch (Exception a) {
            a.printStackTrace();
        }
    }

    private static void crearVivienda(int piso, String letra, int metros, String direccion, String nombreZona) {
        try {
            // Inicializa conexion
            MtDatabase db = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
            db.open();
            db.startTransaction();
            // Crear vivienda
            Vivienda vi = new Vivienda(db);
            vi.setPiso(piso);
            vi.setLetra(letra);
            vi.setMetros(metros);
            vi.setDireccion(direccion);
            // Zona
            Zona[] zonas = new Zona[1];
            // Buscar zona ya creadas
            MtObjectIterator<Zona> iter = Zona.<Zona>instanceIterator(db);
            boolean encontrado = false;
            while (iter.hasNext() && !encontrado) {
                Zona[] zonasTemp = iter.next(1);
                for (int i = 0; i < zonasTemp.length; i++) {
                    if (nombreZona.equalsIgnoreCase(zonasTemp[i].getNombre())) {
                        zonas[0] = zonasTemp[i];
                        encontrado = true;
                        i = zonas.length;
                    }
                }
            }
            // Asignar zona
            vi.setSituadaen(zonas);
            // Ventana
            Ventana[] ventanas = new Ventana[4];
            // Buscar ventanas
            MtObjectIterator<Ventana> iterV = Ventana.<Ventana>instanceIterator(db);
            ArrayList<Ventana> ventanasAL = new ArrayList<>();
            while (iterV.hasNext()) {
                ventanasAL.add(iterV.next());
            }
            for (int i = 0; i < ventanasAL.size(); i++) {
                ventanas[i] = ventanasAL.get(i);
            }
            // Asignar ventanas
            vi.setTieneVentana(ventanas);
            // Finaliza conexion
            db.commit();
            db.close();
        } catch (Exception a) {
            a.printStackTrace();
        }
    }

    private static void crearCliente(String dni, String nombre, String apellidos, int ejemplo, String direccion, int piso, String letra) {
        try {
            // Inicializa conexion
            MtDatabase db = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
            db.open();
            db.startTransaction();
            // Crear obras
            Cliente cliente = new Cliente(db);
            cliente.setDni(dni);
            cliente.setNombre(nombre);
            cliente.setApellidos(apellidos);
            // Vivienda
            Vivienda[] vivs = new Vivienda[1];
            switch (ejemplo) {
                case 1:
                    // Buscar zona ya creadas
                    MtObjectIterator<Vivienda> iter = Vivienda.<Vivienda>instanceIterator(db);
                    boolean encontrado = false;
                    while (iter.hasNext() && !encontrado) {
                        Vivienda[] vivsTemp = iter.next(1);
                        for (int i = 0; i < vivsTemp.length; i++) {
                            if (vivsTemp[i].getDireccion().equals(direccion)
                                    && vivsTemp[i].getPiso() == piso
                                    && vivsTemp[i].getLetra().equals(letra)) {
                                vivs[0] = vivsTemp[i];
                                encontrado = true;
                                i = vivsTemp.length;
                            }
                        }
                    }
                    // Asignar zona
                    cliente.setTieneVivienda(vivs);
                    break;
            }
            // Finaliza conexion
            db.commit();
            db.close();
        } catch (Exception a) {
            a.printStackTrace();
        }
    }

    private static void calcularPrecios() {
        try {
            // Inicializa conexion
            MtDatabase db = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
            db.open();
            db.startTransaction();
            // Recorrer viviendas
            MtObjectIterator<Vivienda> iter = Vivienda.<Vivienda>instanceIterator(db);
            while (iter.hasNext()) {
                Vivienda[] viviendas = iter.next(1);
                for (int i = 0; i < viviendas.length; i++) {
                    Vivienda vivienda = viviendas[i];
                    System.out.println(vivienda + " cuesta " + vivienda.calcularPrecio() + " euros.");
                }
            }
            // Cerrar conexion
            db.commit();
            db.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void calcularLuminosidad() {
        try {
            // Inicializa conexion
            MtDatabase db = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
            db.open();
            db.startTransaction();
            // Recorrer viviendas
            MtObjectIterator<Vivienda> iter = Vivienda.<Vivienda>instanceIterator(db);
            while (iter.hasNext()) {
                Vivienda[] viviendas = iter.next(1);
                for (int i = 0; i < viviendas.length; i++) {
                    Vivienda vivienda = viviendas[i];
                    System.out.println(vivienda + " tiene un indice de luminosidad: " + vivienda.calcularLuminosidad());
                }
            }
            // Cerrar conexion
            db.commit();
            db.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void calcularAislamiento() {
        try {
            // Inicializa conexion
            MtDatabase db = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
            db.open();
            db.startTransaction();
            // Recorrer viviendas
            MtObjectIterator<Vivienda> iter = Vivienda.<Vivienda>instanceIterator(db);
            while (iter.hasNext()) {
                Vivienda[] viviendas = iter.next(1);
                for (int i = 0; i < viviendas.length; i++) {
                    Vivienda vivienda = viviendas[i];
                    System.out.println(vivienda + " tiene una peridad de aislamiento de: " + vivienda.calcularAislamiento());
                }
            }
            // Cerrar conexion
            db.commit();
            db.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void calcularMediaPorZona() {
        try {
            // Inicializa conexion
            MtDatabase db = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
            db.open();
            db.startTransaction();
            // Recorrer viviendas
            MtObjectIterator<Zona> iter = Zona.<Zona>instanceIterator(db);
            while (iter.hasNext()) {
                Zona[] zonas = iter.next(1);
                for (int i = 0; i < zonas.length; i++) {
                    Zona zona = zonas[i];
                    System.out.println("Media de la zona " + zona.getNombre() + ": " + zona.calcularMediaPorZona() + " euros");
                }
            }
            // Cerrar conexion
            db.commit();
            db.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void calcularPorcentajeDescuento(String dni, String direccion, int piso, String letra) {
        try {
            // Inicializa conexion
            MtDatabase db = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
            db.open();
            db.startTransaction();
            // Recorrer viviendas
            Cliente cliente = null;
            MtObjectIterator<Cliente> iter = Cliente.<Cliente>instanceIterator(db);
            while (iter.hasNext()) {
                Cliente[] clientes = iter.next(1);
                for (int i = 0; i < clientes.length; i++) {
                    if (clientes[i].getDni().equals(dni)) {
                        cliente = clientes[i];
                        i = clientes.length;
                    }
                }
            }
            //
            Vivienda vivienda = null;
            MtObjectIterator<Vivienda> iterV = Vivienda.<Vivienda>instanceIterator(db);
            boolean encontrado = false;
            while (iterV.hasNext() && !encontrado) {
                Vivienda[] vivsTemp = iterV.next(1);
                for (int i = 0; i < vivsTemp.length; i++) {
                    if (vivsTemp[i].getDireccion().equals(direccion)
                            && vivsTemp[i].getPiso() == piso
                            && vivsTemp[i].getLetra().equals(letra)) {
                        vivienda = vivsTemp[i];
                        encontrado = true;
                        i = vivsTemp.length;
                    }
                }
            }

            System.out.println(cliente + " puede adquirir " + vivienda + " a un precio de " + cliente.calcularDescuento(vivienda) + " euros");
            // Cerrar conexion
            db.commit();
            db.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
