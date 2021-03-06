/*
 * Vivienda.java
 *
 * Generated with Matisse Schema Definition Language 9.1.12
 * Generation date: Mon Feb 17 13:35:52 2020
 */
// Note: the package and extends declarations are generated by mt_sdl, do not modify them
package inmobiliaria;

import com.matisse.reflect.*;

/**
 * <code>Vivienda</code> is a schema class generated by <code>mt_sdl</code>. Any
 * user-written classes will be found at the end of the file, after the '// END
 * of Matisse SDL Generated Code' comment. Attribute types, default values, and
 * relationship minimum and maximum cardinality are stored in the database
 * itself, not in this source code. For more information, see <i>Getting Started
 * with MATISSE</i>.
 */
public class Vivienda extends com.matisse.reflect.MtObject {

    // BEGIN Matisse SDL Generated Code
    // DO NOT MODIFY UNTIL THE 'END of Matisse SDL Generated Code' MARK BELOW
    /*
     * Generated with Matisse Schema Definition Language 9.1.12
     * Generation Date: Mon Feb 17 13:35:52 2020
     */

 /*
     * Class variables and methods
     */
    /**
     * Class <code>Vivienda</code> cache ID
     */
    private static int CID = com.matisse.MtDatabase.allocCID(new com.matisse.reflect.MtClass.Loader("inmobiliaria.Vivienda"));

    /**
     * Gets the <code>Vivienda</code> class descriptor. This method supports
     * advanced MATISSE programming techniques such as dynamically modifying the
     * schema.
     *
     * @param db a database
     * @return a class descriptor
     */
    public static com.matisse.reflect.MtClass getClass(com.matisse.MtDatabase db) {
        return (com.matisse.reflect.MtClass) db.getCachedObject(CID);
    }

    /**
     * Factory constructor. This constructor is called by
     * <code>MtObjectFactory</code>. It is public for technical reasons but is
     * not intended to be called directly by user methods.
     *
     * @param db a database
     * @param mtOid an existing object ID in the database
     */
    public Vivienda(com.matisse.MtDatabase db, int mtOid) {
        super(db, mtOid);
    }

    /**
     * Cascaded constructor, used by subclasses to create a new object in the
     * database. It is protected for technical reasons but is not intended to be
     * called directly by user methods.
     *
     * @param mtCls a class descriptor (the class to instantiate)
     */
    protected Vivienda(com.matisse.reflect.MtClass mtCls) {
        super(mtCls);
    }

    /**
     * Opens an iterator on all instances of this class (and its subclasses).
     *
     * @param <E> a MtObject class * @param db a database
     * @return an object iterator
     */
    public static <E extends com.matisse.reflect.MtObject> com.matisse.MtObjectIterator<E> instanceIterator(com.matisse.MtDatabase db) {
        return getClass(db).<E>instanceIterator(Vivienda.class);
    }

    /**
     * Opens an iterator on all instances of this class (and its subclasses).
     *
     * @param <E> a MtObject class * @param db a database
     * @param numObjPerBuffer maximum number of objects to fetch from the server
     * at a time
     * @return an object iterator
     */
    public static <E extends com.matisse.reflect.MtObject> com.matisse.MtObjectIterator<E> instanceIterator(com.matisse.MtDatabase db, int numObjPerBuffer) {
        return getClass(db).<E>instanceIterator(numObjPerBuffer, Vivienda.class);
    }

    /**
     * Counts the number of instances of this class (and its subclasses).
     *
     * @param db a database
     * @return total number of instances
     */
    public static long getInstanceNumber(com.matisse.MtDatabase db) {
        return getClass(db).getInstanceNumber();
    }

    /**
     * Opens an iterator on all own instances of this class (excluding
     * subclasses).
     *
     * @param <E> a MtObject class * @param db a database
     * @return an object iterator
     */
    public static <E extends com.matisse.reflect.MtObject> com.matisse.MtObjectIterator<E> ownInstanceIterator(com.matisse.MtDatabase db) {
        return getClass(db).<E>ownInstanceIterator(Vivienda.class);
    }

    /**
     * Opens an iterator on all own instances of this class (excluding
     * subclasses).
     *
     * @param <E> a MtObject class * @param db a database
     * @param numObjPerBuffer maximum number of objects to fetch from the server
     * at a time
     * @return an object iterator
     */
    public static <E extends com.matisse.reflect.MtObject> com.matisse.MtObjectIterator<E> ownInstanceIterator(com.matisse.MtDatabase db, int numObjPerBuffer) {
        return getClass(db).<E>ownInstanceIterator(numObjPerBuffer, Vivienda.class);
    }

    /**
     * Counts the number of own instances of this class (excluding subclasses).
     *
     * @param db a database
     * @return total number of instances
     */
    public static long getOwnInstanceNumber(com.matisse.MtDatabase db) {
        return getClass(db).getOwnInstanceNumber();
    }

    /*
     * Attribute access methods
     */

 /* Attribute 'piso' */
    /**
     * Attribute <code>piso</code> cache ID
     */
    private static int pisoCID = com.matisse.MtDatabase.allocCID(new com.matisse.reflect.MtAttribute.Loader("piso", CID));

    /**
     * Gets the <code>piso</code> attribute descriptor. This method supports
     * advanced MATISSE programming techniques such as dynamically modifying the
     * schema.
     *
     * @param db the database containing the attribute
     * @return the attribute descriptor object
     */
    public static com.matisse.reflect.MtAttribute getPisoAttribute(com.matisse.MtDatabase db) {
        return (com.matisse.reflect.MtAttribute) db.getCachedObject(pisoCID);
    }

    /**
     * Gets the <code>piso</code> attribute value.
     *
     * @return the value
     *
     * @see #setPiso
     * @see #removePiso
     */
    public final int getPiso() {
        return getInteger(getPisoAttribute(getMtDatabase()));
    }

    /**
     * Sets the <code>piso</code> attribute value.
     *
     * @param val the new value
     *
     * @see #getPiso
     * @see #removePiso
     */
    public final void setPiso(int val) {
        setInteger(getPisoAttribute(getMtDatabase()), val);
    }

    /**
     * Removes the current <code>piso</code> attribute value. Falls back to the
     * default value is there is one. If the attribute has no default value, it
     * must be set to a new value before commit.
     *
     * @see #getPiso
     * @see #setPiso
     */
    public final void removePiso() {
        removeValue(getPisoAttribute(getMtDatabase()));
    }

    /**
     * Check if nullable attribute value is set to MT_NULL.
     *
     * @return true if null value
     *
     * @see #getPiso
     * @see #setPiso
     */
    public final boolean isPisoNull() {
        return isNull(getPisoAttribute(getMtDatabase()));
    }

    /**
     * Check if attribute value is set to its default value.
     *
     * @return true if default value
     *
     * @see #getPiso
     * @see #setPiso
     */
    public final boolean isPisoDefaultValue() {
        return isDefaultValue(getPisoAttribute(getMtDatabase()));
    }


    /* Attribute 'letra' */
    /**
     * Attribute <code>letra</code> cache ID
     */
    private static int letraCID = com.matisse.MtDatabase.allocCID(new com.matisse.reflect.MtAttribute.Loader("letra", CID));

    /**
     * Gets the <code>letra</code> attribute descriptor. This method supports
     * advanced MATISSE programming techniques such as dynamically modifying the
     * schema.
     *
     * @param db the database containing the attribute
     * @return the attribute descriptor object
     */
    public static com.matisse.reflect.MtAttribute getLetraAttribute(com.matisse.MtDatabase db) {
        return (com.matisse.reflect.MtAttribute) db.getCachedObject(letraCID);
    }

    /**
     * Gets the <code>letra</code> attribute value.
     *
     * @return the value
     *
     * @see #setLetra
     * @see #removeLetra
     */
    public final String getLetra() {
        return getString(getLetraAttribute(getMtDatabase()));
    }

    /**
     * Sets the <code>letra</code> attribute value.
     *
     * @param val the new value
     *
     * @see #getLetra
     * @see #removeLetra
     */
    public final void setLetra(String val) {
        setString(getLetraAttribute(getMtDatabase()), val);
    }

    /**
     * Removes the current <code>letra</code> attribute value. Falls back to the
     * default value is there is one. If the attribute has no default value, it
     * must be set to a new value before commit.
     *
     * @see #getLetra
     * @see #setLetra
     */
    public final void removeLetra() {
        removeValue(getLetraAttribute(getMtDatabase()));
    }

    /**
     * Check if nullable attribute value is set to MT_NULL.
     *
     * @return true if null value
     *
     * @see #getLetra
     * @see #setLetra
     */
    public final boolean isLetraNull() {
        return isNull(getLetraAttribute(getMtDatabase()));
    }

    /**
     * Check if attribute value is set to its default value.
     *
     * @return true if default value
     *
     * @see #getLetra
     * @see #setLetra
     */
    public final boolean isLetraDefaultValue() {
        return isDefaultValue(getLetraAttribute(getMtDatabase()));
    }


    /* Attribute 'metros' */
    /**
     * Attribute <code>metros</code> cache ID
     */
    private static int metrosCID = com.matisse.MtDatabase.allocCID(new com.matisse.reflect.MtAttribute.Loader("metros", CID));

    /**
     * Gets the <code>metros</code> attribute descriptor. This method supports
     * advanced MATISSE programming techniques such as dynamically modifying the
     * schema.
     *
     * @param db the database containing the attribute
     * @return the attribute descriptor object
     */
    public static com.matisse.reflect.MtAttribute getMetrosAttribute(com.matisse.MtDatabase db) {
        return (com.matisse.reflect.MtAttribute) db.getCachedObject(metrosCID);
    }

    /**
     * Gets the <code>metros</code> attribute value.
     *
     * @return the value
     *
     * @see #setMetros
     * @see #removeMetros
     */
    public final int getMetros() {
        return getInteger(getMetrosAttribute(getMtDatabase()));
    }

    /**
     * Sets the <code>metros</code> attribute value.
     *
     * @param val the new value
     *
     * @see #getMetros
     * @see #removeMetros
     */
    public final void setMetros(int val) {
        setInteger(getMetrosAttribute(getMtDatabase()), val);
    }

    /**
     * Removes the current <code>metros</code> attribute value. Falls back to
     * the default value is there is one. If the attribute has no default value,
     * it must be set to a new value before commit.
     *
     * @see #getMetros
     * @see #setMetros
     */
    public final void removeMetros() {
        removeValue(getMetrosAttribute(getMtDatabase()));
    }

    /**
     * Check if nullable attribute value is set to MT_NULL.
     *
     * @return true if null value
     *
     * @see #getMetros
     * @see #setMetros
     */
    public final boolean isMetrosNull() {
        return isNull(getMetrosAttribute(getMtDatabase()));
    }

    /**
     * Check if attribute value is set to its default value.
     *
     * @return true if default value
     *
     * @see #getMetros
     * @see #setMetros
     */
    public final boolean isMetrosDefaultValue() {
        return isDefaultValue(getMetrosAttribute(getMtDatabase()));
    }


    /* Attribute 'direccion' */
    /**
     * Attribute <code>direccion</code> cache ID
     */
    private static int direccionCID = com.matisse.MtDatabase.allocCID(new com.matisse.reflect.MtAttribute.Loader("direccion", CID));

    /**
     * Gets the <code>direccion</code> attribute descriptor. This method
     * supports advanced MATISSE programming techniques such as dynamically
     * modifying the schema.
     *
     * @param db the database containing the attribute
     * @return the attribute descriptor object
     */
    public static com.matisse.reflect.MtAttribute getDireccionAttribute(com.matisse.MtDatabase db) {
        return (com.matisse.reflect.MtAttribute) db.getCachedObject(direccionCID);
    }

    /**
     * Gets the <code>direccion</code> attribute value.
     *
     * @return the value
     *
     * @see #setDireccion
     * @see #removeDireccion
     */
    public final String getDireccion() {
        return getString(getDireccionAttribute(getMtDatabase()));
    }

    /**
     * Sets the <code>direccion</code> attribute value.
     *
     * @param val the new value
     *
     * @see #getDireccion
     * @see #removeDireccion
     */
    public final void setDireccion(String val) {
        setString(getDireccionAttribute(getMtDatabase()), val);
    }

    /**
     * Removes the current <code>direccion</code> attribute value. Falls back to
     * the default value is there is one. If the attribute has no default value,
     * it must be set to a new value before commit.
     *
     * @see #getDireccion
     * @see #setDireccion
     */
    public final void removeDireccion() {
        removeValue(getDireccionAttribute(getMtDatabase()));
    }

    /**
     * Check if nullable attribute value is set to MT_NULL.
     *
     * @return true if null value
     *
     * @see #getDireccion
     * @see #setDireccion
     */
    public final boolean isDireccionNull() {
        return isNull(getDireccionAttribute(getMtDatabase()));
    }

    /**
     * Check if attribute value is set to its default value.
     *
     * @return true if default value
     *
     * @see #getDireccion
     * @see #setDireccion
     */
    public final boolean isDireccionDefaultValue() {
        return isDefaultValue(getDireccionAttribute(getMtDatabase()));
    }


    /*
     * Relationship access methods
     */

 /* Relationship 'situadaen' */
    /**
     * Relationship <code>situadaen</code> cache ID
     */
    private static int situadaenCID = com.matisse.MtDatabase.allocCID(new com.matisse.reflect.MtRelationship.Loader("situadaen", CID));

    /**
     * Gets the <code>situadaen</code> relationship descriptor. This method
     * supports advanced MATISSE programming techniques such as dynamically
     * modifying the schema.
     *
     * @param db a database
     * @return a relationship descriptor object
     */
    public static com.matisse.reflect.MtRelationship getSituadaenRelationship(com.matisse.MtDatabase db) {
        return (com.matisse.reflect.MtRelationship) db.getCachedObject(situadaenCID);
    }

    /**
     * Gets the <code>situadaen</code> relationship's successors.
     *
     * @return an array of objects
     *
     * @see #getSituadaenSize
     * @see #situadaenIterator
     * @see #setSituadaen
     * @see #removeSituadaen
     */
    public final inmobiliaria.Zona[] getSituadaen() {
        return (inmobiliaria.Zona[]) getSuccessors(getSituadaenRelationship(getMtDatabase()), inmobiliaria.Zona.class);
    }

    /**
     * Counts the <code>situadaen</code> relationship's successors.
     *
     * @return the number of successors
     *
     * @see #getSituadaen
     * @see #situadaenIterator
     * @see #setSituadaen
     * @see #removeSituadaen
     */
    public final int getSituadaenSize() {
        return getSuccessorSize(getSituadaenRelationship(getMtDatabase()));
    }

    /**
     * Opens an iterator on the <code>situadaen</code> relationship's
     * successors.
     *
     * @param <E> a MtObject class * @return an object iterator
     *
     * @see #getSituadaen
     * @see #getSituadaenSize
     * @see #setSituadaen
     * @see #removeSituadaen
     */
    public final <E extends com.matisse.reflect.MtObject> com.matisse.MtObjectIterator<E> situadaenIterator() {
        return this.<E>successorIterator(getSituadaenRelationship(getMtDatabase()), inmobiliaria.Zona.class);
    }

    /**
     * Sets the <code>situadaen</code> relationship's successors.
     *
     * @param succs an array of objects
     *
     * @see #getSituadaen
     * @see #getSituadaenSize
     * @see #situadaenIterator
     * @see #removeSituadaen
     */
    public final void setSituadaen(inmobiliaria.Zona[] succs) {
        setSuccessors(getSituadaenRelationship(getMtDatabase()), succs);
    }

    /**
     * Inserts one object at the beginning of the existing
     * <code>situadaen</code> successors list.
     *
     * @param succ the object to add
     *
     * @see #getSituadaen
     * @see #getSituadaenSize
     * @see #situadaenIterator
     * @see #setSituadaen
     * @see #removeSituadaen
     */
    public final void prependSituadaen(inmobiliaria.Zona succ) {
        prependSuccessor(getSituadaenRelationship(getMtDatabase()), succ);
    }

    /**
     * Adds one object to the end of the existing <code>situadaen</code>
     * successors list.
     *
     * @param succ the object to add
     *
     * @see #getSituadaen
     * @see #setSituadaen
     * @see #removeSituadaen
     * @see #getSituadaenSize
     * @see #situadaenIterator
     */
    public final void appendSituadaen(inmobiliaria.Zona succ) {
        appendSuccessor(getSituadaenRelationship(getMtDatabase()), succ);
    }

    /**
     * Adds multiple objects to the end of the existing <code>situadaen</code>
     * successors list.
     *
     * @param succs an array of objects to add
     *
     * @see #getSituadaen
     * @see #setSituadaen
     * @see #removeSituadaen
     * @see #getSituadaenSize
     * @see #situadaenIterator
     */
    public final void appendSituadaen(inmobiliaria.Zona[] succs) {
        addSuccessors(getSituadaenRelationship(getMtDatabase()), succs);
    }

    /**
     * Removes objects from the <code>situadaen</code> successors list.
     *
     * @param succs an array of objects to remove
     *
     * @see #getSituadaen
     * @see #setSituadaen
     * @see #getSituadaenSize
     * @see #situadaenIterator
     */
    public void removeSituadaen(inmobiliaria.Zona[] succs) {
        removeSuccessors(getSituadaenRelationship(getMtDatabase()), succs);
    }

    /**
     * Removes one object from the <code>situadaen</code> successors list.
     *
     * @param succ the object to remove
     *
     * @see #getSituadaen
     * @see #setSituadaen
     * @see #getSituadaenSize
     * @see #situadaenIterator
     */
    public void removeSituadaen(inmobiliaria.Zona succ) {
        removeSuccessor(getSituadaenRelationship(getMtDatabase()), succ);
    }

    /**
     * Removes all <code>situadaen</code> successors. When the minimum
     * cardinality is 1, a new successor must be set before commit.
     */
    public final void clearSituadaen() {
        clearSuccessors(getSituadaenRelationship(getMtDatabase()));
    }


    /* Relationship 'tieneVentana' */
    /**
     * Relationship <code>tieneVentana</code> cache ID
     */
    private static int tieneVentanaCID = com.matisse.MtDatabase.allocCID(new com.matisse.reflect.MtRelationship.Loader("tieneVentana", CID));

    /**
     * Gets the <code>tieneVentana</code> relationship descriptor. This method
     * supports advanced MATISSE programming techniques such as dynamically
     * modifying the schema.
     *
     * @param db a database
     * @return a relationship descriptor object
     */
    public static com.matisse.reflect.MtRelationship getTieneVentanaRelationship(com.matisse.MtDatabase db) {
        return (com.matisse.reflect.MtRelationship) db.getCachedObject(tieneVentanaCID);
    }

    /**
     * Gets the <code>tieneVentana</code> relationship's successors.
     *
     * @return an array of objects
     *
     * @see #getTieneVentanaSize
     * @see #tieneVentanaIterator
     * @see #setTieneVentana
     * @see #removeTieneVentana
     */
    public final inmobiliaria.Ventana[] getTieneVentana() {
        return (inmobiliaria.Ventana[]) getSuccessors(getTieneVentanaRelationship(getMtDatabase()), inmobiliaria.Ventana.class);
    }

    /**
     * Counts the <code>tieneVentana</code> relationship's successors.
     *
     * @return the number of successors
     *
     * @see #getTieneVentana
     * @see #tieneVentanaIterator
     * @see #setTieneVentana
     * @see #removeTieneVentana
     */
    public final int getTieneVentanaSize() {
        return getSuccessorSize(getTieneVentanaRelationship(getMtDatabase()));
    }

    /**
     * Opens an iterator on the <code>tieneVentana</code> relationship's
     * successors.
     *
     * @param <E> a MtObject class * @return an object iterator
     *
     * @see #getTieneVentana
     * @see #getTieneVentanaSize
     * @see #setTieneVentana
     * @see #removeTieneVentana
     */
    public final <E extends com.matisse.reflect.MtObject> com.matisse.MtObjectIterator<E> tieneVentanaIterator() {
        return this.<E>successorIterator(getTieneVentanaRelationship(getMtDatabase()), inmobiliaria.Ventana.class);
    }

    /**
     * Sets the <code>tieneVentana</code> relationship's successors.
     *
     * @param succs an array of objects
     *
     * @see #getTieneVentana
     * @see #getTieneVentanaSize
     * @see #tieneVentanaIterator
     * @see #removeTieneVentana
     */
    public final void setTieneVentana(inmobiliaria.Ventana[] succs) {
        setSuccessors(getTieneVentanaRelationship(getMtDatabase()), succs);
    }

    /**
     * Inserts one object at the beginning of the existing
     * <code>tieneVentana</code> successors list.
     *
     * @param succ the object to add
     *
     * @see #getTieneVentana
     * @see #getTieneVentanaSize
     * @see #tieneVentanaIterator
     * @see #setTieneVentana
     * @see #removeTieneVentana
     */
    public final void prependTieneVentana(inmobiliaria.Ventana succ) {
        prependSuccessor(getTieneVentanaRelationship(getMtDatabase()), succ);
    }

    /**
     * Adds one object to the end of the existing <code>tieneVentana</code>
     * successors list.
     *
     * @param succ the object to add
     *
     * @see #getTieneVentana
     * @see #setTieneVentana
     * @see #removeTieneVentana
     * @see #getTieneVentanaSize
     * @see #tieneVentanaIterator
     */
    public final void appendTieneVentana(inmobiliaria.Ventana succ) {
        appendSuccessor(getTieneVentanaRelationship(getMtDatabase()), succ);
    }

    /**
     * Adds multiple objects to the end of the existing
     * <code>tieneVentana</code> successors list.
     *
     * @param succs an array of objects to add
     *
     * @see #getTieneVentana
     * @see #setTieneVentana
     * @see #removeTieneVentana
     * @see #getTieneVentanaSize
     * @see #tieneVentanaIterator
     */
    public final void appendTieneVentana(inmobiliaria.Ventana[] succs) {
        addSuccessors(getTieneVentanaRelationship(getMtDatabase()), succs);
    }

    /**
     * Removes objects from the <code>tieneVentana</code> successors list.
     *
     * @param succs an array of objects to remove
     *
     * @see #getTieneVentana
     * @see #setTieneVentana
     * @see #getTieneVentanaSize
     * @see #tieneVentanaIterator
     */
    public void removeTieneVentana(inmobiliaria.Ventana[] succs) {
        removeSuccessors(getTieneVentanaRelationship(getMtDatabase()), succs);
    }

    /**
     * Removes one object from the <code>tieneVentana</code> successors list.
     *
     * @param succ the object to remove
     *
     * @see #getTieneVentana
     * @see #setTieneVentana
     * @see #getTieneVentanaSize
     * @see #tieneVentanaIterator
     */
    public void removeTieneVentana(inmobiliaria.Ventana succ) {
        removeSuccessor(getTieneVentanaRelationship(getMtDatabase()), succ);
    }

    /**
     * Removes all <code>tieneVentana</code> successors. When the minimum
     * cardinality is 1, a new successor must be set before commit.
     */
    public final void clearTieneVentana() {
        clearSuccessors(getTieneVentanaRelationship(getMtDatabase()));
    }


    /* Relationship 'propiedadDe' */
    /**
     * Relationship <code>propiedadDe</code> cache ID
     */
    private static int propiedadDeCID = com.matisse.MtDatabase.allocCID(new com.matisse.reflect.MtRelationship.Loader("propiedadDe", CID));

    /**
     * Gets the <code>propiedadDe</code> relationship descriptor. This method
     * supports advanced MATISSE programming techniques such as dynamically
     * modifying the schema.
     *
     * @param db a database
     * @return a relationship descriptor object
     */
    public static com.matisse.reflect.MtRelationship getPropiedadDeRelationship(com.matisse.MtDatabase db) {
        return (com.matisse.reflect.MtRelationship) db.getCachedObject(propiedadDeCID);
    }

    /**
     * Gets the <code>propiedadDe</code> relationship's successors.
     *
     * @return an array of objects
     *
     * @see #getPropiedadDeSize
     * @see #propiedadDeIterator
     * @see #setPropiedadDe
     * @see #removePropiedadDe
     */
    public final inmobiliaria.Cliente[] getPropiedadDe() {
        return (inmobiliaria.Cliente[]) getSuccessors(getPropiedadDeRelationship(getMtDatabase()), inmobiliaria.Cliente.class);
    }

    /**
     * Counts the <code>propiedadDe</code> relationship's successors.
     *
     * @return the number of successors
     *
     * @see #getPropiedadDe
     * @see #propiedadDeIterator
     * @see #setPropiedadDe
     * @see #removePropiedadDe
     */
    public final int getPropiedadDeSize() {
        return getSuccessorSize(getPropiedadDeRelationship(getMtDatabase()));
    }

    /**
     * Opens an iterator on the <code>propiedadDe</code> relationship's
     * successors.
     *
     * @param <E> a MtObject class * @return an object iterator
     *
     * @see #getPropiedadDe
     * @see #getPropiedadDeSize
     * @see #setPropiedadDe
     * @see #removePropiedadDe
     */
    public final <E extends com.matisse.reflect.MtObject> com.matisse.MtObjectIterator<E> propiedadDeIterator() {
        return this.<E>successorIterator(getPropiedadDeRelationship(getMtDatabase()), inmobiliaria.Cliente.class);
    }

    /**
     * Sets the <code>propiedadDe</code> relationship's successors.
     *
     * @param succs an array of objects
     *
     * @see #getPropiedadDe
     * @see #getPropiedadDeSize
     * @see #propiedadDeIterator
     * @see #removePropiedadDe
     */
    public final void setPropiedadDe(inmobiliaria.Cliente[] succs) {
        setSuccessors(getPropiedadDeRelationship(getMtDatabase()), succs);
    }

    /**
     * Inserts one object at the beginning of the existing
     * <code>propiedadDe</code> successors list.
     *
     * @param succ the object to add
     *
     * @see #getPropiedadDe
     * @see #getPropiedadDeSize
     * @see #propiedadDeIterator
     * @see #setPropiedadDe
     * @see #removePropiedadDe
     */
    public final void prependPropiedadDe(inmobiliaria.Cliente succ) {
        prependSuccessor(getPropiedadDeRelationship(getMtDatabase()), succ);
    }

    /**
     * Adds one object to the end of the existing <code>propiedadDe</code>
     * successors list.
     *
     * @param succ the object to add
     *
     * @see #getPropiedadDe
     * @see #setPropiedadDe
     * @see #removePropiedadDe
     * @see #getPropiedadDeSize
     * @see #propiedadDeIterator
     */
    public final void appendPropiedadDe(inmobiliaria.Cliente succ) {
        appendSuccessor(getPropiedadDeRelationship(getMtDatabase()), succ);
    }

    /**
     * Adds multiple objects to the end of the existing <code>propiedadDe</code>
     * successors list.
     *
     * @param succs an array of objects to add
     *
     * @see #getPropiedadDe
     * @see #setPropiedadDe
     * @see #removePropiedadDe
     * @see #getPropiedadDeSize
     * @see #propiedadDeIterator
     */
    public final void appendPropiedadDe(inmobiliaria.Cliente[] succs) {
        addSuccessors(getPropiedadDeRelationship(getMtDatabase()), succs);
    }

    /**
     * Removes objects from the <code>propiedadDe</code> successors list.
     *
     * @param succs an array of objects to remove
     *
     * @see #getPropiedadDe
     * @see #setPropiedadDe
     * @see #getPropiedadDeSize
     * @see #propiedadDeIterator
     */
    public void removePropiedadDe(inmobiliaria.Cliente[] succs) {
        removeSuccessors(getPropiedadDeRelationship(getMtDatabase()), succs);
    }

    /**
     * Removes one object from the <code>propiedadDe</code> successors list.
     *
     * @param succ the object to remove
     *
     * @see #getPropiedadDe
     * @see #setPropiedadDe
     * @see #getPropiedadDeSize
     * @see #propiedadDeIterator
     */
    public void removePropiedadDe(inmobiliaria.Cliente succ) {
        removeSuccessor(getPropiedadDeRelationship(getMtDatabase()), succ);
    }

    /**
     * Removes all <code>propiedadDe</code> successors. When the minimum
     * cardinality is 1, a new successor must be set before commit.
     */
    public final void clearPropiedadDe() {
        clearSuccessors(getPropiedadDeRelationship(getMtDatabase()));
    }


    /*
     * SQL Method access methods
     */
    /**
     * SQL Method call.
     *
     * @return the SQL Method return value
     */
    public Float calcularPrecio()
            throws java.sql.SQLException {
        float total = 0f;
        // Calculamos precio base
        int metros = getMetros();
        int precioMetro = getSituadaen()[0].getValorxmetro();
        float precioBase = metros * precioMetro;
        // Calculamos extra de altura
        int porcentaje = 3 * getPiso();
        float extraAltura = (precioBase * porcentaje) / 100;
        // Calcular extra de revalorizacion
        float precioPreRevalorizacion = precioBase + extraAltura;
        float extraRevalorizacion = (precioPreRevalorizacion * getSituadaen()[0].getIndicerevalorizacion()) / 100;
        // Sumo los totales
        total = precioBase + extraAltura + extraRevalorizacion;
        return total;
    }

    /**
     * SQL Method call.
     *
     * @return the SQL Method return value
     */
    public Float calcularLuminosidad()
            throws java.sql.SQLException {
        float total = 0f;
        float suma = 0f;
        Ventana[] ventanas = getTieneVentana();
        for (Ventana v : ventanas) {
            switch (v.getOrientacion()) {
                case "Norte":
                    suma = suma + 80f;
                    break;
                case "Sur":
                    suma = suma + 120f;
                    break;
                case "Este":
                case "Oeste":
                    suma = suma + 100f;
                    break;
            }
        }
        float extraPiso = getPiso() * 10;
        float extra = (suma * extraPiso) / 100;
        total = suma + extra;
        return total;
    }

    /**
     * SQL Method call.
     *
     * @return the SQL Method return value
     */
    public Float calcularAislamiento()
            throws java.sql.SQLException {
        float total = 0f;
        // Ejemplo una ventana de 2m orientada al norte con climalite en el piso 1
        // 15 - 0.5 = 14.5 | 14.5 * 2 = 29 | 29/2 = 14.5
        int piso = getPiso();
        float descuentoPiso = piso * (-0.5f);

        Ventana[] ventanas = getTieneVentana();
        for (Ventana v : ventanas) {
            float temp = 0f;
            switch (v.getOrientacion()) {
                case "Norte":
                    temp = (15 - descuentoPiso);
                    break;
                case "Sur":
                    temp = (3 - descuentoPiso);
                    break;
                case "Este":
                case "Oeste":
                    temp = (8 - descuentoPiso);
                    break;
            }
            float totalTEMP = temp * v.getDimensiones();
            if (v.getClimalite()) {
                total = total + (totalTEMP / 2);
            } else {
                total = total + totalTEMP;
            }
        }
        return total;
    }

    /**
     * SQL Method call.
     *
     * @return the SQL Method return value
     */
    public Float calcularPrecioEspecial(float descuento)
            throws java.sql.SQLException {
        float resultado = 0f;
        float total = 0f;
        if (descuento != 0f) {
            total = (calcularPrecio() * descuento) / 100;
            resultado = calcularPrecio() - total;
        } else {
            resultado = calcularPrecio();
        }
        return resultado;
    }

    // END of Matisse SDL Generated Code

    /*
     * You may add your own code here...
     */
    /**
     * Default constructor provided as an example. You may delete this
     * constructor or modify it to suit your needs. If you modify it, please
     * revise this comment accordingly.
     *
     * @param db a database
     */
    public Vivienda(com.matisse.MtDatabase db) {
        super(getClass(db));
    }

    /**
     * Example of <code>toString</code> method. You may delete this method or
     * modify it to suit your needs. If you modify it, please revise this
     * comment accordingly.
     *
     * @return a string
     */
    public java.lang.String toString() {
        return " Vivienda siutada en: " + getDireccion() + " Piso: " + getPiso() + " Letra: " + getLetra();
    }
}
