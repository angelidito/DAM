package com.example.myapplication

fun main() {
//    // Inmutables
//    val a: Int
//    val b = 2
//    // Mutables
//    var c = 2.4
//    var d: Float
//
//    a = 2
//    d = 2.57f
//    funPrintln("Hello world!\nWhat's up man?")
//
//    var juan = Usuario()
//    funPrintln("Nombre: " + juan.name)
//    var maria: Usuario?
//
//    maria = Usuario()
//
//    funPrintln("Nombre nulo: " + maria?.name?:"desconocido")
//
//    println("$a" + '\n')
//
//    helloWorld()

    var person1 = Person(name = "Mori", surname = "M")
    println("Nombre: ${person1.name}; Apellido: ${person1.surname}, Edad: ${person1.age}")

    var person2 = Person("Luka", "Knavish", 22)
    println("Nombre: ${person2.name}; Apellido: ${person2.surname}, Edad: ${person2.age}")

}

fun helloWorld() {
    TODO("Not yet implemented")
}

// todo
fun funPrintln(str: String): Unit {
    println(str)
}

//fun PrintPeople(vararg people: Usuario)
//{
////    for (person in people) {
////        print(person.name)
////    }
//    for (person in 0..people.size - 1) {
//        print(person.name)
//    }
//    for (person in 0 until people.size) {
//        print(person.name)
//    }
//}

fun exampleWhen(num: Int) {
    when (num) {
        10 -> println("vale diez")
        1, 3, 7, 5, 9 -> println("impar")
        in 11..20 -> println("entre 11 y 20")

        !in (21..30) -> println("coassdfsdaf")
        is Int -> {
            println("es un numero")
            println("kotlin es raro")
        }
        else -> println("AAAAAGGGGGHHH")
    }

}
