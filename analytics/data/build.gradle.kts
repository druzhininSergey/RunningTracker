plugins {
    alias(libs.plugins.runningtracker.android.library)
}

android {
    namespace = "com.dsergei.analytics.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)

    implementation(projects.core.database)
    implementation(projects.core.domain)
    implementation(projects.analytics.domain)
}