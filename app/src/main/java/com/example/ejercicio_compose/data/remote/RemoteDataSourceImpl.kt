package com.example.ejercicio_compose.data.remote

import com.example.ejercicio_compose.data.remote.dto.HeroDto
import com.example.ejercicio_compose.data.remote.dto.HeroIdDto
import com.example.ejercicio_compose.data.remote.dto.LocationDto
import com.example.ejercicio_compose.data.remote.dto.SearchDto

class RemoteDataSourceImpl(private val superHeroApi: SuperHeroApi): RemoteDataSource {
    override suspend fun getHeroList(): List<HeroDto> = superHeroApi.getHeroList(SearchDto())
    override suspend fun getHeroLocationList(id: String): List<LocationDto> = superHeroApi.getHeroLocationList(HeroIdDto(id))
}