package com.example.landing.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.landing.action.LandingViewAction
import com.example.nopyjf.models.error.transformError
import com.example.nopyjf.models.landing.LandingListDisplay
import com.example.nopyjf.services.landing.controller.LandingController
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
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

    var uiState: StateFlow<LandingViewAction> = _uiState

    fun getLanding() {
        _uiState.value = LandingViewAction.Loading
        // Do this when not use kotlin flow
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                _landing.value = controller.getLanding()
//                _uiState.value = LandingViewAction.Success
//            } catch (e: Throwable) {
//                _uiState.value = LandingViewAction.ShowErrorDialog(e.transformError())
//            }
//        }
        viewModelScope.launch(Dispatchers.IO) {
            controller.getLanding(
                {
                    _uiState.value = LandingViewAction.Success(it)
                },
                {
                    _uiState.value = LandingViewAction.ShowErrorDialog(it.transformError())
                }
            )
        }
    }
}