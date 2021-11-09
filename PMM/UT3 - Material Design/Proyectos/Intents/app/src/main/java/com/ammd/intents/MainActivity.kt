package com.ammd.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ammd.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    companion object {
        const val EXTRA_NOMBRE = "nombre"
        const val EXTRA_OBJETO = "ususario"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSend.setOnClickListener(escucharBoton)

    }

    val escucharBoton = View.OnClickListener {
        val intent = Intent(this, SecondActivity::class.java)

        intent.putExtra(EXTRA_NOMBRE, binding.textToSend2.text)
        val usuario = Usuario(binding.textToSend2.text.toString(), "Martínez")
        intent.putExtra(EXTRA_OBJETO, usuario)
        startActivity(intent)
    }

    val resultadoActividad : registerActivityResult()
}