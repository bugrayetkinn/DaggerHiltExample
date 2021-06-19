package com.yetkin.daggerhiltexample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yetkin.daggerhiltexample.data.model.IconSetModel
import com.yetkin.daggerhiltexample.databinding.ItemIconSetBinding
import com.yetkin.daggerhiltexample.ui.itemviewstate.ItemIconSetViewState

class IconSetAdapter : RecyclerView.Adapter<IconSetAdapter.IconSetViewHolder>() {

    private var iconSets = mutableListOf<IconSetModel>()

    fun setIconSets(list: List<IconSetModel>?) {
        this.iconSets.apply {
            clear()
            addAll(list ?: mutableListOf())
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IconSetViewHolder =
        IconSetViewHolder(
            ItemIconSetBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: IconSetViewHolder, position: Int) =
        holder.bind(iconSets[position])

    override fun getItemCount(): Int = iconSets.size

    class IconSetViewHolder(private val binding: ItemIconSetBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: IconSetModel) {
            binding.apply {
                itemViewState = ItemIconSetViewState(model)
                executePendingBindings()
            }
        }
    }
}