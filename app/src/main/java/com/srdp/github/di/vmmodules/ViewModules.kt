package com.srdp.github.di.vmmodules

import com.srdp.github.viewmodel.ActivityMainViewModel
import com.srdp.github.viewmodel.SingleUserViewModel
import com.srdp.github.viewmodel.UsersListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModules = module {

    viewModel {
        ActivityMainViewModel()
    }

    viewModel { UsersListViewModel(get()) }

    viewModel { SingleUserViewModel(get()) }
}