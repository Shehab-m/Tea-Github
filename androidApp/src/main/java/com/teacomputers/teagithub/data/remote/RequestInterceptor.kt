package com.teacomputers.teagithub.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return makeRequest(chain)
    }

    private fun makeRequest(
        chain: Interceptor.Chain,
    ): Response {
        val oldRequest = chain
            .request()
            .newBuilder()
            .addHeader(ACCEPT, ACCEPT_VALUE)
            .build()

        return chain.proceed(oldRequest)
    }


    companion object {
        private const val ACCEPT = "Accept"
        private const val ACCEPT_VALUE = "application/json"
    }
}