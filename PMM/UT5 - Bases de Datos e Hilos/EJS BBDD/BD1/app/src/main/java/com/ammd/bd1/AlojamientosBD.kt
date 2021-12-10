package com.ammd.bd1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class AlojamientosBD(
    context: Context,
    name: String,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        val crearTablaAlojamientos =
            "CREATE TABLE ${AlojamientosDAO.TABLA_ALOJAMIENTOS} (" +
                    "CÓDIGO_ALOJAMIENTO INTEGER PRIMARY KEY AUTOINCREMENTAL," +
                    "DENOMINACIÓN VARCHAR," +
                    "LOCALIDAD VARCHAR," +
                    "PRECIO	 INTEGER," +
                    "IMAGEN_ALOJAMIENTO INTEGER," +
                    "TELEFONO INTEGER," +
                    "EMAIL VARCHAR," +
                    "DETALLES VARCHAR," +
                    "ACTIVIDADES VARCHAR," +
                    "FAVORITO INTEGER" +
                    ");"
        try {
            db?.execSQL(crearTablaAlojamientos)
        } catch (e: SQLiteException) {
            println(
                "Error al crear la tabla:" +
                        "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH "
                        + e
            )
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }


}