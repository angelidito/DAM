package com.example.recsaucopedropablo

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recsaucopedropablo.databinding.ActivityRecepcionistaActividadBinding
import com.google.android.material.snackbar.Snackbar

class RecepcionistaActividad : AppCompatActivity(), EventosListener {
    private lateinit var binding: ActivityRecepcionistaActividadBinding
    private lateinit var callAdapter: VehiculoAdapter
    private lateinit var manager: RecyclerView.LayoutManager

    companion object {
        const val DNI = "dni"
        const val NOMBRE = "nombre"
        const val MATRICULA = "matricula"
        const val MODELO = "modelo"
        const val ESTADO = "estado"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRecepcionistaActividadBinding.inflate(layoutInflater)
        callAdapter = VehiculoAdapter(getVehiculos(), this)
        manager = LinearLayoutManager(this)
        binding.recyclerview.adapter = callAdapter
        binding.recyclerview.layoutManager = manager
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.anadir.setOnClickListener {
            intent = Intent(this, AnadirActividad::class.java)
            startActivity(intent)
        }
    }

    private fun getVehiculos(): List<Vehiculo> {
        var vehiculos = mutableListOf<Vehiculo>()
        val vehiculo1 = Vehiculo(
            "12345678A", "Sergio", "87654321A", "Seat Leon", "17/12/21",
            "Dirección tocada", true
        )
        val vehiculo2 = Vehiculo(
            "12345678B", "Vistor", "87654321B", "BMW Serie3", "05/03/21",
            "Radiador roto", false
        )
        vehiculos.add(vehiculo1)
        vehiculos.add(vehiculo2)
        return vehiculos
    }

    override fun onLongClickListener(vehiculo: Vehiculo, posicion: Int) {

    }

    override fun onClickListener(vehiculo: Vehiculo, posicion: Int) {

    }
}
