package com.dsergei.run.presentation.di

import com.dsergei.run.presentation.RunOverviewViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val runPresentationModule = module {
    viewModelOf(::RunOverviewViewModel)

}