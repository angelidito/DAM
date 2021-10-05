package com.example.ejerciciosut2martinezdiez

class Motocicleta(
    marca: String,
    modelo: String,
    color: String,
    var nPuertas: Int = 3,
    var maletero: Boolean = false
) : Vehículo3(marca, modelo, color) {

}