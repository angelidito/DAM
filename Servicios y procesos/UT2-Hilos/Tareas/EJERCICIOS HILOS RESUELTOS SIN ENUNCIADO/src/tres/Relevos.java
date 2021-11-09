package tres;

public class Relevos {
	public static void main(String[] args) {
		Testigo testigo = new Testigo();
		Corredor corredores[] = new Corredor[4];
		for (int i = 0; i < 4; i++) {
			corredores[i] = new Corredor(i + 1, testigo);
			corredores[i].start();
		}
		System.out.println("Todos los hilos creados.");
		testigo.next(1);
		System.out.println("Doy la salida!");
		try {
			for (int i = 0; i < 4; i++) {
				corredores[i].join();
			}
		} catch (InterruptedException ex) {
			System.out.println("Hilo principal interrumpido.");
		}
		System.out.println("Todos los hilos terminaron.");
	}
}
