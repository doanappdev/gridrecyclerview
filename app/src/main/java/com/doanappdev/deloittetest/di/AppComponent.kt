package com.doanappdev.deloittetest.di

import com.doanappdev.deloittetest.DeloitteTestApp
import com.doanappdev.deloittetest.ui.PhotosActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: DeloitteTestApp) : Builder
        fun appModule(appModule: AppModule) : Builder
        fun networkModule(networkModule: NetworkModule) : Builder
        fun build() : AppComponent
    }

    fun inject(activity: PhotosActivity)
}
