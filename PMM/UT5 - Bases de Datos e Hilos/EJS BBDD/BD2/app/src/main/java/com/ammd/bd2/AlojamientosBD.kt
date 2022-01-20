package com.ammd.bd2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class AlojamientosBD(
	context: Context,
	name: String,
	factory: SQLiteDatabase.CursorFactory?,
	version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

	override fun onCreate(db: SQLiteDatabase?) {
//        var crearTablaPrueba =
//            "CREATE TABLE alojamientos( CODIGO_ALOJAMIENTO INTEGER  PRIMARY KEY autoi, DENOMINACION VARCHAR(10), LOCALIDAD VARCHAR(10), PRECIO INTEGER, IMAGEN_ALOJAMIENTO INTEGER, TELEFONO INTEGER, EMAIL VARCHAR(10), DETALLES VARCHAR(10), ACTIVIDADES VARCHAR(10), FAVORITO INTEGER, )"
//
//        try {
//            db?.execSQL(crearTablaPrueba)
//        } catch (e: SQLiteException) {
//            println(
//                "Error al crear la tabla:" +
//                        "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH "
//                        + e
//            )
//        }

		val crearTablaAlojamientos =
			"CREATE TABLE ${AlojamientosDAO.TABLA_ALOJAMIENTOS} (" +
					"CODIGO_ALOJAMIENTO INTEGER PRIMARY KEY AUTOINCREMENT," +
					"DENOMINACION VARCHAR," +
					"LOCALIDAD VARCHAR," +
					"PRECIO INTEGER," +
					"IMAGEN_ALOJAMIENTO INTEGER," +
					"TELEFONO INTEGER," +
					"EMAIL VARCHAR," +
					"DETALLES VARCHAR," +
					"ACTIVIDADES VARCHAR," +
					"FAVORITO INTEGER" +
					")"
		try {
			db?.execSQL(crearTablaAlojamientos)
		} catch (e: SQLiteException) {
			println("Error al crear la tabla:" + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH " + e)
		}

	}


	override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
		TODO("Not yet implemented")
	}


}