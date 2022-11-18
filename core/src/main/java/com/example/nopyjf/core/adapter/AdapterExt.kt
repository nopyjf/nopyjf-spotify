package com.example.nopyjf.core.adapter

import androidx.recyclerview.widget.ConcatAdapter

fun ConcatAdapter.clear() {
    this.adapters.map {
        this.removeAdapter(it)
    }
}