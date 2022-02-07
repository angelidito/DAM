package com.example.recsaucopedropablo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recsaucopedropablo.databinding.ActivityMecanicoActividadBinding
import com.google.android.material.snackbar.Snackbar

//pues dentro del clicklistener pones:
//idTarjeta.background = @android/color/red

class MecanicoActividad : AppCompatActivity(), EventosListener {
    private lateinit var binding: ActivityMecanicoActividadBinding
    private lateinit var callAdapter: VehiculoAdapter
    private lateinit var manager: RecyclerView.LayoutManager
    companion object{
        const val DNI =  "dni"
        const val NOMBRE = "nombre"
        const val MATRICULA = "matricula"
        const val MODELO = "modelo"
        const val ESTADO = "estado"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMecanicoActividadBinding.inflate(layoutInflater)
        callAdapter = VehiculoAdapter(getVehiculos(), this)
        manager = LinearLayoutManager(this)
        binding.recyclerview.adapter = callAdapter
        binding.recyclerview.layoutManager = manager
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
    private fun getVehiculos(): List<Vehiculo> {
        var vehiculos = mutableListOf<Vehiculo>()
        val vehiculo1 = Vehiculo("12345678A", "Sergio","87654321A","Seat Leon","17/12/21",
            "Dirección tocada", true)
        val vehiculo2 = Vehiculo("12345678B", "Vistor","87654321B", "BMW Serie3","05/03/21",
            "Radiador roto", false)
        vehiculos.add(vehiculo1)
        vehiculos.add(vehiculo2)
        return vehiculos
    }
    //pues dentro del clicklistener pones:
    //idTarjeta.background = @android/color/red
    override fun onLongClickListener(vehiculo: Vehiculo, posicion: Int) {

        val estado = vehiculo.estado
        if(estado == false){
            estado == true
            Snackbar.make(binding.root,"El vehículo ya está listo", Snackbar.LENGTH_LONG).show()
        }else{
            Snackbar.make(binding.root,"Ya estaba listo", Snackbar.LENGTH_LONG).show()
        }
        intent.putExtra(ESTADO,estado.toString())
        /*val dni = vehiculo.dni
        val nombre = vehiculo.nombre
        val matricula = vehiculo.matricula
        val modelo = vehiculo.modelo
        val intent = Intent()
        intent.putExtra(DNI,dni)
        intent.putExtra(NOMBRE,nombre)
        intent.putExtra(MATRICULA,matricula)
        intent.putExtra(MODELO,modelo)
        setResult(Activity.RESULT_OK, intent)*/
    }

    override fun onClickListener(vehiculo: Vehiculo, posicion: Int) {

    }
}

/*<TextView
            android:id="@+id/lblEstado"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/estado"
            app:layout_constraintTop_toTopOf="@id/estado"
            app:layout_constraintStart_toStartOf="parent"
            android:layout_marginLeft="10dp"/>

        <TextView
            android:id="@+id/estado"
            android:layout_width="0dp"
            tools:text="Estado"
            android:layout_height="wrap_content"
            android:textAppearance="?attr/textAppearanceSubtitle2"
            app:layout_constraintStart_toStartOf="@id/fecha"
            app:layout_constraintTop_toBottomOf="@id/fecha"
            android:layout_marginTop="40dp"/>*/