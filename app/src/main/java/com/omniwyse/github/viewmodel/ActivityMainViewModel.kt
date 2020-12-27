package com.omniwyse.github.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.android.common.basestate.BaseState
import com.example.android.common.baseviewmodels.BaseViewModel
import com.omniwyse.github.repository.Repository
import kotlinx.coroutines.launch
import org.koin.core.inject

class ActivityMainViewModel : BaseViewModel() {

    private val repository: Repository by inject()

    fun getUser() = viewModelScope.launch {
        state.value = BaseState.LOADING
        /*state.value = repository.getGitHubUserList()*/
    }
}