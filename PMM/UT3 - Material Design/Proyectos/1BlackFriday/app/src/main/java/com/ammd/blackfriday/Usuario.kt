package com.ammd.blackfriday

class Usuario(val login: String, val constraseña: String) {

    public fun validar(login: String, contrasela: String): Boolean {
        return this.login == login && this.constraseña == constraseña
    }
}
