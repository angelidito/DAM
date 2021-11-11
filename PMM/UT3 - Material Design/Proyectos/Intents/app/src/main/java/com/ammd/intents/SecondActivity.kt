package com.ammd.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ammd.intents.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombreRecibido = intent.getStringExtra(MainActivity.EXTRA_NOMBRE)
        binding.tvNameReceived.text = getString(R.string.msgAccept, nombreRecibido)

        val usuarioRecibido = intent.getParcelableExtra<Usuario>(MainActivity.EXTRA_OBJETO)

        binding.tvNameReceived.text = getString(
            R.string.msgAccept,
            usuarioRecibido?.nombre + " " + usuarioRecibido?.apellidos
        )
        binding.btAccept.setOnClickListener {
            val intentResult = intent
            intentResult.putExtra("valores", binding.ratingBar.rating)
            setResult(RESULT_OK, intentResult)
            finish()
        }
        binding.btCancel.setOnClickListener {
            setResult(RESULT_CANCELED)
        }
    }
}