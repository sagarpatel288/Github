package com.srdp.github.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.android.common.baseviewmodels.BaseViewModel
import com.srdp.github.pojos.GitHubUser
import com.srdp.github.repository.UsersListDataSource
import com.srdp.github.repository.UsersListDataSourceFactory
import java.util.concurrent.Executors

class UsersListViewModel(private val usersListDataSourceFactory: UsersListDataSourceFactory) : BaseViewModel() {

    var dataSource: MutableLiveData<UsersListDataSource>
    lateinit var usersLiveData: LiveData<PagedList<GitHubUser>>
    val isWaiting: ObservableField<Boolean> = ObservableField()
    val errorMessage: ObservableField<String> = ObservableField()
    val totalCount: ObservableField<Long> = ObservableField()

    fun getUserLiveData() = usersLiveData

    init {
        isWaiting.set(true)
        errorMessage.set(null)
        dataSource = usersListDataSourceFactory.liveData
        initUsersListFactory()
    }

    private fun initUsersListFactory() {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(UsersListDataSource.PAGE_SIZE)
            .setPageSize(UsersListDataSource.PAGE_SIZE)
            .setPrefetchDistance(3)
            .build()

        val executor = Executors.newFixedThreadPool(5)

        usersLiveData = LivePagedListBuilder<Int, GitHubUser>(usersListDataSourceFactory, config)
            .setFetchExecutor(executor)
            .build()
    }
}
