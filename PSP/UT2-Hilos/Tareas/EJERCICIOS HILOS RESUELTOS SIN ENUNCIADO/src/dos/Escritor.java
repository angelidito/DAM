package dos;

import java.nio.IntBuffer;

class Escritor extends Thread {
	private int bloqueo;
	private IntBuffer buffer;
	private Object mutex;
	private int contador;

	Escritor(int opcion, Object mutex, IntBuffer buf) {
		this.bloqueo = opcion;
		this.buffer = buf;
		this.mutex = mutex;
		this.contador = 0;
	}

	private void escribir() {
		int i;
		for (i = 0; i < 10000; i++) {
			buffer.put(i, contador);
		}
		contador++;
	}

	public void run() {
		while (true) {
			if (this.bloqueo == 1) {
				synchronized (this.mutex) {
					escribir();
				}
			} else {
				escribir();
			}
		}
	}
}
