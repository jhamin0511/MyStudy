package com.github.jhamin0511.mystudy.di.network.service

import com.github.jhamin0511.mystudy.network.service.GithubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

private const val GITHUB_URL = "https://api.github.com/"

@InstallIn(SingletonComponent::class)
@Module
class ServiceModule {

    @Singleton
    @Provides
    fun provideGithubService(default: Retrofit): GithubService {
        val retrofit = default.newBuilder().apply {
            baseUrl(GITHUB_URL)
        }.build()

        return retrofit.create(GithubService::class.java)
    }
}
