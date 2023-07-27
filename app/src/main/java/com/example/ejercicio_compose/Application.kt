package com.example.ejercicio_compose

import android.app.Application
import com.example.ejercicio_compose.di.dataModule
import com.example.ejercicio_compose.di.domainModule
import com.example.ejercicio_compose.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Application: Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin(){
            androidLogger()
            androidContext(this@Application)
            modules(domainModule, presentationModule, dataModule)
        }
    }
}