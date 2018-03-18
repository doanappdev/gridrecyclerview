package com.doanappdev.deloittetest.base

import android.support.v7.widget.AppCompatEditText
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun Int.convertToBoolean() = when(this) {
        1 -> true
        else -> false
    }

fun AppCompatEditText.setRightDrawableOnTouchListener(func: AppCompatEditText.() -> Unit) {
    setOnTouchListener { _, event ->
        var consumed = false
        if (event.action == MotionEvent.ACTION_UP) {
            val drawable = compoundDrawables[2]
            if (event.rawX >= (right - drawable.bounds.width())) {
                func()
                consumed = true
            }
        }
        consumed
    }
}
