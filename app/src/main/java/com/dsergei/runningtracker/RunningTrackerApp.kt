package com.dsergei.runningtracker

import android.app.Application
import com.dsergei.auth.data.di.authDataModule
import com.dsergei.auth.presentation.di.authViewModelModule
import com.dsergei.core.data.di.coreDataModule
import com.dsergei.run.presentation.di.runPresentationModule
import com.dsergei.runningtracker.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RunningTrackerApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RunningTrackerApp)
            modules(
                appModule,
                authDataModule,
                authViewModelModule,
                coreDataModule,
                runPresentationModule
            )
        }
    }
}