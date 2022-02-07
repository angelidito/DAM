package com.sde.ejtiendas

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class TiendaBD (context: Context, name:String, factory: SQLiteDatabase.CursorFactory?, version:Int)
    : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        val crearTablaTienda = "CREATE TABLE ${TiendasDAO.TABLA_TIENDA}" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, favorito INTEGER)"
        db!!.execSQL(crearTablaTienda)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}