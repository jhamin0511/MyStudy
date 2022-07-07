package com.github.jhamin0511.mystudy.di.network.service

import com.github.jhamin0511.mystudy.di.network.GITHUB_RETROFIT
import com.github.jhamin0511.mystudy.network.service.GithubService
import com.github.jhamin0511.mystudy.network.service.UserService
import com.github.jhamin0511.mystudy.network.service.UserServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class ServiceModule {
    @Singleton
    @Provides
    fun provideGithubService(
        @Named(GITHUB_RETROFIT)
        retrofit: Retrofit
    ): GithubService {
        return retrofit.create(GithubService::class.java)
    }

    @Singleton
    @Provides
    fun provideUserService(): UserService {
        return UserServiceImpl()
    }
}
