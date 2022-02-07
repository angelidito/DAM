package com.ppsg.ej1basesdedatos

data class Tienda(var id:Int, var name:String, var esFavorito:Int){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Tienda

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }
}

