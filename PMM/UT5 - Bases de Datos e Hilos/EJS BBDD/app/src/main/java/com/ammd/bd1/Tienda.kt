package com.ammd.tiendasbuenas

data class Tienda(
    var id: Int,
    var nombre: String,
    var esFavorito: Int = 0
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Tienda

        if (id != other.id) return false

        return true
    }

}
