import java.io.File;

import javax.xml.bind.*;

import javanombres.Name;

public class App {

	public static void main(String[] args) throws Exception {
		System.out.println("Hello, World!");
	}

	public int abrir_XML_JAXB(File fichero, Name misLibros) {
		JAXBContext contexto;
		try {
			// Crea una instancia JAXB
			contexto = JAXBContext.newInstance(Name.class); // Crea un objeto Unmarsheller.
			Unmarshaller u = contexto.createUnmarshaller(); // Deserializa (unmarshal) el fichero misLibros=(Libros)
															// u.unmarshal(fichero);
			return 0;
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}
	}

}
