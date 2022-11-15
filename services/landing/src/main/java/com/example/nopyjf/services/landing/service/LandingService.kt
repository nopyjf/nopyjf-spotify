package com.example.nopyjf.services.landing.service

import com.example.nopyjf.models.landing.LandingEntity
import com.example.nopyjf.models.response.ResponseEntity
import retrofit2.http.GET

interface LandingService {
    @GET("v3/0daf9961-5e1a-4545-8019-1cdeadaf8bcc")
    suspend fun getLanding(): ResponseEntity<List<LandingEntity>?>
}