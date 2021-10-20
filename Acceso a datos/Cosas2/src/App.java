import java.io.*;
import java.nio.CharBuffer;

public class App {
    public static void main(String[] args) throws Exception {
        String ruta1;
        String ruta2;
        
        // String moei[][][] = new String[4][8][9];

        ruta1 = "C:\\Mori\\Ciudades.txt";
        ruta2 = "C:\\Mori\\Cities.txt";
        copiarFicheroA(ruta1, ruta2);
        leerFichero(ruta1);
        leerFichero(ruta2);
    }

    private static void crearFichero(String ruta) throws IOException {
        File file;
        FileWriter fWriter;

        file = new File(ruta);
        if (!file.exists()) {
            file.createNewFile();
            fWriter = new FileWriter(file);
            fWriter.write("Burgos\nMadrid\nBilbao\nVitoria\nPalencia");
            fWriter.close();
        }
    }

    private static void leerFichero(String ruta) throws IOException {
        File file;
        FileReader fReader;
        int ch;

        file = new File(ruta);
        if (!file.exists()) {
            fReader = new FileReader(file);
            while ((ch = fReader.read()) != -1)
                System.out.printf("%c", ch);
            fReader.close();
        }
    }

    private static void copiarFicheroA(String rutaOrigen, String rutaDestino) throws IOException {
        File origen;
        File destino;
        FileWriter fWriter;
        FileReader fReader;
        int ch;

        origen = new File(rutaOrigen);
        if (!origen.exists())
            crearFichero(rutaOrigen);
        else
            System.out.println("El archivo de origen no existe.");
        destino = new File(rutaDestino);
        if (!destino.exists()) {
            destino.createNewFile();
            fReader = new FileReader(origen);
            fWriter = new FileWriter(destino);
            while ((ch = fReader.read()) != -1)
                fWriter.write(ch);
            fReader.close();
            fWriter.close();
        } else
            System.out.println("El archivo de destino ya existe.");

    }
}
