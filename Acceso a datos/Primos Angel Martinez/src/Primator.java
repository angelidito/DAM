import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Primator {
	/**
	 * Ruta relativa del fichero donde se van a escribir los primos calculados
	 */
	private static String rutaArchivoPrimos = "primos.txt";
	/**
	 * Fichero que donde se escriben los primos calculados
	 */
	private static File archivoPrimos = new File(rutaArchivoPrimos);
	/**
	 * Lista de primos calculados
	 */
	private static ArrayList<Long> primos = new ArrayList<Long>();

	/**
	 * Para la entradad de datos por consola
	 */
	private static Scanner read;

	/**
	 * Programa principal.
	 * 
	 * Dispone de un menú con múltiples opciones.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		int op;

		updatePrimosFromFile();
		read = new Scanner(System.in);
		do {
			System.out.printf("%n%n¡Primator!%n%n" //
					+ "    Primos calculados: %d.%n" //
					+ "          Primo mayor: %s.%n%n" //
					+ "Escoja una opción:%n" //
					+ "\t  1. Calcular primos hasta un nº X%n" //
					+ "\t  2. Calcular los X primos siguientes%n" //
					+ "\t  3. Calcular primos durante X minutos%n" //
					+ "\t  4. Mostrar primos (atención, si hay muchos puede tardar)%n" //
					+ "\t  5. Tests velocidad%n" //
					+ "\t  6. Guardar%n" //
					+ "\t  0. Guardar y salir%n" //
					+ "\t -1. Salir sin guardar%n" //
					+ "\t-42. Borrar datos%n" //
					, primos.size(), primos.size() == 0 ? "NoData" : primos.get(primos.size() - 1).toString(),
					rutaArchivoPrimos);
			op = switchMenu();
		} while (op != 0 && op != -1);

	}

	/**
	 * Pide por teclado una opción y ejecuta el case corespondiente del switch.
	 * 
	 * @return La opción introducida por teclado
	 */
	private static int switchMenu() {
		int op;

		System.out.print("Mi opción: ");
		op = read.nextInt();
		switch (op) {
		case 1:
			System.out.printf("¿Hasta qué número quieres calcular los primos?%n");
			loadPrimesUntil(read.nextInt());
			break;
		case 2:
			System.out.printf("¿Cuántos primos más quieres calcular?%n");
			calcMorePrimes(read.nextInt());
			break;
		case 3: // case 3 ejecuta también case 6
			System.out.printf("¿Cuántos minutos quieres estar calculando nuevos primos?%n");
			calcMorePrimesFor(read.nextInt());
			// exportPrimes();
			break;
		case 6:
			System.out.printf("%nGuardando...%n");
			exportPrimes();
			System.out.println("\n¡Guardado!");
			break;
		case 4:
			for (Long primo : primos)
				System.out.print(primo + ", ");
			System.out.println();
			break;
		case 5:
			System.out.printf("%n¡TEST DE VELOCIDAD!%n%n¿Hasta qué número quieres calcular los primos?%n");
			testVelocidad(read.nextInt(), false);
			break;
		case -42:
			primos = new ArrayList<Long>();
			init();
			break;
		case 0: // Guardar
			System.out.printf("%nGuardando...%n");
			exportPrimes();
			System.out.println("\n¡Guardado!");
		case -1: // y salir
			System.out.printf("%n%nAdiós%n%n");
			read.close();
			break;
		default:
			System.out.printf("%nEscoja una opción entre las disponibles.%n");
			break;
		}
		return op;
	}

	/**
	 * Test de velocidad de dos algoritmos diferentes.
	 * 
	 * Imprime dos veces por consola los primos del 1 al primo más alto menor o
	 * igual que el parámetro n, si así se desea. Muestra también por consola el
	 * tiempo que ha tardado cada algoritmo en hacerlo.
	 * 
	 * @param n           Número hasta el que comprobar si son o no primos.
	 * @param printPrimes Si se desea mostrar los primos por consola o no.
	 */
	private static void testVelocidad(int n, boolean printPrimes) {

		String txt = "Eficiente: ";
		Date inicioEficiente;
		Date finEficiente;
		Date inicioIneficiente;
		Date finIneficiente;

		inicioEficiente = new Date();
		for (long i = 1; i <= n; i++) {

			if (isPrime(i)) {
				txt += i + ", ";
				if (i > primos.get(primos.size() - 1))
					primos.add(i);
			}
		}
		finEficiente = new Date();

		txt += "\nIneficiente: ";

		inicioIneficiente = new Date();
		for (long i = 1; i <= n; i++) {

			if (isPrimeIneficiente(i))
				txt += i + ", ";
		}
		finIneficiente = new Date();
		if (printPrimes)
			System.out.println(txt);
		System.out.println();

		System.out.println("Método eficiente.");
		System.out.println("        Inicio: " + inicioEficiente);
		System.out.println("           Fin: " + finEficiente);
		System.out.println("  Tiempo total: " + (finEficiente.getTime() - inicioEficiente.getTime()) + "ms");
		System.out.println("\nMétodo ineficiente.");
		System.out.println("        Inicio: " + inicioIneficiente);
		System.out.println("           Fin: " + finIneficiente);
		System.out.println("  Tiempo total: " + (finIneficiente.getTime() - inicioIneficiente.getTime()) + "ms");

	}

	/**
	 * Escribe los datos del arraylist de primos en un archivo.
	 * 
	 * La ruta del archivo se corresponde al atributo rutaArchivoPrimos de esta
	 * clase.
	 * 
	 * Imprime por pantalla le proceso, pero al ser tan rápido, no se aprecia el
	 * avance gradual.
	 * 
	 */
	private static void exportPrimes() {
		FileWriter primosWriter;
		try {
			archivoPrimos.createNewFile();
		} catch (IOException e) {
			System.err.printf("Error al crear el archivo %s", archivoPrimos.getAbsolutePath());
		}
		try {
			primosWriter = new FileWriter(archivoPrimos);

			String cadenaPrimos = "";
			int size = primos.size();
			int index = 0;

			int contador = 1;
			System.out.println("0%..............100%");
			primosWriter.write(cadenaPrimos);

			while (index < size) {
				primosWriter.append(primos.get(index++) + "\n");
				while ((0.05 * contador) <= (index / size)) {
					System.out.print("■");
					contador++;
				}
			}
			primosWriter.close();
			while (contador <= 20) {
				// System.out.print(contador);
				System.out.printf("■");
				contador++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Inicializa el arraylist de primos si no tiene los tres primeros.
	 */
	private static void init() {
		long aux = 1;
		if (primos.size() < 1)
			primos.add(aux);
		aux = 2;
		if (primos.size() < 2)
			primos.add(aux);
		aux = 3;
		if (primos.size() < 3)
			primos.add(aux);
	}

	/**
	 * Calcula primos durante los minutos especificados.
	 * 
	 * @param minutes Minutos durnate los que estar calculando primos.
	 */
	private static void calcMorePrimesFor(int minutes) {
		long prosiblePrimo = primos.get(primos.size() - 1) + 2;
		Date inicio = new Date();
		long horaBucleAnterior = inicio.getTime();
		long fin = inicio.getTime() + (minutes * 60 * 1000);
		System.out.println("Inicio: " + inicio);
		while (inicio.getTime() < fin) {
			if (isPrime(prosiblePrimo))
				primos.add(prosiblePrimo);
			prosiblePrimo += 2;
			if (horaBucleAnterior <= inicio.getTime() - 5000) {
				long minutosRestantes = (fin - inicio.getTime()) / 60000;
				long segundosRestantes = (fin - inicio.getTime()) / 1000 - minutosRestantes * 60;

				System.out.printf("%n%n\tTiempo restante: %d minutos y %d segundos%n" //
						+ "\t   Total primos: %d%n" //
						+ "\t    Mayor primo: %d" //
						, minutosRestantes, segundosRestantes, primos.size(), primos.get(primos.size() - 1));
				horaBucleAnterior = inicio.getTime();
			}
			inicio = new Date();
		}
		System.out.println("\nFin: " + new Date());
	}

	// private static void add(long primo, boolean appendToFile) {
	// primos.add(primo);
	// if (appendToFile && false) {
	// FileWriter primosWriter;
	// if (!archivoPrimos.exists())
	// try {
	// archivoPrimos.createNewFile();
	// } catch (IOException e) {
	// System.err.printf("Error al crear el archivo %s",
	// archivoPrimos.getAbsolutePath());
	// }
	// try {
	// primosWriter = new FileWriter(archivoPrimos);
	// primosWriter.append(primo + "\n");
	// primosWriter.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// }

	/**
	 * Calcula la cantidad de primos especificados. 
	 * 
	 * @param cantidad Cantidad de primos a calcular
	 */
	private static void calcMorePrimes(int cantidad) {
		int objetivo = cantidad + primos.size();
		long prosiblePrimo = primos.get(primos.size() - 1) + 2;
		Date inicio = new Date();
		long horaBucleAnterior = inicio.getTime();

		System.out.println("Inicio: " + inicio);

		while (primos.size() < objetivo) {
			if (isPrime(prosiblePrimo) && prosiblePrimo > primos.get(primos.size() - 1))
				primos.add(prosiblePrimo);
			prosiblePrimo += 2;
			if (horaBucleAnterior <= inicio.getTime() - 5000) {
				System.out.printf("%n%n\tPrimos por hallar: %d%n" //
						+ "\t     Total primos: %d%n" //
						+ "\t      Mayor primo: %d" //
						, //
						objetivo - primos.size(), //
						primos.size(), //
						primos.get(primos.size() - 1));
				horaBucleAnterior = inicio.getTime();
			}
			inicio = new Date();
		}
		System.out.println("\nFin: " + new Date());

	}

	/**
	 * Carga los datos del archivo de primos al arraylist.
	 */
	private static void updatePrimosFromFile() {
		if (!archivoPrimos.exists())
			return;
		try {
			FileReader primosReader = new FileReader(archivoPrimos);
			BufferedReader buff = new BufferedReader(primosReader);
			String linea;
			while ((linea = buff.readLine()) != null)
				primos.add(Long.parseLong(linea));
			buff.close();
			primosReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se ha cargado nada al arrayList ya que no existe el archivo fuente.");
		} catch (NumberFormatException e) {
			System.out.println("No se puede formatear el contenido del archivo a números.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Algo ha ido mal.");
			e.printStackTrace();
		}
		init();
	}

	/**
	 * Comprueba si un número es primo. 
	 * 
	 * Es la versión eficiente
	 * 
	 * @param n Número a comprobar
	 * @return boolean true si es primo; false si no lo es.
	 */
	public static boolean isPrime(long n) {
		if (n < 1)
			return false;
		if (n > 3) {
			int i = 1;
			while (i < primos.size() && primos.get(i) < n / 2)
				if (n % primos.get(i++) == 0)
					return false;
		}
		return true;
	}

	/**
	 * Calcula primos hasta el número especificado. 
	 * 
	 * @param n Número máximo a comprobar si es primo.
	 */
	private static void loadPrimesUntil(long n) {

		if (n >= 5) {
			// Por ejemplo, si el último es 3, empieza a probar el 5
			// Si es 131, empieza por el 15
			// De esta manera al calcular primos hasta, por ejemplo
			// el 1000 y luego el 2000, no hace dos veces el 5 al 1000.
			// Directamente empieza en el 997 + 2, o sea, el último primo+2
			long i = primos.get(primos.size() - 1) + 2;
			while (i <= n) {
				if (isPrime(i) && i > primos.get(primos.size() - 1))
					primos.add(i);
				i += 2;
			}
		}
	}

	/**
	 * Comprueba si un número es primo. 
	 * 
	 * Es la versión no tan eficiente
	 * 
	 * @param n Número a comprobar
	 * @return boolean true si es primo; false si no lo es.
	 */
	private static boolean isPrimeIneficiente(long n) {
		if (n < 1)
			return false;
		if (n < 3)
			return true;
		if (n % 2 == 0)
			return false;
		for (long i = 3; i < n / 2; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}
}
