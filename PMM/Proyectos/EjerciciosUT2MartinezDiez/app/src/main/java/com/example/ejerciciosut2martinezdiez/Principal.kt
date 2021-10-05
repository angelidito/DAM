package com.example.ejerciciosut2martinezdiez

fun main() {
    val v11 = Vehículo1()
    val v12 = Vehículo1()
    val v13 = Vehículo1()
    val lista1 = listOf(v11, v12, v13)

    for (v in lista1) {
        v.mostrarDatos()
    }

    val v21 = Vehículo2("Alfa Romeo", "Giulietta", "rojo")
    val v22 = Vehículo2("Peugeot", "307", "negro")
    val v23 = Vehículo2("Audi", "90", "dorado")
    val lista2 = listOf(v21, v22, v23)

    for (v in lista2) {
        v.mostrarDatos()
    }

    val c1: Vehículo3
    val c2: Vehículo3
    val m1: Vehículo3
    val m2: Vehículo3

    c1 = Coche("Alfa Romeo", "Giulietta", "rojo", 5, 5)


    val lista3 = listOf()

    for (v in lista3) {
        v.mostrarDatos()
    }
}