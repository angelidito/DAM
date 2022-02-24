package com.examen.recmartinezangel.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.examen.recmartinezangel.R
import com.examen.recmartinezangel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)


//		Glide.with(binding.root).load(getString(R.string.url_centro))
//			.diskCacheStrategy(DiskCacheStrategy.ALL).into(binding.imgCorporativa)

		binding.denominacion.text = getString(R.string.denominacion)
		binding.direccion.text = getString(R.string.direccion)
		binding.telefono.text = getString(R.string.telefono)


		Thread {
			Thread.sleep(2500)
			intent = Intent(this, LoginActivity::class.java)
			startActivity(intent)
			finish()
		}.start()
	}
}