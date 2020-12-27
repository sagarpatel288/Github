package com.omniwyse.github

import com.example.android.common.baseapp.BaseApp
import com.example.android.common.baseconstants.BASE_URL_GITHUB
import com.example.android.common.baseconstants.StaticConstants
import com.example.android.common.basedi.baseSharedPrefsModule.baseSharePrefModule
import com.example.android.common.basedi.basecoremodule.baseCoreModule
import com.example.android.common.basedi.baseviewmodules.baseViewModules
import com.omniwyse.github.di.network.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : BaseApp() {

    override fun setBaseUrl() {
        StaticConstants.baseApiUrl = BASE_URL_GITHUB
    }

    override fun setDi() {
        startKoin {
            androidContext(this@MyApp)
            modules(
                listOf(
                    baseCoreModule,
                    baseViewModules,
                    networkModule,
                    baseSharePrefModule
                )
            )
        }
    }
}