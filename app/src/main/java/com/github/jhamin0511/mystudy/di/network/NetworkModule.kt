package com.github.jhamin0511.mystudy.di.network

import com.github.jhamin0511.mystudy.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TIMEOUT = 5000L
const val NETWORK_DELAY_TIME = 1500L
const val LOCAL_RETROFIT = "https://localhost.com/"
const val GITHUB_RETROFIT = "https://api.github.com/"

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    companion object {
        fun createRetrofitBuilder(): Retrofit.Builder {
            return Retrofit.Builder().apply {
                addConverterFactory(GsonConverterFactory.create())
            }
        }
    }

    @Singleton
    @Provides
    fun provideLocalRetrofitBuilder(
        client: OkHttpClient
    ): Retrofit.Builder {
        return createRetrofitBuilder().apply {
            baseUrl(LOCAL_RETROFIT)
            client(client)
        }
    }

    @Named(GITHUB_RETROFIT)
    @Singleton
    @Provides
    fun provideGithubRetrofit(
        builder: Retrofit.Builder
    ): Retrofit {
        return builder.apply {
            baseUrl(GITHUB_RETROFIT)
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
            connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
            readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
            writeTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
            addInterceptor(loggingInterceptor)
        }.build()
    }
}
