plugins {
    alias(libs.plugins.runningtracker.android.feature.ui)
}


android {
    namespace = "com.dsergei.run.presentation"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.run.domain)

    implementation(libs.coil.compose)
    implementation(libs.google.maps.android.compose)
    implementation(libs.timber)
}