package com.doanappdev.deloittetest.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun Int.convertToBoolean() = when(this) {
        1 -> true
        else -> false
    }
