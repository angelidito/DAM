package com.ammd.bd2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent




class SpashActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val intent = Intent(this, MainActivity::class.java)
		startActivity(intent)
		finish()
	}
}