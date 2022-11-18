package com.example.landing.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.landing.databinding.ItemLandingRecommendBinding
import com.example.nopyjf.core.view.loadImage
import com.example.nopyjf.models.landing.LandingItemDisplay

class LandingRecommendItemAdapter(
    private val items: List<LandingItemDisplay>
) : ListAdapter<LandingItemDisplay, RecyclerView.ViewHolder>(LandingListDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView =
            ItemLandingRecommendBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return LandingRecommendViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LandingRecommendViewHolder -> holder.bind(items[position])
        }
    }

    override fun getItemCount() = items.size

    private class LandingRecommendViewHolder(private val view: ItemLandingRecommendBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun bind(data: LandingItemDisplay) {
            view.data = data
            view.landingRecommendImage.loadImage(data.image)
        }
    }

    private class LandingListDiffUtil : DiffUtil.ItemCallback<LandingItemDisplay>() {
        override fun areItemsTheSame(
            oldItem: LandingItemDisplay,
            newItem: LandingItemDisplay
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: LandingItemDisplay,
            newItem: LandingItemDisplay
        ): Boolean {
            return oldItem == newItem
        }
    }
}