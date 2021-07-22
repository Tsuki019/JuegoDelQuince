package com.rafa.juegodelquince

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Juego : AppCompatActivity() {

    val taken = Taken()
    private var btn0: Button? = null
    private var movimientos: TextView? = null
    private var letreroGanar : TextView? = null
    private var btnReiniciar : Button? = null
    var contMovimientos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
        btn0 = findViewById<Button>(R.id.button15)
        movimientos = findViewById<TextView>(R.id.contador)
        letreroGanar = findViewById(R.id.textGanar)
        btnReiniciar = findViewById(R.id.reinicio)


        taken.llenarMatriz()
        taken.llenarMatriz()
    }

    fun cambiar(view : View){

        val btn : Button = view.findViewById<Button>(view.id)
        val valor : Int = btn.text.toString().toInt()
        var gana = 0
        if (taken.cambiarNumero(valor)) {
            btn0?.text = btn.text
            btn0?.visibility = View.VISIBLE
            btn.visibility = View.INVISIBLE
            btn.text = "0"
            btn0 = btn
            contMovimientos++
            movimientos?.text = contMovimientos.toString()

            gana = taken.verificarTablero()
            if (gana != 0){
                ganar(gana)
                desactivar()
            }
        }


    }

    fun ganar(tablero : Int){

        letreroGanar?.visibility = View.VISIBLE
        btnReiniciar?.visibility = View.VISIBLE

        when(tablero){
            1->{
                letreroGanar?.text = "GANAS POR FORMAR LA FIGURA \"VERTICAL\" "
                println("=======GANA POR VERTICAL=====")}
            2->{
                letreroGanar?.text = "GANAS POR FORMAR LA FIGURA \"PERIFERICO\" "
                println("=======GANA POR PERIFERICO=====")
            }
            3->{
                letreroGanar?.text = "GANAS POR FORMAR LA FIGURA \"ESPIRAL\" "
                println("=======GANA POR ESPIRAL=====")
            }
            4->{
                letreroGanar?.text = "GANAS POR FORMAR LA FIGURA \"IMPOSIBLE\" "
                println("=======GANA POR IMPOSIBLE=====")
            }
        }

    }

    fun desactivar (){
        findViewById<Button>(R.id.button2).setOnClickListener(null)
        findViewById<Button>(R.id.button4).setOnClickListener(null)
        findViewById<Button>(R.id.button5).setOnClickListener(null)
        findViewById<Button>(R.id.button6).setOnClickListener(null)
        findViewById<Button>(R.id.button7).setOnClickListener(null)
        findViewById<Button>(R.id.button8).setOnClickListener(null)
        findViewById<Button>(R.id.button9).setOnClickListener(null)
        findViewById<Button>(R.id.button10).setOnClickListener(null)
        findViewById<Button>(R.id.button11).setOnClickListener(null)
        findViewById<Button>(R.id.button12).setOnClickListener(null)
        findViewById<Button>(R.id.button13).setOnClickListener(null)
        findViewById<Button>(R.id.button14).setOnClickListener(null)
        findViewById<Button>(R.id.button16).setOnClickListener(null)
        findViewById<Button>(R.id.button17).setOnClickListener(null)
        findViewById<Button>(R.id.button15).setOnClickListener(null)
    }

    fun reiniciar(view: View){

        intent = Intent(this, Juego::class.java)
        finish()
        startActivity(intent)
    }
}