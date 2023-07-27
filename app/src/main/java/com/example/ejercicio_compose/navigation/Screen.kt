package com.example.ejercicio_compose.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen (
    val route: String,
    val arguments: List<NamedNavArgument>
){
    object LoginScreen: Screen(
        route = "login",
        arguments = emptyList()
    )

    object ForgotPasswordScreen: Screen(
        route = "forgotPassword",
        arguments = emptyList()
    )

    object HeroListScreen: Screen(
        route = "heroList",
        arguments = emptyList()
    )

    object HeroDetailScreen: Screen(
        route = "heroDetail",
        arguments = listOf(
            navArgument(name = "heroId"){
                type = NavType.StringType
                nullable = false
            }
        )
    )
}

val test = Screen.LoginScreen