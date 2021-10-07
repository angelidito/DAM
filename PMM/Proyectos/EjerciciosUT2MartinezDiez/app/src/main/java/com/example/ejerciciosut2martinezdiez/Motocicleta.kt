package com.example.ejerciciosut2martinezdiez

class Motocicleta(
    marca: String,
    modelo: String,
    color: String,
    var nPlazas: Int = 3,
    var maletero: Boolean = false
) : Vehículo3(marca, modelo, color) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        print(", $nPlazas plazas")
        if (maletero)
            println(" con maletero")
        else
            println(" sin maletero")
    }

}