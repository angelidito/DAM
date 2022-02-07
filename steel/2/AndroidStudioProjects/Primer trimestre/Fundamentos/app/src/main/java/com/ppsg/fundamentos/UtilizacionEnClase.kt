package com.ppsg.fundamentos

class UtilizacionEnClase {

}

fun main(){
    /*
    val objeto = Persona("Ana", "Pardo")
    println("${objeto.nombre}      ${objeto.apellidos}     ${objeto.edad}")
    var objeto2 = Persona("pepe","Garcia", 22)
    println("${objeto2.nombre}      ${objeto2.apellidos}     ${objeto2.edad}")

    objeto.nombre="Maria"
    objeto.apellidos=""
    println("${objeto.nombre}      ${objeto.apellidos}")
    objeto.nombre = ""
    objeto.apellidos = "Perez"
    println("${objeto.nombre}      ${objeto.apellidos}")*/
    var alumno=Alumno("Maria", "Pardo","2DAM")
    alumno.visualizar()
}