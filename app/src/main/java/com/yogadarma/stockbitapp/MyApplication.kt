package com.yogadarma.stockbitapp

import android.app.Application
import com.yogadarma.core.di.databaseModule
import com.yogadarma.core.di.networkModule
import com.yogadarma.core.di.repositoryModule
import com.yogadarma.stockbitapp.di.useCaseModule
import com.yogadarma.stockbitapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}