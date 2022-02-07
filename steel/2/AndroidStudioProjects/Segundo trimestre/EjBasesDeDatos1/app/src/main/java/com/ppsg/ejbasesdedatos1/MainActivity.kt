    package com.ppsg.ejbasesdedatos1

    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import androidx.recyclerview.widget.GridLayoutManager
    import com.ppsg.ejbasesdedatos1.databinding.ActivityMainBinding

    class MainActivity : AppCompatActivity(), EventosListener {
        private lateinit var binding: ActivityMainBinding
        private lateinit var adaptador:AdaptadorTienda
        private lateinit var gridLayout: GridLayoutManager
        private lateinit var db:TiendaDAO

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            val bd=TiendaDAO(this)
            configurarRecycler()
            binding.btnSave.setOnClickListener {
                grabar()
            }
        }

        private fun grabar() {
            val tienda=Tienda(1,
                binding.etName.text.toString().trim(), 1)
            db.addTienda(tienda)
        }

        private fun configurarRecycler() {
            adaptador= AdaptadorTienda(mutableListOf(),this)
            gridLayout= GridLayoutManager(this,2)
            consultaTiendas()
            binding.recyclerView.apply {
                setHasFixedSize(true)
                layoutManager=gridLayout
                adapter=adaptador
            }
        }

        private fun consultaTiendas() {

        }

        override fun editar(id: Int) {

        }
    }