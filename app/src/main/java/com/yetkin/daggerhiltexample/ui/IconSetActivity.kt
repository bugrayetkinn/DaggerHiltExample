package com.yetkin.daggerhiltexample.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.yetkin.daggerhiltexample.databinding.ActivityMainBinding
import com.yetkin.daggerhiltexample.ui.adapter.IconSetAdapter
import com.yetkin.daggerhiltexample.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IconSetActivity : AppCompatActivity() {

    private val viewModel: IconSetViewModel by viewModels()

    private val iconSetAdapter by lazy {
        IconSetAdapter()
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            lifecycleOwner = this@IconSetActivity
            viewModel = this@IconSetActivity.viewModel
        }

        initializeRecycler()

        observeIconSets()
    }

    private fun initializeRecycler() {
        binding.recyclerIconSet.apply {
            setHasFixedSize(true)
            adapter = iconSetAdapter
        }
    }

    private fun observeIconSets() {
        viewModel.iconSets.observe(this) { response ->
            when (response) {
                is Resource.Loading -> {
                    viewModel.isLoading.postValue(true)
                }
                is Resource.Success -> {
                    viewModel.isLoading.postValue(false)
                    iconSetAdapter.setIconSets(response.data.iconSets)
                }
                is Resource.Error -> {
                    viewModel.isError.postValue(true)
                    viewModel.isLoading.postValue(false)
                }
            }
        }
    }
}