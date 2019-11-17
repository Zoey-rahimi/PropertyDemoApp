package com.zoey.propertydemoapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zoey.propertydemoapp.model.Properties
import com.zoey.propertydemoapp.model.Property
import com.zoey.propertydemoapp.model.PropertyApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class PropertyViewModel : ViewModel() {

    private val service: PropertyApiService = PropertyApiService()
    private val compositeDisposable = CompositeDisposable()

    val propertyList = MutableLiveData<List<Property>>()
    val loading = MutableLiveData<Boolean>()
    val loadingError = MutableLiveData<Boolean>()

    fun refresh(isRefresh: Boolean): MutableLiveData<List<Property>> {
        if (propertyList.value.isNullOrEmpty() or isRefresh) {
            fetchFromRemote()
        }
        return propertyList
    }

    private fun fetchFromRemote() {
        loading.value = true

        val disposable = service.getProperty()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<Properties>() {
                override fun onError(e: Throwable) {
                    Log.e("ViewModel: ", "ERROR")
                    e.printStackTrace()
                    loading.value = false
                    loadingError.value = true
                }

                override fun onSuccess(t: Properties) {
                    Log.d("ViewModel: ", "SUCCESS")
                    loading.value = false
                    loadingError.value = false
                    propertyList.value = t.data?.propertyList
                }

            })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}