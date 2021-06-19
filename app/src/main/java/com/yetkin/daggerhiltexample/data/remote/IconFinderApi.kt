package com.yetkin.daggerhiltexample.data.remote

import com.yetkin.daggerhiltexample.BuildConfig
import com.yetkin.daggerhiltexample.data.model.IconSetResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Header

const val ICON_SETS = "/v4/iconsets"

const val BEARER_TOKEN = "Bearer ${BuildConfig.API_KEY}"

interface IconFinderApi {
    @GET(ICON_SETS)
    fun getIconSets(
        @Header("Authorization") header: String = BEARER_TOKEN
    ): Single<IconSetResponse>
}