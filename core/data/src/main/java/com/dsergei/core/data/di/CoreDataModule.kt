package com.dsergei.core.data.di

import com.dsergei.core.data.auth.EncryptedSessionStorage
import com.dsergei.core.data.networking.HttpClientFactory
import com.dsergei.core.data.run.OfflineFirstRunRepository
import com.dsergei.core.domain.SessionStorage
import com.dsergei.core.domain.run.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()

}