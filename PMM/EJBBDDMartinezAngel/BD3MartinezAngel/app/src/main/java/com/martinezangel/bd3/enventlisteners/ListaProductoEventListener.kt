package com.martinezangel.bd3.enventlisteners

import com.martinezangel.bd3.models.ListaProducto

interface ListaProductoEventListener {
    fun onClickListener(listaProducto: ListaProducto)

    fun onLongClickListener(listaProducto: ListaProducto)
}