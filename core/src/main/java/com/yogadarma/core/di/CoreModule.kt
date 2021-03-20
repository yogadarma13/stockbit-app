package com.yogadarma.core.di

import androidx.room.Room
import com.yogadarma.core.data.AppRepository
import com.yogadarma.core.data.source.local.LocalDataSource
import com.yogadarma.core.data.source.local.room.AppDatabase
import com.yogadarma.core.data.source.remote.RemoteDataSource
import com.yogadarma.core.data.source.remote.network.ApiService
import com.yogadarma.core.domain.repository.IRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    single { get<AppDatabase>().appDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java, "Stockbit.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    single {
        val retrofit = Retrofit.Builder().baseUrl("https://min-api.cryptocompare.com/data/top/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()

        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get(), get()) }
    single<IRepository> { AppRepository(get(), get()) }
}