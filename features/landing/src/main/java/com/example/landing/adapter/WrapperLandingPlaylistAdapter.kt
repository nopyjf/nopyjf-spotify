package com.example.landing.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.landing.databinding.SectionLandingPlaylistBinding
import com.example.nopyjf.core.config.Config.ONE_ITEM
import com.example.nopyjf.models.landing.LandingDisplay
import com.example.nopyjf.models.landing.LandingItemDisplay

class WrapperLandingPlaylistAdapter(
    private val data: LandingDisplay,
    private val adapter: LandingPlaylistItemAdapter
) : ListAdapter<LandingItemDisplay, RecyclerView.ViewHolder>(WrapperLandingPlaylistDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView =
            SectionLandingPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return WrapperLandingPlaylistViewHolder(data, itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is WrapperLandingPlaylistViewHolder -> holder.bind(adapter)
        }
    }

    override fun getItemCount() = ONE_ITEM

    private class WrapperLandingPlaylistViewHolder(
        private val data: LandingDisplay,
        private val view: SectionLandingPlaylistBinding
    ) :
        RecyclerView.ViewHolder(view.root) {

        fun bind(adapter: LandingPlaylistItemAdapter) {
            view.landingPlaylistList.let {
                it.adapter = adapter
                it.layoutManager =
                    LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            }
            view.data = data
        }
    }

    private class WrapperLandingPlaylistDiffUtil : DiffUtil.ItemCallback<LandingItemDisplay>() {
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