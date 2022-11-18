package com.example.nopyjf.services.landing.repository


import com.example.nopyjf.models.landing.LandingListModel

interface LandingRepositoryContractor {
    suspend fun getLanding(): LandingListModel?
}