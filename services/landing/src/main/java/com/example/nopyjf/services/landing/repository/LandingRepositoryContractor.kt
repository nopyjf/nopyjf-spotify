package com.example.nopyjf.services.landing.repository


import com.example.nopyjf.models.response.ResponseModel

interface LandingRepositoryContractor {
    suspend fun getLanding(): ResponseModel
}