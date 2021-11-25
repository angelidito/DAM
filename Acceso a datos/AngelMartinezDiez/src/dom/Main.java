package dom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class Main {
	static String inputPath = "fichero_jugadores_TXT.txt";
	static String outputPath = "DOM_output_XML.xml";
	static File inputFile = new File(inputPath);
	static ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	private static Document doc;
	// private static File outputFile;

	public static void main(String[] args) throws Exception {

		cargarJugadores();

		// for (Jugador j : jugadores)
		// System.out.println(j);

		File outputFile = createOutput();

		buildDocument();
		createDOMTree();

		saveDOMAt(outputFile);

		leerTextoDOM();
	}

	public static void leerTextoDOM() {
		Node raiz = doc.getFirstChild();
		if (raiz.getChildNodes().getLength() > 1)
			for (int i = 0; i < raiz.getChildNodes().getLength(); i++) {
				recursiveLeerTextoDOM(raiz.getChildNodes().item(i));
			}
		else
			System.out.println(raiz.getTextContent());
	}

	public static void recursiveLeerTextoDOM(Node raiz) {
		if (raiz.getChildNodes().getLength() > 1)
			for (int i = 0; i < raiz.getChildNodes().getLength(); i++) {
				recursiveLeerTextoDOM(raiz.getChildNodes().item(i));
			}
		else
			System.out.println(raiz.getTextContent());

	}

	public static int saveDOMAt(File file) {
		try {
			TransformerFactory tfactory = TransformerFactory.newInstance();
			Transformer transformer = tfactory.newTransformer();
			DOMSource source= new DOMSource(doc);
			DOMResult result = new DOMResult(doc);
			transformer.transform(source, result);
			

			// OutputStream format = new OutputFormat(doc);
			// format.setIndenting(true);
			// XMLSerializer serializer = new XMLSerializer(new FileOutputStream(file), format);
			// serializer.serialize(doc);
			return 0;
		} catch (Exception e) {
			return -1;
		}
	}

	public static void createDOMTree() {
		Node raiz = doc.createElement("JUGADORES");
		int i = 1;
		for (Jugador j : jugadores) {
			Node jNode = doc.createElement("JUGADOR");

			Node capitan, id, nombre, equipo, salario;

			capitan = doc.createAttribute("CAPITAN");
			capitan.setTextContent(j.getCapitan());

			id = doc.createElement("ID_JUGADOR");
			id.appendChild(doc.createTextNode("" + i));

			nombre = doc.createElement("NOMBRE");
			nombre.appendChild(doc.createTextNode(j.getNombre()));

			equipo = doc.createElement("NOMBRE");
			equipo.appendChild(doc.createTextNode(j.getEquipo()));

			salario = doc.createElement("NOMBRE");
			salario.appendChild(doc.createTextNode(j.getSalario()));

			// Node capitan, id, nombre, equipo, salario;
			// jNode.appendChild(capitan);
			jNode.appendChild(id);
			jNode.appendChild(nombre);
			jNode.appendChild(equipo);
			jNode.appendChild(salario);

			raiz.appendChild(jNode);
		}
		doc.appendChild(raiz);
	}

	private static File createOutput() throws IOException {
		File outpuFile = new File(outputPath);
		outpuFile.createNewFile();
		try {
			FileWriter primosWriter = new FileWriter(outpuFile);
			primosWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><JUGADORES></JUGADORES>");
			primosWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outpuFile;
	}

	private static int buildDocument() {
		doc = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringComments(true);
			factory.setIgnoringElementContentWhitespace(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.newDocument();
			doc.setXmlVersion("1.0");
			doc.setXmlStandalone(false);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	private static void cargarJugadores() {
		if (!inputFile.exists())
			return;

		try {
			FileReader fReader = new FileReader(inputFile);
			BufferedReader buff = new BufferedReader(fReader);
			String linea;
			int contador = 0;
			Jugador j = null;

			while ((linea = buff.readLine()) != null) {
				if (contador % 4 == 0) {
					j = new Jugador();
					j.setCapitan(linea);
				} else if (contador % 4 == 1) {
					j.setNombre(linea);
				} else if (contador % 4 == 2) {
					j.setEquipo(linea);
				} else {
					j.setSalario(linea);
				}
				jugadores.add(j);
				contador++;
			}

			buff.close();
			fReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se ha cargado nada al arrayList ya que no existe el archivo fuente.");
		} catch (IOException e) {
			System.out.println("Algo ha ido mal.");
			e.printStackTrace();
		}

	}

}
