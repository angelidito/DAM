package com.ammd.a2monumentos

interface EventosListener {
    fun onClickListenerCall(monumento: Monumento,posicion:Int)
    fun onClickListenerEmail(monumento: Monumento,posicion:Int)
}