package com.martinezangel.bd3.bd

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.martinezangel.bd3.models.Categoria
import com.martinezangel.bd3.models.Lista
import com.martinezangel.bd3.models.ListaProducto
import com.martinezangel.bd3.models.Producto

class ComprasDAO(context: Context) {
    private val database: SQLiteDatabase

    companion object {
        const val DATABASE_NAME = "LISTACOMPRAS"
        const val DATABASE_VERSION = 1
        const val TABLA_CATEGORIAS = "categorias"
        const val TABLA_PRODUCTOS = "productos"
        const val TABLA_LISTAS = "listas"
        const val TABLA_LISTAS_PRODUCTOS = "listas_productos"
    }

    init {
        val estructura = ComprasBD(context, DATABASE_NAME, null, DATABASE_VERSION)
        database = estructura.writableDatabase
    }

    private fun getAllFrom(table: String, conditions: String): Cursor {
        return database.rawQuery("SELECT * FROM $table $conditions", null)
    }

    // CATEGORIAS
    fun getCategorias(): MutableList<Categoria> {
        val categorias: MutableList<Categoria> = ArrayList()
        val cursor: Cursor = getAllFrom(TABLA_CATEGORIAS, "")
        if (cursor.moveToFirst()) {
            do {
                categorias.add(
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
        return categorias
    }

    fun getDenominacionesCategorias(): ArrayList<String> {
        val categorias: ArrayList<String> = ArrayList()
        val cursor: Cursor = database.query(TABLA_CATEGORIAS, null, null, null, null, null, null)
        if (cursor.moveToFirst()) {
            do {
                categorias.add(cursor.getString(cursor.getColumnIndexOrThrow("denominacion")))
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return categorias
    }

    fun addCategoria(denominacion: String) {
        database.execSQL("INSERT INTO $TABLA_CATEGORIAS (denominacion) VALUES ('$denominacion')")
    }

    fun deleteCategoria(codigoCategoria: Int) {
        database.execSQL("DELETE FROM $TABLA_CATEGORIAS WHERE codigoCategoria = $codigoCategoria")
    }

    //PRODUCTOS
    fun getProductos(): MutableList<Producto> {
        val productos: MutableList<Producto> = ArrayList()
        val cursor: Cursor = getAllFrom(TABLA_PRODUCTOS, "")

        if (cursor.moveToFirst()) {
            do {
                productos.add(
                    Producto(
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoProducto")),
                        cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoCategoria")),
                        cursor.getString(cursor.getColumnIndexOrThrow("imagen"))
                    )
                )
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return productos
    }

    fun getProducto(codigoProducto: Int): Producto? {
        var producto: Producto? = null
        val cursor: Cursor = getAllFrom(TABLA_PRODUCTOS, "WHERE codigoProducto = $codigoProducto")

        if (cursor.moveToFirst()) {
            do {
                producto = Producto(
                    cursor.getInt(cursor.getColumnIndexOrThrow("codigoProducto")),
                    cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("codigoCategoria")),
                    cursor.getString(cursor.getColumnIndexOrThrow("imagen"))
                )

            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return producto
    }

    fun getProductosFromCategoria(codigoCategoria: Int): MutableList<Producto> {
        val productos: MutableList<Producto> = ArrayList()
        val cursor: Cursor =
            getAllFrom(TABLA_PRODUCTOS, "WHERE codigoCategoria = $codigoCategoria")

        if (cursor.moveToFirst()) {
            do {
                productos.add(
                    Producto(
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoProducto")),
                        cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoCategoria")),
                        cursor.getString(cursor.getColumnIndexOrThrow("imagen"))
                    )
                )
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return productos
    }

    fun getDenominacionesProductos(): ArrayList<String> {
        val productos: ArrayList<String> = ArrayList()
        val cursor: Cursor = getAllFrom(TABLA_PRODUCTOS, "")

        if (cursor.moveToFirst()) {
            do {
                productos.add(cursor.getString(cursor.getColumnIndexOrThrow("denominacion")))
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return productos
    }

    fun deleteProducto(codigoProducto: Int) {
        database.execSQL("DELETE FROM $TABLA_PRODUCTOS WHERE codigoProducto = $codigoProducto")
    }

    fun addProducto(denominacion: String, codigoCategoria: Int, url: String) {
        database.execSQL("INSERT INTO $TABLA_PRODUCTOS (denominacion, codigoCategoria, imagen) VALUES ('$denominacion', $codigoCategoria, '$url')")
    }

    fun getProductosFromCategoria(
        denominacionProducto: String,
        codigoCategoria: Int
    ): MutableList<Producto> {
        val productos: MutableList<Producto> = ArrayList()
        val cursor: Cursor = getAllFrom(
            TABLA_PRODUCTOS,
            " WHERE codigoCategoria = $codigoCategoria and denominacion like '$denominacionProducto%'"
        )
        if (cursor.moveToFirst()) {
            do {
                productos.add(
                    Producto(
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoProducto")),
                        cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoCategoria")),
                        cursor.getString(cursor.getColumnIndexOrThrow("imagen"))
                    )
                )
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return productos
    }

    fun getProductos(denominacion: String): MutableList<Producto> {
        val productos: MutableList<Producto> = ArrayList()
        val cursor: Cursor =
            getAllFrom(TABLA_PRODUCTOS, " WHERE denominacion like '$denominacion%'")
        if (cursor.moveToFirst()) {
            do {
                productos.add(
                    Producto(
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoProducto")),
                        cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoCategoria")),
                        cursor.getString(cursor.getColumnIndexOrThrow("imagen"))
                    )
                )
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return productos
    }

    fun getProductosFromCategoriaAtoZ(codigoCategoria: Int): MutableList<Producto> {
        val productos: MutableList<Producto> = ArrayList()
        val cursor: Cursor = getAllFrom(
            TABLA_PRODUCTOS,
            " WHERE codigoCategoria = $codigoCategoria ORDER BY denominacion"
        )
        if (cursor.moveToFirst()) {
            do {
                productos.add(
                    Producto(
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoProducto")),
                        cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoCategoria")),
                        cursor.getString(cursor.getColumnIndexOrThrow("imagen"))
                    )
                )
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return productos
    }

    fun getProductosAtoZ(): MutableList<Producto> {
        val productos: MutableList<Producto> = ArrayList()
        val cursor: Cursor = getAllFrom(TABLA_PRODUCTOS, " ORDER BY denominacion")
        if (cursor.moveToFirst()) {
            do {
                productos.add(
                    Producto(
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoProducto")),
                        cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoCategoria")),
                        cursor.getString(cursor.getColumnIndexOrThrow("imagen"))
                    )
                )
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return productos
    }

    fun getProductosOrderedByCategoria(): MutableList<Producto> {
        val productos: MutableList<Producto> = ArrayList()
        val cursor: Cursor = getAllFrom(TABLA_PRODUCTOS, " ORDER BY codigoCategoria")
        if (cursor.moveToFirst()) {
            do {
                productos.add(
                    Producto(
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoProducto")),
                        cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoCategoria")),
                        cursor.getString(cursor.getColumnIndexOrThrow("imagen"))
                    )
                )
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return productos
    }

    //DENOMINACIONES PRODUCTO
    fun getDenominacionesProductosFromCategoriaArray(codigoCategoria: Int): ArrayList<String> {
        val productos: ArrayList<String> = ArrayList()
        val cursor: Cursor =
            getAllFrom(TABLA_PRODUCTOS, "WHERE codigoCategoria = $codigoCategoria")

        if (cursor.moveToFirst()) {
            do {
                productos.add(cursor.getString(cursor.getColumnIndexOrThrow("denominacion")))
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return productos
    }

    fun getDenominacionesProductosArray(): ArrayList<String> {
        val productos: ArrayList<String> = ArrayList()
        val cursor: Cursor = getAllFrom(TABLA_PRODUCTOS, "")
        if (cursor.moveToFirst()) {
            do {
                productos.add(cursor.getString(cursor.getColumnIndexOrThrow("denominacion")))
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return productos
    }

    // LISTAS
    fun getListas(): MutableList<Lista> {
        val listas: MutableList<Lista> = ArrayList()
        val cursor: Cursor = getAllFrom(TABLA_LISTAS, "")

        if (cursor.moveToFirst()) {
            do {
                listas.add(
                    Lista(
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoLista")),
                        cursor.getString(cursor.getColumnIndexOrThrow("denominacion"))
                    )
                )
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return listas
    }

    fun deleteLista(codigoLista: Int) {
        database.execSQL("DELETE FROM $TABLA_LISTAS WHERE codigoLista = $codigoLista")
    }

    fun addLista(denominacion: String) {
        database.execSQL("INSERT INTO $TABLA_LISTAS (denominacion) VALUES ('$denominacion')")
    }

    // LISTA_PRODUCTO
    fun getProductosFromLista(codigoLista: Int): MutableList<ListaProducto> {
        val productos: MutableList<ListaProducto> = ArrayList()
        val cursor: Cursor =
            getAllFrom(TABLA_LISTAS_PRODUCTOS, "WHERE codigoLista = $codigoLista")
        if (cursor.moveToFirst()) {
            do {
                productos.add(
                    ListaProducto(
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoListaProducto")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoLista")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigoProducto")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("cantidad"))
                    )
                )
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return productos
    }

    fun updateCantidadProductoFromLista(
        codigoListaProducto: Int,
        codigoProducto: Int,
        cantidad: String
    ) {
        database.execSQL("UPDATE $TABLA_LISTAS_PRODUCTOS SET cantidad = '$cantidad' WHERE codigoListaProducto = $codigoListaProducto and codigoProducto = $codigoProducto")
    }

    fun addProductoToLista(codigoLista: Int, codigoProducto: Int, cantidad: Int) {
        database.execSQL("INSERT INTO $TABLA_LISTAS_PRODUCTOS (codigoLista, codigoProducto, cantidad) VALUES ($codigoLista, $codigoProducto, '$cantidad')")
    }

    fun deleteProductoFromLista(codigoProducto: Int, codigoLista: Int) {
        database.execSQL("DELETE FROM $TABLA_LISTAS_PRODUCTOS WHERE codigoProducto = $codigoProducto and codigoLista = $codigoLista")
    }

}