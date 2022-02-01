package com.ammd.bd2v2

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class AbogadosDAO(context: Context) {
	private val database: SQLiteDatabase

	companion object {
		val DB_NAME = "abogados"
		val DB_VERSION = 1
		val TABLE_USUARIOS = "usuarios"
		val TABLE_CASOS = "casos"
		val TABLE_GESTIONES = "gestiones"
	}

	init {
		val estructura = AbogadosDB(
			context,
			DB_NAME,
			factory = null,
			DB_VERSION
		)
		database = estructura.writableDatabase
	}

	fun getAllCasos(): MutableList<com.ammd.bd2v2.Caso> {
		val casos: MutableList<com.ammd.bd2v2.Caso> = ArrayList()
		var sql = "select * from $TABLE_CASOS"
		val cursor: Cursor = database.rawQuery(sql, null)

		if (cursor.moveToFirst())
			do {
				var caso = com.ammd.bd2v2.Caso(
					cursor.getInt(cursor.getColumnIndexOrThrow("numeroCaso")),
					cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
					cursor.getString(cursor.getColumnIndexOrThrow("fechaApertura")),
					cursor.getString(cursor.getColumnIndexOrThrow("caracteristicas")),
					cursor.getString(cursor.getColumnIndexOrThrow("abogado"))
				)
				casos.add(caso)
			} while (cursor.moveToNext())

		return casos
	}

	fun getCasosFrom(abogado: String): MutableList<com.ammd.bd2v2.Caso> {
		val casos: MutableList<com.ammd.bd2v2.Caso> = ArrayList()
		var sql = "select * from $TABLE_CASOS where abogado = $abogado"
		val cursor: Cursor = database.rawQuery(sql, null)

		if (cursor.moveToFirst())
			do {
				var caso = Caso(
					cursor.getInt(cursor.getColumnIndexOrThrow("numeroCaso")),
					cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
					cursor.getString(cursor.getColumnIndexOrThrow("fechaApertura")),
					cursor.getString(cursor.getColumnIndexOrThrow("caracteristicas")),
					cursor.getString(cursor.getColumnIndexOrThrow("abogado"))
				)
				casos.add(caso)
			} while (cursor.moveToNext())

		return casos
	}


	fun addGestion(gestion: Gestion): Long {
		val values = ContentValues();

		values.put("numeroGestion", gestion.numeroGestion)
		values.put("numeroCaso", gestion.numeroCaso)
		values.put("fecha", gestion.fecha)
		values.put("descripcion", gestion.descripcion)
		values.put("realizado", gestion.realizado)
		return database.insert(TABLE_GESTIONES, null, values)
	}

	fun updateGestion(gestion: Gestion) {
		val values = ContentValues()
		val args = arrayOf(gestion.numeroGestion.toString())

		values.put("realizado", "Sí")
		database.update(TABLE_GESTIONES, values, "numeroGestion = ?", args)
	}
}