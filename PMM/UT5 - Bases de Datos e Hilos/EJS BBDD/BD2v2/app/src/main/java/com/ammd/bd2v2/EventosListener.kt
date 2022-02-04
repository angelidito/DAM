package com.ammd.bd2v2

interface EventosListener {
	fun marcarComoRealizado(numeroCaso: String)
	fun mostrarCaso(numeroCaso: String)
}
