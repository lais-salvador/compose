package com.example.ejercicio_compose.di

import com.example.ejercicio_compose.domain.usecase.GetHeroDetailByIdUseCase
import com.example.ejercicio_compose.domain.usecase.GetHeroListUseCase
import com.example.ejercicio_compose.domain.usecase.GetLastHeroLocationByIdUseCase
import com.keepcoding.androidavanzado.domain.usecase.GetDistanceFromHeroUseCase
import org.koin.dsl.module


val domainModule = module {
    single { GetHeroListUseCase(get()) }
    single { GetHeroDetailByIdUseCase(get()) }
    single { GetLastHeroLocationByIdUseCase(get()) }
    single { GetDistanceFromHeroUseCase() }
}
