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
					"numeroCaso INTEGER PRIMARY KEY AUTOINCREMENT," +
					"denominacion VARCHAR," +
					"fechaApertura VARCHAR," +
					"caracteristicas VARCHAR," +
					"abogado VARCHAR" +
					")",
			"CREATE TABLE ${BufeteDAO.TABLE_GESTIONES} (" +
					"numeroGestion INTEGER PRIMARY KEY AUTOINCREMENT," +
					"numeroCaso INTEGER," +
					"fecha VARCHAR," +
					"descripcion VARCHAR," +
					"realizado char(2)" +
					")",
			"INSERT into USUARIOS values ('111', 'Juan Antonio', '1', '1', 'S')",
			"INSERT into USUARIOS values ('222', 'Mario Sanchez', '2', '2', 'A')",
			"INSERT into CASOS (denominacion, fechaApertura, caracteristicas, abogado) values ('Caso 12343 de la abuela', '12-12-2012', 'Carantristicas del caso dsfgs f sfsd ', 111)",
			"INSERT into CASOS (denominacion, fechaApertura, caracteristicas, abogado) values ('Caso 56435 de la abuela', '24-04-2014', 'Carantristicas del caso asdfkjajfg kdgskdsgaf s ', 111)",
			"INSERT into CASOS (denominacion, fechaApertura, caracteristicas, abogado) values ('Clientes que nos demandan con razon', '09-09-2009', 'PFFFFFFF PEREZA DE CASO; VAMOS A PERDERLO', 222)",
			"INSERT into GESTIONES (numeroCaso, fecha, descripcion, realizado) values (1, '11-11-2011', 'Descripcion de la gestion dfghdjsl sdsfs afas   dsff dsfdfs af .-.', 'SI')",
			"INSERT into GESTIONES (numeroCaso, fecha, descripcion, realizado) values (1, '11-11-2011', 'Se esta realizando, pero se morira pronto la abuela .-.', 'NO')",
			"INSERT into GESTIONES (numeroCaso, fecha, descripcion, realizado) values (2, '15-05-2015', 'NOS DEMANDAN', 'NO')"
		)
		Thread {
			for (sql in sqls) {
				try {
					database?.execSQL(sql)
					println("\nEJECUTADA la sentencia \"$sql\"")
				} catch (e: SQLiteException) {
					println("\nERROR al ejecutar la sentencia \"$sql\"")
					e.printStackTrace()
				}
			}
		}.start()

	}

	override fun onUpgrade(database: SQLiteDatabase?, p1: Int, p2: Int) {
	}
}