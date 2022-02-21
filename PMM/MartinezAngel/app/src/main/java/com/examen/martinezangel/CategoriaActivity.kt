package com.ammd.martinezangel

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.examen.martinezangel.Categoria
import com.examen.martinezangel.EmpresaDAO
import com.examen.martinezangel.databinding.ActivityListaCategoriasBinding

class CategoriaActivity(var codigoCategoria: Int, var denominacion: String?) : AppCompatActivity(),
    EventosListener {

    private lateinit var binding: ActivityListaCategoriasBinding
    private lateinit var database: EmpresaDAO
    private lateinit var adaptador: CategoriaAdapter
    private lateinit var gridLayout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaCategoriasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = EmpresaDAO(this)

        configurarRecycler()
    }

    private fun configurarRecycler() {
        adaptador = CategoriaAdapter(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 2)

        Thread {
            val categorias = database.getCategorias()

            adaptador.setCategorias(categorias)
        }.start()

        binding.RecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    override fun onClickListenerCall(code: Int) {
        TODO("Not yet implemented")
    }

    private inner class getAllCategoriasAsyncTask() : AsyncTask<Void, Void, MutableList<Categoria>>() {
        override fun doInBackground(vararg p0: Void?): MutableList<Categoria> {
            return  database.getCategorias()
        }

        override fun onPostExecute(result: MutableList<Categoria>?) {
            super.onPostExecute(result)
            if (result != null) {
                adaptador.setCategorias(result)
            }
        }
    }
}
