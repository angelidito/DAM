package app;

import java.io.File;
import java.util.List;

import javax.xml.bind.*;
import jaxbNombres.NOMBRES;

public class App {

    public static void main(String[] args) throws Exception {
        File file = new File("src/data/nombres.xml");
        NOMBRES nombres = null;
        if ( ( nombres = abrir_XML_JAXB(file, nombres)) != null) {
            System.out.println(recorrerJAXByMostrar(nombres));
        }
    }

    public static NOMBRES abrir_XML_JAXB(File fichero, NOMBRES nombres) {
        JAXBContext contexto;
        try {
            // Crea una instancia JAXB
            contexto = JAXBContext.newInstance(NOMBRES.class);
            // Crea un objeto Unmarsheller.
            Unmarshaller u = contexto.createUnmarshaller();
            // Deserializa (unmarshal) el fichero 
            nombres = (NOMBRES) u.unmarshal(fichero);
            return nombres;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String recorrerJAXByMostrar(NOMBRES nombres) {
        String datos_nodo[] = null;
        String cadena_resultado
                = "";
        //Crea una lista con objetos de tipo libro.
        List<NOMBRES.NOMBRE> listaNombres = nombres.getNOMBRE();
        //Recorre la lista para sacar los valores.
        for (int i = 0; i < listaNombres.size(); i++) {
            cadena_resultado = cadena_resultado + "\n "
                    + "Nombre: " + listaNombres.get(i).getNAME();
            cadena_resultado = cadena_resultado + "\n "
                    + "El id es: " + listaNombres.get(i).getIDENTIFICADOR();
            cadena_resultado = cadena_resultado + "\n "
                    + "El origen es: " + listaNombres.get(i).getORIGEN().getValue();
            cadena_resultado = cadena_resultado + "\n "
                    + "El significado es: " + listaNombres.get(i).getSIGNIFICADO().getValue();
            cadena_resultado = cadena_resultado
                    + "\n----------------------------";
        }
        return cadena_resultado;
    }

}
