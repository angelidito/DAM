package dos;

import java.nio.IntBuffer;

class Lector extends Thread {
	private int bloqueo;
	private IntBuffer buffer;
	private Object mutex;

	Lector(int opcion, Object mutex, IntBuffer buf) {
		this.bloqueo = opcion;
		this.buffer = buf;
		this.mutex = mutex;
	}

	private void comprobar() {
		int i;
		int elementoDistinto = 0;
		for (i = 1; i < 10000; i++) {
			if (buffer.get(0) != buffer.get(i)) {
				System.out.println("Trhread lector: Error.Elementos de buffer distintos");
				elementoDistinto = 1;
				break;
			}
		}
		if (elementoDistinto == 0) {
			System.out.println("Trhread lector:Elementos de buffer iguales");
		}
	}

	public void run() {
		while (true) {

			if (this.bloqueo == 1) {
				synchronized (this.mutex) {
					comprobar();
				}
			} else {
				comprobar();
			}
		}
	}
}