package com.ppsg.bloque1_sauco_pedropablo

data class Producto(var codigo: Int, var nombre:String,var imagen:String, var url:String){
    fun producto():String="$codigo $nombre $imagen $url"
    //Función que toma un objeto y genera un valor numérico - Hash Code
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Producto

        if (codigo != other.codigo) return false
        if (nombre != other.nombre) return false
        if (imagen != other.imagen) return false
        if (url != other.url) return false

        return true
    }

    override fun hashCode(): Int {
        var result = codigo
        result = 31 * result + nombre.hashCode()
        result = 31 * result + imagen.hashCode()
        result = 31 * result + url.hashCode()
        return result
    }

}
