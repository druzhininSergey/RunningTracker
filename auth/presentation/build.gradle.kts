plugins {
    alias(libs.plugins.runningtracker.android.feature.ui)
}

android {
    namespace = "com.dsergei.auth.presentation"
}

dependencies {
    implementation(projects.auth.domain)
    implementation(projects.core.domain)
}