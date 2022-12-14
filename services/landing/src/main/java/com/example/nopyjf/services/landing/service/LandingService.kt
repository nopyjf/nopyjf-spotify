package com.example.nopyjf.services.landing.service

import com.example.nopyjf.models.landing.LandingListEntity
import com.example.nopyjf.models.response.ResponseEntity
import retrofit2.http.GET

interface LandingService {
    @GET("landing")
    suspend fun getLanding(): ResponseEntity<LandingListEntity?>
}