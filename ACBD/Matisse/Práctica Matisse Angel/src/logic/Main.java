package logic;

import com.matisse.MtDatabase;
import com.matisse.MtObjectIterator;
import com.matisse.MtPackageObjectFactory;
import inmobiliaria.Cliente;
import inmobiliaria.Ventana;
import inmobiliaria.Vivienda;
import inmobiliaria.Zona;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Mori
 */
public class Main {

	private static MtDatabase mtDB;
	private static Random random = new Random();

	public static void main(String[] args) {

		// ESTO EJECUTARLO SOLO 1 VEZ SI LA BASE DE DATOS ESTA VACIA
		// /*
		crearDatosDB();
		System.out.println("_____________________________");
		// */

		// // ESTO ES LA PRACTICA EN SI
		// calcularPrecios();
		// System.out.println("_____________________________");
		// calcularLuminosidad();
		// System.out.println("_____________________________");
		// calcularAislamiento();
		// System.out.println("_____________________________");
		// calcularMediaPorZona();
		// System.out.println("_____________________________");
		// calcularPorcentajeDescuento("111111111A", "Calle 1", 1, "A");
		// calcularPorcentajeDescuento("444444444A", "Calle 1", 1, "A");
	}

	private static void openAndStartTransaction() {
		mtDB = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
		mtDB.open();
		mtDB.startTransaction();
	}

	private static void commitAndClose() {
		mtDB.commit();
		mtDB.close();
	}

	private static void crearDatosDB() {
		Zona[] zonas = añadirZonas();
		System.out.println("Zonas añadidas");

		añadirVentanas();
		System.out.println("Ventanas añadidas");

		Vivienda[][] viviendas = añadirViviendas();
		System.out.println("Viviendas añadidas");

		setEstaEn(zonas, viviendas);

		// Crear clientes
		Cliente[] clientes = {
				crearCliente("111111111A", "Mori", "M"),
				crearCliente("555555555K", "Elde", "Enmedio"),
				crearCliente("000000000Z", "Gui", "llermo")
		};

		setQuiereComprar(clientes, viviendas);

		System.out.println("Clientes de ejemplo creados!");
	}

	private static void setEstaEn(Zona[] zonas, Vivienda[][] viviendas) {
		try {
			mtDB = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
			mtDB.open();
			mtDB.startTransaction();

			for (int i = 0; i < viviendas.length; i++)
				for (int j = 0; j < viviendas[i].length; j++)
					viviendas[i][j].setEstaEn(zonas[i]);

			mtDB.commit();
			mtDB.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void setQuiereComprar(Cliente[] clientes, Vivienda[][] viviendas) {
		Vivienda[][] viviendasClientes = {
				{
						viviendas[0][0],
						viviendas[1][1],
						viviendas[2][4],
						viviendas[0][3]
				},
				{
						viviendas[2][5],
						viviendas[2][4],
						viviendas[1][3],
						viviendas[0][3]
				},
				{
						viviendas[1][1],
						viviendas[1][5],
						viviendas[0][4],
						viviendas[0][3]
				}
		};

		try {
			mtDB = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
			mtDB.open();
			mtDB.startTransaction();

			for (int i = 0; i < clientes.length; i++)
				clientes[i].setQuiereComprar(viviendasClientes[i]);

			mtDB.commit();
			mtDB.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Zona[] añadirZonas() {
		Zona[] zonas = {
				añadirZona("Zona 1", 100, -5),
				añadirZona("Zona 2", 50, 1),
				añadirZona("Zona 3", 10, 4)
		};
		return zonas;
	}

	/**
	 * 
	 * @return Array 3x6
	 */
	private static Vivienda[][] añadirViviendas() {
		Vivienda[][] viviendas = {
				{
						añadirVivienda(1, "A", 250, "Calle 1", "Zona 1"),
						añadirVivienda(1, "B", 275, "Calle 1", "Zona 1"),
						añadirVivienda(1, "C", 225, "Calle 1", "Zona 1"),
						añadirVivienda(2, "A", 250, "Calle 1", "Zona 1"),
						añadirVivienda(2, "B", 275, "Calle 1", "Zona 1"),
						añadirVivienda(2, "C", 225, "Calle 1", "Zona 1")
				},
				{
						añadirVivienda(1, "A", 150, "Calle 2", "Zona 2"),
						añadirVivienda(1, "B", 175, "Calle 2", "Zona 2"),
						añadirVivienda(1, "C", 125, "Calle 2", "Zona 2"),
						añadirVivienda(2, "A", 150, "Calle 2", "Zona 2"),
						añadirVivienda(2, "B", 175, "Calle 2", "Zona 2"),
						añadirVivienda(2, "C", 125, "Calle 2", "Zona 2")
				},
				{
						añadirVivienda(1, "A", 220, "Calle 3", "Zona 3"),
						añadirVivienda(1, "B", 225, "Calle 3", "Zona 3"),
						añadirVivienda(1, "C", 250, "Calle 3", "Zona 3"),
						añadirVivienda(2, "A", 220, "Calle 3", "Zona 3"),
						añadirVivienda(2, "B", 225, "Calle 3", "Zona 3"),
						añadirVivienda(2, "C", 250, "Calle 3", "Zona 3")
				}
		};
		return viviendas;
	}

	private static void añadirVentanas() {
		añadirVentana(2, "N", true);
		añadirVentana(3, "S", false);
		añadirVentana(5, "E", true);
		añadirVentana(1, "W", false);
		añadirVentana(5, "N", true);
		añadirVentana(3, "S", false);
		añadirVentana(2, "E", true);
		añadirVentana(4, "W", false);
		añadirVentana(1, "N", true);
		añadirVentana(2, "S", false);
		añadirVentana(6, "E", true);
		añadirVentana(10, "W", false);
	}

	private static Zona añadirZona(String nombre, int valorMetro, int indiceRevalorizacion) {
		Zona zona = null;

		try {
			mtDB = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
			mtDB.open();
			mtDB.startTransaction();

			zona = new Zona(mtDB);
			zona.setNombre(nombre);
			zona.setValorMetro(valorMetro);
			zona.setIndiceRevalorizacion(indiceRevalorizacion);

			mtDB.commit();
			mtDB.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return zona;
	}

	private static void añadirVentana(int dimensiones, String orientacion, boolean climalite) {
		try {
			mtDB = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
			mtDB.open();
			mtDB.startTransaction();

			Ventana ventana = new Ventana(mtDB);
			ventana.setMetros(dimensiones);
			ventana.setOrientacion(orientacion);
			ventana.setClimalite(climalite);

			mtDB.commit();
			mtDB.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Vivienda añadirVivienda(int piso, String letra, int metros, String direccion, String nombreZona) {
		Vivienda vivienda = null;
		try {
			mtDB = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
			mtDB.open();
			mtDB.startTransaction();

			vivienda = new Vivienda(mtDB);
			vivienda.setPiso(piso);
			vivienda.setLetra(letra);
			vivienda.setMetros(metros);
			vivienda.setDireccion(direccion);

			// asignarZona(vivienda, nombreZona);

			asignarVentanas(vivienda);

			mtDB.commit();
			mtDB.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vivienda;
	}

	private static void asignarVentanas(Vivienda vivienda) {
		MtObjectIterator<Ventana> it = Ventana.<Ventana>instanceIterator(mtDB);
		ArrayList<Ventana> ventanas = new ArrayList<>();

		while (it.hasNext()) {
			Ventana ventana = it.next();
			if (random.nextBoolean())
				ventanas.add(ventana);
		}

		try {
			mtDB = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
			mtDB.open();
			mtDB.startTransaction();

			vivienda.setTieneVentana((Ventana[]) ventanas.toArray());

			mtDB.commit();
			mtDB.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// private static void asignarZona(Vivienda vivienda, String nombreZona) {
	// MtObjectIterator<Zona> it = Zona.<Zona>instanceIterator(mtDB);
	// boolean found = false;
	// Zona zona = null;
	// while (it.hasNext() && !found) {
	// zona = it.next();
	// if (nombreZona.equalsIgnoreCase(zona.getNombre()))
	// found = true;
	// }
	// if (zona != null)
	// vivienda.setEstaEn(zona);
	// else
	// System.out.println("Error en el método Main.asignarZona (?)");
	// }

	private static Cliente crearCliente(String dni, String nombre, String apellidos) {
		Cliente cliente = null;
		try {
			mtDB = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
			mtDB.open();
			mtDB.startTransaction();

			cliente = new Cliente(mtDB);
			cliente.setDNI(dni);
			cliente.setNombre(nombre);
			cliente.setApellidos(apellidos);

			mtDB.commit();
			mtDB.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cliente;
	}

	private static void clienteQuiereComprar(Cliente cliente, String direccion, int piso, String letra) {
		Vivienda[] vivs = new Vivienda[1];
		// Buscar zona ya añadidas
		MtObjectIterator<Vivienda> it = Vivienda.<Vivienda>instanceIterator(mtDB);
		boolean found = false;
		while (it.hasNext() && !found) {
			Vivienda[] vivsTemp = it.next(1);
			for (int i = 0; i < vivsTemp.length; i++) {
				if (vivsTemp[i].getDireccion().equals(cliente)
						&& vivsTemp[i].getPiso() == direccion
						&& vivsTemp[i].getLetra().equals(piso)) {
					vivs[0] = vivsTemp[i];
					found = true;
					i = vivsTemp.length;
				}
			}
		}
		// Asignar zona
		cliente.setQuiereComprar(vivs);
	}

	private static void calcularPrecios() {
		try {
			mtDB = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
			mtDB.open();
			mtDB.startTransaction();
			// Recorrer viviendas
			MtObjectIterator<Vivienda> it = Vivienda.<Vivienda>instanceIterator(mtDB);
			while (it.hasNext()) {
				Vivienda[] viviendas = it.next(1);
				for (int i = 0; i < viviendas.length; i++) {
					Vivienda vivienda = viviendas[i];
					System.out.println(vivienda + " cuesta " + vivienda.calcularPrecio() + " euros.");
				}
			}
			mtDB.commit();
			mtDB.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void calcularLuminosidad() {
		try {
			mtDB = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
			mtDB.open();
			mtDB.startTransaction();
			// Recorrer viviendas
			MtObjectIterator<Vivienda> it = Vivienda.<Vivienda>instanceIterator(mtDB);
			while (it.hasNext()) {
				Vivienda[] viviendas = it.next(1);
				for (int i = 0; i < viviendas.length; i++) {
					Vivienda vivienda = viviendas[i];
					System.out.println(vivienda + " tiene un indice de luminosidad: " + vivienda.calcularLuminosidad());
				}
			}
			mtDB.commit();
			mtDB.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void calcularAislamiento() {
		try {
			mtDB = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
			mtDB.open();
			mtDB.startTransaction();
			// Recorrer viviendas
			MtObjectIterator<Vivienda> it = Vivienda.<Vivienda>instanceIterator(mtDB);
			while (it.hasNext()) {
				Vivienda[] viviendas = it.next(1);
				for (int i = 0; i < viviendas.length; i++) {
					Vivienda vivienda = viviendas[i];
					System.out.println(
							vivienda + " tiene una peridad de aislamiento de: " + vivienda.calcularAislamiento());
				}
			}
			mtDB.commit();
			mtDB.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void calcularMediaPorZona() {
		try {
			mtDB = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
			mtDB.open();
			mtDB.startTransaction();
			// Recorrer viviendas
			MtObjectIterator<Zona> it = Zona.<Zona>instanceIterator(mtDB);
			while (it.hasNext()) {
				Zona[] zonas = it.next(1);
				for (int i = 0; i < zonas.length; i++) {
					Zona zona = zonas[i];
					System.out.println(
							"Media de la zona " + zona.getNombre() + ": " + zona.calcularMediaPorZona() + " euros");
				}
			}
			mtDB.commit();
			mtDB.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void calcularPorcentajeDescuento(String dni, String direccion, int piso, String letra) {
		try {
			mtDB = new MtDatabase("localhost", "inmobiliaria", new MtPackageObjectFactory("", "inmobiliaria"));
			mtDB.open();
			mtDB.startTransaction();
			// Recorrer viviendas
			Cliente cliente = null;
			MtObjectIterator<Cliente> it = Cliente.<Cliente>instanceIterator(mtDB);
			while (it.hasNext()) {
				Cliente[] clientes = it.next(1);
				for (int i = 0; i < clientes.length; i++) {
					if (clientes[i].getDNI().equals(dni)) {
						cliente = clientes[i];
						i = clientes.length;
					}
				}
			}
			//
			Vivienda vivienda = null;
			MtObjectIterator<Vivienda> iterV = Vivienda.<Vivienda>instanceIterator(mtDB);
			boolean found = false;
			while (iterV.hasNext() && !found) {
				Vivienda[] vivsTemp = iterV.next(1);
				for (int i = 0; i < vivsTemp.length; i++) {
					if (vivsTemp[i].getDireccion().equals(direccion)
							&& vivsTemp[i].getPiso() == piso
							&& vivsTemp[i].getLetra().equals(letra)) {
						vivienda = vivsTemp[i];
						found = true;
						i = vivsTemp.length;
					}
				}
			}

			System.out.println(cliente + " puede adquirir " + vivienda + " a un precio de "
					+ cliente.calcularDescuento(vivienda) + " euros");
			mtDB.commit();
			mtDB.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
