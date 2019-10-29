package com.sample.mynewapplication.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object APIClient {

    private var retrofit: Retrofit? = null
    val client: Retrofit
        get() {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            retrofit = Retrofit.Builder()
                .baseUrl("https://c8r.azurewebsites.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit as Retrofit
        }

}