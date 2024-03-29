package com.github.jhamin0511.mystudy.di.network.service

import com.github.jhamin0511.mystudy.di.network.GITHUB_RETROFIT
import com.github.jhamin0511.mystudy.network.service.AnimalService
import com.github.jhamin0511.mystudy.network.service.AnimalServiceImpl
import com.github.jhamin0511.mystudy.network.service.FoodService
import com.github.jhamin0511.mystudy.network.service.FoodServiceImpl
import com.github.jhamin0511.mystudy.network.service.GithubService
import com.github.jhamin0511.mystudy.network.service.UserService
import com.github.jhamin0511.mystudy.network.service.UserServiceImpl
import com.github.jhamin0511.mystudy.network.service.WhiskeyService
import com.github.jhamin0511.mystudy.network.service.WhiskeyServiceImpl
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
    fun provideAnimalService(): AnimalService {
        return AnimalServiceImpl()
    }

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

    @Singleton
    @Provides
    fun provideFoodService(): FoodService {
        return FoodServiceImpl()
    }

    @Singleton
    @Provides
    fun provideWhiskeyService(): WhiskeyService {
        return WhiskeyServiceImpl()
    }
}
