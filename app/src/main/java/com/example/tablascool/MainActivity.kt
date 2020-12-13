package com.example.tablascool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Lo que hacemos aqui es que un boton nos lleve a otro pantalla cuando le piquemos
        btnEstudiar.setOnClickListener {
            val i = Intent(this,EstudiaActivity::class.java)
            startActivity(i)
        }

        btnPracticar.setOnClickListener {
            val i = Intent(this,PracticaActivity::class.java)
            startActivity(i)
        }
    }
}