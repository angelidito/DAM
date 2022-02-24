package com.martinezangel.bd2.bd

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class BufeteDB(
	context: Context,
	name: String,
	factory: SQLiteDatabase.CursorFactory?,
	version: Int
) : SQLiteOpenHelper(context, name, factory, version) {


	override fun onCreate(database: SQLiteDatabase?) {
		val sqls = arrayOf(
			"CREATE TABLE ${BufeteDAO.TABLE_USUARIOS} (" +
					"numeroColegiado VARCHAR PRIMARY KEY," +
					"nombre VARCHAR," +
					"login VARCHAR UNIQUE," +
					"contrasena VARCHAR," +
					"tipoPerfil CHAR(1)" +
					")",
			"CREATE TABLE ${BufeteDAO.TABLE_CASOS} (" +
					"numeroCaso INT PRIMARY KEY AUTO_INCREMENT," +
					"denominacion VARCHAR," +
					"fechaApertura VARCHAR," +
					"caracteristicas VARCHAR," +
					"abogado VARCHAR FOREIGN KEY REFERENCES ${BufeteDAO.TABLE_USUARIOS}(numeroColegiado)" +
					")",
			"CREATE TABLE ${BufeteDAO.TABLE_GESTIONES} (" +
					"numeroGestion INT PRIMARY KEY AUTO_INCREMENT," +
					"numeroCaso INT FOREIGN KEY REFERENCES ${BufeteDAO.TABLE_CASOS}(numeroCaso)," +
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