package com.cheetah.test.testing

import android.app.Application
import com.cheetah.test.testing.koin.modules.*
import com.facebook.stetho.Stetho
import org.koin.android.ext.android.startKoin

class App : Application(){

    private val moduleList = listOf(
        netModule,
        customerCartRepositoryModule,
        CustomerCartViewModelModules,
        storageModule
    )

    override fun onCreate() {
        super.onCreate()
        startKoin(this, moduleList)
        Stetho.initializeWithDefaults(this)
    }

}