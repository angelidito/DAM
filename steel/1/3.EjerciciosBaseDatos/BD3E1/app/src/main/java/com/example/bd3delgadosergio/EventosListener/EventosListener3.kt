package com.example.bd3delgadosergio.EventosListener

import com.example.bd3delgadosergio.Pojos.ListaCompra

interface EventosListener3 {
    fun onClickListener(lista: ListaCompra)

    fun onLongClickListener(lista: ListaCompra)
}