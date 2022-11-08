package com.example.landing.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.landing.databinding.ItemLandingRecommendBinding
import com.example.nopyjf.core.view.loadImage


class LandingListAdapter(
    private val items: List<String>
) : ListAdapter<String, RecyclerView.ViewHolder>(LandingListDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView =
            ItemLandingRecommendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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

        fun bind(title: String) {
            view.data = title
            view.landingRecommendImage.loadImage("https://d1csarkz8obe9u.cloudfront.net/posterpreviews/album-cover-instagram-ad-template-summer-mix-design-77fdb96e5919dae22a43d3bd46a2a868_screen.jpg?ts=1594329187")
        }
    }

    private class LandingListDiffUtil : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}