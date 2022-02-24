package com.sde.delgadosergio

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class TiendaBD (context: Context, name:String, factory: SQLiteDatabase.CursorFactory?, version:Int)
    : SQLiteOpenHelper(context, name, factory, version){

    // Cuando no existe la BBDD se ejecuta este método
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL ("CREATE TABLE ${TiendaDAO.TABLA_CATEGORIAS}" +
                "(codigoCategoria INTEGER PRIMARY KEY AUTOINCREMENT, denominacion TEXT)")

        db.execSQL ("CREATE TABLE ${TiendaDAO.TABLA_PRODUCTOS}" +
                "(codProducto INTEGER PRIMARY KEY AUTOINCREMENT, codCategoria INTEGER, denominacion TEXT, pvp INTEGER, imagen TEXT, color TEXT, talla TEXT)")


        db.execSQL ("CREATE TABLE ${TiendaDAO.TABLA_USUARIOS}" +
                "(codUsuario INTEGER PRIMARY KEY AUTOINCREMENT, login TEXT, password TEXT, nombre TEXT)")


        db.execSQL ("CREATE TABLE ${TiendaDAO.TABLA_LISTA_DESEOS}" +
                "(codigoLista INTEGER PRIMARY KEY AUTOINCREMENT, codUsuario INTEGER, codProducto INTEGER)")

        Thread {    // Hilo secundario para insertar toda la info
            db.execSQL("INSERT into CATEGORIAS (denominacion) values ('Camisetas')")
            db.execSQL("INSERT into CATEGORIAS (denominacion) values ('Pantalones')")

            db.execSQL("INSERT into PRODUCTOS (codCategoria, denominacion, pvp, imagen, color, talla) values (1, 'Camiseta manga corta Nike', 8, 'https://cdn.deporvillage.com/cdn-cgi/image/h=576,w=576,dpr=1,f=auto,q=75,fit=contain,background=white/product/ni-bv5631-010_001.jpg', 'Negro', 'M')")
            db.execSQL("INSERT into PRODUCTOS (codCategoria, denominacion, pvp, imagen, color, talla) values (1, 'Camiseta manga corta Jordan', 9, 'https://www.manelsanchez.com/uploads/media/images/396x396/jordan-air-wordmark-t-shirt-blackred-1.jpg', 'Negro', 'S')")
            db.execSQL("INSERT into PRODUCTOS (codCategoria, denominacion, pvp, imagen, color, talla) values (2, 'Pantalón corto Jeans', 12, 'https://img01.ztat.net/article/spp-media-p1/f6d2d0130748448e803ad420cf3542d4/c47cc018a21e4d5ebd0ae9cb2b3686ec.jpg?imwidth=1800&filter=packshot', 'Rosa', 'L')")

            db.execSQL("INSERT into USUARIOS (login, password, nombre) values ('Luis15', '123', 'Luis')")
            db.execSQL("INSERT into USUARIOS (login, password, nombre) values ('Nico69', '123', 'Nicolás')")

            db.execSQL("INSERT into LISTADESEOS (codUsuario, codProducto) values (1, 1)")
            db.execSQL("INSERT into LISTADESEOS (codUsuario, codProducto) values (1, 2)")
            db.execSQL("INSERT into LISTADESEOS (codUsuario, codProducto) values (2, 3)")
        }.start()
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}