package com.example.ejercicio_compose.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.ejercicio_compose.presentation.detail.HeroDetailScreen
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
fun NavGraphBuilder.addForgotPasswordScreen(){
    composable(Screen.ForgotPasswordScreen.route){
        ForgotPasswordScreen()
    }
}

fun NavGraphBuilder.addHeroListScreen(navController: NavController){
    composable(Screen.HeroListScreen.route){
        HeroListScreen{ heroId ->
            navController.navigate("${Screen.HeroDetailScreen.route}/$heroId")
        }
    }
}

fun NavGraphBuilder.addHeroDetailScreen() {
    composable(
        route = Screen.HeroDetailScreen.route +"/{heroId}",
        arguments = Screen.HeroDetailScreen.arguments
    ){ navBackStackEntry ->
        val id = navBackStackEntry.arguments?.getString("heroId") ?: ""
        HeroDetailScreen(id)
    }
}