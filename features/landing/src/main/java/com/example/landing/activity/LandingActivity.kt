package com.example.landing.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.landing.action.LandingViewAction
import com.example.landing.adapter.WrapperLandingPlaylistAdapter
import com.example.landing.adapter.LandingPlaylistItemAdapter
import com.example.landing.adapter.WrapperLandingRecommendAdapter
import com.example.landing.adapter.LandingRecommendItemAdapter
import dagger.hilt.android.AndroidEntryPoint
import com.example.landing.databinding.ActivityLandingBinding
import com.example.landing.viewmodel.LandingViewModel
import com.example.nopyjf.core.adapter.clear
import com.example.nopyjf.models.landing.LandingListDisplay
import com.example.nopyjf.models.landing.LandingType


@AndroidEntryPoint
class LandingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandingBinding

    private val landingViewModel: LandingViewModel by viewModels()
    private val adapter: ConcatAdapter = ConcatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launchWhenStarted {
            landingViewModel.getLanding()
            updateUiState()
        }

        lifecycleScope.launchWhenResumed {
            landingViewModel.getLanding()
            updateUiState()
        }
    }

    private suspend fun updateUiState() {
        landingViewModel.uiState.collect {
            when (it) {
                is LandingViewAction.Loading -> {
                    // Show loading
                }
                is LandingViewAction.Success -> {
                    updateLandingList(it.display)
                }
                is LandingViewAction.ShowErrorDialog -> {
                    // Show dialog in here
                    it.errorDisplay
                }
            }
        }
    }

    private fun updateLandingList(data: LandingListDisplay?) {
        adapter.clear()
        data?.landingList?.forEach {
            when (it.type) {
                LandingType.RECOMMEND.name -> {
                    adapter.addAdapter(
                        WrapperLandingRecommendAdapter(LandingRecommendItemAdapter(it.items))
                    )
                }
                else -> {
                    adapter.addAdapter(
                        WrapperLandingPlaylistAdapter(it, LandingPlaylistItemAdapter(it.items))
                    )
                }
            }
        }
        binding.landingList.apply {
            adapter = this@LandingActivity.adapter
            layoutManager = LinearLayoutManager(this@LandingActivity)
        }
    }
}