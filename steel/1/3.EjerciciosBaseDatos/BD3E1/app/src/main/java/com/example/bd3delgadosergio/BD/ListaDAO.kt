package com.example.bd3delgadosergio.BD

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.bd3delgadosergio.Pojos.Categoria
import com.example.bd3delgadosergio.Pojos.ListaCompra
import com.example.bd3delgadosergio.Pojos.ListaProducto
import com.example.bd3delgadosergio.Pojos.Producto

class ListaDAO (context: Context) {
    private val mBD: SQLiteDatabase

    companion object{
        const val DATABASE_NAME = "listabd"
        const val DATABASE_VERSION = 1
        const val TABLA_CATEGORIAS = "categorias"
        const val TABLA_PRODUCTOS = "productos"
        const val TABLA_LISTAS = "listas"
        const val TABLA_LISTAS_PRODUCTOS = "listasProductos"
    }

    init {
        val estructura = ListaBD(context, DATABASE_NAME,null, DATABASE_VERSION)
        mBD = estructura.writableDatabase
    }

    fun consultaCategorias():MutableList<Categoria> {
        val listaCategorias: MutableList<Categoria> = ArrayList()
        val cursor: Cursor = mBD.query(TABLA_CATEGORIAS, null, null, null, null, null, null,)
        if (cursor.moveToFirst()) {
            do {
                listaCategorias.add(
                    Categoria(
                    cursor.getInt(cursor.getColumnIndexOrThrow("codCategoria")),
                    cursor.getString(cursor.getColumnIndexOrThrow("denominacion")))
                )
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return listaCategorias
    }

    fun nuevaCategoria(nombre: String){
        mBD.execSQL("INSERT INTO $TABLA_CATEGORIAS (denominacion) values ('$nombre');")
    }

    fun eliminarCategoria(nombre: String){
        mBD.execSQL("DELETE FROM $TABLA_CATEGORIAS where denominacion = '$nombre';")
    }

    fun consultaProductosCategoria(codCategoria: String):MutableList<Producto>{
        val listaProductos: MutableList<Producto> = ArrayList()
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_PRODUCTOS WHERE idCategoria = '$codCategoria'",null)
        if(cursor.moveToFirst()){
            do{
                listaProductos.add(
                    Producto(
                    cursor.getInt(cursor.getColumnIndexOrThrow("codProducto")),
                    cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("idCategoria")),
                    cursor.getString(cursor.getColumnIndexOrThrow("imagen")))
                )
            }while (cursor.moveToNext())
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return listaProductos
    }

    fun eliminarProducto(nombre: String){
        mBD.execSQL("DELETE FROM $TABLA_PRODUCTOS where denominacion = '$nombre';")
    }

    fun consultaNombreCategorias():ArrayList<String>{
        val listaCategorias: ArrayList<String> = ArrayList()
        val cursor: Cursor = mBD.query(TABLA_CATEGORIAS, null, null, null, null, null, null,)
        if (cursor.moveToFirst()) {
            do {
                listaCategorias.add(cursor.getString(cursor.getColumnIndexOrThrow("denominacion")))
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return listaCategorias
    }

    fun nuevoProducto(nombre: String, idCategoria: Int, url: String){
        mBD.execSQL("INSERT INTO $TABLA_PRODUCTOS (denominacion, idCategoria, imagen) values ('$nombre', '$idCategoria', '$url');")
    }

    fun consultaListas():MutableList<ListaCompra> {
        val listaListasCompra: MutableList<ListaCompra> = ArrayList()
        val cursor: Cursor = mBD.query(TABLA_LISTAS, null, null, null, null, null, null,)
        if (cursor.moveToFirst()) {
            do {
                listaListasCompra.add(
                    ListaCompra(
                        cursor.getInt(cursor.getColumnIndexOrThrow("codLista")),
                        cursor.getString(cursor.getColumnIndexOrThrow("denominacion")))
                )
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return listaListasCompra
    }

    fun eliminarLista(nombre: String){
        mBD.execSQL("DELETE FROM $TABLA_LISTAS where denominacion = '$nombre';")
    }

    fun nuevaLista(nombre: String){
        mBD.execSQL("INSERT INTO $TABLA_LISTAS (denominacion) values ('$nombre');")
    }

    fun tieneProductos(idCat: Int): Boolean{
        var tieneProductos = false
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_PRODUCTOS WHERE idCategoria = '$idCat'",null)
        if(cursor.moveToFirst()){
            tieneProductos = true
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return tieneProductos
    }

    fun hayProductos(): Boolean{
        var tieneProductos = false
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_PRODUCTOS",null)
        if(cursor.moveToFirst()){
            tieneProductos = true
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return tieneProductos
    }

    fun consultaNombreProductos():ArrayList<String>{
        val listaProductos: ArrayList<String> = ArrayList()
        val cursor: Cursor = mBD.query(TABLA_PRODUCTOS, null, null, null, null, null, null,)
        if (cursor.moveToFirst()) {
            do {
                listaProductos.add(cursor.getString(cursor.getColumnIndexOrThrow("denominacion")))
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return listaProductos
    }

    fun consultaTodosProductos(): MutableList<Producto>{
        val listaProductos: MutableList<Producto> = ArrayList()
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_PRODUCTOS",null)
        if(cursor.moveToFirst()){
            do{
                listaProductos.add(
                    Producto(
                    cursor.getInt(cursor.getColumnIndexOrThrow("codProducto")),
                    cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("idCategoria")),
                    cursor.getString(cursor.getColumnIndexOrThrow("imagen")))
                )
            }while (cursor.moveToNext())
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return listaProductos
    }

    fun hayCategorias(): Boolean{
        var tieneCategorias = false
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_CATEGORIAS",null)
        if(cursor.moveToFirst()){
            tieneCategorias = true
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return tieneCategorias
    }

    fun hayListas(): Boolean{
        var tieneListas = false
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_LISTAS",null)
        if(cursor.moveToFirst()){
            tieneListas = true
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return tieneListas
    }

    fun consultaProductosCategoriaArray(codCategoria: String):ArrayList<String>{
        val listaProductos: ArrayList<String> = ArrayList()
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_PRODUCTOS WHERE idCategoria = '$codCategoria'",null)
        if(cursor.moveToFirst()){
            do{
                listaProductos.add(cursor.getString(cursor.getColumnIndexOrThrow("denominacion")))
            }while (cursor.moveToNext())
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return listaProductos
    }

    fun consultaProductosArray():ArrayList<String>{
        val listaProductos: ArrayList<String> = ArrayList()
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_PRODUCTOS",null)
        if(cursor.moveToFirst()){
            do{
                listaProductos.add(cursor.getString(cursor.getColumnIndexOrThrow("denominacion")))
            }while (cursor.moveToNext())
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return listaProductos
    }

    fun consultaProductoString(nombreProd: String, codCategoria: String):MutableList<Producto>{
        val listaProductos: MutableList<Producto> = ArrayList()
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_PRODUCTOS WHERE idCategoria = '$codCategoria' and denominacion = '$nombreProd'",null)
        if(cursor.moveToFirst()){
            do{
                listaProductos.add(
                    Producto(
                    cursor.getInt(cursor.getColumnIndexOrThrow("codProducto")),
                    cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("idCategoria")),
                    cursor.getString(cursor.getColumnIndexOrThrow("imagen")))
                )
            }while (cursor.moveToNext())
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return listaProductos
    }

    fun consultaProductoStringSinCat(nombreProd: String):MutableList<Producto>{
        val listaProductos: MutableList<Producto> = ArrayList()
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_PRODUCTOS WHERE denominacion = '$nombreProd'",null)
        if(cursor.moveToFirst()){
            do{
                listaProductos.add(
                    Producto(
                    cursor.getInt(cursor.getColumnIndexOrThrow("codProducto")),
                    cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("idCategoria")),
                    cursor.getString(cursor.getColumnIndexOrThrow("imagen")))
                )
            }while (cursor.moveToNext())
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return listaProductos
    }

    fun consultaProductosCategoriaOrdenados(codCategoria: String):MutableList<Producto>{
        val listaProductos: MutableList<Producto> = ArrayList()
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_PRODUCTOS WHERE idCategoria = '$codCategoria' ORDER BY denominacion",null)
        if(cursor.moveToFirst()){
            do{
                listaProductos.add(
                    Producto(
                    cursor.getInt(cursor.getColumnIndexOrThrow("codProducto")),
                    cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("idCategoria")),
                    cursor.getString(cursor.getColumnIndexOrThrow("imagen")))
                )
            }while (cursor.moveToNext())
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return listaProductos
    }

    fun consultaTodosProductosOrdenados():MutableList<Producto>{
        val listaProductos: MutableList<Producto> = ArrayList()
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_PRODUCTOS ORDER BY denominacion",null)
        if(cursor.moveToFirst()){
            do{
                listaProductos.add(
                    Producto(
                    cursor.getInt(cursor.getColumnIndexOrThrow("codProducto")),
                    cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("idCategoria")),
                    cursor.getString(cursor.getColumnIndexOrThrow("imagen")))
                )
            }while (cursor.moveToNext())
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return listaProductos
    }

    fun consultaTodosProductosOrdenadosCat(): MutableList<Producto>{
        val listaProductos: MutableList<Producto> = ArrayList()
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_PRODUCTOS ORDER BY idCategoria",null)
        if(cursor.moveToFirst()){
            do{
                listaProductos.add(
                    Producto(
                    cursor.getInt(cursor.getColumnIndexOrThrow("codProducto")),
                    cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("idCategoria")),
                    cursor.getString(cursor.getColumnIndexOrThrow("imagen")))
                )
            }while (cursor.moveToNext())
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return listaProductos
    }

    fun tieneProductosLista(codLista: Int): Boolean{
        var tieneProductos = false
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_LISTAS_PRODUCTOS WHERE codLista = '$codLista'",null)
        if(cursor.moveToFirst()){
            tieneProductos = true
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return tieneProductos
    }

    fun addProductoLista(codLista: Int, codProducto: Int, cantidad: Int){
        mBD.execSQL("INSERT INTO $TABLA_LISTAS_PRODUCTOS (codLista, codProducto, cantidad) values ('$codLista', '$codProducto', '$cantidad');")
    }

    fun consultaProductosLista(idLista: Int):MutableList<ListaProducto>{
        val listaProductos: MutableList<ListaProducto> = ArrayList()
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_LISTAS_PRODUCTOS WHERE codLista = '$idLista';",null)
        if(cursor.moveToFirst()){
            do{
                listaProductos.add(
                    ListaProducto(
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigo")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("codLista")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("codProducto")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("cantidad")))
                )
            }while (cursor.moveToNext())
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return listaProductos
    }

    fun eliminarProductoLista(codProd: Int, codLista: Int){
        mBD.execSQL("DELETE FROM $TABLA_LISTAS_PRODUCTOS where codProducto = '$codProd' and codLista = '$codLista';")
    }

    fun actualizarCantidad(codLista: Int, codProd: Int, cantidad: String){
        mBD.execSQL("UPDATE $TABLA_LISTAS_PRODUCTOS SET cantidad = '$cantidad' WHERE codLista = $codLista and codProducto = $codProd")
    }
}