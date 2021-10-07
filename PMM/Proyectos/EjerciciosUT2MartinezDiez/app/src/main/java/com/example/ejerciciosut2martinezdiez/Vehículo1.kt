package com.example.ejerciciosut2martinezdiez

class Vehículo1 {
    var marca = "Empty"
        get() {
            return "$field"
        }
        set(value) {
            field = if (value.isEmpty()) "Empty" else value
        }
    var modelo = "Empty"
        get() {
            return "$field"
        }
        set(value) {
            field = if (value.isEmpty()) "Empty" else value
        }
    var color = "Empty"
        get() {
            return "$field"
        }
        set(value) {
            field = if (value.isEmpty()) "Empty" else value
        }

    fun mostrarDatos() {
        println("$marca $modelo $color")
    }
}