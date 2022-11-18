package com.example.nopyjf.services.landing.repository

import com.example.nopyjf.models.landing.LandingListModel
import com.example.nopyjf.models.landing.transformModel
import com.example.nopyjf.models.response.getResponseModel
import com.example.nopyjf.services.landing.api.LandingApi
import javax.inject.Inject

class LandingRepository @Inject constructor(
    private val api: LandingApi
) : LandingRepositoryContractor {
    override suspend fun getLanding(): LandingListModel? {
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