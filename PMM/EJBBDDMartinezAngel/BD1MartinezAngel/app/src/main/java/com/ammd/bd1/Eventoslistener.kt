package com.ammd.bd1

interface Eventoslistener {
    fun onLongClickListener(alojamiento: Alojamientos, posicion:Int)
    fun openAlojamiento(alojamiento: Alojamientos)
    fun onFavorito(alojamiento: Alojamientos)

}