package com.omniwyse.github.di.vmmodules

import com.omniwyse.github.viewmodel.ActivityMainViewModel
import com.omniwyse.github.viewmodel.SingleUserViewModel
import com.omniwyse.github.viewmodel.UsersListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModules = module {

    viewModel {
        ActivityMainViewModel()
    }

    viewModel { UsersListViewModel(get()) }

    viewModel { SingleUserViewModel(get()) }
}