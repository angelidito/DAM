package com.ammd.bd1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class AlojamientosDAO(context: Context) {
    private val database: SQLiteDatabase

    companion object {
        val DATABASE_NAME = "alojamientosdb"
        val DATABASE_VERSION = 1
        val TABLA_ALOJAMIENTOS = "alojamientos"
    }

    init {
        val estructura = AlojamientosBD(context, DATABASE_NAME, factory = null, DATABASE_VERSION)

        database = estructura.writableDatabase
    }

    fun addAlojamiento(alojamiento: Alojamientos) {
        val values = ContentValues()
        values.put("denominacion", alojamiento.denominacion)
        values.put("localidad", alojamiento.localidad)
        values.put("precio", alojamiento.precio)
        values.put("imagen_alojamiento", alojamiento.imagen_alojamiento)
        values.put("telefono", alojamiento.telefono)
        values.put("email", alojamiento.email)
        values.put("detalles", alojamiento.detalles)
        values.put("actividades", alojamiento.actividades)
        values.put("favorito", alojamiento.favorito)
        database.insert(TABLA_ALOJAMIENTOS, null, values)
    }

    fun getAllAlojamiento(): MutableList<Alojamientos> {
        val lista: MutableList<Alojamientos> = ArrayList()
        val cursor: Cursor = database.query(
            TABLA_ALOJAMIENTOS, null, null, null,
            null, null, null, null
        )

        if (cursor.moveToFirst()) {
            do {
                lista.add(
                    Alojamientos(
                        cursor.getInt(cursor.getColumnIndexOrThrow("CODIGO_ALOJAMIENTO")),
                        cursor.getString(cursor.getColumnIndexOrThrow("DENOMINACION")),
                        cursor.getString(cursor.getColumnIndexOrThrow("LOCALIDAD")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("PRECIO")),
                        cursor.getString(cursor.getColumnIndexOrThrow("IMAGEN_ALOJAMIENTO")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("TELEFONO")),
                        cursor.getString(cursor.getColumnIndexOrThrow("EMAIL")),
                        cursor.getString(cursor.getColumnIndexOrThrow("DETALLES")),
                        cursor.getString(cursor.getColumnIndexOrThrow("ACTIVIDADES")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("FAVORITO"))
                    )
                )
            } while (cursor.moveToNext())
        }
        return lista
    }

    fun getAlojamientos(localidad: String): MutableList<Alojamientos> {
        val lista: MutableList<Alojamientos> = ArrayList()
        val cursor: Cursor = database.query(
            TABLA_ALOJAMIENTOS, null, "localidad LIKE %?%", arrayOf(localidad),
            null, null, null, null
        )

        if (cursor.moveToFirst()) {
            do {
                lista.add(
                    Alojamientos(
                        cursor.getInt(cursor.getColumnIndexOrThrow("CODIGO_ALOJAMIENTO")),
                        cursor.getString(cursor.getColumnIndexOrThrow("DENOMINACION")),
                        cursor.getString(cursor.getColumnIndexOrThrow("LOCALIDAD")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("PRECIO")),
                        cursor.getString(cursor.getColumnIndexOrThrow("IMAGEN_ALOJAMIENTO")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("TELEFONO")),
                        cursor.getString(cursor.getColumnIndexOrThrow("EMAIL")),
                        cursor.getString(cursor.getColumnIndexOrThrow("DETALLES")),
                        cursor.getString(cursor.getColumnIndexOrThrow("ACTIVIDADES")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("FAVORITO"))
                    )
                )
            } while (cursor.moveToNext())
        }

        if (!cursor.isClosed)
            cursor.close()

        return lista
    }

    fun updateAlojamiento(alojamiento: Alojamientos) {
        val values = ContentValues()
        val args = arrayOf(alojamiento.codigo_alojamiento.toString())

        values.put("DENOMINACION", alojamiento.denominacion)
        values.put("FAVORITO", alojamiento.favorito)
        database.update(TABLA_ALOJAMIENTOS, values, "CODIGO_ALOJAMIENTO = ?", args)
    }

    fun deleteAlojamiento(id: Int) {
        val args = arrayOf(id.toString())

        database.delete(TABLA_ALOJAMIENTOS, "CODIGO_ALOJAMIENTO = ?", args)
    }
}

