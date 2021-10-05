package com.example.myapplication

import java.util.*

class Alumn(name: String, surname: String, var course: Int, age: Int) : Person(name, surname, age) {

    override fun visualizar() {
        super.visualizar()
        println("Está en ${course}º.")
    }
}