package com.zoey.propertydemoapp

import com.zoey.propertydemoapp.model.Properties
import com.zoey.propertydemoapp.model.PropertyApiService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Singleton
class PropertyRepository {

    private val service: PropertyApiService = PropertyApiService()

    fun getPropertyList(): Single<Properties> {

        return service.getProperty()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
    }
}