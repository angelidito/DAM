package cuatro;

import java.util.Random;

class Resultados {
	public static int ganancias;
	public static long tiempo_espera;
	public static int clientes_atendidos;
}

class Caja {
	private static final int MAX_TIME = 1000;

	class Nodo {
		int cliente;
		Nodo sig;
	}

	Nodo raiz, fondo;

	public Caja() {
		raiz = null;
		fondo = null;
	}

	private boolean vacia() {
		if (raiz == null)
			return true;
		else
			return false;
	}

	synchronized public void esperar(int id_cliente) throws InterruptedException {
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
		while (raiz.cliente != id_cliente) {
			// Me bloqueo hasta que sea mi turno
			wait();
		}
	}

	synchronized public void atender(int pago) throws InterruptedException {
		if (raiz == fondo) {
			raiz = null;
			fondo = null;
		} else {
			raiz = raiz.sig;
		}
		int tiempo_atencion = new Random().nextInt(MAX_TIME);
		Thread.sleep(tiempo_atencion);
		Resultados.ganancias += pago;
		Resultados.clientes_atendidos++;
		notify();
	}

	synchronized public void imprimir() {
		Nodo reco = raiz;
		while (reco != null) {
			System.out.print(reco.cliente + "-");
			reco = reco.sig;
		}
		System.out.println();
	}
}
