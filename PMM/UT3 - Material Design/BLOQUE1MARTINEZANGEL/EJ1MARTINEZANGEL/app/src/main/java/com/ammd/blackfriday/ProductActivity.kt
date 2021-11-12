package com.ammd.blackfriday

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ammd.blackfriday.databinding.ActivityProductBinding

class ProductActivity : AppCompatActivity() {
    private lateinit var producto: List<Producto>
    private lateinit var binding: ActivityProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        var idProds = 0
        producto = listOf(
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

    }
}