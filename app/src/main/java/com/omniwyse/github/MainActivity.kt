package com.omniwyse.github

import androidx.databinding.ViewDataBinding
import com.example.android.common.baseapp.BaseActivity
import com.example.android.common.basestate.BaseState
import com.omniwyse.github.databinding.ActivityMainBinding
import com.omniwyse.github.viewmodel.ActivityMainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity :
    BaseActivity<ActivityMainBinding, ActivityMainViewModel>(R.layout.activity_main) {

    // comment by srdpatel: 12/3/2019 KOIN has special direction to inject viewModel to support view life cycle
    override val viewModel: ActivityMainViewModel by viewModel()

    private var dataBinding: ActivityMainBinding? = null

    override fun dataBinding(dataBinding: ViewDataBinding) {
        this.dataBinding = dataBinding as? ActivityMainBinding
    }

    override fun setObservers() {

    }

    override fun otherStuffs() {
        TODO("Not yet implemented")
    }

    override fun onIdle(baseState: BaseState) {
        TODO("Not yet implemented")
    }

    override fun onLoading(baseState: BaseState) {
        TODO("Not yet implemented")
    }

    override fun onFinished(baseState: BaseState) {
        TODO("Not yet implemented")
    }

    override fun onResult(result: BaseState) {
        TODO("Not yet implemented")
    }

}   