package com.mjpg.tiendasfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mjpg.tiendasfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (binding.fragContenedor!= null) {
            val fragment =ConsultaFragment()
            val fragmentManager = supportFragmentManager;
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.frag_contenedor, fragment)
            fragmentTransaction.commit()
        } else {
            val fragmento2 = EditarFragment()
            val fragmentManager = supportFragmentManager;
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fragmentdetalle, fragmento2)
            fragmentTransaction.commit()
        }
    }

}


