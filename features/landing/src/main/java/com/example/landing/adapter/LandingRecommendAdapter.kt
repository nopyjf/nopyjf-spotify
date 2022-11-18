package com.example.landing.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.landing.databinding.SectionLandingRecommendBinding
import com.example.nopyjf.core.config.Config.ONE_ITEM
import com.example.nopyjf.core.config.Config.SPAN_COUNT_TWO
import com.example.nopyjf.models.landing.LandingDisplay

class LandingRecommendAdapter(
    private val adapter: LandingRecommendItemAdapter
) : ListAdapter<LandingDisplay, RecyclerView.ViewHolder>(LandingListDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView =
            SectionLandingRecommendBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return LandingRecommendViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LandingRecommendViewHolder -> holder.bind(adapter)
        }
    }

    override fun getItemCount() = ONE_ITEM

    private class LandingRecommendViewHolder(private val view: SectionLandingRecommendBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun bind(adapter: LandingRecommendItemAdapter) {
            view.landingRecommendList.let {
                it.adapter = adapter
                it.layoutManager = GridLayoutManager(itemView.context, SPAN_COUNT_TWO)
            }
        }
    }

    private class LandingListDiffUtil : DiffUtil.ItemCallback<LandingDisplay>() {
        override fun areItemsTheSame(
            oldItem: LandingDisplay,
            newItem: LandingDisplay
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: LandingDisplay,
            newItem: LandingDisplay
        ): Boolean {
            return oldItem == newItem
        }
    }
}