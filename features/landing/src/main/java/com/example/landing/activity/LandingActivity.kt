package com.example.landing.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.landing.action.LandingViewAction
import com.example.landing.adapter.LandingListAdapter
import dagger.hilt.android.AndroidEntryPoint
import com.example.landing.databinding.ActivityLandingBinding
import com.example.landing.viewmodel.LandingViewModel
import com.example.nopyjf.models.landing.LandingDisplay


@AndroidEntryPoint
class LandingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandingBinding

    private val landingViewModel: LandingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launchWhenStarted {
            landingViewModel.startLandingScreen()
            updateUiState()
        }

        lifecycleScope.launchWhenResumed {
            landingViewModel.startLandingScreen()
            updateUiState()
        }
    }

    private suspend fun updateUiState() {
        landingViewModel.uiState.collect {
            when (it) {
                is LandingViewAction.ShowLoading -> {
                    updateLandingList(listOf())
                }
                LandingViewAction.ShowError -> {
                    updateLandingList(listOf())
                }
                LandingViewAction.Success -> {
                    updateLandingList(landingViewModel.landing.value)
                }
            }
        }

    }

    private fun updateLandingList(data: List<LandingDisplay>) {
        binding.landingList.adapter = LandingListAdapter(data)
        binding.landingList.layoutManager = GridLayoutManager(this, 2)
    }
}