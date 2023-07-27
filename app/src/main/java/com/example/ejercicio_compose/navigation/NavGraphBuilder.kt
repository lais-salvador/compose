package com.example.ejercicio_compose.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.ejercicio_compose.presentation.forgotPassword.ForgotPasswordScreen
import com.example.ejercicio_compose.presentation.list.HeroListScreen
import com.example.ejercicio_compose.presentation.login.LoginScreen

fun NavGraphBuilder.addLoginScreen(navController: NavController){
    composable(Screen.LoginScreen.route){
        LoginScreen(
            onLoginSuccess = { navController.navigate(Screen.HeroListScreen.route) },
            onForgotPassword = { navController.navigate(Screen.ForgotPasswordScreen.route) }
        )
    }
}
fun NavGraphBuilder.addForgotPasswordScreen(navController: NavController){
    composable(Screen.ForgotPasswordScreen.route){
        ForgotPasswordScreen()
    }
}

fun NavGraphBuilder.addHeroListScreen(navController: NavController){
    composable(Screen.HeroListScreen.route){
        HeroListScreen()
    }
}