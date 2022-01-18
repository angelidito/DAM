package tres_sax;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class Main {

	private static String XMLFileRoute = "nombres.xml";

	public static void main(String[] args) throws Exception {

		File XMLFile = new File(XMLFileRoute);

		SAXHandler sh = null;
		SAXParser parser = null;

		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			parser = factory.newSAXParser();
			sh = new SAXHandler();
		} catch (Exception e) {
			System.out.println("Error al abrir el XML");
			e.printStackTrace();
			return;
		}

		recorrerSAX(XMLFile, sh, parser);

		for (Name nombre : sh.nombres) {
			System.out.println(nombre.toString());
			System.out.println();
		}
	}

	public static void recorrerSAX(File XMLFile, SAXHandler sh, SAXParser parser) {
		try {
			parser.parse(XMLFile, sh);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}