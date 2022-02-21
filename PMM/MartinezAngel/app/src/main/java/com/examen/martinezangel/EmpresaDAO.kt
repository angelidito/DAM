package com.examen.martinezangel

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class EmpresaDAO(context: Context) {
    private val database: SQLiteDatabase

    companion object {
        const val DATABASE_NAME = "EMPRESA"
        const val DATABASE_VERSION = 1
        const val TABLA_CATEGORIAS = "CATEGORIAS"
        const val TABLA_PRODUCTOS = "PRODUCTOS"
        const val TABLA_USUARIOS = "USUARIOS"
        const val TABLA_LISTADESEOS = "LISTADESEOS"
    }

    init {
        val estructura = EmpresaBD(context, DATABASE_NAME, null, DATABASE_VERSION)
        database = estructura.writableDatabase
    }

    fun logIn(login: String, contrasena: String): Boolean {
        var sql =
            "select * from $TABLA_USUARIOS where login = $login and contrasena = $contrasena"
        val cursor: Cursor = database.rawQuery(sql, null)
        if (cursor.moveToFirst())
            if (
                cursor.getString(cursor.getColumnIndexOrThrow("login")).compareTo(login) == 0
                && cursor.getString(cursor.getColumnIndexOrThrow("contrasena"))
                    .compareTo(contrasena) == 0
            ) {
                if (!cursor.isClosed) {
                    cursor.close()
                }
                return true
            }
        return false
    }

    fun getProductosFrom(categoria: String): MutableList<Producto> {
        val listaProductos: MutableList<Producto> = ArrayList()
        val cursor: Cursor
        if (categoria.compareTo("*") == 0) {
            cursor =
                database.rawQuery(
                    "SELECT * FROM $TABLA_PRODUCTOS",
                    null
                )
        } else {
            cursor =
                database.rawQuery(
                    "SELECT * FROM $TABLA_PRODUCTOS WHERE codigoCategoria = '$categoria'",
                    null
                )
        }
        if (cursor.moveToFirst()) {
            do {
                listaProductos.add(
                    Producto(
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoProducto")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoCategoria")),
                        cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("pvp")),
                        cursor.getString(cursor.getColumnIndexOrThrow("imagenProducto")),
                        cursor.getString(cursor.getColumnIndexOrThrow("color")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("talla"))
                    )
                )
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return listaProductos
    }

    fun getCategorias(): MutableList<Categoria> {
        val listaCategorias: MutableList<Categoria> = ArrayList()
        val cursor = database.rawQuery("SELECT * FROM $TABLA_CATEGORIAS", null)

        if (cursor.moveToFirst()) {
            do {
                listaCategorias.add(
                    Categoria(
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoCategoria")),
                        cursor.getString(cursor.getColumnIndexOrThrow("denominacion"))
                    )
                )
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return listaCategorias

    }

    fun añadirProductoListaDeseos(codigoProducto: Int, codigoUsuario: Int) {
        database.execSQL("INSERT INTO $TABLA_LISTADESEOS (codigoProducto, codigoUsuario) values ('$codigoProducto', '$codigoUsuario');")
    }

    fun eliminarProductoListaDeseos(codigoProducto: Int, codigoUsuario: Int) {
        database.execSQL("DELETE FROM $TABLA_LISTADESEOS WHERE codigoProducto='$codigoProducto' and codigoUsuario='$codigoUsuario');")
    }

    fun getProductosListaDeseos(codigoUsuario: Int): MutableList<Producto> {
        val listaProductos: MutableList<Producto> = ArrayList()
        var sql =
            "select * from $TABLA_PRODUCTOS where codigoProducto in (select codigoProducto from $TABLA_LISTADESEOS where codigoUsuario='$codigoUsuario');"
        val cursor: Cursor = database.rawQuery(sql, null)

        if (cursor.moveToFirst()) {
            do {
                listaProductos.add(
                    Producto(
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoProducto")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoCategoria")),
                        cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("pvp")),
                        cursor.getString(cursor.getColumnIndexOrThrow("imagenProducto")),
                        cursor.getString(cursor.getColumnIndexOrThrow("color")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("talla"))
                    )
                )
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return listaProductos
    }

    fun productoEnLista(codigoProducto: Int, codigoUsuario: Int): Boolean {
        val listaProductos: MutableList<Producto> = ArrayList()
        var sql =
            "select * from $TABLA_LISTADESEOS where codigoUsuario='$codigoUsuario' and codigoProducto='$codigoProducto';"
        val cursor: Cursor = database.rawQuery(sql, null)

        if (cursor.moveToFirst()) {
            if (!cursor.isClosed) {
                cursor.close()
            }
            return true
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return false
    }


}