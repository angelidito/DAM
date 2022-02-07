package com.sde.ej1delgadosergio

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.sde.ej1delgadosergio.databinding.ActivityConsultaProductosBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ConsultaProductos : AppCompatActivity() {
    private lateinit var binding: ActivityConsultaProductosBinding
    private lateinit var linearlayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        // Crear los productos
        val prod1 = Producto("001", "Balón de fútbol UCL 2021", "https://media.futbolmania.com/media/catalog/product/cache/1/image/0f330055bc18e2dda592b4a7c3a0ea22/G/U/GU0207_mini-balon-color-blanco-y-naranja-adidas-finale-21-ucl-talla-mini_1_completa-frontal.jpg", "https://www.adidas.es/balon-ucl-league-pyrostorm/GT7788.html")
        val prod2 = Producto("002", "Botas Nike Mercurial", "https://botasdefutbolsala.net/wp-content/uploads/2016/12/botas-de-futbol-blancas-con-detalles-dorados-624x624.jpg", "https://www.nike.com/es/u/custom-nike-mercurial-superfly-8-elite-by-you-10001026/8787067524")
        val prod3 = Producto("003", "Segunda equipación Real Madrid 21/22", "https://tiendagolperu.com/wp-content/uploads/2021/08/segunda-camiseta-adidas-real-madrid-2021-22-5.jpg", "https://www.adidas.es/camiseta-segunda-equipacion-real-madrid-21-22/H40942.html")
        val prod4 = Producto("004", "Guantes portero Xtreme Guard Pro", "https://www.goalinn.com/f/13750/137507418/rinat-guantes-portero-xtreme-guard-pro.jpg", "https://www.goalinn.com/futbol/rinat-guantes-portero-xtreme-guard-pro/137507418/p")
        val prod5 = Producto("005", "Pantalón corto Nike SportWear", "https://www.dressinn.com/f/13697/136971736/nike-pantalones-cortos-sportswear-flow.jpg", "https://www.dressinn.com/moda/nike-pantalones-cortos-sportswear-flow/136971736/p")
        val productos: List<Producto> = listOf(prod1, prod2, prod3, prod4, prod5)

        super.onCreate(savedInstanceState)

        binding = ActivityConsultaProductosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Al pulsar el botón de Aceptar...
        binding.btnAceptar.setOnClickListener {
            // Variable con el código introducido por teclado
            var codProd = binding.txtProducto.text.toString()

            // Si el campo del código está vacío
            if (codProd.isEmpty()){
                Toast.makeText(this,"Introduzca el código del producto", Toast.LENGTH_SHORT).show()
            }
            else {
                // Boolean para el posible mensaje de error
                var encontrado = false
                // Recorre toda la lista de productos
                for (i in 0 until productos.size){
                    // Si el código introducido está en la lista de productos
                    if (productos[i].codigo == codProd){
                        // Mostrar nombre del producto
                        binding.lblNombreProd.text = productos[i].nombre

                        // Mostrar botón de la URL
                        binding.btnURL.text = ""
                        binding.btnURL.isVisible = true

                        // Al pulsar el botón de la URL...
                        binding.btnURL.setOnClickListener{
                            // Mensaje
                            MaterialAlertDialogBuilder(this, 1).setMessage("Este link le llevará a: " + productos[i].url + "\n\n¿Desea continuar?")
                                // Si le das a cancelar...
                                .setNegativeButton("Cancelar") { dialog, which ->
                                }
                                // Si le das a aceptar...
                                .setPositiveButton("Aceptar") { dialog, which ->
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(productos[i].url))
                                    if (intent.resolveActivity(packageManager) != null) {
                                        startActivity(intent)}
                                }
                                .show()
                        }

                        // Mostrar imagen del producto
                        Glide.with(binding.root).load(productos.get(i).imagen).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(binding.imgProd)

                        encontrado = true
                    }
                }
                // Si no entra al if (No encuentra el producto)
                if (encontrado == false){
                    Toast.makeText(this,"Código de producto incorrecto", Toast.LENGTH_SHORT).show()
                    binding.lblNombreProd.setText("")
                    binding.imgProd.setImageResource(android.R.color.transparent)
                    binding.btnURL.isVisible = false
                }
            }
        }
    }
}