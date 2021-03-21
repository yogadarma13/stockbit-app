package com.yogadarma.core.di

import androidx.room.Room
import com.yogadarma.core.data.AppRepository
import com.yogadarma.core.data.source.local.LocalDataSource
import com.yogadarma.core.data.source.local.room.AppDatabase
import com.yogadarma.core.data.source.remote.RemoteDataSource
import com.yogadarma.core.data.source.remote.network.ApiService
import com.yogadarma.core.domain.repository.IRepository
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
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
        val passphrase: ByteArray = SQLiteDatabase.getBytes("stockbit".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java, "Stockbit.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        val hostname = "min-api.cryptocompare.com"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/Xd+EsIDqyqDn1x3n0JYVVar+W73w1U0GxC8uZa6/QTk=")
            .add(hostname, "sha256/8Rw90Ej3Ttt8RRkrg+WYDS9n7IS03bk5bjP/UXPtaY8=")
            .add(hostname, "sha256/Ko8tivDrEjiY90yGasP6ZpBU4jwXvHqVvQI0GS3GNdA=")
            .build()

        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val builder = originalRequest.newBuilder()
                    .header(
                        "Authorization",
                        "Apikey 474a94ef13d1c271fa442cc487879627686ed55c0313862289656ab12e2bc3a8"
                    )

                val authenticatedRequest = builder.build()
                chain.proceed(authenticatedRequest)
            }.certificatePinner(certificatePinner)
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