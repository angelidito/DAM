package com.ppsg.ej1basesdedatos

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
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

    fun addTienda(tienda: Tienda) {
        val values = ContentValues()
        values.put("nombre", tienda.name)
        values.put("favorito", tienda.esFavorito)
        mBD.insert(TABLA_TIENDA, null, values)
    }

    fun getAllTiendas(): MutableList<Tienda> {
        val lista: MutableList<Tienda> = ArrayList()
        val cursor: Cursor = mBD.query(TABLA_TIENDA, null, null, null, null, null, null)
        if (cursor.moveToFirst()) {
            do {
                lista.add(
                    Tienda(
                        cursor.getInt(0),
                        cursor.getString(cursor.getColumnIndexOrThrow("nombre")),
                        cursor.getInt(
                            cursor.getColumnIndexOrThrow("favorito")
                        )
                    )
                )
            } while (cursor.moveToNext())
            if (!cursor.isClosed)
                cursor.close()
        }
        return lista
    }

    fun updateTienda(tienda: Tienda) {
        val values=ContentValues()
        values.put("nombre",tienda.name)
        values.put("favorito",tienda.esFavorito)
        val argumentos= arrayOf(tienda.id.toString())
        mBD.update(TABLA_TIENDA,values,"id=?",argumentos)
    }

    fun deleteTienda(id:Int){
        val argumentos= arrayOf(id.toString())
        mBD.delete(TABLA_TIENDA,"id=?",argumentos)

    }
}