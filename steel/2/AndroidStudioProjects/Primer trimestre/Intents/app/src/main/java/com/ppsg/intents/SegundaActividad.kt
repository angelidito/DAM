package com.ppsg.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ppsg.intents.databinding.ActivityMainBinding
import com.ppsg.intents.databinding.ActivitySecondBinding

class SegundaActividad : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val enviado = intent.getStringExtra(MainActivity.EXTRA_NOMBRE)
        val recibido = intent.getParcelableExtra<Usuario>(MainActivity.OBJETO)
        //binding.tvNameReceived.text=getString(R.string.msgAccept,enviado)
        binding.tvNameReceived.text = getString(
            R.string.msgAccept,
            recibido?.nombre + "   " + recibido?.apellidos
        )
        binding.btAccept.setOnClickListener {
            //Devuelve el numero de estrellas que has solicitado
            val intentResult: Intent = Intent()
            intentResult.putExtra("Valores", binding.ratingBar.rating)
            setResult(RESULT_OK, intentResult)
            finish()
        }
        binding.btCancel.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}