package com.doanappdev.deloittetest.ui

import com.doanappdev.deloittetest.base.ViewItem
import com.doanappdev.deloittetest.base.convertToBoolean
import com.doanappdev.deloittetest.data.models.PhotoItem
import com.doanappdev.deloittetest.repository.PhotoRepository
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class PhotosPresenter constructor(val repository: PhotoRepository) : PhotosContract.Presenter, AnkoLogger {

    override var view: PhotosContract.View? = null

    private var photoViewItems = mutableListOf<ViewItem>()


    override fun attach(view: PhotosContract.View) {
       this.view = view
    }


    override fun subscribe() {}

    override fun searchFlicker(searchTerm: String) {
        repository.getPhotoInfo(searchTerm)
                .subscribe  ({
                    if (view != null) {
                        val photoInfo = it.photos
                        val photos = photoInfo.photoList
                        photos.map {
                            photoViewItems.add(PhotoItem(it))
                        }

                        view?.hideProgressBar()
                        view?.setAdapter(photoViewItems)
                    } else {
                        // handle device rotation
                        info { "view is not attached!!" }
                    }

                }, {
                    // handle network error e.g. stop progress bar, display error msg etc..
                    info { "network error" }
                    view?.hideProgressBar()
                })
    }
}