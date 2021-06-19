package com.yetkin.daggerhiltexample.data.remote

import com.yetkin.daggerhiltexample.data.model.IconSetResponse
import com.yetkin.daggerhiltexample.util.Resource
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton
@Singleton
class RemoteDataSource @Inject constructor( private val api: IconFinderApi) {

    fun getIconSets(): Observable<Resource<IconSetResponse>> =
        Observable.create { emitter ->
            emitter.onNext(Resource.Loading)
            api.getIconSets().subscribeOn(Schedulers.io()).subscribe(
                { response ->
                    emitter.onNext(Resource.Success(response))
                    emitter.onComplete()
                },
                { throwable ->
                    emitter.onNext(Resource.Error(throwable))
                    emitter.onComplete()
                }
            )
        }
}