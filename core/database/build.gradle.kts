plugins {
    alias(libs.plugins.runningtracker.android.library)
}

android {
    namespace = "com.dsergei.core.database"
}

dependencies {
    implementation(projects.core.domain)
    
    implementation(libs.org.mongodb.bson)
    implementation(libs.bundles.koin)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}