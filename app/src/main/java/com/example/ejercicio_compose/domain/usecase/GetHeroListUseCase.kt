package com.example.ejercicio_compose.domain.usecase

import com.example.ejercicio_compose.data.HeroRepository
import com.example.ejercicio_compose.domain.model.HeroModel

class GetHeroListUseCase (private val heroRepository: HeroRepository) {
    suspend fun invoke(): List<HeroModel> = heroRepository.getHeroList()
}