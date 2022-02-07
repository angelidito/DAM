package com.sde.ejbasedatos

data class Tienda(var id:Int, var name:String, var esFavorito:Int){
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}
