package com.example.ejercicio_compose.domain.usecase

import com.example.ejercicio_compose.data.HeroRepository
import com.example.ejercicio_compose.domain.model.LocationModel

class GetLastHeroLocationByIdUseCase(
    private val heroRepository: HeroRepository
) {
    suspend fun invoke(id: String): LocationModel {
        val result = heroRepository.getHeroLocationList(id)
        return if(result.isNotEmpty())
            result.last()
        else
            LocationModel(0.0, 0.0)
    }
}