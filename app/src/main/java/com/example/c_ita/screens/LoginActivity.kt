package com.example.c_ita.screens

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(navController: NavHostController) {
    // Estado para los campos de texto
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Contenedor principal
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2A1A5E)), // Fondo azul oscuro
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Campo de entrada para el correo
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo electrónico") },
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
                        navController.navigate("Menu") // Navegar a la pantalla tipo fb
                    } else {
                        Toast.makeText(
                            context, // Usa el contexto pasado
                            "Por favor, ingresar los datos completos",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .background(Color(0xFF3E92CC))
            ) {
                Text(text = "Iniciar sesión",
                    color = Color.White)
            }
        }
    }
}