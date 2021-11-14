package com.example.githubclient.model.api

import com.example.githubclient.model.data.GithubResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubAPi {

    @GET("/users/{userName}/repos")
    suspend fun searchUserRepositories(@Path("userName") name: String) : Response<List<GithubResponse>>
}