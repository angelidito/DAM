package com.examen.martinezangel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.examen.martinezangel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		Thread {
			Thread.sleep(2500)
			intent = Intent(this, LoginActivity::class.java)
			startActivity(intent)
		}.start()
	}
}