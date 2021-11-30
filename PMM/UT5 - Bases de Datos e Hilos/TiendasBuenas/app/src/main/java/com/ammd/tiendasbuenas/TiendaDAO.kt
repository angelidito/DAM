package com.ammd.tiendasbuenas

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class TiendaDAO(context: Context) {
    private val mBD: SQLiteDatabase

    companion object {
        val DATABASE_NAME = "tiendasbd"
        val DATABASE_VERSION = 1
        val TABLA_TIENDA = "tiendas"
    }

    init {
        val estructura = TiendaBD(context, DATABASE_NAME, factory = null, DATABASE_VERSION)

        mBD = estructura.writableDatabase
    }

     fun addTienda(tienda: Tienda) {
        val values = ContentValues()
        values.put("nombre", tienda.nombre)
        values.put("favorito", tienda.esFavorito)
        mBD.insert(TABLA_TIENDA, null, values)
    }

}