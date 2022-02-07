package com.sde.bd1delgadosergio

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AlojamientoBD(context: Context, name:String, factory: SQLiteDatabase.CursorFactory?, version:Int)
    : SQLiteOpenHelper(context, name, factory, version){

    // Cuando no existe la bbdd se ejecuta este método
    override fun onCreate(db: SQLiteDatabase?) {
        val crearTablaAlojamiento = "CREATE TABLE ${AlojamientoDAO.TABLA_ALOJAMIENTOS}" +
                "(codigo INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, localidad TEXT, precio INTEGER, imagen TEXT, telefono INTEGER, email TEXT, detalles TEXT, actividades TEXT, favorito INTEGER)"
        db!!.execSQL(crearTablaAlojamiento)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}