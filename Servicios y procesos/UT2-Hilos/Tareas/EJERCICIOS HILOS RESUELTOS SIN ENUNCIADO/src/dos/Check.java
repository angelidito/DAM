package dos;

import java.nio.IntBuffer;

public class Check {
	public static void main(String[] args) {
		IntBuffer buf = IntBuffer.allocate(10000);
		Object mutex = new Object();
		// Modificar primer parámetro entre:
		// 0 = No usar mutex
		// 1 = Usar mutex
		Lector l = new Lector(1, mutex, buf);
		Escritor e = new Escritor(1, mutex, buf);
		l.start();
		e.start();
		try {
			l.join();
			e.join();
		} catch (InterruptedException ex) {
			System.out.println("Hilo principalinterrumpido.");
		}
		System.out.println("Proceso acabando.");
	}
}