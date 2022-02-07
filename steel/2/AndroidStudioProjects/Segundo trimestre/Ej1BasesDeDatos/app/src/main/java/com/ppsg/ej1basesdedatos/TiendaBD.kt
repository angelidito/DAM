package com.ppsg.ej1basesdedatos

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

class TiendaBD(context: Context,name:String, factory:SQLiteDatabase.CursorFactory?, version:Int)
    :SQLiteOpenHelper(context,name,factory,version) {

    //Creas las tablas (NO HABLAMOS DE DATOS, SOLO ESTRUCTURA)
    override fun onCreate(db: SQLiteDatabase?) {
        //El try te saca si has tenido un error en el SQL
        try {
            val crearTablaTienda="CREATE TABLE ${TiendaDAO.TABLA_TIENDA} " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " nombre TEXT, favorito INTEGER)"
            //Con las !! decimos que sabemos que ese dato es no nulo, para poder ejecutarlo
            db!!.execSQL(crearTablaTienda)
        }catch (e:SQLiteException){

        }

    }

    //Actualizas la estructura de la tabla -pudiendo añadir campos o modificarlos-(NO HABLAMOS DE DATOS, SOLO ESTRUCTURA)
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}