package com.ammd.bd2v2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class AbogadosDB(
	context: Context,
	name: String,
	factory: SQLiteDatabase.CursorFactory?,
	version: Int
) : SQLiteOpenHelper(context, name, factory, version) {


	override fun onCreate(database: SQLiteDatabase?) {
		val sqls = arrayOf(
			"CREATE TABLE ${AbogadosDAO.TABLE_USUARIOS} (" +
					"numeroColegiado VARCHAR PRIMARY KEY," +
					"nombre VARCHAR," +
					"login VARCHAR UNIQUE," +
					"contrasena VARCHAR," +
					"tipoPerfil CHAR(1)" +
					")",
			"CREATE TABLE ${AbogadosDAO.TABLE_CASOS} (" +
					"numeroCaso INT PRIMARY KEY AUTO_INCREMENT," +
					"denominacion VARCHAR," +
					"fechaApertura VARCHAR," +
					"caracteristicas VARCHAR," +
					"abogado VARCHAR FOREIGN KEY REFERENCES ${AbogadosDAO.TABLE_USUARIOS}(numeroColegiado)" +
					")",
			"CREATE TABLE ${AbogadosDAO.TABLE_GESTIONES} (" +
					"numeroGestion INT PRIMARY KEY AUTO_INCREMENT," +
					"numeroCaso INT FOREIGN KEY REFERENCES ${AbogadosDAO.TABLE_CASOS}(numeroCaso)," +
					"fecha VARCHAR," +
					"descripcion VARCHAR," +
					"realizado char(2)" +
					")"
		)
		for (sql in sqls) {
			try {
				database?.execSQL(sql)
			} catch (e: SQLiteException) {
				println("\nError al ejecutar la sentencia \"$sql\"")
				e.printStackTrace()
			}
		}
	}

	override fun onUpgrade(database: SQLiteDatabase?, p1: Int, p2: Int) {
		TODO("Not yet implemented")
	}
}