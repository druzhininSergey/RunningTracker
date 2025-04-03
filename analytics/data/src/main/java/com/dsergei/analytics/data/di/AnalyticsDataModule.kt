package com.dsergei.analytics.data.di

import com.dsergei.analytics.data.RoomAnalyticsRepository
import com.dsergei.analytics.domain.AnalyticsRepository
import com.dsergei.core.database.RunDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
    single {
        get<RunDatabase>().analyticsDao
    }
}