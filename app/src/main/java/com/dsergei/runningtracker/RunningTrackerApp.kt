package com.dsergei.runningtracker

import android.app.Application
import android.content.Context
import com.dsergei.auth.data.di.authDataModule
import com.dsergei.auth.presentation.di.authViewModelModule
import com.dsergei.core.data.di.coreDataModule
import com.dsergei.core.database.di.databaseModule
import com.dsergei.run.data.di.runDataModule
import com.dsergei.run.location.di.locationModule
import com.dsergei.run.network.di.networkModule
import com.dsergei.run.presentation.di.runPresentationModule
import com.dsergei.runningtracker.di.appModule
import com.google.android.play.core.splitcompat.SplitCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
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
            workManagerFactory()

            modules(
                appModule,
                authDataModule,
                authViewModelModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule,
                runDataModule
                )
        }
    }
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}