package com.example.ejerciciosut2martinezdiez

class Coche(
    marca: String,
    modelo: String,
    color: String,
    var nPuertas: Int = 3,
    var nPlazas: Int = 2
) : Vehículo3(marca, modelo, color) {

}