package com.mjpg.tiendasfragment

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mjpg.tiendasfragment.databinding.ConsultaBinding


class ConsultaFragment : Fragment() {

	private lateinit var mBinding: ConsultaBinding


	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		mBinding = ConsultaBinding.inflate(inflater, container, false)
		return mBinding.root
	}

/*
/////////////////////////////////////
	private fun getAllTiendas(){
		consultaCorrutinas()
	}

	override fun borrarTienda(id:long){
		lobalScope.launch(Disparchers.IO) {
		 db.deleteTienda(id)
			launch(Dispatchers.Main)
			{
				adaptador.borrar(id)
			}
		}
	}

	private fun consultaCorrutinas(){
		GlobalScope.launch(Disparchers.IO){
			launch(Dispatchers.Main){
				adaptador.setTiendas(tienda)
			}
		}
	}
*/


}


