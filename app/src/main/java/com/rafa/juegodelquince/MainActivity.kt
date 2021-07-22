package com.rafa.juegodelquince

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var pantallaReglas : ScrollView? = null
//    private var btnAceptar : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pantallaReglas = findViewById(R.id.reglas)
//        btnAceptar = findViewById(R.id.btnReglas)
    }

    fun jugar(view : View){

        val intent = Intent(this, Juego::class.java)
        startActivity(intent)
    }

    fun reglas(view: View){

        pantallaReglas?.visibility = View.VISIBLE
    }

    fun ocultarReglas(view: View){

        pantallaReglas?.visibility = View.GONE
    }
}