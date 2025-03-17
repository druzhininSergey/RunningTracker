package com.dsergei.run.network.di

import com.dsergei.core.domain.run.RemoteRunDataSource
import com.dsergei.run.network.KtorRemoteRunDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::KtorRemoteRunDataSource).bind<RemoteRunDataSource>()
}