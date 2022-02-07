package com.sde.ejbasedatos

interface EventosListener {
    fun editar(id:Int)
    fun onFavorito(tienda: Tienda)
    fun borrarTienda(id: Int)
}