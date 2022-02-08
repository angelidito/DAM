package com.mjpg.tiendasfragment.vistamodelo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VistaModelo(id: Long) : ViewModel() {
	var identificador = MutableLiveData<Long>()

	init {
		identificador = MutableLiveData(0)
	}

	fun getIdentificador(): Long? {
		return identificador!!.value
	}

	fun setIdentificador(id: Long) {
		identificador.value = id
	}


}