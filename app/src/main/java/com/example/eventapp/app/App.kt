package com.example.eventapp.app

import android.app.Application
import com.example.eventapp.data.MyPref

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MyPref.init(this)
    }
}