package com.hamidulloh.exampleretrofit.dagger.module

import com.hamidulloh.exampleretrofit.api.RetrofitInstance
import com.hamidulloh.exampleretrofit.repository.Repository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Module
class MainModule {
    @Provides
    @Singleton
    fun provideRetrofit() : RetrofitInstance = RetrofitInstance

    @Provides
    @Singleton
    @Inject
    fun provideRepository(retrofitInstance : RetrofitInstance) : Repository =
        Repository(retrofitInstance)
}