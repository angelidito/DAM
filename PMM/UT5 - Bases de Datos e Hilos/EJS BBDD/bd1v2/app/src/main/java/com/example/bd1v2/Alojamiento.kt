package com.example.bd1v2

data class Alojamiento(var id: Int, var denominacion: String, var precioNochePers: Int, var esFavorito: Int) {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}
