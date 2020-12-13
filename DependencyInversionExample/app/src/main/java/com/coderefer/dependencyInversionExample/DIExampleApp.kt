package com.coderefer.dependencyInversionExample

import android.app.Application

class DIExampleApp : Application() {

//    TODO add di and remove these
    val repository by lazy { PrefLocalDataSourceImpl(this) }


    override fun onCreate() {
        super.onCreate()

    }
}