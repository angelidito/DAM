package com.example.ej2_sauco_pedropablo

interface EventosListener {
    fun llamarEvento(monumento: Monumento)
    fun correoEvento(monumento: Monumento)
    fun mostrarDetalles(monumento: Monumento)
}