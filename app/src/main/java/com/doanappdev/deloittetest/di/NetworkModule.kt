package com.doanappdev.deloittetest.di

import com.doanappdev.deloittetest.data.FlickerService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    val BASE_URL = "https://api.flickr.com/services/"

    @[Provides Singleton]
    fun provideRetrofitBuilder(okHttpClient: OkHttpClient) : Retrofit.Builder =
         Retrofit.Builder()
                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 .addConverterFactory(GsonConverterFactory.create())
                 .client(okHttpClient)

    @[Provides Singleton]
    fun provideFlickerService(builder: Retrofit.Builder) : FlickerService = builder
            .baseUrl(BASE_URL)
            .build()
            .create(FlickerService::class.java)

    @[Provides Singleton]
    fun provideOkHttpClient() : OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC })
            .build()
}
