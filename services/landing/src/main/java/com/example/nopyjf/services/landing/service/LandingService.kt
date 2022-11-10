package com.example.nopyjf.services.landing.service

import com.example.nopyjf.models.landing.LandingEntity
import com.example.nopyjf.models.response.ResponseEntity
import retrofit2.http.GET

interface LandingService {
    @GET("landing")
    suspend fun getLanding(): ResponseEntity<LandingEntity?>
}