plugins {
    alias(libs.plugins.runningtracker.jvm.library)
}

dependencies {
    implementation(projects.core.domain)
}