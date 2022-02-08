package com.example.bd2E1ds

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class BufeteDAO (context: Context) {
    private val mBD: SQLiteDatabase

    companion object{
        const val DATABASE_NAME = "bufetebd"
        const val DATABASE_VERSION = 1
        const val TABLA_USUARIOS = "usuarios"
        const val TABLA_CASOS = "casos"
        const val TABLA_GESTIONES = "gestiones"
    }

    init {
        val  estructura = BufeteBD(context, DATABASE_NAME,null, DATABASE_VERSION)
        mBD = estructura.writableDatabase
    }

    // Si devuelve una letra (S/A), el usuario existe. Si devuelve "", no existe
    fun consultaLogin(usuario: String, pass: String): String{
        var tipoPerfil = ""
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_USUARIOS WHERE login = '$usuario' AND contra = '$pass'",null)
        // Si encuentra registros (el usuario es correcto)
        if (cursor.moveToFirst()) {
            // Obtiene el tipo de perfil (S/A)
            tipoPerfil = cursor.getString(cursor.getColumnIndexOrThrow("tipoPerfil"))

            if (!cursor.isClosed)
                cursor.close()
        }
        return tipoPerfil
    }

    fun consultaTodosCasos():MutableList<Caso>{
        val listaCasos: MutableList<Caso> = ArrayList()
        val cursor: Cursor = mBD.query(TABLA_CASOS,null,null,null,null,null,null,)
        if(cursor.moveToFirst()){
            do{
                listaCasos.add(
                    Caso(
                    cursor.getInt(cursor.getColumnIndexOrThrow("numCaso")),
                    cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                    cursor.getString(cursor.getColumnIndexOrThrow("fechaApertura")),
                    cursor.getString(cursor.getColumnIndexOrThrow("caracteristicas")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("numAbogado")))
                )
            }while (cursor.moveToNext())
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return listaCasos
    }

    fun consultaCasosAbogado(codAbogado: String):MutableList<Caso>{
        val listaCasos: MutableList<Caso> = ArrayList()
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_CASOS WHERE numAbogado = '$codAbogado'",null)
        if(cursor.moveToFirst()){
            do{
                listaCasos.add(
                    Caso(
                    cursor.getInt(cursor.getColumnIndexOrThrow("numCaso")),
                    cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                    cursor.getString(cursor.getColumnIndexOrThrow("fechaApertura")),
                    cursor.getString(cursor.getColumnIndexOrThrow("caracteristicas")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("numAbogado")))
                )
            }while (cursor.moveToNext())
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return listaCasos
    }

    fun consultaNumAbogado(usuario: String): Int{
        var numAbogado = 0
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_USUARIOS USUARIOS WHERE login = '$usuario'",null)
        // Si encuentra registros (el usuario es correcto)
        if (cursor.moveToFirst()) {
            numAbogado = cursor.getInt(cursor.getColumnIndexOrThrow("numColegiado"))

            if (!cursor.isClosed)
                cursor.close()
        }
        return numAbogado
    }

    fun consultaGestionesCaso(numCaso: String):MutableList<Gestion>{
        val listaGestiones: MutableList<Gestion> = ArrayList()
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_GESTIONES WHERE numCaso = '$numCaso'",null)
        if(cursor.moveToFirst()){
            do{
                listaGestiones.add(
                    Gestion(
                    cursor.getInt(cursor.getColumnIndexOrThrow("numGestion")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("numCaso")),
                    cursor.getString(cursor.getColumnIndexOrThrow("fecha")),
                    cursor.getString(cursor.getColumnIndexOrThrow("descripcion")),
                    cursor.getString(cursor.getColumnIndexOrThrow("realizado")))
                )
            }while (cursor.moveToNext())
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return listaGestiones
    }

    fun consultaExisteAbogado(numAbogado: String): Boolean{
        var abogadoCorrecto = false
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_USUARIOS WHERE numColegiado = '$numAbogado'",null)
        if (cursor.moveToFirst()) {
            abogadoCorrecto = true

            if (!cursor.isClosed)
                cursor.close()
        }
        return abogadoCorrecto
    }

    fun nuevaGestion(casoPertenece: String, fecha: String, descripcion: String){
        mBD.execSQL("INSERT INTO $TABLA_GESTIONES (numCaso, fecha, descripcion, realizado) values ('$casoPertenece', '$fecha', '$descripcion', 'NO');")
    }

    fun nuevoCaso(denominacion: String, fecha: String, caracteristicas: String, numAbogado: Int){
        mBD.execSQL("INSERT INTO $TABLA_CASOS (denominacion, fechaApertura, caracteristicas, numAbogado) values ('$denominacion', '$fecha', '$caracteristicas', $numAbogado);")
    }

    fun gestionRealizada(numGestion: Int): String{
        var gestionRealizada = ""

        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_GESTIONES WHERE numGestion = '$numGestion'",null)
        // Si encuentra gestiones
        if (cursor.moveToFirst()) {
            gestionRealizada = cursor.getString(cursor.getColumnIndexOrThrow("realizado"))

            if (!cursor.isClosed)
                cursor.close()
        }
        return gestionRealizada
    }

    fun cambiarEstadoGestion(numGestion: Int){
        mBD.execSQL("UPDATE $TABLA_GESTIONES SET realizado = 'SI' WHERE numGestion = $numGestion")
    }
}