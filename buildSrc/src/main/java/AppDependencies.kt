import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object AppDependencies {

    // Project Level
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val JETBRAINS_KOTLIN_ANDROID = "org.jetbrains.kotlin.android"
    const val JETBRAINS_KOTLIN_JVM = "org.jetbrains.kotlin.jvm"
    const val ANDROID_HILT = "com.google.dagger.hilt.android"
    const val PARCELIZE = "kotlin-parcelize"
    const val KAPT = "kapt"

    // Core
    private const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    private const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    private const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    private const val HILT = "com.google.dagger:hilt-android:${Versions.HILT}"
    private const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    private const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
    private const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"
    private const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    private const val RETROFIT_GSON_CONVERTER =
        "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    private const val GSON = "com.google.code.gson:gson:${Versions.GSON}"
    private const val COROUTINE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINE}"
    private const val LIFECYCLE_VIEW_MODEL =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
    private const val LIFECYCLE_EXTENSION =
        "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE}"
    private const val FRAGMENT = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT}"
    private const val HTTP_CLIENT = "com.squareup.okhttp3:okhttp:${Versions.HTTP_CLIENT}"
    private const val HTTP_CLIENT_LOG =
        "com.squareup.okhttp3:logging-interceptor:${Versions.HTTP_CLIENT}"
    private const val RECYCLER_VIEW =
        "androidx.recyclerview:recyclerview:${Versions.RECYCLER_VIEW}"

    // Unit Test
    private const val J_UNIT = "junit:junit:4.13.2:${Versions.J_UNIT}"

    // Instrument Test
    private const val J_UNIT_EXT = "androidx.test.ext:junit:${Versions.J_UNIT_EXT}"
    private const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"

    // Features
    private const val FEATURE_LANDING = ":features:landing"

    // Service
    private const val SERVICE_LANDING = ":services:landing"

    // Core
    private const val BASELINE = ":baseline"
    private const val CORE = ":core"
    private const val MODEL = ":models"

    val coreDependencies = listOf(
        CORE_KTX,
        HILT,
        APP_COMPAT,
        MATERIAL,
        GLIDE,
        RETROFIT,
        RETROFIT_GSON_CONVERTER,
        GSON,
        COROUTINE,
        LIFECYCLE_VIEW_MODEL,
        LIFECYCLE_EXTENSION,
        FRAGMENT,
        HTTP_CLIENT,
        HTTP_CLIENT_LOG,
        RECYCLER_VIEW,
    )

    val appDependencies = listOf(
        APP_COMPAT,
        MATERIAL,
        GLIDE,
        LIFECYCLE_VIEW_MODEL,
        LIFECYCLE_EXTENSION,
        FRAGMENT,
        RECYCLER_VIEW,
    )

    val testDependencies = listOf(
        J_UNIT,
    )

    val androidTestDependencies = listOf(
        J_UNIT_EXT,
        ESPRESSO,
    )

    val kaptDependencies = listOf(
        HILT_COMPILER,
        GLIDE_COMPILER,
    )

    val featureDependencies = listOf(
        APP_COMPAT,
        MATERIAL,
        GLIDE,
        COROUTINE,
        LIFECYCLE_VIEW_MODEL,
        LIFECYCLE_EXTENSION,
        FRAGMENT,
        RECYCLER_VIEW,
    )

    val serviceDependencies = listOf(
        RETROFIT,
        RETROFIT_GSON_CONVERTER,
        GSON,
        COROUTINE,
        HTTP_CLIENT,
        HTTP_CLIENT_LOG,
    )

    val appProjectDependencies = listOf(
        FEATURE_LANDING,
        CORE,
        MODEL,
        BASELINE,
    )

    val featureLandingProjectDependencies = listOf(
        CORE,
        MODEL,
        BASELINE,
        SERVICE_LANDING,
    )

    val serviceLandingProjectDependencies = listOf(
        CORE,
        MODEL,
        BASELINE,
    )

    val coreProjectDependencies = listOf(
        MODEL,
        BASELINE,
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