import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


// import com.sun.org.apache.xml.internal.serialize.OutputFormat;
// import com.sun.org.apache.xml.internal.serialize.XMLSerializer;



public class MonumentosCreateDOM {

	private static Document doc;

	// public static int saveDOMAt(File file) {
	// 	try {
	// 		OutputStream format = new OutputFormat(doc);
	// 		format.setIndenting(true);
	// 		XMLSerializer serializer = new XMLSerializer(new FileOutputStream(file), format);
	// 		serializer.serialize(doc);
	// 		return 0;
	// 	} catch (Exception e) {
	// 		return -1;
	// 	}
	// }
	public static void main(String[] args) throws Exception {
		File monumentosFile = new File("monumentos_soria.xml");
		openXML(monumentosFile);

		Node root = doc.getFirstChild();
		NodeList nodosMonumento = root.getChildNodes();
		for (int i = 0; i < nodosMonumento.getLength(); i++) {
			Node nodoMonumento = nodosMonumento.item(i);
			
			if (nodoMonumento.getNodeType() != Node.ELEMENT_NODE || nodoMonumento.getNodeName() != "monumento")
				continue;

			String data[] = procesarMonumento(nodoMonumento);

			if (data != null && data.length == 4)
				System.out.printf("%s:%n" //
						+ "\t- %s está restaurado%n" //
						+ "\t- %s se puede entrar%n" //
						+ "\t- aforo de %s personas%n%n" //
						, data[0], data[1].compareTo("no") != 0 ? "sí" : "no",
						data[2].compareTo("no") != 0 ? "sí" : "no", data[3]);

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
		int count = 0;
		int n = 0;

		while (count < 4) {
			Node tmpNode = nList.item(n);
			if (tmpNode.getNodeName() == "nombre") {
				datos[0] = tmpNode.getTextContent();
				datos[1] = tmpNode.getAttributes().item(0).getNodeValue();
				count += 2;
			}
			if (tmpNode.getNodeName() == "entrada") {
				datos[2] = tmpNode.getTextContent();
				count++;
			}
			if (tmpNode.getNodeName() == "aforo") {
				datos[3] = tmpNode.getTextContent();
				count++;
			}
			n++;
		}
		for (int i = 0; i < datos.length; i++)
			datos[i] = datos[i] == null ? "???" : datos[i];
		return datos;
	}
}
