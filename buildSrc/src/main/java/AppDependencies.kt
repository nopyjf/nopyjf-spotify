import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object AppDependencies {

    // Project Level
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val JETBRAINS_KOTLIN_ANDROID = "org.jetbrains.kotlin.android"
    const val JETBRAINS_KOTLIN_JVM = "org.jetbrains.kotlin.jvm"
    const val ANDROID_HILT = "com.google.dagger.hilt.android"
    const val KAPT = "kapt"

    // Core
    private const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    private const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    private const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    private const val HILT = "com.google.dagger:hilt-android:${Versions.HILT}"
    private const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"

    // Unit Test
    private const val J_UNIT = "junit:junit:4.13.2:${Versions.J_UNIT}"

    // Instrument Test
    private const val J_UNIT_EXT = "androidx.test.ext:junit:${Versions.J_UNIT_EXT}"
    private const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"

    // Features
    const val FEATURE_LANDING = ":features:landing"

    val coreDependencies = listOf(
        CORE_KTX,
        HILT
    )

    val appDependencies = listOf(
        APP_COMPAT,
        MATERIAL,
    )

    val testDependencies = listOf(
        J_UNIT
    )

    val androidTestDependencies = listOf(
        J_UNIT_EXT,
        ESPRESSO
    )

    val kaptDependencies = listOf(
        HILT_COMPILER
    )

    val featureDependencies = listOf(
        APP_COMPAT,
        MATERIAL,
    )

    val appProjectDependencies = listOf(
        FEATURE_LANDING
    )
}

fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.implementationProject(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", project(dependency))
    }
}