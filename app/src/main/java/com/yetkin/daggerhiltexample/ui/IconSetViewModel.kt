package com.yetkin.daggerhiltexample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yetkin.daggerhiltexample.data.model.IconSetResponse
import com.yetkin.daggerhiltexample.data.remote.RemoteDataSource
import com.yetkin.daggerhiltexample.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@HiltViewModel
class IconSetViewModel @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    ViewModel() {

    private val _iconSets: MutableLiveData<Resource<IconSetResponse>> = MutableLiveData()
    val iconSets: LiveData<Resource<IconSetResponse>> get() = _iconSets

    val isLoading = MutableLiveData<Boolean>().apply { value = false }
    val isError = MutableLiveData<Boolean>().apply { value = false }

    init {
        getIconSets()
    }

    private fun getIconSets() {
        remoteDataSource
            .getIconSets()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response ->
                _iconSets.postValue(response)
            }
    }
}