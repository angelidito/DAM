package com.martinezangel.bd3.enventlisteners

import com.martinezangel.bd3.models.Lista

interface ListaEventListener {
    fun onClickListener(lista: Lista)

    fun onLongClickListener(lista: Lista)
}