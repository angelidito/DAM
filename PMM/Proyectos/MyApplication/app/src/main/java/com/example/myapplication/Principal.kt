package com.example.myapplication

fun main()
{
    // Inmutables
    val a: Int
    val b = 2
    // Mutables
    var c = 2.4
    var d: Float

    a = 2
    d = 2.57f
    funPrintln("Hello world!\nWhat's up man?")

    var juan = Usuario()
    funPrintln("Nombre: " + juan.nombre)
    var maria: Usuario?

    maria = Usuario()

    funPrintln("Nombre nulo: " + maria?.nombre?:"desconocido")

    println("$a" + '\n')
}

// todo
fun funPrintln(str:String):Unit
{
    println(str)
}

