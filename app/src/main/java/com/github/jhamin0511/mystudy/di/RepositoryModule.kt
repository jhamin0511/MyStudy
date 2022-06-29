package com.github.jhamin0511.mystudy.di

import com.github.jhamin0511.mystudy.repository.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideGithubRepository(): GithubRepository {
        return GithubRepository()
    }
}
