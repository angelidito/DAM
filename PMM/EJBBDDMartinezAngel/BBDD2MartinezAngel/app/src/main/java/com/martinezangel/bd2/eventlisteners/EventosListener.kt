package com.martinezangel.bd2.eventlisteners

import com.martinezangel.bd2.models.Caso

interface EventosListener {
    fun onClickListener(caso: Caso)
}