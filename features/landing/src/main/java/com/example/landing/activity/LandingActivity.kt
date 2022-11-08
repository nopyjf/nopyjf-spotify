package com.example.landing.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.landing.adapter.LandingListAdapter
import dagger.hilt.android.AndroidEntryPoint
import com.example.landing.databinding.ActivityLandingBinding


@AndroidEntryPoint
class LandingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = LandingListAdapter(listOf("TEST", "TEST2"))
        binding.landingList.adapter = adapter
        binding.landingList.layoutManager = GridLayoutManager(this, 2)
    }
}