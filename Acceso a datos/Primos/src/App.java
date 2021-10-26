import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {
		int op;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.printf("%nEscoja una opcion:" + "%n\t1. Mostrar primos del uno al 1000."
					+ "%n\t2. Escoger hasta qué nº mostrar los primos." + "%n\t3. Comprobar si un nº es primo."
					+ "%n\t0. Salir del programa.%n");
			op = sc.nextInt();
			switch (op) {
			case 1:
				printPrimesFrom1To1000();
				break;
			case 2:
				System.out.printf("%¿Hasta qué número quieres ver los primos?%n");
				printPrimesFromOneTo(sc.nextInt());
				break;
			case 3:
				System.out.printf("%n¿Qué número quieres saber si es primo?%n");
				printPrimeResolution(sc.nextInt());
				break;
			default:
				System.out.printf("%nAdiós%n");
				break;
			}
		} while (op != 0);
		sc.close();

	}

	public static void printPrimesFromOneTo(int topNumber) {
		if (topNumber < 1)
			return;
		else if (topNumber == 1)
			System.out.printf("1");
		else if (topNumber >= 2)
			System.out.printf("1, 2");
		for (int i = 3; i < topNumber; i += 2)
			if (isPrime(i))
				System.out.printf(", %d", i);
	}

	public static void printPrimesFrom1To1000() {
		System.out.printf("1, 2");
		for (int i = 3; i < 9971; i += 2)
			if (isPrime(i))
				System.out.printf(", %d", i);
	}

	public static void printPrimeResolution(int n) {

		if (isPrime(n))
			System.out.printf("El numero %d es primo.%n%n", n);
		else
			System.out.printf("El numero %d no es primo.%n%n", n);

	}

	public static boolean isPrime(int n) {
		if (n < 1)
			return false;
		if (n < 3)
			return true;
		if (n % 2 == 0)
			return false;
		for (int i = 1; i < n / 2; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}
}
