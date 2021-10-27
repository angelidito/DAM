import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
			System.out.printf(
					"%nActualmente hay %d primos calculados.%n" + "El mayor primo es el %s." + "%nEscoja una opcion:%n"
							+ "\t1. Calcular primos hasta un nº.%n" + "\t2. Mostrar los primos almacenados.%n"
							+ "\t3. Exportar a \"%s\".%n" + "\t4. Calcular los 50 primos siguientes.%n"
							+ "\t5. Calcular primos durante 5 minutos.%n" + "\t0. Salir del programa.%n",
					primos.size(), primos.size() == 0 ? "NoData" : primos.get(primos.size() - 1).toString(),
					rutaArchivoPrimos);
			op = sc.nextInt();
			switch (op) {
			case 1:
				System.out.printf("¿Hasta qué número quieres calcular los primos?%n");
				loadPrimesUntil(sc.nextInt());
				break;
			case 2:
				for (Long primo : primos)
					System.out.print(primo + ", ");
				System.out.println();
				break;
			case 3:
				archivoPrimos.createNewFile();
				FileWriter primosWriter = new FileWriter(archivoPrimos);
				String cadenaPrimos = "";
				for (Long primo : primos)
					cadenaPrimos += primo + "\n";
				primosWriter.write(cadenaPrimos);
				primosWriter.close();
				break;
			case 4:
				calcMorePrimes(50);
				break;
			case 5:

				break;
			case 0:
				System.out.printf("%nAdiós%n");
				break;
			default:
				System.out.printf("%nEscoja una opción entre las disponibles.%n");
				break;
			}
		} while (op != 0);
		sc.close();

	}

	private static void calcMorePrimes(int i) {
		int objetivo = i + primos.size();
		long max = primos.get(primos.size() - 1);
		while (objetivo < primos.size()) {

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
		long aux = 1;
		if (n >= aux && !primos.contains(aux))
			primos.add(aux);
		aux++;
		if (n >= aux && !primos.contains(aux))
			primos.add(aux);
		aux++;
		if (n >= aux && !primos.contains(aux))
			primos.add(aux);
		if (n >= 5)
			for (long i = 5; i <= n; i++) {
				if (isPrime(i) && !primos.contains(i))
					primos.add(i);
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
