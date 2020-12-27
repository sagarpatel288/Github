package com.omniwyse.github

import android.app.Application
import com.example.android.common.baseconstants.BASE_URL_GITHUB
import com.example.android.common.baseconstants.StaticConstants
import com.omniwyse.github.di.datasource.repositoryModule
import com.omniwyse.github.di.vmmodules.viewModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setBaseUrl()
        setDi()
    }

    fun setBaseUrl() {
        StaticConstants.baseApiUrl = BASE_URL_GITHUB
    }

    fun setDi() {
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(viewModules, repositoryModule))
        }
    }
}