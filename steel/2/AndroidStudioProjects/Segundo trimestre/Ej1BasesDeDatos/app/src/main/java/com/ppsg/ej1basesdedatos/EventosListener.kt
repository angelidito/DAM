package com.ppsg.ej1basesdedatos

interface EventosListener {
    fun editar(id: Int)
    fun onFavorito(tienda: Tienda)
    fun borrarTienda(id:Int)
}
