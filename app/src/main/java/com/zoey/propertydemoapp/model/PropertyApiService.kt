package com.zoey.propertydemoapp.model

import com.zoey.propertydemoapp.BuildConfig
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PropertyApiService {

    private val api = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .build()
        .create(PropertyApi::class.java)

    fun getProperty(): Single<Properties> {
        return api.getProperties()
    }
}