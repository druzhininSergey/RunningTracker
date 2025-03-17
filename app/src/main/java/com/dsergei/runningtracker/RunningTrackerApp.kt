package com.dsergei.runningtracker

import android.app.Application
import com.dsergei.auth.data.di.authDataModule
import com.dsergei.auth.presentation.di.authViewModelModule
import com.dsergei.core.data.di.coreDataModule
import com.dsergei.core.database.di.databaseModule
import com.dsergei.run.location.di.locationModule
import com.dsergei.run.network.di.networkModule
import com.dsergei.run.presentation.di.runPresentationModule
import com.dsergei.runningtracker.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RunningTrackerApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

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
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule,

                )
        }
    }
}