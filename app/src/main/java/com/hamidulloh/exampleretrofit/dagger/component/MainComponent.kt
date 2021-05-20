package com.hamidulloh.exampleretrofit.dagger.component

import com.hamidulloh.exampleretrofit.dagger.module.MainModule
import com.hamidulloh.exampleretrofit.repository.Repository
import dagger.Component
import javax.inject.Singleton

@Component(modules = [MainModule::class])
@Singleton
interface MainComponent {
    fun createRepository() : Repository
}