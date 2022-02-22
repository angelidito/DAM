package com.examen.recmartinezangel.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.examen.recmartinezangel.databinding.ActivityOptionsBinding
import com.examen.recmartinezangel.db.ColegioDAO
import com.examen.recmartinezangel.eventlisteners.OptionsListener

class OptionsActivity : AppCompatActivity(), OptionsListener {
	private lateinit var database: ColegioDAO
	lateinit var binding: ActivityOptionsBinding
	lateinit var codigoProfe:String

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityOptionsBinding.inflate(layoutInflater)
		setContentView(binding.root)
  		codigoProfe = intent.getStringExtra("codigoProfesor").toString()
		onFaltasClickListener()
		onConsultaClickListener()
	}

	override fun onFaltasClickListener() {
		binding.btnFaltas.setOnClickListener {
			intent = Intent(this, FaltasActivity::class.java)
			intent.putExtra("codprofe", codigoProfe)
			startActivity(intent)
		}
	}

	override fun onConsultaClickListener() {

	}
}