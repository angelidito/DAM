package com.example.bd3delgadosergio.BD

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ListaBD (context: Context, name:String, factory: SQLiteDatabase.CursorFactory?, version:Int)
    : SQLiteOpenHelper(context, name, factory, version){

    // Cuando no existe la BBDD se ejecuta este método
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE ${ListaDAO.TABLA_CATEGORIAS} (codCategoria INTEGER PRIMARY KEY AUTOINCREMENT, denominacion TEXT)")

        db.execSQL("CREATE TABLE ${ListaDAO.TABLA_PRODUCTOS} (codProducto INTEGER PRIMARY KEY AUTOINCREMENT, denominacion TEXT, idCategoria INTEGER, imagen TEXT)")

        db.execSQL("CREATE TABLE ${ListaDAO.TABLA_LISTAS} (codLista INTEGER PRIMARY KEY AUTOINCREMENT, denominacion TEXT)")

        db.execSQL("CREATE TABLE ${ListaDAO.TABLA_LISTAS_PRODUCTOS} (codigo INTEGER PRIMARY KEY AUTOINCREMENT, codLista INTEGER, codProducto INTEGER, cantidad INTEGER)")

        Thread {    // Hilo secundario para insertar toda la info
            db.execSQL("INSERT into CATEGORIAS (denominacion) values ('Comida 🥐');")
            db.execSQL("INSERT into CATEGORIAS (denominacion) values ('Higiene 🚿');")

        }.start()
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}