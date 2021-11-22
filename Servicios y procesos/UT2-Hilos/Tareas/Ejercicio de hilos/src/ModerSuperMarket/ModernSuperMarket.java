package ModerSuperMarket;

import java.util.Random;

class Resultados {
	public static int ganancias;
	public static long tiempo_espera;
	public static int clientes_atendidos;
}

class Caja {
	private static final int MAX_TIME = 1000;
	private boolean ocupada;

	public Caja() {
		this.ocupada = false;
	}

	public boolean ocupada() {
		return ocupada;
	}

	synchronized public void atender(int pago) throws InterruptedException {
		ocupada = true;
		int tiempo_atencion = new Random().nextInt(MAX_TIME);
		Thread.sleep(tiempo_atencion);
		Resultados.ganancias += pago;
		Resultados.clientes_atendidos++;
		ocupada = false;
	}
}

class Cola {
	class Nodo {
		int cliente;
		Nodo sig;
	}

	Nodo raiz, fondo;
	Caja cajas[];
	int N;

	public Cola(int N) {
		raiz = null;
		fondo = null;
		this.N = N;
		cajas = new Caja[N];
		for (int i = 0; i < N; i++) {
			cajas[i] = new Caja();
		}
	}

	private boolean vacia() {
		if (raiz == null)
			return true;
		else
			return false;
	}

	private int cajaLibre() {
		int i = 0;
		while (i < N) {
			if (!cajas[i].ocupada()) {
				break;
			}
			i++;
		}
		return i;
	}

	synchronized public int esperar(int id_cliente) throws InterruptedException {
		int caja_id;
		Nodo nuevo;
		nuevo = new Nodo();
		nuevo.cliente = id_cliente;
		nuevo.sig = null;
		if (vacia()) {
			raiz = nuevo;
			fondo = nuevo;
		} else {
			fondo.sig = nuevo;
			fondo = nuevo;
		}
		// Esperar hasta el turno
		while (((caja_id = cajaLibre()) == N) || (raiz.cliente != id_cliente)) {
			// Me bloqueo hasta que sea mi turno
			wait();
		}
		// Salgo de la cola
		raiz = raiz.sig;
		return caja_id;
	}

	public void atender(int id_caja, int pago) throws InterruptedException {
		cajas[id_caja].atender(pago);
	}

	synchronized public void finalizar_compra() throws InterruptedException {
		notify();
	}
}

class Cliente extends Thread {
	private static final int MAX_DELAY = 2000;
	private static final int MAX_COST = 100;
	private int id;
	private Cola cola;

	Cliente(int id, Cola cola) {

		this.id = id;
		this.cola = cola;
	}

	public void run() {
		try {
			int numero_caja;
			System.out.println("Cliente " + id + " realizando compra");
			Thread.sleep(new Random().nextInt(MAX_DELAY));
			long s = System.currentTimeMillis();
			numero_caja = cola.esperar(id);
			cola.atender(numero_caja, new Random().nextInt(MAX_COST));
			System.out.println("Cliente " + id + " atendido en caja " + numero_caja);
			cola.finalizar_compra();
			System.out.println("Cliente " + id + " finalizando");
			long espera = System.currentTimeMillis() - s;
			Resultados.tiempo_espera += espera;
			System.out.println("Cliente " + id + " saliendo despues de esperar " + espera);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ModernSuperMarket {
	public static void main(String[] args) throws InterruptedException {
		int N = Integer.parseInt(args[0]);
		Cola cola = new Cola(N);
		int M = Integer.parseInt(args[1]);
		Cliente clientes[] = new Cliente[M];
		for (int i = 0; i < M; i++) {
			clientes[i] = new Cliente(i, cola);
			clientes[i].start();
		}
		try {
			for (int i = 0; i < M; i++) {
				clientes[i].join();
			}
		} catch (InterruptedException ex) {
			System.out.println("Hilo principal interrumpido.");
		}
		System.out.println("Supermercado cerrado.");
		System.out.println("Ganancias: " + Resultados.ganancias);
		System.out.println("Tiempo medio de espera: " + (Resultados.tiempo_espera / Resultados.clientes_atendidos));
	}
}