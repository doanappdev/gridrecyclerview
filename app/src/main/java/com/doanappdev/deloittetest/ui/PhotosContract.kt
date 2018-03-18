package com.doanappdev.deloittetest.ui

import com.doanappdev.deloittetest.base.BaseContract
import com.doanappdev.deloittetest.base.ViewItem
import org.jetbrains.anko.AnkoLogger

interface PhotosContract {
    interface View : BaseContract.View, AnkoLogger {
        fun showProgressBar()
        fun hideProgressBar()
        fun setAdapter(viewItems: List<ViewItem>)
    }


    interface Presenter : BaseContract.Presenter<View> {
        fun searchFlicker(searchTerm: String)
    }
}