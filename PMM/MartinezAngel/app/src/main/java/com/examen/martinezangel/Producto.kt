package com.examen.martinezangel

data class Producto(
	var codigoProducto: Int,
	var codigoCategoria: Int,
	var denominacion: String,
	var pvp: Int,
	var imagenProducto: String,
	var color: String,
	var talla: Int
) {
}
