package com.example.myapplication

fun main() {
    // coleccion de sólo lectura
    val listaFrutas = listOf("manzana", "pera", "plátano", "melocotón en almibar")

    for (fruta in listaFrutas) {
        println(fruta)
    }
    for (i in 0 until listaFrutas.size) {
        println(listaFrutas[i])
        println(listaFrutas.get(i))
    }

    val persona1 = Person("Mori", "M", 24)
    val persona2 = Person ("Juana", "de Arco", 18)

    val lista2 = mutableListOf<Person>(persona1, persona2)

    for (i in 0..lista2.size - 1) {
        lista2[i].visualizar()
    }
}