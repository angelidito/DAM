package com.ammd.tiendasbuenas

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class TiendaDAO(context: Context) {
    private val database: SQLiteDatabase

    companion object {
        val DATABASE_NAME = "tiendasbd"
        val DATABASE_VERSION = 1
        val TABLA_TIENDA = "tiendas"
    }

    init {
        val estructura = TiendaBD(context, DATABASE_NAME, factory = null, DATABASE_VERSION)

        database = estructura.writableDatabase
    }

    fun addTienda(tienda: Tienda) {
        val values = ContentValues()
        values.put("nombre", tienda.nombre)
        values.put("favorito", tienda.esFavorito)
        database.insert(TABLA_TIENDA, null, values)
    }

    fun getAllTiendas(): MutableList<Tienda> {
        val lista: MutableList<Tienda> = ArrayList()
        val cursor: Cursor = database.query(
            TABLA_TIENDA, null, null, null, null, null, null, null
        )

        if (cursor.moveToFirst()) {
            do {
                lista.add(
                    Tienda(
                        cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                        cursor.getString(cursor.getColumnIndexOrThrow("nombre")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("favorito"))
                    )
                )
            } while (cursor.moveToNext())
        }

        if (!cursor.isClosed)
            cursor.close()

        return lista
    }

}