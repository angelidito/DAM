import java.io.*;
import java.util.ArrayList;

public class App {

	static ArrayList<String> lista1 = new ArrayList<String>();;
	static ArrayList<String> lista2 = new ArrayList<String>();;

	public static void main(String[] args) throws Exception {
		String rutaArchivo1 = "ciudadesCyL.txt";
		String rutaArchivo2 = "ciudadesEspaña.txt";

		System.out.println("Inicializando listas!");
		inicializar(rutaArchivo1, rutaArchivo2);

		// for (String linea : lista1)
		// System.out.println(linea);
		// for (String linea : lista2)
		// System.out.println(linea);
		boolean castellana;
		for (String ciudadEsp : lista2) {
			castellana = false;
			for (String ciudadCyL : lista1)
				if (ciudadCyL.compareTo(ciudadEsp) == 0)
					castellana= true;
			if (!castellana)
				System.out.println(ciudadEsp);
		}
	}

	public static void inicializar(String rutaArchivo1, String rutaArchivo2) throws IOException {
		File archivo1;
		File archivo2;
		FileReader fReader;
		BufferedReader buff;
		String linea;

		archivo1 = new File(rutaArchivo1);
		archivo2 = new File(rutaArchivo2);
		if (!archivo1.exists())
			System.out.println("ERROR. El archivo " + archivo1.getAbsolutePath() + " no existe.");
		else if (!archivo2.exists())
			System.out.println("ERROR. El archivo " + archivo2.getAbsolutePath() + " no existe.");
		else {
			fReader = new FileReader(archivo1);
			buff = new BufferedReader(fReader);
			while ((linea = buff.readLine()) != null)
				lista1.add(linea);
			fReader.close();
			buff.close();
			fReader = new FileReader(archivo2);
			buff = new BufferedReader(fReader);
			while ((linea = buff.readLine()) != null)
				lista2.add(linea);
			fReader.close();
			buff.close();
		}
	}
}
