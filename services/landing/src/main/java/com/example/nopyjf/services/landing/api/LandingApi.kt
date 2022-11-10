package com.example.nopyjf.services.landing.api

import com.example.nopyjf.models.landing.LandingEntity
import com.example.nopyjf.models.response.ResponseEntity
import com.example.nopyjf.services.landing.service.LandingService

class LandingApi(
    private val service: LandingService
) {
    suspend fun getLanding(): ResponseEntity<LandingEntity?> {
        return service.getLanding()
    }
}