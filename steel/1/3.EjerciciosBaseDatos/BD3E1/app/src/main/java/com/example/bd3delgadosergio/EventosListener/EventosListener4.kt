package com.example.bd3delgadosergio.EventosListener

import com.example.bd3delgadosergio.Pojos.ListaProducto

interface EventosListener4 {
    fun onClickListener(listaProducto: ListaProducto)

    fun onLongClickListener(listaProducto: ListaProducto)
}