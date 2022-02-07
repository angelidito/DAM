package com.sde.bd1delgadosergio

import android.content.Intent
import android.graphics.Typeface
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.sde.bd1delgadosergio.databinding.ActivityBuscarBinding

class BuscarActivity : AppCompatActivity(), EventosListener {
    private lateinit var binding: ActivityBuscarBinding
    private lateinit var adaptador:AlojamientoAdapter
    private lateinit var gridLayout:GridLayoutManager
    private lateinit var bd:AlojamientoDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBuscarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = AlojamientoDAO(this)
        adaptador = AlojamientoAdapter(mutableListOf(),this)
        grabarAlojamientos()

        binding.btnBuscar.setOnClickListener{
            // Si hay una ciudad introducida
            if (binding.txtLocalidad.text?.isNotEmpty() == true) {
                configurarRecyclerCiudad()
            }
            // Si el buscador está vacío muestra toda la oferta disponible
            else {
                configurarRecyclerTodos()
            }
        }
    }

    private fun configurarRecyclerTodos() {
        adaptador = AlojamientoAdapter(mutableListOf(),this)
        gridLayout = GridLayoutManager(this,1)
        consultaTodosAlojamientos()
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager=gridLayout
            adapter=adaptador
        }
    }

    private fun configurarRecyclerCiudad() {
        adaptador = AlojamientoAdapter(mutableListOf(),this)
        gridLayout = GridLayoutManager(this,1)
        consultaAlojamientosCiudad()
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager=gridLayout
            adapter=adaptador
        }
    }

    private fun consultaTodosAlojamientos() {
        val myAsyncTask = MyAsyncTask().execute()
    }

    private fun consultaAlojamientosCiudad() {
        val myAsyncTask = MyAsyncTask2().execute()
    }

    private inner class MyAsyncTask2() : AsyncTask<Void, Void, MutableList<Alojamiento>>() {
        override fun doInBackground(vararg params: Void?): MutableList<Alojamiento> {
            val alojamientos = bd.consultaAlojamientosCiudad(binding.txtLocalidad.text.toString())
            return alojamientos
        }

        override fun onPostExecute(result: MutableList<Alojamiento>) {
            super.onPostExecute(result)
            adaptador.setAlojamientos(result)
            if (adaptador.itemCount == 0){
                mensaje()
            }

        }
    }

    private fun mensaje(){
        Snackbar.make(binding.root, "No hay alojamientos en esta ciudad :(", Snackbar.LENGTH_LONG).show()
    }

    private inner class MyAsyncTask(): AsyncTask<Void, Void, MutableList<Alojamiento>>(){
        override fun doInBackground(vararg params: Void?): MutableList<Alojamiento> {
            val alojamientos = bd.consultaTodosAlojamientos()
            return alojamientos
        }

        override fun onPostExecute(result: MutableList<Alojamiento>) {
            super.onPostExecute(result)
            adaptador.setAlojamientos(result)
        }
    }

    private fun grabarAlojamientos() {
        val alojamiento1 = Alojamiento(1, "Hua Hin Marriot Resort", "Cancún", 325, "https://latinexclusive.com/sites/default/files/styles/main_property_slide/public/api_file_downloads/603962b90a351c45f427c88f_1.jpg?itok=eKEOU8RQ", 947613878, "huahinresort@gmail.com", "En medio del Caribe, Hua Hin Marriot Resort es un espacio ideal para poder descansar, relajarse, desconectar de la rutina y disfrutar de una experiencia única", "En las inmediaciones del hotel podrá disfrutar de la maravillosa playa del Caribe, y practicar todo tipo de actividades acuáticas",0)
        val alojamiento2 = Alojamiento(2, "JW Marriot Miami", "Miami", 450, "https://www.centarahotelsresorts.com/centaragrand/sites/g/files/yplzxh121/files/styles/1440x700/public/2020-06/Centara%20Grand%20at%20Central%20Plaza%20Ladprao%20Bangkok.jpg?itok=g7PZpLbS", 947479900, "jwmarriormiami@gmail.com", "El JW Marriott Miami está ubicado en el corazón de Brickell, el destino de moda de Miami, lleno de restaurantes, tiendas y locales de vida nocturna, y se encuentra a pocos pasos del centro comercial más nuevo de la ciudad: el Brickell City Centre. Este elegante hotel ejecutivo cuenta con 296 habitaciones, lo último en tecnología y más de 2.323 m²", "Este hotel está a pocos pasos de todo lo que puede ofrecer Miami, como el museo de arte Perez, el museo de la ciencia Frost, el centro Adrienne Arsht, el puerto de Miami, South Beach, Coral Gables, Coconut Grove, el aeropuerto internacional de Miami...", 0)
        val alojamiento3 = Alojamiento(3, "Hotel Mandarin Oriental", "Barcelona", 550, "https://etcbahia.com/wp-content/uploads/2013/11/casa-grande-piscina-940x460.jpg", 947851021, "hotelmandarin@gmail.com", "Situado en el Paseo de Gracia, el Mandarin Oriental, Barcelona es uno de los hoteles más valorados de la ciudad. Con impresionantes vistas de nuestros jardines o de la emblemática y modernista Casa Batlló, ofrecemos una maravillosa mezcla de estilo y lujo de cinco estrellas", "A pocos minutos del hotel podemos visitar la emblemática y modernista Casa Batlló, y disfrutar la paz y tranquilidad en los jardines aledaños", 0)
        val alojamiento4 = Alojamiento(4, "Albion Hotel", "Miami", 300, "https://www.centarahotelsresorts.com/sites/g/files/yplzxh136/files/styles/1440x700/public/2021-01/cch-exterior_0.jpg?itok=XO3qqPJN", 917438300, "albionhotel@gmail.com", "Este hotel en la primera línea de Miami Beach dispone de todos los lujos que se pueda imaginar, desde una sala de hidromasaje relajante hasta un gimnasio totalmente equipado", "La actividad que más buscan nuestros clientes es disfrutar de un completo día relajante en la famosa playa de Miami Beach", 0)

        Thread{ //realiza la tarea en el hilo secundario
            bd.addAlojamiento(alojamiento1)
            bd.addAlojamiento(alojamiento2)
            bd.addAlojamiento(alojamiento3)
            bd.addAlojamiento(alojamiento4)
            runOnUiThread { adaptador.add(alojamiento1) } //realiza la tarea en el hilo principal
            runOnUiThread { adaptador.add(alojamiento2) }
            runOnUiThread { adaptador.add(alojamiento3) }
            runOnUiThread { adaptador.add(alojamiento4) }
        }.start()
    }

    companion object{
        const val ALOJAMIENTO = "alojamiento"
    }

    // Al pulsar sobre cada tarjeta, pasa lo siguiente...
    override fun onLongClickListener(alojamiento: Alojamiento) {
        intent= Intent(this,InfoCadaAlojamiento::class.java)
        intent.putExtra(ALOJAMIENTO, alojamiento)
        startActivity(intent)
    }

    override fun onFavorito(alojamiento: Alojamiento) {
        if (alojamiento.favorito == 0){
            alojamiento.favorito = 1
        }
        else{
            alojamiento.favorito = 0
        }
        bd.updateAlojamiento(alojamiento)
        adaptador.update(alojamiento)
    }
}