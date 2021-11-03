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
					+ "\t  6. Comprobar si un nº es primo%n" //
					+ "\t  7. Guardar%n" //
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
			// break;
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
			testVelocidad(read.nextInt());
			break;
		case -42:
			primos = new ArrayList<Long>();
			init();
			break;
		case 0: // case 0 ejecuta también case -1
			System.out.printf("%nGuardando...%n");
			exportPrimes();
			System.out.println("\n¡Guardado!");
		case -1:
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
	 * igual que el parámetro n. Muestra también por consola el tiempo que ha
	 * tardado cada algoritmo en hacerlo.
	 * 
	 * @param n Número hasta el que comprobar si son o no primos.
	 */
	private static void testVelocidad(int n) {

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

	private static void init() {
		if (primos.size() < 3) {
			long aux = 1;
			primos.add(aux++);
			primos.add(aux++);
			primos.add(aux);
		}
	}

	/**
	 * @param minutes
	 */
	private static void calcMorePrimesFor(int minutes) {
		long n = primos.get(primos.size() - 1) + 2;
		Date inicio = new Date();
		long horaBucleAnterior = inicio.getTime();
		long fin = inicio.getTime() + (minutes * 60 * 1000);
		System.out.println("Inicio: " + inicio);
		while (inicio.getTime() < fin) {
			if (isPrime(n))
				primos.add(n);
			n += 2;
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

	/**
	 * @param cantidad
	 */
	private static void calcMorePrimes(int cantidad) {
		int objetivo = cantidad + primos.size();
		long n = primos.get(primos.size() - 1) + 2;
		Date inicio = new Date();
		long horaBucleAnterior = inicio.getTime();

		System.out.println("Inicio: " + inicio);

		while (primos.size() < objetivo) {
			if (isPrime(n) && n > primos.get(primos.size() - 1))
				primos.add(n);
			n += 2;
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
	 * @param n
	 * @return boolean
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
	 * @param n
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
	 * @param n
	 * @return boolean
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
