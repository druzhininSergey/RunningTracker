plugins {
    alias(libs.plugins.runningtracker.android.library)
    alias(libs.plugins.runningtracker.android.room)
}

android {
    namespace = "com.dsergei.core.database"
}

dependencies {

    implementation(libs.bundles.koin)
    implementation(libs.org.mongodb.bson)
    implementation(projects.core.domain)
}