package com.sde.bd1delgadosergio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sde.bd1delgadosergio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(binding.root).load(getString(R.string.url)).diskCacheStrategy(DiskCacheStrategy.ALL).into(binding.imgPortal)

        Thread{
            Thread.sleep(1500)
            intent = Intent(this, BuscarActivity::class.java)
            startActivity(intent)
        }.start()
    }
}