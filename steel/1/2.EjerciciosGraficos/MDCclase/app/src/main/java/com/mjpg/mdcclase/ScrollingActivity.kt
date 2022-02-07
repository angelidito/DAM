package com.mjpg.mdcclase

import android.graphics.Color
import android.os.Bundle
import android.telephony.SignalThresholdInfo


import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.URLUtil
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.mjpg.mdcclase.databinding.ActivityScrollingBinding

class ScrollingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        /* var bar1:FloatingActionButton */
        super.onCreate(savedInstanceState)
        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*
        setContentView(R.layout.activity_scrolling)
        bar1 = findViewById(R.id.fab)
        bar1.setOnClickListener{
            if(findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER)
                findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_END
            else
                findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
        }
        */

        binding.fab.setOnClickListener {
            if (binding.bottomAppBar.fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER)
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            else
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
        }

        binding.bottomAppBar.setNavigationOnClickListener {
            Snackbar.make(binding.root, getString(R.string.mensaje), Snackbar.LENGTH_LONG)
                .setAnchorView(binding.fab).show()
        }
        // Sirve para escribir un mensaje por pantalla
        // El setAnchorView coloca el mensaje en la parte superior del menú inferior

        binding.content.btnSkip?.setOnClickListener {
            binding.content.cvAd?.visibility = View.GONE
        }

        binding.content.btnBuy?.setOnClickListener {
            Snackbar.make(it, getString(R.string.comprando), Snackbar.LENGTH_SHORT)
                .setAction(R.string.ir) {
                    Toast.makeText(this, "Probando", Toast.LENGTH_LONG).show()
                }
                .setAnchorView(binding.fab)
                .show()
        }
        // Al darle a "Comprar", abajo sale un mensaje de "Comprando" con un botón de "ir"
        // Si le damos al ir sale otro mensaje de "probando"

        cargarImagen()

        binding.content.cbEnablePass.setOnClickListener(){
            binding.content.tilPassword!!.isEnabled =! binding.content.tilPassword!!.isEnabled
        }

        binding.content.etUrl.onFocusChangeListener = View.OnFocusChangeListener{_, focus ->
            val url = binding.content.etUrl.text.toString()
            var error: String?=null
            if (!focus) {
                if (!url.isEmpty()) {
                    if (URLUtil.isValidUrl(url)) {
                        cargarImagen(url)
                    } else {
                        error = getString(R.string.urlincorrecta)
                    }
                } else {
                    error = getString(R.string.requerido)
                }
            }
            binding.content.tilUrl.error = error
        }

        binding.content.toggleButton.addOnButtonCheckedListener {group, checkedId, isChecked ->
            binding.content.root.setBackgroundColor(
                when (checkedId){
                    R.id.btnBlue -> Color.BLUE
                    R.id.btnRed -> Color.RED
                    else -> Color.GREEN
                }
            )
        }
    }

    fun cargarImagen (url: String="https://www.clipartmax.com/png/full/238-2381243_safeness-kotlin-android-logo.png"){
        Glide.with(this)
            .load(url)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.content.imgCover)
    }
}
