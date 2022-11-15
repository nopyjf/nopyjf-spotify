package com.example.nopyjf.services.landing.di

import com.example.nopyjf.services.landing.service.LandingService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class LandingModule {

    @Provides
    fun provideLandingService(
        retrofit: Retrofit
    ): LandingService {
        return retrofit.create(LandingService::class.java)
    }
}