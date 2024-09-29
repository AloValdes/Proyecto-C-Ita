package com.example.c_ita.screens

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.unit.dp
import androidx.core.view.setPadding
import com.example.c_ita.MainActivity
import com.example.c_ita.R

class LoginActivity : AppCompatActivity() {

    // Función de extensión para convertir dp a px
    private fun Int.toPx(): Int = (this * resources.displayMetrics.density).toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Crear el contenedor principal (LinearLayout)
        val mainLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor("#2A1A5E")) // Fondo azul oscuro
            gravity = Gravity.CENTER
            setPadding(32.toPx(),
                32.toPx(),
                32.toPx(),
                32.toPx()) // Padding alrededor del layout
        }

        // Campo de entrada para el correo (EditText)
        val emailEditText = EditText(this).apply {
            hint = "Correo electrónico"
            inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            setPadding(24.toPx())
            setBackgroundResource(android.R.drawable.edit_text) // Ajustar fondo para evitar problemas de recursos
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0,
                    0,
                    0,
                    20.toPx())
            }
        }

        // Campo de entrada para la contraseña (EditText)
        val passwordEditText = EditText(this).apply {
            hint = "Contraseña"
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            setPadding(24.toPx())
            setBackgroundResource(android.R.drawable.edit_text)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0,
                    0,
                    0,
                    20.toPx())
            }
        }

        // Botón de inicio de sesión (Button)
        val loginButton = Button(this).apply {
            text = "Iniciar sesión"
            setBackgroundColor(Color.parseColor("#3E92CC"))
            setTextColor(Color.WHITE)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER
                setMargins(0,
                    20.toPx(),
                    0,
                    0)
            }
        }

        // Agregar vistas al layout principal
        mainLayout.addView(emailEditText)
        mainLayout.addView(passwordEditText)
        mainLayout.addView(loginButton)

        // Establecer el layout principal como la vista de la actividad
        setContentView(mainLayout)

        // Acción del botón de inicio de sesión
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            // Si el campo de correo y contraseña no están vacíos, se pasa a MainActivity
            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Navegar a MainActivity
                val intent = Intent(this,
                    MainActivity::class.java)
                startActivity(intent)

                // Opcional: Finalizar LoginActivity para que no se pueda volver atrás
                finish()
            } else {
                Toast.makeText(this,
                    "Por favor, ingresar los datos completos",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}
