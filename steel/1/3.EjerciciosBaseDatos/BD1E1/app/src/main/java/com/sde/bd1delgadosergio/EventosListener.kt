package com.sde.bd1delgadosergio

interface EventosListener {
    fun onLongClickListener(alojamiento: Alojamiento)

    fun onFavorito(alojamiento: Alojamiento)
}