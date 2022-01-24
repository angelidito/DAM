package com.ammd.bd1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.bd1v2.Alojamiento
import com.example.bd1v2.AlojamientoBD

class AlojamientosDAO(context: Context) {
	private val database: SQLiteDatabase

	companion object {
		val DATABASE_NAME = "alojamientosdb"
		val DATABASE_VERSION = 1
		val TABLA_ALOJAMIENTOS = "alojamientos"
	}

	init {
		val estructura = AlojamientoBD(context, DATABASE_NAME, factory = null, DATABASE_VERSION)

		database = estructura.writableDatabase
	}

	fun addAlojamiento(alojamiento: Alojamiento) {
		val values = ContentValues()
		values.put("denominacion", alojamiento.denominacion)
//        values.put("localidad", alojamiento.localidad)
//        values.put("precio", alojamiento.precio)
//        values.put("imagen_alojamiento", alojamiento.imagen_alojamiento)
//        values.put("telefono", alojamiento.telefono)
//        values.put("email", alojamiento.email)
//        values.put("detalles", alojamiento.detalles)
//        values.put("actividades", alojamiento.actividades)
		values.put("favorito", alojamiento.esFavorito)
		values.put("CODIGO_ALOJAMIENTO", alojamiento.id)
		values.put("precio", alojamiento.precioNochePers)

		database.insert(TABLA_ALOJAMIENTOS, null, values)
	}

	fun getAllAlojamiento(): MutableList<Alojamiento> {
		val lista: MutableList<Alojamiento> = ArrayList()
		val cursor: Cursor = database.query(
			TABLA_ALOJAMIENTOS, null, null, null,
			null, null, null, null
		)

		if (cursor.moveToFirst()) {
			do {
				lista.add(
					Alojamiento(
						cursor.getInt(cursor.getColumnIndexOrThrow("CODIGO_ALOJAMIENTO")),
						cursor.getString(cursor.getColumnIndexOrThrow("DENOMINACION")),
//						cursor.getString(cursor.getColumnIndexOrThrow("LOCALIDAD")),
						cursor.getInt(cursor.getColumnIndexOrThrow("PRECIO")),
//						cursor.getString(cursor.getColumnIndexOrThrow("IMAGEN_ALOJAMIENTO")),
//						cursor.getInt(cursor.getColumnIndexOrThrow("TELEFONO")),
//						cursor.getString(cursor.getColumnIndexOrThrow("EMAIL")),
//						cursor.getString(cursor.getColumnIndexOrThrow("DETALLES")),
//						cursor.getString(cursor.getColumnIndexOrThrow("ACTIVIDADES")),
						cursor.getInt(cursor.getColumnIndexOrThrow("FAVORITO"))
					)
				)
			} while (cursor.moveToNext())
		}
		return lista
	}

	fun getAlojamientos(localidad: String): MutableList<Alojamiento> {
		val lista: MutableList<Alojamiento> = ArrayList()
		val cursor: Cursor = database.query(
			TABLA_ALOJAMIENTOS, null, "localidad LIKE %?%", arrayOf(localidad),
			null, null, null, null
		)

		if (cursor.moveToFirst()) {
			do {
				lista.add(
					Alojamiento(
						cursor.getInt(cursor.getColumnIndexOrThrow("CODIGO_ALOJAMIENTO")),
						cursor.getString(cursor.getColumnIndexOrThrow("DENOMINACION")),
//						cursor.getString(cursor.getColumnIndexOrThrow("LOCALIDAD")),
						cursor.getInt(cursor.getColumnIndexOrThrow("PRECIO")),
//						cursor.getString(cursor.getColumnIndexOrThrow("IMAGEN_ALOJAMIENTO")),
//						cursor.getInt(cursor.getColumnIndexOrThrow("TELEFONO")),
//						cursor.getString(cursor.getColumnIndexOrThrow("EMAIL")),
//						cursor.getString(cursor.getColumnIndexOrThrow("DETALLES")),
//						cursor.getString(cursor.getColumnIndexOrThrow("ACTIVIDADES")),
						cursor.getInt(cursor.getColumnIndexOrThrow("FAVORITO"))
					)
				)
			} while (cursor.moveToNext())
		}

		if (!cursor.isClosed)
			cursor.close()

		return lista
	}

	fun updateAlojamiento(alojamiento: Alojamiento) {
		val values = ContentValues()
		val args = arrayOf(alojamiento.id.toString())

		values.put("DENOMINACION", alojamiento.denominacion)
		values.put("FAVORITO", alojamiento.esFavorito)
		database.update(TABLA_ALOJAMIENTOS, values, "CODIGO_ALOJAMIENTO = ?", args)
	}

	fun deleteAlojamiento(id: Int) {
		val args = arrayOf(id.toString())

		database.delete(TABLA_ALOJAMIENTOS, "CODIGO_ALOJAMIENTO = ?", args)
	}
}

