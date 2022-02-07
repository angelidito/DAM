package com.example.ej2delgadosergio

interface EventosListener {
    fun onLongClickListener(monumento: Monumento)

    fun onClickLlamar(monumento: Monumento)

    fun onClickEmail(monumento: Monumento)
}