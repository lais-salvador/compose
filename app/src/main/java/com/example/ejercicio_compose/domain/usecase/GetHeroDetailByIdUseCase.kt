package com.example.ejercicio_compose.domain.usecase

import com.example.ejercicio_compose.data.HeroRepository

class GetHeroDetailByIdUseCase(private val heroRepository: HeroRepository) {
    suspend fun invoke(id: String) = heroRepository.getHeroDetailById(id)
}