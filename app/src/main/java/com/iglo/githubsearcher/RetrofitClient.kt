package com.iglo.githubsearcher

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.github.com/"

    fun create(): Retrofit {
        val gson = GsonBuilder().setLenient().create() // Consider using Moshi for stricter parsing

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor()) // Optional: Add logging interceptor for debugging
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    private fun loggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY // Change to Level.BASIC for minimal logs
        return loggingInterceptor
    }
}