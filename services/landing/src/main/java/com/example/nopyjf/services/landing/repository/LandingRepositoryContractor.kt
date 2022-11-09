package com.example.nopyjf.services.landing.repository

import com.example.nopyjf.models.landing.LandingModel

interface LandingRepositoryContractor {
    suspend fun getLanding(): LandingModel?
}