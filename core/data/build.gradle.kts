plugins {
    alias(libs.plugins.runningtracker.android.library)
    alias(libs.plugins.runningtracker.jvm.ktor)
}

android {
    namespace = "com.dsergei.core.data"
}

dependencies {
    implementation(libs.timber)
    implementation(libs.bundles.koin)

    implementation(projects.core.domain)
    implementation(projects.core.database)
}
