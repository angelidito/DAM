package com.ammd.bd2

interface Eventoslistener {
    fun onLongClickListener(alojamiento: Alojamientos, posicion:Int)
    fun openAlojamiento(codigoAlojamiento: Int)
    fun onFavorito(alojamiento: Alojamientos)

}