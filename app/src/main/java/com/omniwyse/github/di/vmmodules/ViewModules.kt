package com.omniwyse.github.di.vmmodules

import com.omniwyse.github.viewmodel.ActivityMainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModules = module {

    viewModel {
        ActivityMainViewModel()
    }
}