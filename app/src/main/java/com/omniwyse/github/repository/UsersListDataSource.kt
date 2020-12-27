package com.omniwyse.github.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.example.android.common.basestate.BaseState
import com.omniwyse.github.domain.api.GithubApiClient
import com.omniwyse.github.pojos.GitHubUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class UsersListDataSource(private val githubApiClient: GithubApiClient): PageKeyedDataSource<Int, GitHubUser>() {

    private val dataSourceJob = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + dataSourceJob)
    val loadStateLiveData: MutableLiveData<BaseState> = MutableLiveData()
    val totalCount: MutableLiveData<Long> = MutableLiveData()

    companion object{
        const val PAGE_SIZE = 15
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, GitHubUser>) {
        scope.launch {
            loadStateLiveData.postValue(BaseState.LOADING)
            totalCount.postValue(0)

            val response = githubApiClient.getUsersList(1, PAGE_SIZE)
            when(response.BaseState) {
                BaseState.ERROR -> loadStateLiveData.postValue(BaseState.ERROR)
                BaseState.EMPTY -> loadStateLiveData.postValue(BaseState.EMPTY)
                else -> {
                    response.data?.let {
                        callback.onResult(it.items, null, 2)
                        loadStateLiveData.postValue(BaseState.SUCCESS)
                        totalCount.postValue(it.totalCount)
                    }
                }
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, GitHubUser>) {
        scope.launch {
            val response = githubApiClient.getUsersList(params.key, PAGE_SIZE)
            response.data?.let {
                callback.onResult(it.items, params.key + 1)
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, GitHubUser>) {

    }
}