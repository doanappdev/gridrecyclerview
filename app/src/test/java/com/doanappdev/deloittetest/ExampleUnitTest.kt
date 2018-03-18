package com.doanappdev.deloittetest

import com.doanappdev.deloittetest.data.models.Photo
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    /**
     *  This test should verify URL is in correct format given various values, the format is
     *  http://farm{farm}.static.flickr.com/{server}/{id}_{secret}.jpg
     */
    @Test
    fun shouldFormatUrl_GivenValues() {
        val photos = Photo("39593986652", "36739135@N04", "0ec416669f", "4740", 5, "IMG_5508", 1, 0, 0)
        val expected = "http://farm5.static.flickr.com/4740/39593986652_0ec416669f.jpg"
        val actual = photos.getUrl()
        assertEquals(expected, actual)
    }
}
