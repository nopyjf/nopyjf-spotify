package com.example.nopyjf.services.landing.repository

import com.example.nopyjf.models.landing.LandingListModel
import com.example.nopyjf.models.landing.transformModel
import com.example.nopyjf.models.response.getErrorException
import com.example.nopyjf.services.landing.api.LandingApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LandingRepository @Inject constructor(
    private val api: LandingApi
) : LandingRepositoryContractor {

    override suspend fun getLanding(): Flow<LandingListModel?> = flow {
        val response = api.getLanding()
        response.getErrorException()?.let { throw it }
        emit(response.data.transformModel())
    }
}