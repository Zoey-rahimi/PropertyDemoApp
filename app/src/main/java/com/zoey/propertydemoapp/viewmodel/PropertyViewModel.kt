package com.zoey.propertydemoapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zoey.propertydemoapp.PropertyRepository
import com.zoey.propertydemoapp.model.Properties
import com.zoey.propertydemoapp.model.Property
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver

class PropertyViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val repository = PropertyRepository()
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

        val disposable = repository.getPropertyList()
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