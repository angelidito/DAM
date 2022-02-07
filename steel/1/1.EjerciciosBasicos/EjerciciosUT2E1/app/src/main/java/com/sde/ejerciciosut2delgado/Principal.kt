package com.sde.ejerciciosut2delgado

fun main() {

    // EJERCICIO 1
    var veh1 = Vehiculo1()
    var veh2 = Vehiculo1()
    var veh3 = Vehiculo1()

    veh1.marca = "Seat"; veh1.modelo = "Ibiza"; veh1.color = "Negro"
    veh2.marca = "Ferrari"; veh2.modelo = ""; veh2.color = "Rojo"
    veh3.marca = "Citroën"; veh3.modelo = "DS4"; veh3.color = ""

    println("${veh1.marca}, ${veh1.modelo}, ${veh1.color}")
    println("${veh2.marca}, ${veh2.modelo}, ${veh2.color}")
    println("${veh3.marca}, ${veh3.modelo}, ${veh3.color}")

    // EJERCICIO 2
    var veh21 = Vehiculo2("Seat", "Ibiza", "Negro")
    var veh22 = Vehiculo2("Ferrari", "", "Rojo")
    var veh23 = Vehiculo2("Citroën", "DS4", "")

    veh21.visualizar()
    veh22.visualizar()
    veh23.visualizar()

    // EJERCICIO 3 (Vamos a hacer la herencia de la clase "Vehiculo3")
    var moto = Motocicleta("Kawasaki", "Z900", "Negra", 2, maletero = true)
    var moto1 = Motocicleta("Honda", "Super Cub", "Azul", 1, maletero = false)
    moto.visualizar()
    moto1.visualizar()

    var coch = Coche("Citroen", "Picasso", "Gris", 2, 5)
    var coch1 = Coche("Honda", "Super Cub", "Azul", 1, 3)
    coch.visualizar()
    coch1.visualizar()
}