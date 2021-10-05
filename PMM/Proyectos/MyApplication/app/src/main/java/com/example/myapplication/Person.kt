package com.example.myapplication

open class Person(name: String, surname: String) {

    var name = ""
        get() = "$field"
        set(value) {
            field = if (value.isEmpty()) "Sin nombre" else value
        }


    var surname = ""
        get() {
            return "$field"
        }
        set(value) {
            field = if (value.isEmpty()) "Sin apellido" else value.uppercase()
        }
    var age: Int

    init {
        this.name = name
        this.surname = surname
        age = -1
    }

    constructor(name: String, surname: String, age: Int) : this(name, surname) {
        this.age = age
    }

    open fun visualizar(){
        println(this.surname + ", " + this.name +"; " + this.age + " años.")
    }
}