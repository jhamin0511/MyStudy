package com.github.jhamin0511.mystudy.di

import com.github.jhamin0511.mystudy.ui.refresh.RefreshTabStateWithDI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class TabStateModule {
    @Singleton
    @Provides
    fun provideRefreshTabOne(): RefreshTabStateWithDI.One {
        return RefreshTabStateWithDI.One
    }

    @Singleton
    @Provides
    fun provideRefreshTabTwo(): RefreshTabStateWithDI.Two {
        return RefreshTabStateWithDI.Two
    }

    @Singleton
    @Provides
    fun provideRefreshTabThree(): RefreshTabStateWithDI.Three {
        return RefreshTabStateWithDI.Three
    }

    @Singleton
    @Provides
    fun provideRefreshTabFour(): RefreshTabStateWithDI.Four {
        return RefreshTabStateWithDI.Four
    }
}
