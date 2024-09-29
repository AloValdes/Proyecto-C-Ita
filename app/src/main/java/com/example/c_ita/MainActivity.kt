package com.example.c_ita

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.c_ita.screens.LoginActivity
import com.example.c_ita.ui.theme.CitaTheme

class MainActivity : AppCompatActivity() {

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