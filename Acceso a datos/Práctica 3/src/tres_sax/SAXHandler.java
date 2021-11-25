package tres_sax;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {

	ArrayList<Name> nombres = new ArrayList<Name>();
	private Name nameToAdd;
	private Tag actualTag = Tag.UNKNOWN;

	public SAXHandler() {
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {

		if (qName != null) {
			actualTag = getTag(qName);
			switch (actualTag) {
			case NAME:
				nameToAdd = new Name();
				break;
			case ORIGEN:
				if (atts != null && atts.getLocalName(0) == "nacional")
					nameToAdd.setNacional(atts.getValue(0));
				break;
			case SIGNIFICADO:
				if (atts.getLength() > 0 && atts.getLocalName(0) == "abstracto")
					nameToAdd.setAbstracto(atts.getValue(0));
				break;
			default:
				break;
			}
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (actualTag == Tag.SIGNIFICADO)
			nombres.add(nameToAdd);
		actualTag = Tag.UNKNOWN;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		String str = "";
		for (int i = start; i < length + start; i++)
			str += ch[i];

		switch (actualTag) {
		case NAME:
			nameToAdd.setNombre(str);
			break;
		case ORIGEN:
			nameToAdd.setOrigen(str);
			break;
		case SIGNIFICADO:
			nameToAdd.setSignificado(str);
		default:
			break;
		}
	}

	private Tag getTag(String tagName) {
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
		else
			return Tag.UNKNOWN;
	}
}