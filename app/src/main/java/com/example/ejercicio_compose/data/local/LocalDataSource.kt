package com.example.ejercicio_compose.data.local

import com.example.ejercicio_compose.data.local.model.HeroLocal

interface LocalDataSource {
    suspend fun insertHeroList(heroList: List<HeroLocal>)
    suspend fun getHeroList(): List<HeroLocal>
    suspend fun getHeroDetailById(id: String): HeroLocal
}