package com.ppsg.bd2saucopedropablo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

//Esta clase me permite crearme la estructura de mi base de datos
//context-->el boton(o la parte de xml donde lo vas a aplicar) donde vas a utilizarlo
//para utilizar para localizar rutas a la base de datos

//name--> nombre del archivo de base de datos-String: del archivo de base de datos, o nulo para una base de datos en memoria

//factory-->SQLiteDatabase.CursorFactory: para usar para crear objetos de cursor, o nulo para el valor predeterminado
//int: número de la base de datos (a partir de 1); si la base de datos es más antigua, se utilizará para actualizar la base de datos;

//version-->si la base de datos es más nueva, se utilizará para degradar la base de datos
class BufeteBD(
    context: Context,
    name: String,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    //Creas las tablas e introduces los datos
    override fun onCreate(db: SQLiteDatabase?) {
        //El try te saca si has tenido un error en el SQL
        try {
            //CREAS LA TABLA USUARIOS
            val crearTablaUsuarios = "CREATE TABLE ${BufeteDAO.TABLA_USUARIOS} " +
                    "(numeroColegiado TEXT PRIMARY KEY, " +
                    " nombre TEXT," +
                    " login TEXT, " +
                    " contrasena TEXT, tipo TEXT)"
            //Con las !! decimos que sabemos que ese dato es no nulo, para poder ejecutarlo
            db!!.execSQL(crearTablaUsuarios)
            val usuario1 =
                "INSERT into ${BufeteDAO.TABLA_USUARIOS} values ('1','PedroPa','pedro','123','A')"
            val usuario2 =
                "INSERT into ${BufeteDAO.TABLA_USUARIOS} values ('2','Sergio','sergio','123','S')"

            db.execSQL(usuario1)
            db.execSQL(usuario2)

            //CREAS LA TABLA CASOS
            val crearTablaCasos = "CREATE TABLE ${BufeteDAO.TABLA_CASOS} " +
                    "(numeroCaso INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " denominacion TEXT," +
                    " fecha TEXT, " +
                    " caracteristicas TEXT," +
                    " numAbogado TEXT)"
            db.execSQL(crearTablaCasos)
            val caso1 =
                "INSERT into ${BufeteDAO.TABLA_CASOS} ('denominacion','fecha','caracteristicas','numAbogado') values ('gurtel','7/5/2002','12345','1')"
            val caso2 =
                "INSERT into ${BufeteDAO.TABLA_CASOS} ('denominacion','fecha','caracteristicas','numAbogado') values ('nobita','13/10/2002','54321', '2')"

            db.execSQL(caso1)
            db.execSQL(caso2)

            //CREAS LA TABLA GESTIONES
            val crearTablaGestiones = "CREATE TABLE ${BufeteDAO.TABLA_GESTIONES} " +
                    "(numeroGestion INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " numeroCaso INTEGER," +
                    " fecha TEXT, " +
                    " descripcion TEXT, realizado TEXT)"
            db.execSQL(crearTablaGestiones)
            val gestion1 =
                "INSERT into ${BufeteDAO.TABLA_GESTIONES}('numeroCaso','fecha','descripcion','realizado') values ('1','10/9/2002','gurtel','SI')"
            val gestion2 =
                "INSERT into ${BufeteDAO.TABLA_GESTIONES}('numeroCaso','fecha','descripcion','realizado') values ('2','27/11/2002','bartomeu','NO')"

            db.execSQL(gestion1)
            db.execSQL(gestion2)
        } catch (e: SQLiteException) {
        }

    }

    //Actualizas la estructura de la tabla -pudiendo añadir campos o modificarlos-(NO HABLAMOS DE DATOS, SOLO ESTRUCTURA)
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}