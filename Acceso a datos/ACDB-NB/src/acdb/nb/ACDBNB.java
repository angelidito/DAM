/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acdb.nb;

import java.io.File;

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

        dir = "C:\\Mori\\DAM";
        f = new File(dir);
        indexTree(f, 0);
        files = f.list();
        System.out.printf("%n%n%n%n%n%n");
        for (String name : files) {
            f2 = new File(f, name);
            if (f2.isDirectory()) {
                System.out.printf("%n%n  '%s' es un directorio.%n%n", f2.getName(), f2.getAbsolutePath());
                getDataFromFile(f2);
            } else {
                System.out.printf("%n%n  '%s' es un archivo.%n%n", f2.getName(), f2.getAbsolutePath());
                getDataFromFile(f2);
            }
        }

    }

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

    public static void printDeep(int deep) {

        for (int i = 0; i < deep - 1; i++) {
            System.out.print("  ");
        }
        System.out.print("|_");

    }

}
