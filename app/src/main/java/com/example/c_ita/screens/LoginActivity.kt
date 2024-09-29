package com.example.c_ita.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.core.app.ComponentActivity
import androidx.core.view.setPadding
import com.example.c_ita.MainActivity
import java.lang.reflect.Modifier

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}

@Composable
fun LoginScreen() {
    // Estado para los campos de texto
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Contenedor principal
    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF2A1A5E)), Alignment.Center // Fondo azul oscuro
    ) {
        Column(
            modifier = Modifier
                .padding(32.dp)
                .padding(32.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Campo de entrada para el correo
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo electrónico") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            )

            // Campo de entrada para la contraseña
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(), // Muestra asteriscos
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            )

            // Botón de inicio de sesión
            Button(
                onClick = {
                    if (email.isNotEmpty() && password.isNotEmpty()) {
                        // Navegar a MainActivity
                        val intent = Intent(LocalContext.current, MainActivity::class.java)
                        LocalContext.current.startActivity(intent)

                        // Opcional: Finalizar LoginActivity para que no se pueda volver atrás
                        (LocalContext.current as LoginActivity).finish()
                    } else {
                        Toast.makeText(LocalContext.current, "Por favor, ingresar los datos completos", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .background(Color(0xFF3E92CC))
            ) {
                Text(text = "Iniciar sesión", color = Color.White)
            }
        }
    }
}
