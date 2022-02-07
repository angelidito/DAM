package com.ppsg.fundamentos

fun main() {
    var objeto: String? = null
    println(objeto?.toString())
    mostrarNombre(nombre1 = "Ana", nombre2 = "Pepe", nombre3 = "Juan")
    mostrarNombre2("Ana")
    mostrarNombre2("Ana", "xzxz", "yyy")

    mostrarNombre2("Ana", "xzxz", "yyy","hhhh")


    for (i in 1 .. 5)
       print(i.toString()+"\t")
    println()

    ejemplowhen()
}

fun ejemplowhen() {
    var numero = 31
    when (numero){
        10 -> println("Vale diez")
        7, 5 ,9 -> println("Son impares")
        in 20..30 -> println("Vale entre 20 y 30")
        !in 30..40 -> println("No está ni entre 30 ni 40")
        is Int -> println("Es un número")
        else -> println("No es nada")
    }
}

fun mostrarNombre (nombre1:String, nombre2:String,nombre3:String):Unit{
    println(nombre1)
    println(nombre2)
    println(nombre3)
}

fun mostrarNombre2 (vararg personas:String){
    println()
    for(persona in personas)
        print(persona + "\t")
    for (posicion in 0..personas.size-1)
        print(personas[posicion])
    for (posicion2 in 0 until personas.size-1){

    }
}
