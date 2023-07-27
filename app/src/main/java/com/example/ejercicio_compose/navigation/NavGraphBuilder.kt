package com.example.ejercicio_compose.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.ejercicio_compose.presentation.login.LoginScreen

fun NavGraphBuilder.addLoginScreen(navController: NavController){
    composable(Screen.LoginScreen.route){
        LoginScreen {
            //TODO Navigate MainScreen
        }
    }
}