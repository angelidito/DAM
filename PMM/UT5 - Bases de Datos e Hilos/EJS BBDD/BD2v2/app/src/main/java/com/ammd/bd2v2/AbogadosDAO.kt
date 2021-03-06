package com.ammd.bd2v2

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class AbogadosDAO(context: Context) {
	private val database: SQLiteDatabase

	companion object {
		const val DB_NAME = "abogados"
		const val DB_VERSION = 1
		const val TABLE_USUARIOS = "usuarios"
		const val TABLE_CASOS = "casos"
		const val TABLE_GESTIONES = "gestiones"
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

	fun logIn(login: String, contrasena: String): Usuario? {
		var sql =
			"select * from $TABLE_USUARIOS where login = $login and contrasena = $contrasena"
		val cursor: Cursor = database.rawQuery(sql, null)
		if (cursor.moveToFirst())
			return Usuario(
				cursor.getString(cursor.getColumnIndexOrThrow("numeroColegiado")),
				cursor.getString(cursor.getColumnIndexOrThrow("nombre")),
				cursor.getString(cursor.getColumnIndexOrThrow("login")),
				cursor.getString(cursor.getColumnIndexOrThrow("contrasena")),
				cursor.getString(cursor.getColumnIndexOrThrow("tipoPerfil"))
			)
		return null
	}


	fun getAllCasos(): MutableList<com.ammd.bd2v2.Caso> {
		val casos: MutableList<com.ammd.bd2v2.Caso> = ArrayList()
		var sql = "select * from $TABLE_CASOS"
		val cursor: Cursor = database.rawQuery(sql, null)

		if (cursor.moveToFirst())
			do {
				var caso = com.ammd.bd2v2.Caso(
					cursor.getString(cursor.getColumnIndexOrThrow("numeroCaso")),
					cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
					cursor.getString(cursor.getColumnIndexOrThrow("fechaApertura")),
					cursor.getString(cursor.getColumnIndexOrThrow("caracteristicas")),
					cursor.getString(cursor.getColumnIndexOrThrow("abogado"))
				)
				casos.add(caso)
			} while (cursor.moveToNext())

		return casos
	}

	fun getCasosFrom(usuario: Usuario): MutableList<com.ammd.bd2v2.Caso> {
		val casos: MutableList<com.ammd.bd2v2.Caso> = ArrayList()
		var sql = "select * from $TABLE_CASOS where numeroColegiado = ${usuario.numeroColegiado}"
		val cursor: Cursor = database.rawQuery(sql, null)

		if (cursor.moveToFirst())
			do {
				var caso = Caso(
					cursor.getString(cursor.getColumnIndexOrThrow("numeroCaso")),
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

	fun realizarGestion(gestion: Gestion) {
		val values = ContentValues()
		val args = arrayOf(gestion.numeroGestion.toString())

		values.put("realizado", "SI")
		database.update(TABLE_GESTIONES, values, "numeroGestion = ?", args)
	}


}