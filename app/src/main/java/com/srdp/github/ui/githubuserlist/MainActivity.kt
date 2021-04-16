package com.srdp.github.ui.githubuserlist

import android.content.Intent
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Transformations
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.common.baseconstants.PARCEL
import com.example.android.common.basestate.BaseState
import com.srdp.github.R
import com.srdp.github.base.BaseActivity
import com.srdp.github.databinding.ActivityMainBinding
import com.srdp.github.pojos.GitHubUser
import com.srdp.github.ui.userprofile.DetailActivity
import com.srdp.github.viewmodel.UsersListViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity :
    BaseActivity<ActivityMainBinding, UsersListViewModel>(R.layout.activity_main),
    UsersListAdapter.UsersListAdapterInteraction {

    // comment by srdpatel: 12/3/2019 KOIN has special direction to inject viewModel to support view life cycle
    override val viewModel: UsersListViewModel by viewModel()

    private lateinit var listView: RecyclerView
    private lateinit var usersListAdapter: UsersListAdapter
    private lateinit var dataBinding: ActivityMainBinding

    override fun dataBinding(dataBinding: ViewDataBinding) {
        this.dataBinding = dataBinding as ActivityMainBinding
    }

    override fun beforeObserver() {
        setListView()
        if (hasInternet()) {
            setObservers()
        } else {
            showNoInternetUi()
        }
        dataBinding.btnToggl.setOnClickListener { view -> onClickToggle(view) }
    }

    override fun onNetworkStateChange(hasInternet: Boolean) {
        super.onNetworkStateChange(hasInternet)
        if (!hasInternet) {
            showNoInternetUi()
        } else {
            showDataUi()
        }
    }

    private fun showDataUi() {
        dataBinding.layNoDataContainer.visibility = View.GONE
    }

    private fun showNoInternetUi() {
        dataBinding.layNoDataContainer.visibility = View.VISIBLE
        dataBinding.includeNoData.viewTvNoDataTitle.text = getString(R.string.com_st_error_aw_snap)
        dataBinding.includeNoData.viewTvNoDataSubTitle.text = getString(R.string.com_st_no_internet)
    }

    override fun setObservers() {
        Transformations.switchMap(viewModel.dataSource) { dataSource -> dataSource.loadStateLiveData }
            .observe(this, {
                when (it) {
                    BaseState.LOADING -> {
                        viewModel.isWaiting.set(true)
                        viewModel.errorMessage.set(null)
                        dataBinding.btnToggl.visibility = View.GONE
                    }
                    BaseState.SUCCESS -> {
                        viewModel.isWaiting.set(false)
                        viewModel.errorMessage.set(null)
                        dataBinding.btnToggl.visibility = View.VISIBLE
                    }
                    BaseState.EMPTY -> {
                        viewModel.isWaiting.set(false)
                        viewModel.errorMessage.set(getString(R.string.com_st_error_empty_data))
                        dataBinding.btnToggl.visibility = View.GONE
                        retry()
                    }
                    else -> {
                        viewModel.isWaiting.set(false)
                        viewModel.errorMessage.set(getString(R.string.com_st_error_something_went_wrong))
                        dataBinding.btnToggl.visibility = View.GONE
                        retry()
                    }
                }
            })

        Transformations.switchMap(viewModel.dataSource) { dataSource -> dataSource.totalCount }
            .observe(this, { totalCount ->
                totalCount?.let { viewModel.totalCount.set(it) }
            })

        viewModel.usersLiveData.observe(this, {
            dataBinding.btnToggl.visibility = if (it.size > 0) View.VISIBLE else View.GONE
            usersListAdapter.submitList(it)
        })
    }

    private fun retry() {

    }

    private fun setListView() {
        listView = dataBinding.viewRvUserList
        usersListAdapter = UsersListAdapter(this)
        listView.layoutManager = LinearLayoutManager(this)
        listView.adapter = usersListAdapter
    }

    override fun onUserItemClick(gitHubUser: GitHubUser) {
        var intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(PARCEL, gitHubUser.login)
        startActivity(intent)
    }

    fun onClickToggle(view: View) {
        if (listView.layoutManager is GridLayoutManager) {
            listView.layoutManager = LinearLayoutManager(this)
        } else if (listView.layoutManager is LinearLayoutManager) {
            listView.layoutManager = GridLayoutManager(this, 2)
        }
        listView.adapter = usersListAdapter
    }
}   