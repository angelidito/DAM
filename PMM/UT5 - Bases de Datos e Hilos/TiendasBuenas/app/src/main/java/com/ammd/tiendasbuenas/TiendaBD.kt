package com.ammd.tiendasbuenas

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class TiendaBD(
    context: Context,
    name: String,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        val crearTablaTienda =
            "CREATE TABLE ${TiendaDAO.TABLA_TIENDA} (" +
                    "id INTEGER PRIMARY KEY , " +
                    "nombre TEXT," +
                    "favorito INTEGER" +
                    ");"
        try {
            db?.execSQL(crearTablaTienda)
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