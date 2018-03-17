package com.doanappdev.deloittetest.data.models

import com.google.gson.annotations.SerializedName

data class PhotoResponse(
        @SerializedName("photos") val photos: Photos,
        val stat: String
        //val message: String?
)

data class Photos(
        val page: Int?,
        val pages: Int?,
        val perpage: Int?,
        val total: String,
        @SerializedName("photo") val photoList: List<Photo>
)

data class Photo(
        val id: String,
        val owner: String,
        val secret: String,
        val server: String,
        val farm: Int,
        val title: String,
        val ispublic: Int,
        val isfriend: Int,
        val isfamily: Int
) {
    fun getUrl() : String {
        // example URL:
        // http://farm{farm}.static.flickr.com/{server}/{id}_{secret}.jpg
        // https://farm1.staticflickr.com/2/1418878_1e92283336_m.jpg
        return "http://farm%d.static.flickr.com/%s/%s_%s.jpg".format(farm, server, id, secret)
    }
}
