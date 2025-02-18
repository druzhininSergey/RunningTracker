package com.dsergei.auth.presentation.di

import com.dsergei.auth.presentation.login.LoginViewModel
import com.dsergei.auth.presentation.register.RegisterViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}