package com.ppsg.bd2saucopedropablo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.ppsg.bd2saucopedropablo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var gridLayout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(binding.root)
            .load("https://jdimmigration.es/wp-content/uploads/bufete-de-abogados.jpg")
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.imgBufete)
        Thread {
            Thread.sleep(1000)
            intent = Intent(this, Login::class.java)
            startActivity(intent)
        }.start()
    }
}
