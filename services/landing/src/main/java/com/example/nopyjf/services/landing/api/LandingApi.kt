package com.example.nopyjf.services.landing.api

import com.example.nopyjf.models.landing.LandingListEntity
import com.example.nopyjf.models.response.ResponseEntity
import com.example.nopyjf.services.landing.service.LandingService
import javax.inject.Inject

class LandingApi @Inject constructor(
    private val service: LandingService
) {
    suspend fun getLanding(): ResponseEntity<LandingListEntity?> {
        return service.getLanding()
    }
}