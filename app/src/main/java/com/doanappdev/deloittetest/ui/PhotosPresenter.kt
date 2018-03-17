package com.doanappdev.deloittetest.ui

import com.doanappdev.deloittetest.base.ViewItem
import com.doanappdev.deloittetest.base.convertToBoolean
import com.doanappdev.deloittetest.data.models.Photo
import com.doanappdev.deloittetest.data.models.PhotoItem
import com.doanappdev.deloittetest.repository.PhotoRepository
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class PhotosPresenter constructor(val repository: PhotoRepository) : PhotosContract.Presenter, AnkoLogger {

    override lateinit var view: PhotosContract.View

    override fun attach(view: PhotosContract.View) {
       this.view = view
    }

    override fun subscribe() {
        view.showProgressBar()
        repository.getPhotoInfo("kittens")
                .subscribe  ({
                    val photoInfo = it.photos
                    val photos = photoInfo.photoList

                    info { "size : ${photos.size}" }

                    val photoViewItems = mutableListOf<ViewItem>()

                    photos.map {
                        info { "id : ${it.id}" }
                        info { "ispublic : ${it.ispublic}" }
                        info { "isPublic : ${it.ispublic.convertToBoolean()}" }
                        photoViewItems.add(PhotoItem(it))
                    }

                    info { "stat : ${it.stat}" }
                    view.hideProgressBar()
                    view.setAdapter(photoViewItems)

                }, {
                    // handle network error e.g. stop progress bar, display error msg etc..
                    info { "network error" }
                    view.hideProgressBar()
                })
    }
}