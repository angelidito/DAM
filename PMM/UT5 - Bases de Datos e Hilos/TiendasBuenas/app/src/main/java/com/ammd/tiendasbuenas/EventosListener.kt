package com.ammd.tiendasbuenas

interface EventosListener {
    fun editar(id: Int)
    fun onFavorito(tienda: Tienda)
    fun borrarTienda(id: Int)
}