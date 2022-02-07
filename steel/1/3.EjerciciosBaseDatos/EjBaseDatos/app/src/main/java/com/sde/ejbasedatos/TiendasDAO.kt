package com.sde.ejbasedatos

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class TiendasDAO(context: Context) {
    private val mBD:SQLiteDatabase
    companion object{
        val DATABASE_NAME ="tiendasbd"
        val DATABASE_VERSION=1
        val TABLA_TIENDA="ejbasedatos"
    }

    init {
        val estructura = TiendaBD(context, DATABASE_NAME,null, DATABASE_VERSION)
        mBD = estructura.writableDatabase
    }

    fun addTienda(tienda: Tienda){
        val values= ContentValues()
        values.put("nombre",tienda.name)
        values.put("favorito",tienda.esFavorito)
        mBD.insert(TABLA_TIENDA,null,values)
    }

    fun getAllTiendas():MutableList<Tienda>{
        val lista:MutableList<Tienda> = ArrayList()
        val cursor:Cursor =mBD.query(TABLA_TIENDA,null,null,null,null,null,null,)
        if(cursor.moveToFirst()){
            do{
                lista.add(Tienda(cursor.getInt(0),
                    cursor.getString(cursor.getColumnIndexOrThrow("nombre")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("favorito"))))
            }while (cursor.moveToNext())
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return lista
    }

    fun updateTienda(tienda: Tienda){
        val values=ContentValues()
        values.put("nombre",tienda.name)
        values.put("favorito",tienda.esFavorito)
        val args= arrayOf(tienda.id.toString())
        mBD.update(TABLA_TIENDA,values,"id=?",args)
    }

    fun deleteTienda(id:Int){
        val args= arrayOf(id.toString())
        mBD.delete( TABLA_TIENDA,"id=?",args)
    }
}

// ContentValues es una coleccion de solo un registro