// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(AppDependencies.ANDROID_APPLICATION) version Versions.ANDROID_VERSION apply false
    id(AppDependencies.ANDROID_LIBRARY) version Versions.ANDROID_VERSION apply false
    id(AppDependencies.JETBRAINS_KOTLIN_ANDROID) version Versions.JETBRAINS_VERSION apply false
    id(AppDependencies.JETBRAINS_KOTLIN_JVM) version Versions.JETBRAINS_VERSION apply false
    id(AppDependencies.ANDROID_HILT) version Versions.HILT apply false
}