package com.example.bd1saucopedropablo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.bd1saucopedropablo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptador: AdaptadorPortal
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var db: PortalDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = PortalDAO(this)

        Glide.with(binding.root)
            .load("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e2/Trivago-2018.svg/640px-Trivago-2018.svg.png")
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.imgHotel)
        Thread {
            Thread.sleep(1000)
            intent = Intent(this, BusquedaHotel::class.java)
            startActivity(intent)
        }.start()
    }
}