package com.example.c_ita

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Crear una vista simple para MainActivity
        val mainLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
        }

        // Crear un TextView que diga "Bienvenido"
        val welcomeTextView = TextView(this).apply {
            text = "Bienvenido a C-Ita"
            textSize = 24f
            gravity = Gravity.CENTER
        }

        // Agregar el TextView al layout principal
        mainLayout.addView(welcomeTextView)

        // Establecer el layout principal como la vista de la actividad
        setContentView(mainLayout)
    }
}