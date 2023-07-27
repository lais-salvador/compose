package com.example.ejercicio_compose.presentation.detail

import androidx.compose.runtime.Composable
import com.example.ejercicio_compose.domain.model.TestDataBuilder
import com.example.ejercicio_compose.presentation.list.ShowHero

@Composable
fun HeroDetailScreen(heroId: String) {
    ShowHero(
        hero = TestDataBuilder().withName(heroId + " Name")
            .withDescription("LalaLalaLalaLalaLalaLalaLalaLalaLalaLalaLalaLalaLalaLalaLalaLalaLalaLalaLalaLalaLalaLalaLalaLalaLala")
            .buildSingle()
    )
}