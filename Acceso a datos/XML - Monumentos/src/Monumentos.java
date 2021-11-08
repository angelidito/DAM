import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Monumentos {

	private static Document doc;

	public static void main(String[] args) throws Exception {
		File monumentosFile = new File("monumentos_soria.xml");
		openXML(monumentosFile);

		Node root = doc.getFirstChild();
		NodeList nodosMonumento = root.getChildNodes();
		for (int i = 0; i < nodosMonumento.getLength(); i++) {
			Node nodoMonumento = nodosMonumento.item(i);
			if (nodoMonumento.getNodeType() == Node.ELEMENT_NODE && nodoMonumento.getNodeName() == "monumento") {
				String data[] = procesarMonumento(nodoMonumento);

				if (data.length == 4)
					System.out.printf("%s:%n" //
							+ "\t- %srestaurado%n" //
							+ "\t- %sse puede entrar%n" //
							+ "\t- aforo de %s personas%n%n" //
							, data[0], data[1] != "no" ? "" : "no ", data[2] != "no" ? "" : "no ", data[3]);
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

	private static String[] procesarMonumento(Node node) {
		String datos[] = new String[4];
		NodeList nList = node.getChildNodes();

		System.out.println(nList.item(0).getNodeName());
		System.out.println(nList.item(0).getFirstChild());
		// System.out.println(nList.item(1).getNodeValue());
		// System.out.println(nList.item(2).getNodeValue());

		// datos[0] = nList.item(0).getFirstChild().toString();
		// datos[1] = nList.item(0).getAttributes().item(0).getNodeValue();
		// datos[2] = nList.item(1).getNodeValue();
		// datos[3] = nList.item(2).getNodeValue();

		for (int i = 0; i < datos.length; i++)
			datos[i] = datos[i] == null ? "" : datos[i];
		return null;
	}
}
