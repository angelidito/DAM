//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.5-2 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: AM.02.17 a las 09:11:18 AM CET 
//


package jaxbNombres;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jaxbNombres package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jaxbNombres
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NOMBRES }
     * 
     */
    public NOMBRES createNOMBRES() {
        return new NOMBRES();
    }

    /**
     * Create an instance of {@link NOMBRES.NOMBRE }
     * 
     */
    public NOMBRES.NOMBRE createNOMBRESNOMBRE() {
        return new NOMBRES.NOMBRE();
    }

    /**
     * Create an instance of {@link NOMBRES.NOMBRE.ORIGEN }
     * 
     */
    public NOMBRES.NOMBRE.ORIGEN createNOMBRESNOMBREORIGEN() {
        return new NOMBRES.NOMBRE.ORIGEN();
    }

    /**
     * Create an instance of {@link NOMBRES.NOMBRE.SIGNIFICADO }
     * 
     */
    public NOMBRES.NOMBRE.SIGNIFICADO createNOMBRESNOMBRESIGNIFICADO() {
        return new NOMBRES.NOMBRE.SIGNIFICADO();
    }

}
