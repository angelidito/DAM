package com.example.recsaucopedropablo

interface EventosListener {
    fun onLongClickListener(vehiculo: Vehiculo , posicion:Int)
    fun onClickListener(vehiculo: Vehiculo , posicion:Int)
}