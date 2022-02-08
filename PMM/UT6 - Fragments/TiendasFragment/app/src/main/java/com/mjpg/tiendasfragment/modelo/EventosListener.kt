package com.mjpg.tiendasfragment.modelo

import com.mjpg.tiendasfragment.modelo.Tienda

interface EventosListener {
    fun editar(id:Long)
    fun onFavorito(tienda: Tienda)
    fun borrarTienda(id:Long)

}
