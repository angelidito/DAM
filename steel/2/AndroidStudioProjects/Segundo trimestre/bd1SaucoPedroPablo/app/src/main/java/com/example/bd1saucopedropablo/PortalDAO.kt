package com.example.bd1saucopedropablo

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.widget.Toast

class PortalDAO(contexto: Context) {
    private val mBD: SQLiteDatabase

    //Ponemos poner el nombre de la tabla, de algún campo... -companion = static en java-
    companion object {
        val DATABASE_NAME = "alojamientobd"
        val DATABASE_VERSION = 1
        val TABLA_ALOJAMIENTOS = "alojamientos"
    }

    init {
        val estructura = PortalBD(contexto, DATABASE_NAME, null, DATABASE_VERSION)
        mBD = estructura.writableDatabase
    }

    fun getAllAlojamientos(): MutableList<Portal> {
        val lista: MutableList<Portal> = ArrayList()
        val cursor: Cursor = mBD.query(TABLA_ALOJAMIENTOS, null, null, null, null, null, null)
        if (cursor.moveToFirst()) {
            do {
                lista.add(
                    Portal(
                        cursor.getInt(0),
                        cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                        cursor.getString(cursor.getColumnIndexOrThrow("localidad")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("precio")),
                        cursor.getString(cursor.getColumnIndexOrThrow("imagen")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("telefono")),
                        cursor.getString(cursor.getColumnIndexOrThrow("email")),
                        cursor.getString(cursor.getColumnIndexOrThrow("detalles")),
                        cursor.getString(cursor.getColumnIndexOrThrow("actividades")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("favorito"))
                    )
                )
            } while (cursor.moveToNext())
            if (!cursor.isClosed)
                cursor.close()
        }
        return lista
    }
    //AGREGAR UN HOTEL A FAVORITO
    fun updateAlojamiento(portal: Portal) {
        val values = ContentValues()
        values.put("favorito", portal.favorito)
        val argumentos = arrayOf(portal.codAlojamiento.toString())
        mBD.update(TABLA_ALOJAMIENTOS, values, "codAlojamiento=?", argumentos)
    }
    //BÚSQUEDA POR LOCALIDAD
    fun getLocalidad(ubicacion: String): MutableList<Portal> {
        val lista: MutableList<Portal> = ArrayList()
        val cursor: Cursor = mBD.rawQuery(
            "SELECT * FROM ${TABLA_ALOJAMIENTOS} WHERE localidad = '" + ubicacion + "'",
            null
        )
        if (cursor.moveToFirst()) {
            do {
                lista.add(
                    Portal(
                        cursor.getInt(0),
                        cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                        cursor.getString(cursor.getColumnIndexOrThrow("localidad")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("precio")),
                        cursor.getString(cursor.getColumnIndexOrThrow("imagen")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("telefono")),
                        cursor.getString(cursor.getColumnIndexOrThrow("email")),
                        cursor.getString(cursor.getColumnIndexOrThrow("detalles")),
                        cursor.getString(cursor.getColumnIndexOrThrow("actividades")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("favorito"))
                    )
                )
            } while (cursor.moveToNext())
            if (!cursor.isClosed)
                cursor.close()
        }
        return lista
    }
}