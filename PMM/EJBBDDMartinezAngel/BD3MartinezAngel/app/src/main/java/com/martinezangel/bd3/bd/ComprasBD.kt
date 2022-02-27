package com.martinezangel.bd3.bd

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class ComprasBD(
    context: Context,
    name: String,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(database: SQLiteDatabase?) {
        var sqlQueries = arrayOf(
            "CREATE TABLE ${ComprasDAO.TABLA_PRODUCTOS} (codigoProducto INTEGER PRIMARY KEY AUTOINCREMENT, denominacion TEXT, codigoCategoria INTEGER, imagen TEXT)",
            "CREATE TABLE ${ComprasDAO.TABLA_CATEGORIAS} (codigoCategoria INTEGER PRIMARY KEY AUTOINCREMENT, denominacion TEXT)",
            "CREATE TABLE ${ComprasDAO.TABLA_LISTAS} (codigoLista INTEGER PRIMARY KEY AUTOINCREMENT, denominacion TEXT)",
            "CREATE TABLE ${ComprasDAO.TABLA_LISTAS_PRODUCTOS} (codigoListaProducto INTEGER PRIMARY KEY AUTOINCREMENT, codigoLista INTEGER, codigoProducto INTEGER, cantidad INTEGER)",

            "INSERT into ${ComprasDAO.TABLA_PRODUCTOS} (denominacion, codigoCategoria, imagen) VALUES ('Yate', 1,          'https://upload.wikimedia.org/wikipedia/commons/d/de/%C3%81lvaro_Baeza_Gui%C3%B1ez%2C_Abogado_Chileno.jpg')",
            "INSERT into ${ComprasDAO.TABLA_PRODUCTOS} (denominacion, codigoCategoria, imagen) VALUES ('Sardina', 2,       'https://upload.wikimedia.org/wikipedia/commons/d/de/%C3%81lvaro_Baeza_Gui%C3%B1ez%2C_Abogado_Chileno.jpg')",
            "INSERT into ${ComprasDAO.TABLA_PRODUCTOS} (denominacion, codigoCategoria, imagen) VALUES ('Cañonero', 1,      'https://upload.wikimedia.org/wikipedia/commons/d/de/%C3%81lvaro_Baeza_Gui%C3%B1ez%2C_Abogado_Chileno.jpg')",
            "INSERT into ${ComprasDAO.TABLA_PRODUCTOS} (denominacion, codigoCategoria, imagen) VALUES ('Mister Limpio', 3, 'https://upload.wikimedia.org/wikipedia/commons/d/de/%C3%81lvaro_Baeza_Gui%C3%B1ez%2C_Abogado_Chileno.jpg')",
            "INSERT into ${ComprasDAO.TABLA_PRODUCTOS} (denominacion, codigoCategoria, imagen) VALUES ('K-Yate', 1,        'https://upload.wikimedia.org/wikipedia/commons/d/de/%C3%81lvaro_Baeza_Gui%C3%B1ez%2C_Abogado_Chileno.jpg')",
            "INSERT into ${ComprasDAO.TABLA_PRODUCTOS} (denominacion, codigoCategoria, imagen) VALUES ('Pescadilla', 2,    'https://upload.wikimedia.org/wikipedia/commons/d/de/%C3%81lvaro_Baeza_Gui%C3%B1ez%2C_Abogado_Chileno.jpg')",
            "INSERT into ${ComprasDAO.TABLA_PRODUCTOS} (denominacion, codigoCategoria, imagen) VALUES ('Vergantín', 1,     'https://upload.wikimedia.org/wikipedia/commons/d/de/%C3%81lvaro_Baeza_Gui%C3%B1ez%2C_Abogado_Chileno.jpg')",
            "INSERT into ${ComprasDAO.TABLA_CATEGORIAS} (denominacion) VALUES ('Barcos')",
            "INSERT into ${ComprasDAO.TABLA_CATEGORIAS} (denominacion) VALUES ('Peces')",
            "INSERT into ${ComprasDAO.TABLA_CATEGORIAS} (denominacion) VALUES ('Limpieza')",
        )
//        Thread {
//            Thread.sleep(2500)
        for (sql in sqlQueries) {
            try {
//                    Thread.sleep(750)

                database?.execSQL(sql)
                println("\nEJECUTADA la sentencia \"$sql\"")
            } catch (e: SQLiteException) {
                println("\nERROR al ejecutar la sentencia \"$sql\"")
                e.printStackTrace()
            }
        }
//        }.start()
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }
}