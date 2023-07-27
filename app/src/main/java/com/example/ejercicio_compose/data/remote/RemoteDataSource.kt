package com.example.ejercicio_compose.data.remote

import com.example.ejercicio_compose.data.remote.dto.HeroDto
import com.example.ejercicio_compose.data.remote.dto.LocationDto

interface RemoteDataSource {
    suspend fun getHeroList(): List<HeroDto>
    suspend fun getHeroLocationList(id: String): List<LocationDto>
}