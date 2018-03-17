package com.doanappdev.deloittetest.data

import android.net.Uri
import com.doanappdev.deloittetest.data.models.PhotoResponse
import io.reactivex.Observable
import retrofit2.http.GET
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Query


interface FlickerService {


    // "?method=flickr.photoList.search&api_key=96358825614a5d3b1a1c3fd87fca2b47&text=kittens&format=json&nojsoncallback=1"


//    @GET("?method=flickr.photoList.search&api_key=96358825614a5d3b1a1c3fd87fca2b47&text=kittens&format=json&nojsoncallback=1")
//    fun getPhotoInfo(@Query("text") text: String) : Observable<PhotoResponse>

    @GET("rest/?format=json&nojsoncallback=1")
    fun getPhotoInfo(@Query("method") method: String,
                     @Query("api_key") apiKey: String,
                     @Query("text") text: String
    ) : Observable<PhotoResponse>

}