package com.example.nopyjf.services.landing.repository

import com.example.nopyjf.models.landing.LandingEntity
import com.example.nopyjf.models.landing.LandingModel
import com.example.nopyjf.models.landing.transformModel
import com.example.nopyjf.services.landing.api.LandingApi

class LandingRepository(
    private val api: LandingApi
) : LandingRepositoryContractor {
    override suspend fun getLanding(): LandingModel {
        val data: LandingEntity = api.getLanding().data ?: throw java.lang.Exception()
        return data.transformModel()
    }
}