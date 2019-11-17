package com.zoey.propertydemoapp.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PropertyApiService {
    private val baseUrl: String = "https://demo7442132.mockable.io/"

    private val api = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()
        .create(PropertyApi::class.java)

    fun getProperty(): Single<Properties> {
        return api.getProperties()
    }
}