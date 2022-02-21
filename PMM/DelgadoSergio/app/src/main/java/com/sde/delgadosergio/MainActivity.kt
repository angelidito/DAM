package com.sde.delgadosergio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sde.delgadosergio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(binding.root).load(getString(R.string.url))
            .diskCacheStrategy(DiskCacheStrategy.ALL).into(binding.imgLogo)

        binding.nombreTienda.text = R.string.nombreTienda.toString()

        binding.cifTienda.text = R.string.CIF.toString()

        Thread {
            Thread.sleep(2500)
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }.start()
    }
}