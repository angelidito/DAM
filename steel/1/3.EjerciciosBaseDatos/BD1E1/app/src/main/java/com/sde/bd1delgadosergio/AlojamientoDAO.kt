package com.sde.bd1delgadosergio

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class AlojamientoDAO(context: Context) {
    private val mBD: SQLiteDatabase

    companion object{
        const val DATABASE_NAME = "alojamientobd"
        const val DATABASE_VERSION = 1
        const val TABLA_ALOJAMIENTOS = "alojamientos"
    }
    init {
        val  estructura = AlojamientoBD(context, DATABASE_NAME,null, DATABASE_VERSION)
        mBD = estructura.writableDatabase
    }

    fun addAlojamiento(alojamiento: Alojamiento){
        val values = ContentValues()
        values.put("codigo", alojamiento.codigo)
        values.put("nombre", alojamiento.nombre)
        values.put("localidad", alojamiento.localidad)
        values.put("precio", alojamiento.precio)
        values.put("imagen", alojamiento.imagen)
        values.put("telefono", alojamiento.telefono)
        values.put("email", alojamiento.email)
        values.put("detalles", alojamiento.detalles)
        values.put("actividades", alojamiento.actividades)
        values.put("favorito", alojamiento.favorito)
        mBD.insert(TABLA_ALOJAMIENTOS,null, values)
    }

    fun consultaTodosAlojamientos():MutableList<Alojamiento>{
        val lista:MutableList<Alojamiento> = ArrayList()
        val cursor: Cursor = mBD.query(TABLA_ALOJAMIENTOS,null,null,null,null,null,null,)
        if(cursor.moveToFirst()){
            do{
                lista.add(Alojamiento(cursor.getInt(0),
                    cursor.getString(cursor.getColumnIndexOrThrow("nombre")),
                    cursor.getString(cursor.getColumnIndexOrThrow("localidad")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("precio")),
                    cursor.getString(cursor.getColumnIndexOrThrow("imagen")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("telefono")),
                    cursor.getString(cursor.getColumnIndexOrThrow("email")),
                    cursor.getString(cursor.getColumnIndexOrThrow("detalles")),
                    cursor.getString(cursor.getColumnIndexOrThrow("actividades")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("favorito"))))
            }while (cursor.moveToNext())
        }
        if(!cursor.isClosed){
            cursor.close()
        }
        return lista
    }

    fun consultaAlojamientosCiudad(localidad: String): MutableList<Alojamiento> {
        val lista: MutableList<Alojamiento> = ArrayList()
        val cursor: Cursor = mBD.rawQuery("SELECT * FROM $TABLA_ALOJAMIENTOS WHERE localidad = '$localidad'",null)
        if (cursor.moveToFirst()) {
            do {
                lista.add(Alojamiento(cursor.getInt(0),
                    cursor.getString(cursor.getColumnIndexOrThrow("nombre")),
                    cursor.getString(cursor.getColumnIndexOrThrow("localidad")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("precio")),
                    cursor.getString(cursor.getColumnIndexOrThrow("imagen")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("telefono")),
                    cursor.getString(cursor.getColumnIndexOrThrow("email")),
                    cursor.getString(cursor.getColumnIndexOrThrow("detalles")),
                    cursor.getString(cursor.getColumnIndexOrThrow("actividades")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("favorito"))))
            } while (cursor.moveToNext())
            if (!cursor.isClosed)
                cursor.close()
        }
        return lista
    }

    fun updateAlojamiento(alojamiento: Alojamiento){
        val values = ContentValues()
        values.put("favorito",alojamiento.favorito)
        val args = arrayOf(alojamiento.codigo.toString())
        mBD.update(TABLA_ALOJAMIENTOS, values, "codigo=?", args)
    }
}