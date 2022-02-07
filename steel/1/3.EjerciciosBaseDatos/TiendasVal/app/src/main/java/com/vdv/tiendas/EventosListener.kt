package com.vdv.tiendas

import com.mjpg.tiendas.Tienda

interface EventosListener {
    fun editar(id:Long)
    fun onFavorito(tienda: Tienda)
    fun borrarTienda(id: Long)
}