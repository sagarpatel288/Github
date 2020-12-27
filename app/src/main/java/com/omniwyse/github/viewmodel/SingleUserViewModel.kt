package com.omniwyse.github.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android.common.basestate.BaseState
import com.example.android.common.baseviewmodels.BaseViewModel
import com.omniwyse.github.domain.api.GithubApiClient
import com.omniwyse.github.pojos.GitHubUser
import kotlinx.coroutines.launch

class SingleUserViewModel(private val githubApiClient: GithubApiClient) : BaseViewModel() {

    val isWaiting: ObservableField<Boolean> = ObservableField()
    val errorMessage: ObservableField<String> = ObservableField()
    val githubUserModel: ObservableField<GitHubUser> = ObservableField()
    val pageUrl: MutableLiveData<String> = MutableLiveData()

    init {
        isWaiting.set(true)
        errorMessage.set(null)
    }

    fun getUserInfoByUsername(username: String) {
        viewModelScope.launch {
            val result = githubApiClient.getUserInfo(username)
            if (result.BaseState == BaseState.SUCCESS) {
                githubUserModel.set(result.data)
                errorMessage.set(null)

            } else {
                githubUserModel.set(null)
                errorMessage.set(result.message)
            }

            isWaiting.set(false)
        }
    }

    fun openInBrowser(pageUrl: String?) {
        this.pageUrl.value = pageUrl
    }
}
