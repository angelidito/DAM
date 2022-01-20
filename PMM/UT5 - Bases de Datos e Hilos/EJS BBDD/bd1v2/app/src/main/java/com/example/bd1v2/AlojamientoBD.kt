package com.example.bd1v2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.ammd.bd1.AlojamientosDAO

class AlojamientoBD(context: Context, name:String, factory: SQLiteDatabase.CursorFactory?, version:Int)
    : SQLiteOpenHelper(context, name, factory, version){
    override fun onCreate(db: SQLiteDatabase?) {
        val crearTablaAlojamiento="CREATE TABLE ${AlojamientosDAO.TABLA_ALOJAMIENTOS}" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, denominacion TEXT, precioNoche INTEGER, favorito INTEGER)"
        db!!.execSQL(crearTablaAlojamiento)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
    }