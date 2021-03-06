package uno;

import java.util.concurrent.Semaphore;

public class Orden {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(0);
		Saludo t2 = new Saludo(2, semaphore);
		Saludo t1 = new Saludo(1, semaphore);
		t2.start();
		t1.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			System.out.println("Hilo principaldel proceso interrumpido.");
		}
		System.out.println("Proceso acabando.");
	}
}