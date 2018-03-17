package com.doanappdev.deloittetest.data.models

import com.doanappdev.deloittetest.base.ViewItem

val PHOTO_ITEM = 0

data class PhotoItem(val photo: Photo) : ViewItem {
    override fun getViewType() = PHOTO_ITEM
}
