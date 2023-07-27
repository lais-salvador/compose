package com.example.ejercicio_compose.di
import com.example.ejercicio_compose.navigation.Screen
import com.example.ejercicio_compose.presentation.list.HeroListScreen
import com.example.ejercicio_compose.presentation.list.HeroListViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HeroListViewModel(get(), get()) }
    viewModelOf(::HeroListViewModel)


    /*viewModel{ DetailViewModel(get(), get(), get(), get())}
    viewModelOf(::DetailViewModel)*/
}