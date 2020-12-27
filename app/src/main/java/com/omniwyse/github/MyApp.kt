package com.omniwyse.github

import com.example.android.common.baseapp.BaseApp
import com.example.android.common.baseconstants.BASE_URL_GITHUB
import com.example.android.common.baseconstants.StaticConstants

class MyApp : BaseApp() {

    override fun setBaseUrl() {
        StaticConstants.baseApiUrl = BASE_URL_GITHUB
    }
}