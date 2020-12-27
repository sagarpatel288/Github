package com.omniwyse.github.domain.api

import com.example.android.common.basenetworking.BaseResponse
import com.omniwyse.github.pojos.GitHubUser
import com.omniwyse.github.pojos.GithubUserResponseModel

interface GithubApiClient {

    suspend fun getUsersList(page: Int, pageSize: Int): BaseResponse<GithubUserResponseModel>

    suspend fun getUserInfo(username: String): BaseResponse<GitHubUser>
}