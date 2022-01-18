import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class App {
	public static void main(String[] args) throws Exception {

		SAXHandler sh = null;
		SAXParser parser = null;
		// if (openXML(sh, parser) != 0) {}
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			parser = factory.newSAXParser();
			sh = new SAXHandler();
		} catch (Exception e) {
			System.out.println("Error al abrir el XML");
			e.printStackTrace();
			return;
		}

		recorrerSAX(new File("LibrosXML.xml"), sh, parser);

		for (Libro libro : sh.libros) {
			System.out.println(libro);
		}
	}

	public static int openXML(SAXHandler sh, SAXParser parser) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			parser = factory.newSAXParser();
			sh = new SAXHandler();
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static void recorrerSAX(File xMLFile, SAXHandler sh, SAXParser parser) {
		try {
			parser.parse(xMLFile, sh);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}