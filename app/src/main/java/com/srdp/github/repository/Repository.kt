package com.srdp.github.repository

import com.example.android.common.baserepository.BaseRepository
import com.srdp.github.api.GitHubApi
import org.koin.core.KoinComponent
import org.koin.core.inject

class Repository : BaseRepository(), KoinComponent {

    private val apiService: GitHubApi by inject()

    suspend fun getGitHubUserList(since: Int, itemsPerPage: Int) = safeApiCall {
        apiService.getUsersList(since, itemsPerPage)
    }
}