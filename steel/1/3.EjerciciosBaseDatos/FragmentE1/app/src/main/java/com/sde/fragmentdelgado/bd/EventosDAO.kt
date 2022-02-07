package com.sde.fragmentdelgado.bd

import android.content.Context
import android.database.sqlite.SQLiteDatabase

class EventosDAO (context: Context) {
    private val mBD: SQLiteDatabase

    companion object {
        const val DATABASE_NAME = "eventosbd"
        const val DATABASE_VERSION = 1
        const val TABLA_USUARIOS = "usuarios"
        const val TABLA_EVENTOS = "eventos"
        const val TABLA_EVENTOS_USUARIO = "eventosUsuario"
    }

    init {
        val estructura = EventosBD(context, DATABASE_NAME, null, DATABASE_VERSION)
        mBD = estructura.writableDatabase
    }
}