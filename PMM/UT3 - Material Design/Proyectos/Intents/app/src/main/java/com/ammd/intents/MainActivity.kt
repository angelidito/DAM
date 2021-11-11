package com.ammd.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
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
        resultadoActividad.launch(intent)
    }

    val resultadoActividad =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {
            if (it.resultCode == RESULT_OK) {
                val data: Intent? = it.data
                val resultado = data?.getFloatExtra("valores", 0.0f)
                binding.tvResult.text= "Condiciones aceptadas.\nGracias por dar su valoración con $resultado estrellas."
            }
            else {
                binding.tvResult.text= "Se ha cancelado."
            }
        }
}