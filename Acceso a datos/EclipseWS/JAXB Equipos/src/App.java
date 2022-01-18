import java.io.File;
import java.util.List;

import javax.xml.bind.*;

import clasesXJC.*;

public class App {

	public static void main(String[] args) throws Exception {
		File file = new File("xdata/equipos_futbol.xml");
		Equipos equipos = null;
		if ((equipos = abrir_XML_JAXB(file, equipos)) != null) {

			String resultado = recorrerJAXB(equipos);
			System.out.println(resultado);
		}
	}

	public static Equipos abrir_XML_JAXB(File fichero, Equipos equipos) {
		JAXBContext contexto;
		try {
			// Crea una instancia JAXB
			contexto = JAXBContext.newInstance(Equipos.class);
			// Crea un objeto Unmarsheller.
			Unmarshaller u = contexto.createUnmarshaller();
			// Deserializa (unmarshal) el fichero
			equipos = (Equipos) u.unmarshal(fichero);
			return equipos;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static String recorrerJAXB(Equipos equipos) {
		String datos_nodo[] = null;
		String cadena_resultado = "";
		// Crea una lista con objetos.
		List<Equipos.Equipo> listaEquipos = equipos.getEquipo();
		// Recorre la lista para sacar los valores.
		for (int i = 0; i < listaEquipos.size(); i++) {
			cadena_resultado = cadena_resultado + "\n "
					+ "Equipo: " + listaEquipos.get(i).getNombre();
			cadena_resultado = cadena_resultado + "\n "
					+ "El residente es: " + listaEquipos.get(i).getPresidente();
			cadena_resultado = cadena_resultado + "\n "
					+ "El capitán es: " + listaEquipos.get(i).getCapitan();
			cadena_resultado = cadena_resultado + "\n "
					+ "La posición es: " + listaEquipos.get(i).getPosicion();
			cadena_resultado = cadena_resultado + "\n "
					+ "La fundación fue en : " + listaEquipos.get(i).getFundacion();
			cadena_resultado = cadena_resultado
					+ "\n----------------------------";
		}
		return cadena_resultado;
	}

}
