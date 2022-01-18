//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.01.10 a las 11:15:28 AM CET 
//

package clasesXJC;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para anonymous complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="equipo" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="presidente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="capitan" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="posicion" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="fundacion" type="{http://www.w3.org/2001/XMLSchema}short" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"equipo"
})
@XmlRootElement(name = "equipos")
public class Equipos {

	protected List<Equipos.Equipo> equipo;

	/**
	 * Gets the value of the equipo property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the equipo property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getEquipo().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link Equipos.Equipo }
	 * 
	 * 
	 */
	public List<Equipos.Equipo> getEquipo() {
		if (equipo == null) {
			equipo = new ArrayList<Equipos.Equipo>();
		}
		return this.equipo;
	}

	/**
	 * <p>
	 * Clase Java para anonymous complex type.
	 * 
	 * <p>
	 * El siguiente fragmento de esquema especifica el contenido que se espera que
	 * haya en esta clase.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="presidente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *         &lt;element name="capitan" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="posicion" type="{http://www.w3.org/2001/XMLSchema}byte"/>
	 *       &lt;/sequence>
	 *       &lt;attribute name="fundacion" type="{http://www.w3.org/2001/XMLSchema}short" />
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = {
			"nombre",
			"presidente",
			"capitan",
			"posicion"
	})
	public static class Equipo {

		@XmlElement(required = true)
		protected String nombre;
		protected String presidente;
		@XmlElement(required = true)
		protected String capitan;
		protected byte posicion;
		@XmlAttribute(name = "fundacion")
		protected Short fundacion;

		/**
		 * Obtiene el valor de la propiedad nombre.
		 * 
		 * @return
		 *         possible object is
		 *         {@link String }
		 * 
		 */
		public String getNombre() {
			return nombre;
		}

		/**
		 * Define el valor de la propiedad nombre.
		 * 
		 * @param value
		 *              allowed object is
		 *              {@link String }
		 * 
		 */
		public void setNombre(String value) {
			this.nombre = value;
		}

		/**
		 * Obtiene el valor de la propiedad presidente.
		 * 
		 * @return
		 *         possible object is
		 *         {@link String }
		 * 
		 */
		public String getPresidente() {
			return presidente;
		}

		/**
		 * Define el valor de la propiedad presidente.
		 * 
		 * @param value
		 *              allowed object is
		 *              {@link String }
		 * 
		 */
		public void setPresidente(String value) {
			this.presidente = value;
		}

		/**
		 * Obtiene el valor de la propiedad capitan.
		 * 
		 * @return
		 *         possible object is
		 *         {@link String }
		 * 
		 */
		public String getCapitan() {
			return capitan;
		}

		/**
		 * Define el valor de la propiedad capitan.
		 * 
		 * @param value
		 *              allowed object is
		 *              {@link String }
		 * 
		 */
		public void setCapitan(String value) {
			this.capitan = value;
		}

		/**
		 * Obtiene el valor de la propiedad posicion.
		 * 
		 */
		public byte getPosicion() {
			return posicion;
		}

		/**
		 * Define el valor de la propiedad posicion.
		 * 
		 */
		public void setPosicion(byte value) {
			this.posicion = value;
		}

		/**
		 * Obtiene el valor de la propiedad fundacion.
		 * 
		 * @return
		 *         possible object is
		 *         {@link Short }
		 * 
		 */
		public Short getFundacion() {
			return fundacion;
		}

		/**
		 * Define el valor de la propiedad fundacion.
		 * 
		 * @param value
		 *              allowed object is
		 *              {@link Short }
		 * 
		 */
		public void setFundacion(Short value) {
			this.fundacion = value;
		}

	}

}
