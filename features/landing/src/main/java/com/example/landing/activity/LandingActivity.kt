package com.example.landing.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.landing.action.LandingViewAction
import com.example.landing.adapter.LandingPlaylistAdapter
import com.example.landing.adapter.LandingPlaylistItemAdapter
import com.example.landing.adapter.LandingRecommendAdapter
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
//                    updateLandingList(listOf())
                }
                LandingViewAction.ApiError -> {
//                    updateLandingList(listOf())
                }
                LandingViewAction.Success -> {
                    updateLandingList(landingViewModel.landing.value)
                }
                LandingViewAction.ServerError -> {
//                    updateLandingList(listOf())
                }
                LandingViewAction.MysteryError -> {
//                    updateLandingList(listOf())
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
                        LandingRecommendAdapter(LandingRecommendItemAdapter(it.items))
                    )
                }
                else -> {
                    adapter.addAdapter(
                        LandingPlaylistAdapter(it, LandingPlaylistItemAdapter(it.items))
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