package com.yetkin.daggerhiltexample.ui.itemviewstate

import android.view.View
import com.yetkin.daggerhiltexample.data.model.IconSetModel

data class ItemIconSetViewState(
    val model: IconSetModel
) {

    fun name() = model.name ?: "empty name"

    fun userName() = " - ( ${model.author?.userName ?: "empty user name"} )"

    fun userId() =
        if (model.author?.userId.toString().isEmpty()) "0" else model.author?.userId.toString()

    fun userTotalIconCount() =
        if (model.iconsCount.toString().isEmpty()) "0" else model.iconsCount.toString()

    fun isDesigner() = if (model.author?.isDesigner == true) View.VISIBLE else View.INVISIBLE
}
