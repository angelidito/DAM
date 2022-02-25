package com.ammd.bd1

interface Eventoslistener {
    fun onLongClickListener(alojamiento: Alojamientos, posicion:Int)
    fun openAlojamiento(codigoAlojamiento: Int)
    fun onFavorito(alojamiento: Alojamientos)

}