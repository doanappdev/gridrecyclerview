package com.doanappdev.deloittetest.di

import android.app.Application
import android.content.Context
import android.location.LocationManager
import com.doanappdev.deloittetest.data.FlickerService
import com.doanappdev.deloittetest.repository.PhotoRepository
import com.doanappdev.deloittetest.repository.PhotoRepositoryImp
import com.doanappdev.deloittetest.ui.PhotosContract
import com.doanappdev.deloittetest.ui.PhotosPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {


    @[Provides Singleton]
    fun provideApplication(): Application {
        return application
    }

    @[Provides Singleton]
    fun provideContext() : Context = application

    @[Provides Singleton]
    fun provideLocationManager(): LocationManager {
        return application.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    @Provides
    fun providePhotoRepository(service: FlickerService) : PhotoRepository = PhotoRepositoryImp(service)

    @Provides
    fun providePhotoPresenter(repository: PhotoRepository) : PhotosContract.Presenter = PhotosPresenter(repository)


}
