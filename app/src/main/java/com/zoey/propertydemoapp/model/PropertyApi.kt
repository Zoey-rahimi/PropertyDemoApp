package com.zoey.propertydemoapp.model

import io.reactivex.Single
import retrofit2.http.GET

interface PropertyApi {
    @GET("test/properties")
    fun getProperties(): Single<Properties>
}