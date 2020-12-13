package com.example.tablascool

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_practica.*
import kotlin.random.Random

class PracticaActivity : AppCompatActivity() {
    var resultado = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practica)

        generaOperacion()

        btnVerifica.setOnClickListener {
            val resText = editTextNumber.text.toString()
            if (!resText.equals("")){
                val respuesta = resText.toInt()
                if (respuesta == resultado){
                    Log.d("resultado", "Le atinaste")
                    crearDialogoOk()
                }else{
                    Log.d("resultado", "No le atinaste")
                    crearDialogoMal()
                }
            }

            generaOperacion()
        }

    }

    fun crearDialogoOk(){
        val miDialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_ok,null)
        val mBuilder = AlertDialog.Builder(this).setView(miDialogView)
            .setTitle("Muy bien!!")
        val miDialogOk = mBuilder.create()
        miDialogOk.show()
        //Con esto de abajo hago que se agrege sonido para cuando es correcto y cuando no
        //val miPlayer:MediaPlayer? = MediaPlayer.create(this, R.raw.aplausos)
        //miPlayer?.start()
    }
    fun crearDialogoMal(){
        val miDialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_error,null)
        val mBuilder = AlertDialog.Builder(this).setView(miDialogView)
            .setTitle("Muy mal!!")
        val miDialogError = mBuilder.create()
        miDialogError.show()

    }

    fun generaOperacion(){
        val operando1 = Random.nextInt(1, 10)
        val operando2 = Random.nextInt(1, 10)

        resultado = operando1*operando2
        tvPregunta.text = "$operando1 x $operando2 = ?"
        editTextNumber.text.clear()
    }
}