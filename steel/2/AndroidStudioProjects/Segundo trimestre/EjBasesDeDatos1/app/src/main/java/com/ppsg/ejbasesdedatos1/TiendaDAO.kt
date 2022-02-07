package com.ppsg.ejbasesdedatos1


import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

//En esta clase me voy a definir los metodos para poder eliminar, modificar y añadir los datos de mi tabla de SQL
class TiendaDAO(contexto: Context) {
    private val mBD: SQLiteDatabase

    //Ponemos poner el nombre de la tabla, de algún campo... -companion = static en java-
    companion object {
        val DATABASE_NAME = "tiendasbd"
        val DATABASE_VERSION = 1
        val TABLA_TIENDA = "tiendas"
    }

    init {
        val estructura = TiendaBD(contexto, DATABASE_NAME, null, DATABASE_VERSION)
        mBD = estructura.writableDatabase
    }

    public fun addTienda(tienda: Tienda) {
        val values = ContentValues()
        values.put("nombre", tienda.name)
        values.put("favorito", tienda.esFavorito)
        mBD.insert(TABLA_TIENDA,null,values)
    }
}