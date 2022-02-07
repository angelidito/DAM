package com.sde.delgadosergio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sde.delgadosergio.databinding.ActivityInformacionBinding
import com.sde.delgadosergio.databinding.ActivityRegistroBinding

class InformacionActivity : AppCompatActivity(), EventosListener {
    private lateinit var binding: ActivityInformacionBinding
    private lateinit var especialidadAdaptador:EspecialidadAdapter
    private lateinit var linearlayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInformacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        especialidadAdaptador = EspecialidadAdapter(getEspecialidades(), this)
        linearlayoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = especialidadAdaptador
        binding.recyclerView.layoutManager = linearlayoutManager
    }

    private fun getEspecialidades(): List<Especialidad> {
        val especialidad1 = Especialidad(1, "Dermatología", 2)
        val especialidad2 = Especialidad(2, "Traumatología", 3)
        val especialidad3 = Especialidad(3, "Alergología", 1)
        val especialidad4 = Especialidad(4, "Cardiología", 6)
        val especialidad5 = Especialidad(5, "Oftalmología ", 4)
        return listOf(especialidad1, especialidad2, especialidad3, especialidad4, especialidad5)
    }

    companion object{
        const val ESPECIALIDAD = "especialidad"
    }

    // Al pulsar sobre una tarjeta te lleva de vuelta al Activity de Registro
    override fun onLongClickListener(especialidad: Especialidad) {
        val intentResult: Intent = Intent()
        intentResult.putExtra("especialidad", especialidad)
        setResult(RESULT_OK, intentResult)
        finish()
    }
}