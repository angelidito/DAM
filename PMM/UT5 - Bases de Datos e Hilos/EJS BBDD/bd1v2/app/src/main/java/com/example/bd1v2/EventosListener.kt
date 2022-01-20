package com.example.bd1v2

interface EventosListener {
    fun onLongClickListener(alojamiento: Alojamiento)
    fun editar(id: Int)
    fun favorito(alojamiento: Alojamiento)
    fun borrarTienda(id: Int)
}