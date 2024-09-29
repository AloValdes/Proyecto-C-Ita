package com.example.c_ita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.c_ita.screens.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMultiScreenApp()
        }
    }


            @Composable
            fun ComposeMultiScreenApp() {
                val navController = rememberNavController()
                Surface(color = Color.White) {
                    setupNavGraph(navController = navController)
                }
            }

            @Composable
            fun setupNavGraph(navController: NavHostController) {
                NavHost(navController = navController, startDestination = "Login") {
                    composable("Login") {
                        LoginScreen(navController)
                    }

                }
            }
        }
