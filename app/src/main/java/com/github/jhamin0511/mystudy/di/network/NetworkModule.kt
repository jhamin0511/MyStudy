package com.github.jhamin0511.mystudy.di.network

import com.github.jhamin0511.mystudy.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://localhost.com"
private const val TIMEOUT = 5L

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl(BASE_URL)
            client(client)
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }

    @Singleton
    @Provides
    fun provideClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        }

        return OkHttpClient.Builder().apply {
            connectTimeout(TIMEOUT, TimeUnit.MINUTES)
            readTimeout(TIMEOUT, TimeUnit.MINUTES)
            writeTimeout(TIMEOUT, TimeUnit.MINUTES)
            addInterceptor(loggingInterceptor)
        }.build()
    }
}
