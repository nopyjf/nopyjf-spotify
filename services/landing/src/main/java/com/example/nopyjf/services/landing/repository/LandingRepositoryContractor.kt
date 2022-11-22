package com.example.nopyjf.services.landing.repository


import com.example.nopyjf.models.landing.LandingListModel
import kotlinx.coroutines.flow.Flow

interface LandingRepositoryContractor {
    suspend fun getLanding(): Flow<LandingListModel?>
}