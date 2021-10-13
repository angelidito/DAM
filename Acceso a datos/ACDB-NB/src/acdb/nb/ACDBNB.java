/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acdb.nb;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author dam
 */
public class ACDBNB {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		String dir;
		String files[];
		File f;
		File f2;

		// dir = "C:\\Mori\\DAM";
		// f = new File(dir);
		// indexTree(f);
		// files = f.list();
		// System.out.printf("%n%n%n%n%n%n");
		// for (String name : files) {
		// f2 = new File(f, name);
		// if (f2.isDirectory()) {
		// System.out.printf("%n%n '%s' es un directorio.%n%n", f2.getName(),
		// f2.getAbsolutePath());
		// getDataFromFile(f2);
		// } else {
		// System.out.printf("%n%n '%s' es un archivo.%n%n", f2.getName(),
		// f2.getAbsolutePath());
		// getDataFromFile(f2);
		// }
		// }

		dir = "C:\\Mori";
		f = new File(dir);
		createFile(f);

	}

	/**
	 * Crea un fichero en la ruta espeficicada. Si y solo si no existe.
	 * 
	 * @param ruta Fichero a Crear
	 */
	private static void createFile(File ruta) {
		Scanner sc;
		File file;
		String fileName;

		sc = new Scanner(System.in);
		System.out.println("¿Cómo desea llamar al nuevo fichero?");
		fileName = sc.nextLine();
		file = new File(ruta, fileName);

		if (!ruta.exists())
			ruta.mkdir();
		if (!ruta.isDirectory())
			System.out.println(ruta.getPath() + " ya existe y NO es un directorio");
		else
			try {
				if (file.createNewFile()) {
					System.out.println("Archivo creado:");
					getDataFromFile(file);
				} else {
					System.out.print("Archivo el archivo no ha podido ser creado");
					if (file.exists())
						System.out.println(" porque ya existe.");
					else
						System.out.println(" por algún motivo.");

				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		System.out.println("¿Desea borrar el fichero? (s/n)");
		char borrar = sc.nextLine().charAt(0);

		switch (borrar) {
			case 's':
			case 'S':
				if (file.delete())
					System.out.println("Borrado.");
				else
					System.out.println("No se ha podido borrar por algún motivo...");
				break;
			case 'n':
			case 'N':
				System.out.println("OK");
				break;

			default:
				System.out.println("No se qué has dicho, me lo tomo como un no.");
				break;
		}

		sc.close();
	}

	/**
	 * Imprime los datos un fichero. El fichero es pasado cómo parámetro.
	 * 
	 * @param f Fichero cuyos datos se van a mostrar por pantalla.
	 */
	public static void getDataFromFile(File f) {
		System.out.println("Nombre del fichero: " + f.getName());
		System.out.println("Tamaño: " + f.length());
		System.out.println("Ruta: " + f.getPath());
		System.out.println("Ruta absoluta: " + f.getAbsolutePath());
		System.out.println("Nombre del directorio padre: " + f.getParent());
		System.out.println("Se puede leer: " + f.canRead());
		System.out.println("Se puede escribir: " + f.canWrite());
		System.out.println("Es un directorio: " + f.isDirectory());
		System.out.println("Es un fichero: " + f.isFile());
	}

	/**
	 * Recorre el arbol de directorios y lo imprime. Llama al metodo recursivo
	 * homónimo `indexTree(File directory, int deep)`.
	 * 
	 * @param directory Directorio cuyo arbol se quiere mostrar
	 */
	public static void indexTree(File directory) {
		indexTree(directory, 0);
	}

	/**
	 * Recorre el arbol de directorios y lo imprime. Método recursivo.
	 * 
	 * @param directory Directorio cuyo arbol se quiere mostrar
	 * @param deep      profuncidad del directorio en el árbol.
	 */
	public static void indexTree(File directory, int deep) {
		String dir;
		String files[];
		File f;

		files = directory.list();
		for (String name : files) {
			f = new File(directory, name);
			printDeep(deep);
			if (f.isDirectory()) {
				if (f.getName().charAt(0) != '.') {
					System.out.printf("%s%n", f.getName());
					indexTree(f, deep + 1);
				}
			} else {
				System.out.printf("%s%n", f.getName());
			}
		}
	}

	/**
	 * Imprime espacios. Tantos como @deep - 2, ya que luego imprime "|_!.
	 * 
	 * @param deep Profundidad imprimir.
	 */
	public static void printDeep(int deep) {

		for (int i = 0; i < deep - 1; i++) {
			System.out.print("  ");
		}
		System.out.print("|_");

	}

}
