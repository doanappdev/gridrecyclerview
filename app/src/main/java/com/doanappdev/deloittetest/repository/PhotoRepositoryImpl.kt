package com.doanappdev.deloittetest.repository

import com.doanappdev.deloittetest.data.FlickerService
import com.doanappdev.deloittetest.data.models.PhotoResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PhotoRepositoryImp(private val service: FlickerService) : PhotoRepository {
    override fun getPhotoInfo(text: String): Observable<PhotoResponse> {
        return service.getPhotoInfo(
                "flickr.photos.search",
                "96358825614a5d3b1a1c3fd87fca2b47",
                text)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}