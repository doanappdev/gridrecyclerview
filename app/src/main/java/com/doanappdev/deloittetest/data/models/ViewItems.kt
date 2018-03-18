package com.doanappdev.deloittetest.data.models

import com.doanappdev.deloittetest.base.ViewItem
import io.reactivex.subjects.PublishSubject

val PHOTO_ITEM = 0

data class PhotoItem(val photo: Photo) : ViewItem {

    val clickSubject = PublishSubject.create<PhotoItem>()

    override fun getViewType() = PHOTO_ITEM
}
