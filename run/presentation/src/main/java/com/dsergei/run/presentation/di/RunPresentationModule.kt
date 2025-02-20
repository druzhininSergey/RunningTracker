package com.dsergei.run.presentation.di

import com.dsergei.run.presentation.active_run.ActiveRunViewModel
import com.dsergei.run.presentation.run_overview.RunOverviewViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val runPresentationModule = module {
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}