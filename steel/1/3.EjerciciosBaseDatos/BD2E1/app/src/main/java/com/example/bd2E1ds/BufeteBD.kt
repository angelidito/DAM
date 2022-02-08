package com.example.bd2E1ds

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BufeteBD (context: Context, name:String, factory: SQLiteDatabase.CursorFactory?, version:Int)
: SQLiteOpenHelper(context, name, factory, version){

    // Cuando no existe la BBDD se ejecuta este método
    override fun onCreate(db: SQLiteDatabase?) {
        val crearTablaUsuarios = "CREATE TABLE ${BufeteDAO.TABLA_USUARIOS}" +
                "(numColegiado INTEGER PRIMARY KEY, nombre TEXT, login TEXT UNIQUE, contra TEXT, tipoPerfil TEXT)"
        db!!.execSQL(crearTablaUsuarios)

        val crearTablaCasos = "CREATE TABLE ${BufeteDAO.TABLA_CASOS}" +
                "(numCaso INTEGER PRIMARY KEY AUTOINCREMENT, denominacion TEXT, fechaApertura TEXT, caracteristicas TEXT, numAbogado INTEGER)"
        db.execSQL(crearTablaCasos)

        val crearTablaGestiones = "CREATE TABLE ${BufeteDAO.TABLA_GESTIONES}" +
                "(numGestion INTEGER PRIMARY KEY AUTOINCREMENT, numCaso INTEGER, fecha TEXT, descripcion TEXT, realizado TEXT)"
        db.execSQL(crearTablaGestiones)

        Thread {    // Hilo secundario para insertar toda la info
            val crearUsuario1 = "INSERT into USUARIOS values (111, 'Luis Calvo', 'Luis15', '123', 'S');"
            val crearUsuario2 = "INSERT into USUARIOS values (222, 'Juan Sánchez', 'Juan69', '1234', 'A');"
            db.execSQL(crearUsuario1)
            db.execSQL(crearUsuario2)

            val crearCaso1 = "INSERT into CASOS (denominacion, fechaApertura, caracteristicas, numAbogado) values ('Caso del Asesino Inesperado', '04-01-2022', 'Asesinato de Juanma Rodríguez por herida de arma blanca. Principal sospechoso: Cristóbal Soria', 111);"
            val crearCaso2 = "INSERT into CASOS (denominacion, fechaApertura, caracteristicas, numAbogado) values ('Caso de los Ladrones Mojados', '26-06-2015', 'Varios robos en el centro de California a cargo de John Francis y Lewis Hamilton', 222);"
            db.execSQL(crearCaso1)
            db.execSQL(crearCaso2)

            val crearGestion1 = "INSERT into GESTIONES (numCaso, fecha, descripcion, realizado) values (1, '05-01-2022', 'Caso abierto, en proceso', 'NO');"
            val crearGestion2 = "INSERT into GESTIONES (numCaso, fecha, descripcion, realizado) values (2, '30-06-2015', 'Se produjo la detención de los ladrones y se obtuvo el 80% del botín estimado que habían robado', 'SI');"
            db.execSQL(crearGestion1)
            db.execSQL(crearGestion2)

        }.start()
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}