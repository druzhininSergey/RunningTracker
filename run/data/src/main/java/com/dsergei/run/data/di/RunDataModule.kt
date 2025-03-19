package com.dsergei.run.data.di

import com.dsergei.run.data.CreateRunWorker
import com.dsergei.run.data.DeleteRunWorker
import com.dsergei.run.data.FetchRunsWorker
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)
}