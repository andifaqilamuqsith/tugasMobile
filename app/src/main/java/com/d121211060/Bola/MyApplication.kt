package com.d121211060.Bola

import android.app.Application
import com.d121211060.Bola.data.AppContainer
import com.d121211060.Bola.data.DefaultAppContainer

class MyApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}