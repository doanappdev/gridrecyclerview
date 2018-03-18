package com.doanappdev.deloittetest.ui.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.doanappdev.deloittetest.base.ViewTypeDelegateAdapter
import com.doanappdev.deloittetest.base.ViewItem
import com.doanappdev.deloittetest.data.models.PHOTO_ITEM

class PhotosAdapter(private val viewItems: List<ViewItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    init {
        // we can add other delegate adapters here to handle different view types
        // eg. if we wanted to display image view with round borders
        delegateAdapters.put(PHOTO_ITEM, PhotoDelegateAdapter())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            delegateAdapters.get(viewType).onCreateViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, viewItems[position])
    }

    override fun getItemViewType(position: Int) = viewItems[position].getViewType()
    override fun getItemCount(): Int = viewItems.count()
}
