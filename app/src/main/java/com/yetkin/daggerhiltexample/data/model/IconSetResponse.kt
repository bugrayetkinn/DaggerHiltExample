package com.yetkin.daggerhiltexample.data.model

import com.google.gson.annotations.SerializedName

data class IconSetResponse(
    @SerializedName("iconsets")
    val iconSets: List<IconSetModel>?
)
