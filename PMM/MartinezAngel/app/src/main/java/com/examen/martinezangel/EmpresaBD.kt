package com.examen.martinezangel

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class EmpresaBD(
	context: Context,
	name: String,
	factory: SQLiteDatabase.CursorFactory?,
	version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

	override fun onCreate(db: SQLiteDatabase?) {
		val crearTablaCategorias = "CREATE TABLE ${EmpresaDAO.TABLA_CATEGORIAS}" +
				"(" +
				"codigoCategoria INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"denominacion TEXT" +
				")"
		db!!.execSQL(crearTablaCategorias)

		val crearTablaProductos = "CREATE TABLE ${EmpresaDAO.TABLA_PRODUCTOS}" +
				"(" +
				"codigoProducto INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"codigoCategoria INTEGER, " +
				"denominacion TEXT, " +
				"pvp INTEGER, " +
				"imagenProducto TEXT, " +
				"color TEXT," +
				"talla INTEGER" +
//				", FOREIGN KEY codigoCategoria REFERENCES ${EmpresaDAO.TABLA_CATEGORIAS} (codigoCategoria)" +
				")"
		db.execSQL(crearTablaProductos)

		val crearTablaUsuarios = "CREATE TABLE ${EmpresaDAO.TABLA_USUARIOS}" +
				"(" +
				"codigoUsuario INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"login TEXT UNIQUE, " +
				"contrasena TEXT, " +
				"nombre TEXT" +
				")"
		db.execSQL(crearTablaUsuarios)

		val crearTablaListaDeseos = "CREATE TABLE ${EmpresaDAO.TABLA_LISTADESEOS}" +
				"(" +
				"codigo INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"codigoUsuario INTEGER, " +
//				"codigoUsuario INTEGER FOREIGN KEY REFERENCES ${EmpresaDAO.TABLA_USUARIOS} (codigoUsuario), " +
				"codigoProducto INTEGER" +
//				"codigoProducto INTEGER FOREIGN KEY REFERENCES ${EmpresaDAO.TABLA_PRODUCTOS} (codigoProducto)" +
				")"
		db.execSQL(crearTablaListaDeseos)

		Thread {
			db.execSQL("INSERT into ${EmpresaDAO.TABLA_CATEGORIAS} (denominacion) values ('Camisetas')")
			db.execSQL("INSERT into ${EmpresaDAO.TABLA_CATEGORIAS} (denominacion) values ('Pantalones')")
			db.execSQL("INSERT into ${EmpresaDAO.TABLA_CATEGORIAS} (denominacion) values ('Zapatos')")
			db.execSQL("INSERT into ${EmpresaDAO.TABLA_USUARIOS} (login, contrasena, nombre ) values ('mori', 'mori', 'Angel');")
			db.execSQL("INSERT into ${EmpresaDAO.TABLA_USUARIOS} (login, contrasena, nombre ) values ('MJ', 'MJ', 'MJ');")
			db.execSQL("INSERT into ${EmpresaDAO.TABLA_USUARIOS} (login, contrasena, nombre ) values ('invitado', 'invitado', 'invitado');")

			db.execSQL("INSERT into ${EmpresaDAO.TABLA_PRODUCTOS} (codigoCategoria, denominacion, pvp, imagenProducto, color, talla) values ('1', 'Camiseta', 55,'https://upload.wikimedia.org/wikipedia/commons/5/57/TShirtForgetIraq.jpg', 'blanco', 12)")
			db.execSQL("INSERT into ${EmpresaDAO.TABLA_PRODUCTOS} (codigoCategoria, denominacion, pvp, imagenProducto, color, talla) values ('1', 'Camiseta', 43,'https://upload.wikimedia.org/wikipedia/commons/8/81/Camiseta-negra.jpg', 'negra', 12)")

		}.start()
	}

	override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
		TODO("Not yet implemented")
	}
}