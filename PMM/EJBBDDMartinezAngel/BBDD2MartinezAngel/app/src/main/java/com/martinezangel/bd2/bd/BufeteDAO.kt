package com.martinezangel.bd2.bd

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.Cursor
import com.martinezangel.bd2.models.Caso
import com.martinezangel.bd2.models.Gestion
import com.martinezangel.bd2.models.Usuario

class BufeteDAO(context: Context) {
	private val database: SQLiteDatabase

	companion object {
		const val DB_NAME = "abogados"
		const val DB_VERSION = 1
		const val TABLE_USUARIOS = "usuarios"
		const val TABLE_CASOS = "casos"
		const val TABLE_GESTIONES = "gestiones"
	}

	init {
		val estructura = BufeteDB(
			context,
			DB_NAME,
			factory = null,
			DB_VERSION
		)
		database = estructura.writableDatabase
	}

	fun logIn(login: String, contrasena: String): Usuario? {
		val sql =
			"select * FROM $TABLE_USUARIOS where login = '$login' and contrasena = '$contrasena'"
		val cursor: Cursor = database.rawQuery(sql, null)
		if (cursor.moveToFirst())
			return Usuario(
				cursor.getString(cursor.getColumnIndexOrThrow("numeroColegiado")),
				cursor.getString(cursor.getColumnIndexOrThrow("nombre")),
				login,
				cursor.getString(cursor.getColumnIndexOrThrow("tipoPerfil"))
			)
		return null
	}

	fun getUsario(numeroColegiado: String): Usuario? {
		val sql = "select * from $TABLE_USUARIOS where numeroColegiado = '$numeroColegiado'"
		val cursor: Cursor = database.rawQuery(sql, null)
		if (cursor.moveToFirst())
			return Usuario(
				cursor.getString(cursor.getColumnIndexOrThrow("numeroColegiado")),
				cursor.getString(cursor.getColumnIndexOrThrow("nombre")),
				cursor.getString(cursor.getColumnIndexOrThrow("numeroColegiado")),
				cursor.getString(cursor.getColumnIndexOrThrow("tipoPerfil"))
			)
		return null
	}


	fun getAllCasos(): MutableList<Caso> {
		val casos: MutableList<Caso> = ArrayList()
		var sql = "select * from $TABLE_CASOS"
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

	fun getCasosFrom(usuario: Usuario): MutableList<Caso> {
		val casos: MutableList<Caso> = ArrayList()
		val sql = "select * FROM $TABLE_CASOS where abogado = '${usuario.numeroColegiado}'"
		val cursor: Cursor = database.rawQuery(sql, null)
		println(sql)
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

	fun getGestionesFrom(caso: Caso): MutableList<Gestion> {
		val casos: MutableList<Gestion> = ArrayList()
		val sql = "select * FROM $TABLE_GESTIONES where numeroCaso=${caso.numeroCaso}"
		val cursor: Cursor = database.rawQuery(sql, null)

		if (cursor.moveToFirst())
			do {
				var gestion = Gestion(
					cursor.getInt(cursor.getColumnIndexOrThrow("numeroGestion")),
					cursor.getInt(cursor.getColumnIndexOrThrow("numeroCaso")),
					cursor.getString(cursor.getColumnIndexOrThrow("fecha")),
					cursor.getString(cursor.getColumnIndexOrThrow("descripcion")),
					cursor.getString(cursor.getColumnIndexOrThrow("realizado"))
				)
				casos.add(gestion)
			} while (cursor.moveToNext())
		return casos
	}

	fun realizarGestion(gestion: Gestion) {
		val values = ContentValues()
		val args = arrayOf(gestion.numeroGestion.toString())

		values.put("realizado", "SI")
		database.update(TABLE_GESTIONES, values, "numeroGestion = ?", args)
	}

	fun addGestion(numeroCaso: String, fecha: String, descripcion: String): Long {
		val values = ContentValues();

		values.put("numeroCaso", numeroCaso)
		values.put("fecha", fecha)
		values.put("descripcion", descripcion)
		values.put("realizado", "NO")

		return database.insert(TABLE_GESTIONES, null, values)
	}

	fun addCaso(caso: Caso): Long {
		val values = ContentValues();

		values.put("denominacion", caso.denominacion)
		values.put("fechaApertura", caso.fechaApertura)
		values.put("caracteristicas", caso.caracteristicas)
		values.put("abogado", caso.abogado)

		return database.insert(TABLE_CASOS, null, values)
	}


}