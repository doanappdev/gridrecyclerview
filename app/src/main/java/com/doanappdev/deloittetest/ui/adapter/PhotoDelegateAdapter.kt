package com.doanappdev.deloittetest.ui.adapter

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.doanappdev.deloittetest.R
import com.doanappdev.deloittetest.base.ViewItem
import com.doanappdev.deloittetest.base.ViewTypeDelegateAdapter
import com.doanappdev.deloittetest.base.inflate
import com.doanappdev.deloittetest.data.models.PhotoItem
import kotlinx.android.synthetic.main.item_photo.view.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class PhotoDelegateAdapter : ViewTypeDelegateAdapter, AnkoLogger {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return PhotoViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewItem) {
        holder as PhotoViewHolder
        holder.bind(item as PhotoItem)
    }

    inner class PhotoViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_photo)) {
        fun bind(item: PhotoItem) = with(itemView) {
            val photo = item.photo
            info { "farm : ${photo.farm}" }
            info { "server : ${photo.server}" }
            info { "id : ${photo.id}" }
            info { "secret : ${photo.secret}" }
            info { "URL : ${photo.getUrl()}" }

            Glide.with(context)
                    .load(photo.getUrl())
                    .placeholder(ContextCompat.getDrawable(context, R.drawable.ic_file_download_black_24dp))
                    .into(imageView)
        }
    }
}
