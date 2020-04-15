package com.deividasstr.daggervmargs

import android.app.Application

class App: Application() {

    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.create()
    }
}