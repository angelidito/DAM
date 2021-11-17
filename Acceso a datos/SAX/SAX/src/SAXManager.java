import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class SAXManager extends DefaultHandler {
	int ultimoelement;
	String cadena_resultado = "";

	public SAXManager() {
		ultimoelement = 0;
	}

	// Se sobrecarga (redefine) el método startElement
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		switch (tag(qName)) {
		case LIBRO:
			break;
		case TITULO:

			break;
		case AUTOR:

			break;
		default:
			break;
		}
		if (qName.equals("Libro")) {
			cadena_resultado = cadena_resultado + "Publicado en: " + atts.getValue(atts.getQName(0)) + "\n ";
			ultimoelement = 1;
		} else if (qName.equals("Titulo")) {
			ultimoelement = 2;
			cadena_resultado = cadena_resultado + "\n " + "El título es: ";
		} else if (qName.equals("Autor")) {
			ultimoelement = 3;
			cadena_resultado = cadena_resultado + "\n " + "El autor es: ";
		}
	}

	// Cuando en este ejemplo se detecta el final de un elemento <libro>, se pone
	// una línea
	// discontinua en la salida.
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("Libro")) {
			cadena_resultado = cadena_resultado + "\n -------------------";
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (ultimoelement == 2) {
			for (int i = start; i < length + start; i++)
				cadena_resultado = cadena_resultado + ch[i];
		} else if (ultimoelement == 3) {
			for (int i = start; i < length + start; i++)
				cadena_resultado = cadena_resultado + ch[i];
		}
	}

	private TAG tag(String tagName) {
		if (tagName.compareTo("Libro") == 0)
			return TAG.LIBRO;
		if (tagName.compareTo("Titulo") == 0)
			return TAG.TITULO;
		if (tagName.compareTo("Autor") == 0)
			return TAG.AUTOR;
	}
}