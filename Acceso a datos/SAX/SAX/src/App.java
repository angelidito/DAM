import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class App {
	public static void main(String[] args) throws Exception {

		SAXManager sm = null;
		SAXParser parser = null;
		if (openXML(sm, parser) != 0) {
			System.out.println("Error al abrir el XML");
			return;
		}
		
	}

	public static int openXML(SAXManager sm, SAXParser parser) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			parser = factory.newSAXParser();
			sm = new SAXManager();
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}