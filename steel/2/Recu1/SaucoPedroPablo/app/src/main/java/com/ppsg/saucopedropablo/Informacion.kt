package com.ppsg.saucopedropablo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ppsg.saucopedropablo.databinding.ActivityInformacionBinding


class Informacion : AppCompatActivity() {
    private lateinit var binding: ActivityInformacionBinding
    private lateinit var callAdapter: EspecialidadAdapter
    private lateinit var manager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityInformacionBinding.inflate(layoutInflater)
        callAdapter = EspecialidadAdapter(getEspecialidad(), this)
        manager = LinearLayoutManager(this)
        binding.recyclerview.adapter = callAdapter
        binding.recyclerview.layoutManager = manager
        setContentView(binding.root)

        var especialidad = intent.getParcelableExtra<Especialidad>("Especialidad")


        super.onCreate(savedInstanceState)

    }

    private fun getEspecialidad(): List<Especialidad> {
        val especialidad1 = Especialidad(1, "Neurología",2)
        val especialidad2 = Especialidad(2, "Trauma",3)
        val especialidades: List<Especialidad> = listOf(especialidad1, especialidad2)
        return especialidades
    }
}
