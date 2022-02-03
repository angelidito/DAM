package com.ammd.bd2v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent




class SplashActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val intent = Intent(this, MainActivity::class.java)
		startActivity(intent)
		finish() // evitar regresar a éste activity
	}
}