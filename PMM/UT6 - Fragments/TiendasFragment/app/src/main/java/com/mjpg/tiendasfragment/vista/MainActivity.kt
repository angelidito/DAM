package com.mjpg.tiendasfragment.vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.mjpg.tiendasfragment.R
import com.mjpg.tiendasfragment.databinding.ActivityMainBinding
import com.mjpg.tiendasfragment.vistamodelo.VistaModelo
import com.mjpg.tiendasfragment.vistamodelo.VistaModeloFactory

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	private lateinit var vistaModelo: VistaModelo

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		val fragmentManager = supportFragmentManager;
		val fragmentTransaction = fragmentManager.beginTransaction()

		val vistaModeloFactory = VistaModeloFactory(0)
		vistaModelo = ViewModelProvider(this, vistaModeloFactory).get(VistaModelo::class.java)

		if (binding.fragContenedor != null) {
			val fragment = ConsultaFragment()
			fragmentTransaction.add(R.id.frag_contenedor, fragment)

		} else {
			val fragmento2 = EditarFragment()
			fragmentTransaction.add(R.id.fragmentdetalle, fragmento2)
		}
		fragmentTransaction.addToBackStack(null)
		fragmentTransaction.commit()


	}

	fun anadir() {
		val fragmentManager = supportFragmentManager;
		val fragmentTransaction = fragmentManager.beginTransaction()
		if (binding.fragContenedor != null) {
			val fragment = EditarFragment()
			fragmentTransaction.replace(R.id.frag_contenedor, fragment)

		} else {
			val fragmento2 = EditarFragment()
			fragmentTransaction.replace(R.id.fragmentdetalle, fragmento2)
		}
		fragmentTransaction.addToBackStack(null)
		fragmentTransaction.commit()
	}

	public final fun editar(id: Long) {

	}

}


