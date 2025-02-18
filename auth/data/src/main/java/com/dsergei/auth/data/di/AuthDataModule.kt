package com.dsergei.auth.data.di

import com.dsergei.auth.data.AuthRepositoryImpl
import com.dsergei.auth.data.EmailPatternValidator
import com.dsergei.auth.domain.AuthRepository
import com.dsergei.auth.domain.PatternValidator
import com.dsergei.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}