package com.omniwyse.github.api

import com.omniwyse.github.pojos.GitHubUser
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApi {

    /*https://api.github.com/users?since=0&perpage=20*/
    @GET("/users")
    suspend fun getUsersList(
        @Query("since") since: Int,
        @Query("per_page") itemsPerPage: Int
    ): List<GitHubUser>

    /*https://api.github.com/users/sagarpatel288*/
    @GET("users/{username}")
    suspend fun getUserInfo(
        @Path("username") username: String
    ): Response<GitHubUser>
}