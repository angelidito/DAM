package com.ammd.blackfriday

import android.Manifest
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import com.ammd.blackfriday.databinding.ActivityProductBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class ProductActivity : AppCompatActivity() {
    private lateinit var productos: List<Producto>
    private lateinit var binding: ActivityProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var idProds = 0
        productos = listOf(
            Producto(
                ++idProds,
                "Tomate",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Bright_red_tomato_and_cross_section02.jpg/251px-Bright_red_tomato_and_cross_section02.jpg",
                Uri.parse("https://es.wikipedia.org/wiki/Tomate")
            ),
            Producto(
                ++idProds,
                "Lechuga",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Romaine_lettuce.jpg/250px-Romaine_lettuce.jpg",
                Uri.parse("https://es.wikipedia.org/wiki/Lechuga")
            ),
            Producto(
                ++idProds,
                "Cebolla",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Two_colors_of_onions.jpg/250px-Two_colors_of_onions.jpg",
                Uri.parse("https://es.wikipedia.org/wiki/Cebolla")
            ),
            Producto(
                ++idProds,
                "Gato",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Collage_of_Six_Cats-02.jpg/250px-Collage_of_Six_Cats-02.jpg",
                Uri.parse("https://es.wikipedia.org/wiki/Gato")
            ),
            Producto(
                ++idProds,
                "Alcachofa",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c6/P1000578_Galactites_tomentosa_%28Compositae%29_Flowers.JPG/250px-P1000578_Galactites_tomentosa_%28Compositae%29_Flowers.JPG",
                Uri.parse("https://es.wikipedia.org/wiki/Alcachofa")
            )
        )

        binding.btnBuscar.setOnClickListener { eventoBoton() }
    }

    private fun eventoBoton() {
        val idProd = binding.idProd.editText?.text.toString()

        var found = false
        var i = -1
        while (!found && ++i < productos.size)
            if (idProd.compareTo(productos[i].codigo.toString()) == 0)
                found = true
        if (!found) {
            binding.idProd.error = "Producto no encontrado"
        } else {
            binding.idProd.error = null



            cargarImagen(productos[i].imagen)

            binding.cardTitle.text = ("#" + productos[i].codigo + " - " + productos[i].denominacion)

            binding.cardDescription.text = productos[i].url.toString()

        }
    }

    fun cargarImagen(
        url: String
    ) {
        Glide.with(binding.root)
            .load(url)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.cardImg)
    }
}