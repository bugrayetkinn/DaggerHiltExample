package com.yetkin.daggerhiltexample.data.model

import com.google.gson.annotations.SerializedName

data class Author(
    val company: String?,
    @SerializedName("username")
    val userName: String?,
    val name: String?,
    @SerializedName("is_designer")
    val isDesigner: Boolean?,
    @SerializedName("iconsets_count")
    val iconSetsCount: Int?,
    @SerializedName("user_id")
    val userId: Int?
)
