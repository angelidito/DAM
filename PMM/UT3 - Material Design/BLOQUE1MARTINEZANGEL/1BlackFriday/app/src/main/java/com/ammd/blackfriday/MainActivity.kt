package com.ammd.blackfriday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var usuarios = listOf<Usuario>(
            Usuario("admin", "1234"),
            Usuario("MJ", "MJ"),
            Usuario("mori", "mori")
        )

//        layoutInflater.inflate()

    }
}