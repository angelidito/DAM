package com.martinezangel.bd2.eventlisteners

import com.martinezangel.bd2.models.Gestion

interface InfoCasoEventListener {
	fun onLongClickListener(gestion: Gestion)
}