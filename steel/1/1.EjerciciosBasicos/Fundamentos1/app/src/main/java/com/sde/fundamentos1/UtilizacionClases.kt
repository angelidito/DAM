package com.sde.fundamentos1

fun main(){
    val objeto = Persona("Ana", "Pardo")    // Creas el objeto de tipo Persona
    println("${objeto.nombre} \t ${objeto.apellidos} \t ${objeto.edad}")    // Como no recibe la edad, pone 0 (Si no hay edad, edad = 0)

    val objeto2 = Persona("Pepe", "García", 33)
    println("${objeto2.nombre} \t ${objeto2.apellidos} \t ${objeto2.edad}")


    objeto.nombre = "María"
    objeto.apellidos = "Garcia"
    println("${objeto.nombre} \t ${objeto.apellidos}")

    objeto.nombre = ""
    objeto.apellidos = "lópez"
    println("${objeto.nombre} \t ${objeto.apellidos}")

    var alumno = Alumno("Pepe", "López", "DAM")
    alumno.visualizar()
}