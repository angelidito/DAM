package com.sde.fundamentos1

fun main(){
    nuevoConcepto("Mutables e Inmutables")

    // INMUTABLE (Una vez que se indica el valor, no se puede cambiar)
    val a:Int
    a = 2
    val numero = 2

    // MUTABLE (El valor se puede cambiar en el futuro)
    var b:Float
    b = 2.4f
    var numero2 = 2.4

    var obj:String?
    obj = null

    var jorge = Usuario()
    println (jorge.nombre ?:"sinnombre") // Si Jorge no es nulo, dame el nombre. Si es nulo, pon "sinnombre"

    var objeto:String?=null
    println(objeto.toString())
    // Como el objeto es nulo, no salta el error, sino que literalmente sale "null"
    var num1=2
    var num2=5
    println ("numero" + num1)
    println ("numero + $num2")
    println ("SUMAR")
    println ("$num1 + $num2 = ${sumar(num1, num2)}")

    nuevoConcepto("Sobrecarga")
    mostrarProducto("lapicero")
    mostrarProducto("boligrafo", "15%")
    mostrarProducto("sacapuntas", "20%", "Hasta final de mes")
    mostrarProducto("estuche", vigencia = "Hasta final de año")
}

fun nuevoConcepto(topico:String){
    println()
    println(topico)
}

fun sumar(a:Int, b:Int):Int {
    return a + b
}

fun sumar2(a:Int, b:Int) = a+b  // Como la función de arriba pero más simple

fun mostrarProducto(nombre:String, promo:String="sin promocion", vigencia:String="Hasta agotar existencias"){
    println("nombre = $nombre + $promo + $vigencia")
    // Si el método no recibe la variable "promo", muestra "sin promoción". Si la recibe, muestra su contenido
}

