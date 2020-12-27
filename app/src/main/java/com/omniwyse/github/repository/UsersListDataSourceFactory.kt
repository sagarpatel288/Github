package com.omniwyse.github.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.omniwyse.github.domain.api.GithubApiClient
import com.omniwyse.github.pojos.GitHubUser

class UsersListDataSourceFactory(private val githubApiClient: GithubApiClient): DataSource.Factory<Int, GitHubUser>() {

    val liveData: MutableLiveData<UsersListDataSource> = MutableLiveData()

    override fun create(): DataSource<Int, GitHubUser> {
        val usersListDataSource = UsersListDataSource(githubApiClient)
        liveData.postValue(usersListDataSource)
        return usersListDataSource
    }
}