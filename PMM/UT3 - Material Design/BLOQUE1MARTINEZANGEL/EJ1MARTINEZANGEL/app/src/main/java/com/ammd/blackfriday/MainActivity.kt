package com.ammd.blackfriday

import android.Manifest
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ammd.blackfriday.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import android.view.animation.CycleInterpolator

import android.view.animation.TranslateAnimation
import androidx.core.app.ActivityCompat
import com.ammd.blackfriday.databinding.ActivityProductBinding
import android.content.Intent as Intent


class MainActivity : AppCompatActivity() {
    private lateinit var usuarios: List<Usuario>
    private lateinit var producto: List<Producto>
    private lateinit var binding: ActivityMainBinding
    private var intentosFallidos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        usuarios = listOf(
            Usuario("admin", "1234"),
            Usuario("MJ", "MJ"),
            Usuario("mori", "mori")
        )


        binding.btnAcceder.setOnClickListener { accessLoginButton() }

    }

    private fun accessLoginButton() {

        var user = Usuario(
            binding.loginTil.editText?.text.toString(),
            binding.passwordTil.editText?.text.toString()
        )
        if (usuarios.contains(user)) {
            Snackbar.make(
                binding.root,
                "Bienvenid@ " + user.login,
                Snackbar.LENGTH_SHORT
            ).show()
            binding.loginTil.error = null
            binding.passwordTil.error = null

            val intent = Intent(this, ProductActivity::class.java)

            startActivity(intent)
//            binding.launch(intent)

        } else {
            binding.loginTil.startAnimation(shakeError())
            binding.passwordTil.startAnimation(shakeError())

            binding.loginTil.error = "Datos inválidos"
            binding.passwordTil.error = "Datos inválidos"
            Snackbar.make(
                binding.root,
                "Intentos fallidos: " + ++intentosFallidos,
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    private fun shakeError(): TranslateAnimation? {
        val shake = TranslateAnimation(0f, 10f, 0f, 0f)
        shake.duration = 300
        shake.interpolator = CycleInterpolator(7f)
        return shake
    }


}