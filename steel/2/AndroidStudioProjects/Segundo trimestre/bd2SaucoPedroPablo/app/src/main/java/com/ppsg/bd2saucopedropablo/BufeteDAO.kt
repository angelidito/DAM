package com.ppsg.bd2saucopedropablo

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.widget.Toast

class BufeteDAO(contexto: Context) {
    private var mBD: SQLiteDatabase

    //Ponemos poner el nombre de la tabla, de algún campo... -companion = static en java-
    companion object {
        val DATABASE_NAME = "abogados"
        val DATABASE_VERSION = 1
        val TABLA_USUARIOS = "tablaUsuarios"
        val TABLA_CASOS = "tablaCasos"
        val TABLA_GESTIONES = "tablaGestiones"
    }

    init {
        val bufete = BufeteBD(contexto, DATABASE_NAME, null, DATABASE_VERSION)
        mBD = bufete.writableDatabase
    }

    fun getAllCasos(): MutableList<Casos> {
        val lista: MutableList<Casos> = ArrayList()
        val cursor: Cursor = mBD.query(TABLA_CASOS, null, null, null, null, null, null)
        if (cursor.moveToFirst()) {
            do {
                lista.add(
                    Casos(
                        cursor.getInt(cursor.getColumnIndexOrThrow("numeroCaso")),
                        cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                        cursor.getString(cursor.getColumnIndexOrThrow("fecha")),
                        cursor.getString(cursor.getColumnIndexOrThrow("caracteristicas")),
                        cursor.getString(cursor.getColumnIndexOrThrow("numAbogado")),
                    )
                )
            } while (cursor.moveToNext())
            if (!cursor.isClosed)
                cursor.close()
        }
        return lista
    }

    //BÚSQUEDA DE USUARIO SEGÚN SU TIPO
    fun getTipoUsuario(login: String, contrasena: String): String {
        var tipo: String = ""
        val cursor: Cursor = mBD.rawQuery(
            "SELECT tipo FROM ${TABLA_USUARIOS} WHERE login = '$login' and contrasena='$contrasena'",
            null
        )
        if (cursor.moveToFirst()) {
            tipo = cursor.getString(cursor.getColumnIndexOrThrow("tipo"))
            if (!cursor.isClosed)
                cursor.close()
        }
        return tipo
    }

    //DEVUELVE EL NUMERO DE ABOGADO
    fun getNumAbogado(login: String, contrasena: String): String {
        var tipo: String = ""
        val cursor: Cursor = mBD.rawQuery(
            "SELECT numeroColegiado FROM ${TABLA_USUARIOS} WHERE login = '$login' and contrasena='$contrasena'",
            null
        )
        if (cursor.moveToFirst()) {
            tipo = cursor.getString(cursor.getColumnIndexOrThrow("numeroColegiado"))
            if (!cursor.isClosed)
                cursor.close()
        }
        return tipo
    }

    //BÚSQUEDA DEL CÓDIGO DE ABOGADO
    fun getNumColegiado(login: String): String {
        var tipo: String = ""
        val cursor: Cursor = mBD.rawQuery(
            "SELECT * FROM $TABLA_USUARIOS WHERE login = '$login'",
            null
        )
        if (cursor.moveToFirst()) {
            tipo = cursor.getString(cursor.getColumnIndexOrThrow("tipo"))
            if (!cursor.isClosed)
                cursor.close()
        }
        return tipo
    }

    //BÚSQUEDA DEL NÚMERO DE CASO
    fun getNumCaso(codigoAbogado: String): MutableList<Casos> {
        val listaCasos: MutableList<Casos> = ArrayList()
        val sql = "SELECT * FROM $TABLA_CASOS WHERE numAbogado = '$codigoAbogado'"
        val cursor: Cursor = mBD.rawQuery(
            sql,
            null
        )
        if (cursor.moveToFirst()) {
            do {
                listaCasos.add(
                    Casos(
                        cursor.getInt(cursor.getColumnIndexOrThrow("numeroCaso")),
                        cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                        cursor.getString(cursor.getColumnIndexOrThrow("fecha")),
                        cursor.getString(cursor.getColumnIndexOrThrow("caracteristicas")),
                        cursor.getString(cursor.getColumnIndexOrThrow("numAbogado")),
                    )
                )
            } while (cursor.moveToNext())
            if (!cursor.isClosed)
                cursor.close()
        }
        return listaCasos
    }

    //INSERTAR DATOS A LA TABLA CASOS
    fun insertCasos(deno: String, fech: String, caracte: String, numAbogado: String) {
        val cursor: Cursor = mBD.rawQuery(
            "INSERT INTO $TABLA_CASOS ('denominacion','fecha','caracteristicas', 'numAbogado') VALUES ('$deno','$fech','$caracte','$numAbogado')",
            null
        )
    }

    //BÚSQUEDA DE LA GESTIÓN POR CADA CASO
    fun getGestionPorCaso(numCaso: String): MutableList<Gestiones> {
        val gestionCaso: MutableList<Gestiones> = ArrayList()
        val cursor: Cursor = mBD.rawQuery(
            "SELECT * FROM ${TABLA_GESTIONES} WHERE numeroCaso = '$numCaso'",
            null
        )
        if (cursor.moveToFirst()) {
            do {
                gestionCaso.add(
                    Gestiones(
                        cursor.getInt(cursor.getColumnIndexOrThrow("numeroGestion")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("numeroCaso")),
                        cursor.getString(cursor.getColumnIndexOrThrow("fecha")),
                        cursor.getString(cursor.getColumnIndexOrThrow("descripcion")),
                        cursor.getString(cursor.getColumnIndexOrThrow("realizado")),
                    )
                )
            } while (cursor.moveToNext())
            if (!cursor.isClosed)
                cursor.close()
        }
        return gestionCaso
    }

}