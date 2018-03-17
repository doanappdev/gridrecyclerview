package com.doanappdev.deloittetest.repository

import com.doanappdev.deloittetest.data.models.PhotoResponse
import io.reactivex.Observable

interface PhotoRepository {
    fun getPhotoInfo(text: String) : Observable<PhotoResponse>
}
