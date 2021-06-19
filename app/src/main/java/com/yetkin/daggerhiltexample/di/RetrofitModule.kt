package com.yetkin.daggerhiltexample.di

import com.yetkin.daggerhiltexample.BuildConfig
import com.yetkin.daggerhiltexample.data.remote.IconFinderApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.HEADERS
    }

    @Singleton
    @Provides
    fun provideHttpClient() = OkHttpClient.Builder().apply {
        addInterceptor(provideInterceptor())
    }.build()

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideHttpClient())
            .baseUrl(BuildConfig.BASE_URL)
            .build()

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): IconFinderApi = retrofit.create(IconFinderApi::class.java)
}