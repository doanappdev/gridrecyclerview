package com.doanappdev.deloittetest.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.doanappdev.deloittetest.DeloitteTestApp
import com.doanappdev.deloittetest.R
import com.doanappdev.deloittetest.base.ViewItem
import com.doanappdev.deloittetest.ui.adapter.PhotosAdapter
import kotlinx.android.synthetic.main.activity_photos.*
import javax.inject.Inject
import org.jetbrains.anko.info


class PhotosActivity : AppCompatActivity(), PhotosContract.View {

    private val SPAN_COUNT = 3
    private val KEY_SEARCH_TERM = "search term"

    @Inject
    lateinit var presenter: PhotosContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)
        DeloitteTestApp.appComponent.inject(this)

        if (savedInstanceState != null) {
            val searchTerm = savedInstanceState.getString(KEY_SEARCH_TERM)
            info { "searchTerm : $searchTerm" }
        }


        presenter.attach(this)
        presenter.subscribe()

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putString(KEY_SEARCH_TERM, searchInput.text.toString())
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
}
