package com.example.ejerciciosut2martinezdiez

fun main() {
    val v11 = Vehículo1()
    val v12 = Vehículo1()
    val v13 = Vehículo1()
    val lista1 = listOf(v11, v12, v13)
    v12.marca = "Opel"
    v12.modelo = "Calibra"
    v12.color = "negro"
    for (v in lista1)
        v.mostrarDatos()
    println()

    val v21 = Vehículo2("Alfa Romeo", "Giulietta", "rojo")
    val v22 = Vehículo2("Peugeot", "307", "negro")
    val v23 = Vehículo2("Audi", "90", "dorado")
    val lista2 = listOf(v21, v22, v23)

    for (v in lista2)
        v.mostrarDatos()
    println()



    val c1 = Coche("Alfa Romeo", "Giulietta", "rojo", 5, 5)
    val c2 = Coche("Peugeot", "307", "negro", 3, 4)
    val m1 = Motocicleta("BMW", "Tx-2", "azul", 2, false)
    val m2 = Motocicleta("Xian Lu", "Yukari", "rojo", 2, true)


    val lista3 = listOf(c1, c2, m1, m2)

    for (v in lista3)
        v.mostrarDatos()
}