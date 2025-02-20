plugins {
    alias(libs.plugins.runningtracker.android.library)
    alias(libs.plugins.runningtracker.jvm.ktor)
}


android {
    namespace = "com.dsergei.run.network"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
}