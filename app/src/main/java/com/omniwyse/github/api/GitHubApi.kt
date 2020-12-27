package com.omniwyse.github.api

import com.omniwyse.github.pojos.GitHubUser
import com.omniwyse.github.pojos.GithubUserResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApi {

    @GET("search/users?q=repos:>1")
    suspend fun getUsersList(
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int
    ): Response<GithubUserResponseModel>

    @GET("users/{username}")
    suspend fun getUserInfo(
        @Path("username") username: String
    ): Response<GitHubUser>
}