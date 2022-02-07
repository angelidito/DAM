package com.sde.fragmentdelgado.bd

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class EventosBD (context: Context, name:String, factory: SQLiteDatabase.CursorFactory?, version:Int)
    : SQLiteOpenHelper(context, name, factory, version){

    // Cuando no existe la BBDD se ejecuta este método
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE ${EventosDAO.TABLA_USUARIOS} (codUsuario INTEGER PRIMARY KEY AUTOINCREMENT, login TEXT, password TEXT, perfil TEXT)")

        db.execSQL("CREATE TABLE ${EventosDAO.TABLA_EVENTOS} (codEvento INTEGER PRIMARY KEY AUTOINCREMENT, fecha TEXT, titulo TEXT, descripcion TEXT)")

        db.execSQL("CREATE TABLE ${EventosDAO.TABLA_EVENTOS_USUARIO} (codEventoUsuario INTEGER PRIMARY KEY AUTOINCREMENT, codUsuario INTEGER, codEvento INTEGER)")

        db.execSQL("INSERT into usuarios (login, password, perfil) values ('PedroPa', '123', 'A');")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}