package com.example.landing.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.landing.databinding.ItemLandingPlaylistBinding
import com.example.nopyjf.core.view.loadImage
import com.example.nopyjf.models.landing.LandingItemDisplay

class LandingPlaylistItemAdapter(
    private val items: List<LandingItemDisplay>
) : ListAdapter<LandingItemDisplay, RecyclerView.ViewHolder>(LandingPlaylistItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView =
            ItemLandingPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LandingPlaylistItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LandingPlaylistItemViewHolder -> holder.bind(items[position])
        }
    }

    override fun getItemCount() = items.size

    private class LandingPlaylistItemViewHolder(private val view: ItemLandingPlaylistBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun bind(data: LandingItemDisplay) {
            view.data = data
            view.landingPlaylistItemImage.loadImage(data.image)
        }
    }

    private class LandingPlaylistItemDiffUtil : DiffUtil.ItemCallback<LandingItemDisplay>() {
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