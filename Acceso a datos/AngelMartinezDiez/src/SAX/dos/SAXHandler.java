package SAX.dos;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {

	private Tag actualTag = Tag.UNKNOWN;
	private String result = "";
	private String capitan = "";

	public SAXHandler() {
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {

		if (qName != null) {
			actualTag = getTag(qName);
			if (actualTag == Tag.JUGADOR) {
				result += "El Jugador ";
				capitan = atts.getValue(0);
			}
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		actualTag = Tag.UNKNOWN;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		String str = "";
		for (int i = start; i < length + start; i++)
			str += ch[i];

		switch (actualTag) {
		case ID_JUGADOR:
			result += "(" + str + ") ";
			break;
		case NOMBRE:
			result += str;
			break;
		case EQUIPO:
			result += " del equipo: " + str;
			break;
		case SALARIO:
			result += " su salario asciende a: " + str + "EUROS y " + capitan
					+ " es capitan.\n----------------------------------------------\n";
			break;
		default:
			break;
		}
	}

	private Tag getTag(String tagName) {
		if (tagName.compareTo("JUGADORES") == 0)
			return Tag.JUGADORES;
		if (tagName.compareTo("JUGADOR") == 0)
			return Tag.JUGADOR;
		if (tagName.compareTo("ID_JUGADOR") == 0)
			return Tag.ID_JUGADOR;
		if (tagName.compareTo("NOMBRE") == 0)
			return Tag.NOMBRE;
		if (tagName.compareTo("EQUIPO") == 0)
			return Tag.EQUIPO;
		if (tagName.compareTo("SALARIO") == 0)
			return Tag.SALARIO;
		else
			return Tag.UNKNOWN;
	}

	public String getResult() {
		return result;
	}
}