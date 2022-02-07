package com.ppsg.fundamentos

data class Articulo(val nombre:String, val precio:Float){
    //Para generar el equals, debes dar click derecho-->generate-->y eliges
    override fun equals(other: Any?): Boolean {//la ? quiere decir que puede ser nulo
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
