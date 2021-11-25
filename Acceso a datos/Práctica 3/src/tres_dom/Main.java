package tres_dom;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

	private static Document doc;
	private static String rutaXML = "nombres.xml";
	private static ArrayList<Name> names = new ArrayList<Name>();

	public static void main(String[] args) {
		File file = new File(rutaXML);

		openXML(file);

		getInfoFromXML(file);

		for (Name name : names) {
			System.out.println(name);
			;
		}
	}

	private static void getInfoFromXML(File file) {
		NodeList nombreNodeList = doc.getFirstChild().getChildNodes();

		for (int i = 0; i < nombreNodeList.getLength(); i++) {
			NodeList data = nombreNodeList.item(i).getChildNodes();
			Name name = new Name();
			for (int j = 0; j < data.getLength(); j++) {
				Node node = data.item(j);
				Tag tag = getTag(node.getNodeName());

				switch (tag) {
				case NAME:
					name.setNombre(node.getTextContent());
					// System.out.println(node.getTextContent());
					break;
				case ORIGEN:
					name.setOrigen(node.getTextContent()); {
					Node atts = node.getAttributes().getNamedItem("nacional");
					if (atts != null)
						name.setNacional(atts.getNodeValue());
				}
					break;
				case SIGNIFICADO:
					name.setSignificado(node.getTextContent()); {
					Node atts = node.getAttributes().getNamedItem("abstracto");
					if (atts != null)
						name.setAbstracto(atts.getNodeValue());
				}
					names.add(name);
					break;

				default:
					break;
				}

			}
		}
	}

	private static int openXML(File file) {
		doc = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringComments(true);
			factory.setIgnoringElementContentWhitespace(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(file);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	/**
	 * Con esto te aseguras de tratar solo con los nodos que me interesan y nunca
	 * con texto.
	 * 
	 * @param tagName
	 * @return
	 */
	private static Tag getTag(String tagName) {
		if (tagName.compareTo("NOMBRES") == 0)
			return Tag.NOMBRES;
		if (tagName.compareTo("NOMBRE") == 0)
			return Tag.NOMBRE;
		if (tagName.compareTo("IDENTIFICADOR") == 0)
			return Tag.IDENTIFICADOR;
		if (tagName.compareTo("NAME") == 0)
			return Tag.NAME;
		if (tagName.compareTo("ORIGEN") == 0)
			return Tag.ORIGEN;
		if (tagName.compareTo("SIGNIFICADO") == 0)
			return Tag.SIGNIFICADO;
		if (tagName.compareTo("#text") == 0)
			return Tag.TEXT;
		else
			return Tag.UNKNOWN;
	}
}
