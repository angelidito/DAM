package SAX.tres;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {

	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	private Jugador jugadorActual = null;
	private Tag actualTag = Tag.UNKNOWN;

	public SAXHandler() {
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {

		if (qName != null) {
			actualTag = getTag(qName);
			if (actualTag == Tag.JUGADOR) {
				jugadorActual = new Jugador();
				jugadorActual.setCapitan(atts.getValue(0));
			}
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (actualTag == Tag.SALARIO)
			jugadores.add(jugadorActual);
		actualTag = Tag.UNKNOWN;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		String str = "";
		for (int i = start; i < length + start; i++)
			str += ch[i];

		switch (actualTag) {
		case ID_JUGADOR:
			jugadorActual.setNum_jugador(str);
			break;
		case NOMBRE:
			jugadorActual.setNombre(str);
			break;
		case EQUIPO:
			jugadorActual.setEquipo(str);
			break;
		case SALARIO:
			jugadorActual.setSalario(str);
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
}