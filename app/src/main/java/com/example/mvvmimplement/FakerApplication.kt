package com.example.mvvmimplement

import android.app.Application
import com.example.mvvmimplement.di.ApplicationComponent
import com.example.mvvmimplement.di.DaggerApplicationComponent

class FakerApplication:Application() {
    lateinit var ApplicationComponent :ApplicationComponent
    override fun onCreate() {
        super.onCreate()

        ApplicationComponent = DaggerApplicationComponent.builder().build()

    }
}