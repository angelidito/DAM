package com.sde.ejtiendas

interface EventosListener {
    fun editar(id:Int)
    fun onFavorito(tienda: Tienda)
    fun borrarTienda(id: Int)
}