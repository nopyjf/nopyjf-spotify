package com.example.landing.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.landing.action.LandingViewAction
import com.example.nopyjf.models.error.ErrorException
import com.example.nopyjf.models.landing.LandingListDisplay
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

    private val _uiState = MutableStateFlow<LandingViewAction>(LandingViewAction.Loading)
    private val _landing = MutableStateFlow<LandingListDisplay?>(null)

    var uiState: StateFlow<LandingViewAction> = _uiState
    var landing: StateFlow<LandingListDisplay?> = _landing

    fun getLanding() {
        _uiState.value = LandingViewAction.Loading
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _landing.value = controller.getLanding()
                _uiState.value = LandingViewAction.Success
            } catch (e: ErrorException) {
                LandingViewAction.getLandingViewAction(_uiState, e)
            } catch (e: Exception) {
                _uiState.value = LandingViewAction.MysteryError
            }
        }
    }
}