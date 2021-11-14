package com.example.githubclient.repository

import com.example.githubclient.model.data.GithubResponse
import com.example.githubclient.model.api.GithubAPi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubRepository {

    private val baseUrl: String = "https://api.github.com"

    private val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    suspend fun searchUserRepositories(name: String): Response<List<GithubResponse>> {
        val service = retrofit.create(GithubAPi::class.java)
        return service.searchUserRepositories(name)
    }
}