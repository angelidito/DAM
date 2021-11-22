import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class SAXHandler extends DefaultHandler {
	ArrayList<Libro> libros = new ArrayList<Libro>();

	public SAXHandler() {
	}

	// Se sobrecarga (redefine) el método startElement
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		if (qName != null)
			switch (getTag(qName)) {
			case LIBRO:
				// System.out.println("<Libro>");

				libros.add(new Libro());
				libros.get(libros.size() - 1).setPublicacdoEn(atts.getValue(0));
				break;
			// case TITULO:
			// // System.out.println("<Titulo>");
			// break;
			// case AUTOR:
			// // System.out.println("<Autor>");
			// break;
			default:
				// System.out.println("<" + qName + ">");
				break;
			}
	}

	// Cuando en este ejemplo se detecta el final de un elemento <libro>, se pone
	// una línea
	// discontinua en la salida.
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// if (qName.equals("Libro")) {
		// cadena_resultado = cadena_resultado + "\n -------------------";
		// }
		switch (getTag(qName)) {
		case LIBRO:
			// System.out.println("</Libro>");
			break;
		case TITULO:
			// libros.get(libros.size() - 1).setTitulo("titulo");
			// System.out.println("</Titulo>");
			break;
		case AUTOR:
			// System.out.println("</Autor>");

			break;
		default:
			// System.out.println("</" + qName + ">");

			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str = "";
		for (int i = start; i < length + start; i++)
			str += ch[i];
		if (str.matches("^[\\t\\n\\f\\r]+$"))
			return;
		// System.out.println(str);
		if (libros.get(libros.size() - 1).getTitulo() == null)
			libros.get(libros.size() - 1).setTitulo(str);
		else if (libros.get(libros.size() - 1).getAutor() == null)
			libros.get(libros.size() - 1).setAutor(str);
		else
			System.out.println("Error al obtener valores. Cadena \"" + str + "\".");
	}

	private Tag getTag(String tagName) {
		if (tagName.compareTo("Libro") == 0)
			return Tag.LIBRO;
		if (tagName.compareTo("Titulo") == 0)
			return Tag.TITULO;
		if (tagName.compareTo("Autor") == 0)
			return Tag.AUTOR;
		else
			return Tag.UNKNOWN;
	}
}