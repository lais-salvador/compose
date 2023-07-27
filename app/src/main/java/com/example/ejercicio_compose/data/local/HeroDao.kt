package com.example.ejercicio_compose.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ejercicio_compose.data.local.model.HeroLocal

@Dao
interface HeroDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(heroList: List<HeroLocal>)

    @Query("SELECT * FROM HeroTable")
    suspend fun getAll(): List<HeroLocal>

    @Query("SELECT * FROM HeroTable")
    suspend fun getFavorites(): List<HeroLocal>

    @Delete
    suspend fun delete(model:HeroLocal)
    @Query("SELECT * FROM HeroTable WHERE id = :id")
    suspend fun getHeroById(id: String): HeroLocal
}