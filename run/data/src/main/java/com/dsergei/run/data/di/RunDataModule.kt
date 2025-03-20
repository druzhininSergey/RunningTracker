package com.dsergei.run.data.di

import com.dsergei.core.domain.run.SyncRunScheduler
import com.dsergei.run.data.CreateRunWorker
import com.dsergei.run.data.DeleteRunWorker
import com.dsergei.run.data.FetchRunsWorker
import com.dsergei.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}