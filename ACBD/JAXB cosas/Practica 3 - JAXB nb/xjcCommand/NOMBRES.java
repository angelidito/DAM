//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.01.10 a las 10:19:47 AM CET 
//


package xjcCommand;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NOMBRE" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IDENTIFICADOR" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                   &lt;element name="NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ORIGEN">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="nacional" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="SIGNIFICADO">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="abstracto" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
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
    "nombre"
})
@XmlRootElement(name = "NOMBRES")
public class NOMBRES {

    @XmlElement(name = "NOMBRE")
    protected List<NOMBRES.NOMBRE> nombre;

    /**
     * Gets the value of the nombre property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nombre property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNOMBRE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NOMBRES.NOMBRE }
     * 
     * 
     */
    public List<NOMBRES.NOMBRE> getNOMBRE() {
        if (nombre == null) {
            nombre = new ArrayList<NOMBRES.NOMBRE>();
        }
        return this.nombre;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="IDENTIFICADOR" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *         &lt;element name="NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ORIGEN">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="nacional" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="SIGNIFICADO">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="abstracto" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
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
        "identificador",
        "name",
        "origen",
        "significado"
    })
    public static class NOMBRE {

        @XmlElement(name = "IDENTIFICADOR")
        protected byte identificador;
        @XmlElement(name = "NAME", required = true)
        protected String name;
        @XmlElement(name = "ORIGEN", required = true)
        protected NOMBRES.NOMBRE.ORIGEN origen;
        @XmlElement(name = "SIGNIFICADO", required = true)
        protected NOMBRES.NOMBRE.SIGNIFICADO significado;

        /**
         * Obtiene el valor de la propiedad identificador.
         * 
         */
        public byte getIDENTIFICADOR() {
            return identificador;
        }

        /**
         * Define el valor de la propiedad identificador.
         * 
         */
        public void setIDENTIFICADOR(byte value) {
            this.identificador = value;
        }

        /**
         * Obtiene el valor de la propiedad name.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNAME() {
            return name;
        }

        /**
         * Define el valor de la propiedad name.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNAME(String value) {
            this.name = value;
        }

        /**
         * Obtiene el valor de la propiedad origen.
         * 
         * @return
         *     possible object is
         *     {@link NOMBRES.NOMBRE.ORIGEN }
         *     
         */
        public NOMBRES.NOMBRE.ORIGEN getORIGEN() {
            return origen;
        }

        /**
         * Define el valor de la propiedad origen.
         * 
         * @param value
         *     allowed object is
         *     {@link NOMBRES.NOMBRE.ORIGEN }
         *     
         */
        public void setORIGEN(NOMBRES.NOMBRE.ORIGEN value) {
            this.origen = value;
        }

        /**
         * Obtiene el valor de la propiedad significado.
         * 
         * @return
         *     possible object is
         *     {@link NOMBRES.NOMBRE.SIGNIFICADO }
         *     
         */
        public NOMBRES.NOMBRE.SIGNIFICADO getSIGNIFICADO() {
            return significado;
        }

        /**
         * Define el valor de la propiedad significado.
         * 
         * @param value
         *     allowed object is
         *     {@link NOMBRES.NOMBRE.SIGNIFICADO }
         *     
         */
        public void setSIGNIFICADO(NOMBRES.NOMBRE.SIGNIFICADO value) {
            this.significado = value;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="nacional" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class ORIGEN {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "nacional")
            protected String nacional;

            /**
             * Obtiene el valor de la propiedad value.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Define el valor de la propiedad value.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Obtiene el valor de la propiedad nacional.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNacional() {
                return nacional;
            }

            /**
             * Define el valor de la propiedad nacional.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNacional(String value) {
                this.nacional = value;
            }

        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="abstracto" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class SIGNIFICADO {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "abstracto")
            protected String abstracto;

            /**
             * Obtiene el valor de la propiedad value.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Define el valor de la propiedad value.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Obtiene el valor de la propiedad abstracto.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAbstracto() {
                return abstracto;
            }

            /**
             * Define el valor de la propiedad abstracto.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAbstracto(String value) {
                this.abstracto = value;
            }

        }

    }

}
