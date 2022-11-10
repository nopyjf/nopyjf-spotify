package com.example.nopyjf.services.landing.repository

import com.example.nopyjf.models.landing.LandingEntity
import com.example.nopyjf.models.landing.LandingModel
import com.example.nopyjf.models.landing.transformModel
import com.example.nopyjf.models.response.ResponseEntity
import com.example.nopyjf.models.response.ResponseModel
import com.example.nopyjf.models.response.getResponseModel
import com.example.nopyjf.services.landing.api.LandingApi

class LandingRepository(
    private val api: LandingApi
) : LandingRepositoryContractor {
    override suspend fun getLanding(): ResponseModel<LandingModel> {
        return try {
            val response: ResponseEntity<LandingEntity?> = api.getLanding()
            response.getResponseModel { response.data.transformModel() }
        } catch (e: Exception) {
            ResponseModel.MysteryError()
        }
    }
}