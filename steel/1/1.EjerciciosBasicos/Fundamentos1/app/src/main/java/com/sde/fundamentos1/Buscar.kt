package com.sde.fundamentos1

fun main(){
    mostrarNombres("ana", "pepe", "juan")
    mostrarNombres2("xx", "zz", "ii")
    ejemplowhen()
    
    for (i in 1..4)
        println (i.toString() + "\t")
}

fun ejemplowhen(){
    var numero = 11
    when (numero){
        10 -> println("El valor es diez")
        7, 5, 9 -> println("Son impares") //Se pueden meter varios valores
        in 20..30 -> println("El valor está entre 20 y 30") //Se pueden meter rangos
        !in (30..40) -> println("El valor no está entre 30 y 40") //Si no está entre...
        is Int -> println("Es un número") //Si es un Int
        else -> println("No es nada")
    }
}


fun mostrarNombres(nombre1:String, nombre2:String, nombre3:String){
    println(nombre1)
    println(nombre2)
    println(nombre3)
}

fun mostrarNombres2(vararg personas:String){
    for (persona in personas)
        println(persona + "\t")
    for (posicion in 0.. personas.size - 1)
        print(personas[posicion] + "\t")
    for (posicion2 in 0 until personas.size - 1)
        print(personas[posicion2] + "\t")
}
