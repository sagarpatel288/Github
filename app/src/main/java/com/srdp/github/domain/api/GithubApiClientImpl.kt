package com.srdp.github.domain.api

import com.example.android.common.basenetworking.BaseResponse
import com.example.android.common.basenetworking.BaseResponseHandler
import com.srdp.github.api.GitHubApi
import com.srdp.github.pojos.GitHubUser
import com.srdp.github.pojos.GithubUserResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

class GithubApiClientImpl(private val githubApi: GitHubApi) : GithubApiClient, KoinComponent {

    private val baseResponseHandler: BaseResponseHandler by inject()

    override suspend fun getUsersList(
        page: Int,
        pageSize: Int
    ): BaseResponse<GithubUserResponseModel> = withContext(Dispatchers.IO) {
        try {
            val response = githubApi.getUsersList(page, pageSize)
            if (response.isSuccessful) {
                BaseResponse.success(response.body())
            } else {
                BaseResponse.error(false, response.code(), response.message(), response.errorBody())
            }
        } catch (throwable: Throwable) {
            baseResponseHandler.handleException(throwable)
        }
    }

    override suspend fun getUserInfo(username: String): BaseResponse<GitHubUser> =
        withContext(Dispatchers.IO) {
            try {
                val response = githubApi.getUserInfo(username)
                if (response.isSuccessful) {
                    BaseResponse.success(response.body())
                } else {
                    BaseResponse.error(
                        false,
                        response.code(),
                        response.message(),
                        response.errorBody()
                    )
                }
            } catch (throwable: Throwable) {
                baseResponseHandler.handleException(throwable)
            }
        }
}