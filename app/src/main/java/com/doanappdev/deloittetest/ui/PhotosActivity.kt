package com.doanappdev.deloittetest.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.doanappdev.deloittetest.DeloitteTestApp
import com.doanappdev.deloittetest.R
import com.doanappdev.deloittetest.base.ViewItem
import com.doanappdev.deloittetest.base.setRightDrawableOnTouchListener
import com.doanappdev.deloittetest.ui.adapter.PhotosAdapter
import kotlinx.android.synthetic.main.activity_photos.*
import javax.inject.Inject
import android.app.Activity
import android.view.inputmethod.InputMethodManager


class PhotosActivity : AppCompatActivity(), PhotosContract.View {

    private val SPAN_COUNT = 3
    private val KEY_SEARCH_TERM = "search term"

    @Inject
    lateinit var presenter: PhotosContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)
        DeloitteTestApp.appComponent.inject(this)
        presenter.attach(this)

        if (savedInstanceState != null) {
            val search = savedInstanceState.getString(KEY_SEARCH_TERM)
            when(search.isNotEmpty()) {
                true -> {
                    searchEditText.setText(search.toString())
                    presenter.searchFlicker(search)
                }
            }
        }

        searchEditText.setRightDrawableOnTouchListener {
            showProgressBar()
            hideKeyboard()
            presenter.searchFlicker(this.text.toString())
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putString(KEY_SEARCH_TERM, searchEditText.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun setAdapter(viewItems: List<ViewItem>) {
        recyclerView.visibility = View.VISIBLE
        recyclerView.apply {
            layoutManager = GridLayoutManager(context, SPAN_COUNT)
            adapter = PhotosAdapter(viewItems)
        }
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    fun hideKeyboard() {
        val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = this.currentFocus
        if (view == null) {
            view = View(this)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
