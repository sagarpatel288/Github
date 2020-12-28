package com.omniwyse.github.networking

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

// comment by srdpatel: 3/7/2020 https://github.com/harmittaa/KoinExample/blob/master/app/src/main/java/com/github/harmittaa/koinexample/networking/AuthInterceptor.kt
class AuthInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        // DON'T INCLUDE API KEYS IN YOUR SOURCE CODE
        // Edit (or add) a gradle.properties file in your project root
        // and add the API_KEY there!

        val requestBuilder = chain.request().newBuilder()
//        var request = chain.request()
//        val url = request.url.newBuilder().addQueryParameter("APPID", BuildConfig.API_KEY).build()
//        request = request.newBuilder().url(url).build()
        requestBuilder.addHeader(
            "Authorization",
            Credentials.basic("sagarpatel288",
            "4060f3c9c86886c2c454674efbab26085c304bb3")
            /*Credentials.basic(BuildConfig.USER_NAME, BuildConfig.TOKEN)*/
        )
        return chain.proceed(requestBuilder.build())
    }
}