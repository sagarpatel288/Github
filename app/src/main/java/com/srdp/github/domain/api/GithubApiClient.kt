package com.srdp.github.domain.api

import com.example.android.common.basenetworking.BaseResponse
import com.srdp.github.pojos.GitHubUser
import com.srdp.github.pojos.GithubUserResponseModel

interface GithubApiClient {

    suspend fun getUsersList(page: Int, pageSize: Int): BaseResponse<GithubUserResponseModel>

    suspend fun getUserInfo(username: String): BaseResponse<GitHubUser>
}