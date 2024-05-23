package com.example.mvvmimplement.di

import com.example.mvvmimplement.Retrofit.FakerAPI
import com.example.mvvmimplement.Utlis.Constant
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    //singleton - puri application ek hi object ho to use karenege ham singleton
    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl(Constant.baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesFakerAPI(retrofit: Retrofit): FakerAPI{
        return retrofit.create(FakerAPI::class.java)

    }
}