package com.example.ejercicio_compose.di

import android.content.Context
import androidx.room.Room
import com.example.ejercicio_compose.data.HeroRepository
import com.example.ejercicio_compose.data.HeroRepositoryImpl
import com.example.ejercicio_compose.data.local.HeroDao
import com.example.ejercicio_compose.data.local.HeroDatabase
import com.example.ejercicio_compose.data.local.LocalDataSource
import com.example.ejercicio_compose.data.local.LocalDataSourceImpl
import com.example.ejercicio_compose.data.remote.RemoteDataSource
import com.example.ejercicio_compose.data.remote.RemoteDataSourceImpl
import com.example.ejercicio_compose.data.remote.SuperHeroApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val dataModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://dragonball.keepcoding.education/")
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single<Moshi> {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single<HeroRepository> { HeroRepositoryImpl(get(),get()) }

    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }

    single<LocalDataSource> { LocalDataSourceImpl(get()) }

    single<SuperHeroApi> {
        getSuperHeroApi(get())
    }

    single {
        getDataBase(get())
    }

    single {
        providesHeroDao(get())
    }
}

private fun getSuperHeroApi(retrofit: Retrofit) =
    retrofit.create(SuperHeroApi::class.java)

private fun getDataBase(context: Context): HeroDatabase =
    Room.databaseBuilder(
        context,
        HeroDatabase::class.java, "Superhero-db"
    ).build()

private fun providesHeroDao(db: HeroDatabase): HeroDao = db.heroDao()
