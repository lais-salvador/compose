package com.example.ejercicio_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ejercicio_compose.navigation.NavigationGraph
import com.example.ejercicio_compose.presentation.login.LoginScreen
import com.example.ejercicio_compose.ui.theme.EjerciciocomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjerciciocomposeTheme {
                NavigationGraph()
            }
        }
    }
}

