package com.example.ejercicio_compose.navigation

import androidx.navigation.NamedNavArgument

sealed class Screen (
    val route: String,
    val arguments: List<NamedNavArgument>
){
    object LoginScreen: Screen(
        route = "login",
        arguments = emptyList()
    )

    /*class OtherClass: Screen (
        "", emptyList()
    )*/
}

val test = Screen.LoginScreen