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
        val estructura = AlojamientosBD(
            context,
            DATABASE_NAME,
            factory = null,
            DATABASE_VERSION
        )

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
        val sql = "select * from $TABLA_ALOJAMIENTOS"
        val cursor: Cursor = database.rawQuery(sql, null)

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
        val sql = "select * from $TABLA_ALOJAMIENTOS where localidad LIKE '%$localidad%'"
        val cursor: Cursor = database.rawQuery(sql, null)

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

    fun updateAlojamiento(alojamiento: Alojamientos) {
        val values = ContentValues()

        values.put("DENOMINACION", alojamiento.denominacion)
        values.put("FAVORITO", alojamiento.favorito)

        database.update(
            TABLA_ALOJAMIENTOS,
            values,
            "CODIGO_ALOJAMIENTO = ?",
            arrayOf(alojamiento.codigo_alojamiento.toString())
        )

    }

    fun deleteAlojamiento(id: Int) {
        val args = arrayOf(id.toString())
        database.delete(TABLA_ALOJAMIENTOS, "CODIGO_ALOJAMIENTO = ?", args)
    }

    fun addAlojamientosPrueba() {
        addAlojamiento(
            Alojamientos(
                1,
                "Alohamiendos Mori",
                "Burgos",
                54,
                "https://www.tourinews.es/uploads/s1/74/92/70/" +
                        "hotel-juan-carlos-i-en-barcelona-foto-de-" +
                        "wikimedia-commons-cc-by-sa-4-0_4_732x400.jpeg",
                618245190,
                "correo@yopmail.com",
                ", detalle,vdetalle, detalle, detalle",
                "actividades, actividad, actividad, actividad",
                0
            )
        )

        addAlojamiento(
            Alojamientos(
                1,
                "Alohamiendos Lojados",
                "Burgo de Areas",
                32,
                "https://upload.wikimedia.org/wikipedia/" +
                        "commons/d/de/%C3%81lvaro_Baeza_Gui%C3%B1ez%2C_Abogado_Chileno.jpg",
                618295190,
                "correo2@yopmail.com",
                "detalles del alojamiento...  umo, dos, tres, probando, probando",
                "ache coltio che caaity tkeurent: 0xakeCrent: 0xa",
                0
            )
        )

        addAlojamiento(
            Alojamientos(
                1,
                "Alohamiendos Mori 290",
                "Burgos",
                54,
                "https://www.tourinews.es/uploads/s1/74/92/70/" +
                        "hotel-juan-carlos-i-en-barcelona-foto-de-" +
                        "wikimedia-commons-cc-by-sa-4-0_4_732x400.jpeg",
                618245190,
                "correo@yopmail.com",
                ", detalle,vdetalle, detalle, detalle",
                "actividades, actividad, actividad, actividad",
                0
            )
        )

        addAlojamiento(
            Alojamientos(
                1,
                "Alohamiendos Mori 2345",
                "Burgos",
                54,
                "https://www.tourinews.es/uploads/s1/74/92/70/" +
                        "hotel-juan-carlos-i-en-barcelona-foto-de-" +
                        "wikimedia-commons-cc-by-sa-4-0_4_732x400.jpeg",
                618245190,
                "correo@yopmail.com",
                ", detalle,vdetalle, detalle, detalle",
                "actividades, actividad, actividad, actividad",
                0
            )
        )

        addAlojamiento(
            Alojamientos(
                1,
                "Alohamiendos Mori 5455",
                "Burgos",
                54,
                "https://www.tourinews.es/uploads/s1/74/92/70/" +
                        "hotel-juan-carlos-i-en-barcelona-foto-de-" +
                        "wikimedia-commons-cc-by-sa-4-0_4_732x400.jpeg",
                618245190,
                "correo@yopmail.com",
                ", detalle,vdetalle, detalle, detalle",
                "actividades, actividad, actividad, actividad",
                0
            )
        )
    }
}

