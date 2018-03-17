package com.doanappdev.deloittetest

import android.app.Application
import com.doanappdev.deloittetest.di.AppComponent
import com.doanappdev.deloittetest.di.AppModule
import com.doanappdev.deloittetest.di.DaggerAppComponent
import com.doanappdev.deloittetest.di.NetworkModule

class DeloitteTestApp : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .build()
    }
}