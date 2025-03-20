plugins {
    alias(libs.plugins.runningtracker.android.feature.ui)
}

android {
    namespace = "com.dsergei.analytics.presentation"
}

dependencies {
    implementation(projects.analytics.domain)
}