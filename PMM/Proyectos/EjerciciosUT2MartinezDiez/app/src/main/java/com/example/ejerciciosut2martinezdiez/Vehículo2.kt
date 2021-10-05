package com.example.ejerciciosut2martinezdiez

class Vehículo2(marca: String, modelo: String, color: String) {
    var marca: String = "Empty"
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

    init {
        this.marca = marca
        this.modelo = modelo
        this.color = color
    }

    fun mostrarDatos() {
        println("${marca} ${modelo} ${color}")
    }
}