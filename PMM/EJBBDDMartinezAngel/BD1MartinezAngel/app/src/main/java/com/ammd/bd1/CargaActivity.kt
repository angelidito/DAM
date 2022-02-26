package com.ammd.bd1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ammd.bd1.databinding.ActivityCargaBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class CargaActivity : AppCompatActivity(){
    lateinit var binding: ActivityCargaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCargaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(binding.root)
            .load("https://upload.wikimedia.org/wikipedia/commons/d/de/%C3%81lvaro_Baeza_Gui%C3%B1ez%2C_Abogado_Chileno.jpg")
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.imgCorporativa)

        Thread {
            Thread.sleep(2500)
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }.start()

    }
}