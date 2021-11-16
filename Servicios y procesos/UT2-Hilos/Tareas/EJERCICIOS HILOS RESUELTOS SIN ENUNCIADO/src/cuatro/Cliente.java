package cuatro;

import java.util.Random;

class Cliente extends Thread {
	private static final int MAX_DELAY = 2000;
	private static final int MAX_COST = 100;
	private int id;
	private Caja caja;

	Cliente(int id, Caja caja) {
		this.id = id;
		this.caja = caja;
	}

	public void run() {
		try {
			System.out.println("Cliente " + id + " realizando compra");
			Thread.sleep(new Random().nextInt(MAX_DELAY));
			long s = System.currentTimeMillis();
			caja.esperar(id);
			System.out.print("Cliente " + id + " en cola con ");
			caja.imprimir();
			caja.atender(new Random().nextInt(MAX_COST));
			System.out.println("Cliente " + id + " atendido");
			long espera = System.currentTimeMillis() - s;
			Resultados.tiempo_espera += espera;
			System.out.println("Cliente " + id + " saliendo después de esperar " + espera);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
