package com.ppsg.fundamentos

fun main(){
    //colección de solo lectura
    val listaFrutas= listOf("Manzada", "Pera","Platano")
    for (fruta in listaFrutas) {
        println(fruta)
    }
    for (i in 0 until listaFrutas.size) {
        println(listaFrutas[i])
        println(listaFrutas.get(i))
    }
val persona1=Persona("Maria","Pardo")
    val persona2=Persona("Pepe","Sauco")
    val lista2= mutableListOf<Persona>(persona1,persona2)
    for (i in 0..lista2.size-1){
        lista2[i].visualizar()
        lista2.get((i))
    }
}