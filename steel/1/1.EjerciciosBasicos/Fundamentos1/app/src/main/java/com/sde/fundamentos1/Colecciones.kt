package com.sde.fundamentos1

fun main(){
    // Colección de SOLO lectura
    val listaFrutas = listOf("Manzana", "Pera", "Plátano")
    for (fruta in listaFrutas)
        println(fruta)
    for (i in 0 until listaFrutas.size) {
        println(listaFrutas[i])         // Esta línea y la de abajo hacen lo mismo
        println(listaFrutas.get(i))
    }

    val persona1= Persona("Luis", "Pérez")
    val persona2= Persona("Juan", "Calvo")
    val lista2 = mutableListOf<Persona>(persona1, persona2)
    for (i in 0..lista2.size - 1)
        lista2[i].visualizar()
}