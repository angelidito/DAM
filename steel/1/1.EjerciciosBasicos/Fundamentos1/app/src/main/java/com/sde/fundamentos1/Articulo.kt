package com.sde.fundamentos1

data class Articulo(val nombre:String, val precio:Float){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Articulo

        if (nombre != other.nombre) return false
        if (precio != other.precio) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nombre.hashCode()
        result = 31 * result + precio.hashCode()
        return result
    }
}
