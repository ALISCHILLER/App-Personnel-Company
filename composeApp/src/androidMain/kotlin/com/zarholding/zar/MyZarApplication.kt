package com.zarholding.zar

import android.app.Application
import di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyZarApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyZarApplication)
            modules(
                diUtilsModule,
                diViewModelsModule,
                diRepositoriesModule,
                diUseCasesModule,
                diServicesModule,
                diDatabaseModule
            )
        }
    }
}