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

	private static String rutaArchivoPrimos = "primos.txt";
	private static File archivoPrimos = new File(rutaArchivoPrimos);
	private static ArrayList<Long> primos = new ArrayList<Long>();

	public static void main(String[] args) throws Exception {
		int op;
		Scanner sc = new Scanner(System.in);
		updatePrimosFromFile();
		do {
			// System.out.printf("%nEscoja una opcion:" + "%n\t1. Mostrar primos del uno al
			// 1000."
			// + "%n\t2. Escoger hasta qué nº mostrar los primos." + "%n\t3. Comprobar si un
			// nº es primo."
			// + "%n\t0. Salir del programa.%n");
			System.out.printf("%nActualmente hay %d primos calculados.%n" //
					+ "El mayor primo es el %s.%n" //
					+ "Escoja una opcion:%n" //
					+ "\t  1. Calcular primos hasta un nº%n" //
					+ "\t  2. Calcular los X primos siguientes%n" //
					+ "\t  3. Calcular primos durante X minutos%n" //
					+ "\t  4. Mostrar primos%n" //
					+ "\t  5. Guardar%n" //
					+ "\t  0. Guardar y salir%n" //
					+ "\t -1. Salir sin guardar%n" //
					+ "\t-42. Borrar datos%n" //
					, primos.size(), primos.size() == 0 ? "NoData" : primos.get(primos.size() - 1).toString(),
					rutaArchivoPrimos);
			op = sc.nextInt();
			switch (op) {
			case 1:
				System.out.printf("¿Hasta qué número quieres calcular los primos?%n");
				loadPrimesUntil(sc.nextInt());
				break;
			case 2:
				System.out.printf("¿Cuántos primos más quieres calcular?%n");
				calcMorePrimes(sc.nextInt());
				break;
			case 3:
				System.out.printf("¿Cuántos minutos quieres estar calculando nuevos primos?%n");
				calcMorePrimesFor(sc.nextInt());
			case 5:
				System.out.printf("%nGuardando...%n");
				exportPrimes();
				System.out.println("\n¡Guardado!");
				break;
			case 4:
				for (Long primo : primos)
					System.out.print(primo + ", ");
				System.out.println();
				break;
			case 0:
				System.out.printf("%nGuardando...%n");
				exportPrimes();
				System.out.println("\n¡Guardado!");
				System.out.printf("%n%nAdiós%n");
				break;
			case -1:
				System.out.printf("%n%nAdiós%n");
				break;
			case -42:
				primos = new ArrayList<Long>();
				init();
				break;
			default:
				System.out.printf("%nEscoja una opción entre las disponibles.%n");
				break;
			}
		} while (op != 0 && op != 9);
		sc.close();

	}

	private static void calcMorePrimesFor(int minutes) {
		long n = primos.get(primos.size() - 1) + 2;
		Date inicio = new Date();
		long horaBucleAnterior = inicio.getTime();
		long fin = inicio.getTime() + (minutes * 60 * 1000);
		System.out.println("Inicio: " + inicio + "\n");
		while (inicio.getTime() < fin) {
			if (isPrime(n))
				primos.add(n);
			n += 2;
			if (horaBucleAnterior <= inicio.getTime() - 5000) {
				System.out.printf("\t\tTiempo restante: %d minutos y %d segundos%n" //
						+ "\tTotal primos: %d%n" //
						+ "\t Mayor primo: %d%n%n" //
						, (fin - inicio.getTime()) / 60000, (fin - inicio.getTime()) / 1000, primos.size(),
						primos.get(primos.size() - 1));
				horaBucleAnterior = inicio.getTime();
			}
			inicio = new Date();
		}
		System.out.println("\nFin: " + new Date());
	}

	private static void exportPrimes() throws IOException {
		archivoPrimos.createNewFile();
		FileWriter primosWriter = new FileWriter(archivoPrimos);
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
		while (contador <= 20) {
			// System.out.print(contador);
			System.out.printf("■");
			contador++;
		}

		primosWriter.close();
	}

	private static void calcMorePrimes(int cantidad) {
		int objetivo = cantidad + primos.size();
		long n = primos.get(primos.size() - 1) + 2;

		while (primos.size() < objetivo) {
			if (isPrime(n) && !primos.contains(n))
				primos.add(n);
			n += 2;
		}
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

	private static void init() {
		if (primos.size() < 3) {
			long aux = 1;
			primos.add(aux++);
			primos.add(aux++);
			primos.add(aux);
		}
	}

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

	private static void loadPrimesUntil(long n) {

		if (n >= 5) {
			// Por ejemplo, si el último es 3, empieza a probar el 5
			// Si es 131, empieza por el 15
			// De esta manera al calcular primos hasta, por ejemplo
			// el 1000 y luego el 2000, no hace dos veces el 5 al 1000.
			// Directamente empieza en el 997 + 2, o sea, el último primo+2
			long i = primos.get(primos.size() - 1) + 2;
			while (i <= n) {
				if (isPrime(i) && !primos.contains(i))
					primos.add(i);
				i += 2;
			}
		}
	}

	// public static boolean isPrime(int n) {
	// if (n < 1)
	// return false;
	// if (n < 3)
	// return true;
	// if (n % 2 == 0)
	// return false;
	// for (int i = 1; i < n / 2; i += 2)
	// if (n % i == 0)
	// return false;
	// return true;
	// }

	public static boolean isPrimeBad(long n) {
		if (n < 1)
			return false;
		if (n < 3)
			return true;
		if (n % 2 == 0)
			return false;
		for (long i = 1; i < n / 2; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}
}
