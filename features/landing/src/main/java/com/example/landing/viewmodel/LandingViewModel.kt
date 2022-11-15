package com.example.landing.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.landing.action.LandingViewAction
import com.example.nopyjf.models.landing.LandingDisplay
import com.example.nopyjf.services.landing.controller.LandingController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LandingViewModel @Inject constructor(
    private val controller: LandingController
) : ViewModel() {

    private val _uiState = MutableStateFlow<LandingViewAction>(LandingViewAction.ShowLoading)
    private val _landing = MutableStateFlow<List<LandingDisplay>>(listOf())

    var landing: StateFlow<List<LandingDisplay>> = _landing
    var uiState: StateFlow<LandingViewAction> = _uiState

    fun startLandingScreen() {
        _uiState.value = LandingViewAction.ShowLoading
        getLanding()
    }

    private fun getLanding() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _landing.value = controller.getLanding()
                _uiState.value = LandingViewAction.Success
            } catch (e: Exception) {
                _uiState.value = LandingViewAction.ShowError
            }
        }
    }
}