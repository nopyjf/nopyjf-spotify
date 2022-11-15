package com.example.nopyjf.services.landing.repository

import com.example.nopyjf.models.landing.LandingModel
import com.example.nopyjf.models.landing.transformModel
import com.example.nopyjf.models.response.getResponseModel
import com.example.nopyjf.services.landing.api.LandingApi
import javax.inject.Inject

class LandingRepository @Inject constructor(
    private val api: LandingApi
) : LandingRepositoryContractor {
    override suspend fun getLanding(): List<LandingModel>? {
        return try {
            val response = api.getLanding()
            response.getResponseModel {
                response.data?.transformModel()
            }
        } catch (e: Exception) {
            throw e
        }
    }
}