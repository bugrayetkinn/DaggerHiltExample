package com.yetkin.daggerhiltexample.data.model

import com.google.gson.annotations.SerializedName

data class IconSetModel(
    @SerializedName("icons_count")
    val iconsCount: Int?,
    val author: Author?,
    val name: String?,
    @SerializedName("published_at")
    val publishedAt: String?,
    @SerializedName("is_premium")
    val isPremium:Boolean,
    val prices:List<Prices>
)
