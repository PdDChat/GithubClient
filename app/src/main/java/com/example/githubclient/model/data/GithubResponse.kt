package com.example.githubclient.model.data

import com.google.gson.annotations.SerializedName

data class GithubResponse(
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("full_name")
    val fullName: String = "",

)
