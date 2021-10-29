package com.mjpg.userssp

class Usuario(val id: Long, var name: String, var apellidos: String, var url: String) {
    fun personalizado(): String = "$name + $apellidos"
}