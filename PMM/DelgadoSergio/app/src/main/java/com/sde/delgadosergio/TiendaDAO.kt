package com.sde.delgadosergio

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class TiendaDAO (context: Context){
    private val mBD: SQLiteDatabase

    companion object{
        const val DATABASE_NAME = "DelgadoSergio"
        const val DATABASE_VERSION = 1
        const val TABLA_CATEGORIAS = "categorias"
        const val TABLA_PRODUCTOS = "productos"
        const val TABLA_USUARIOS = "usuarios"
        const val TABLA_LISTA_DESEOS = "listaDeseos"
    }

    init {
        val  estructura = TiendaBD(context, DATABASE_NAME,null, DATABASE_VERSION)
        mBD = estructura.writableDatabase
    }

    // Si devuelve el id del usuario es que existe. Si devuelve "", no existe
    fun consultaLogin(usuario: String, pass: String): String{
        var perfil = ""
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_USUARIOS WHERE login = '$usuario' AND password = '$pass'",null)
        // Si encuentra registros (el usuario es correcto)
        if (cursor.moveToFirst()) {
            // Obtiene el id del usuario (S/A)
            perfil = cursor.getString(cursor.getColumnIndexOrThrow("codUsuario"))

            if (!cursor.isClosed)
                cursor.close()
        }
        return perfil
    }

    fun consultaCategorias():MutableList<Categoria> {
        val listaCategorias: MutableList<Categoria> = ArrayList()
        val cursor: Cursor = mBD.query(TABLA_CATEGORIAS, null, null, null, null, null, null,)
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

    fun consultaProductosCategoria(codCategoria: Int):MutableList<Producto>{
        val listaProductos: MutableList<Producto> = ArrayList()
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_PRODUCTOS WHERE codCategoria = '$codCategoria'",null)
        if(cursor.moveToFirst()){
            do{
                listaProductos.add(
                    Producto(
                        cursor.getInt(cursor.getColumnIndexOrThrow("codProducto")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("codCategoria")),
                        cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("pvp")),
                        cursor.getString(cursor.getColumnIndexOrThrow("imagen")),
                        cursor.getString(cursor.getColumnIndexOrThrow("color")),
                        cursor.getString(cursor.getColumnIndexOrThrow("talla")))
                )
            }while (cursor.moveToNext())
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return listaProductos
    }

    fun productoEstaEnFavoritos(codUsuario: String, codProducto: String): Boolean{
        var esta = false;
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_LISTA_DESEOS WHERE codUsuario = '$codUsuario' AND codProducto = '$codProducto'",null)
        // Si encuentra registros (el producto está en la lista de favoritos)
        if (cursor.moveToFirst()) {
            esta = true

            if (!cursor.isClosed)
                cursor.close()
        }
        return esta
    }

    fun addProductoFavoritos(codUsuario: String, codProducto: String){
        mBD.execSQL("INSERT into $TABLA_LISTA_DESEOS (codUsuario, codProducto) values ('$codUsuario', '$codProducto');")
    }

    fun eliminarProductoLista(codUsuario: String, codProducto: String){
        mBD.execSQL("DELETE FROM $TABLA_LISTA_DESEOS where codUsuario = '$codUsuario' AND codProducto = '$codProducto';")
    }
}