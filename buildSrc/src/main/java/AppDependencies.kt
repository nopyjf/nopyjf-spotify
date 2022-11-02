import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {

    // Project Level
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val JETBRAINS_KOTLIN_ANDROID = "org.jetbrains.kotlin.android"
    const val JETBRAINS_KOTLIN_JVM = "org.jetbrains.kotlin.jvm"

    // Core
    private const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    private const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    private const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"

    // Unit Test
    private const val J_UNIT = "junit:junit:4.13.2:${Versions.J_UNIT}"

    // Instrument Test
    private const val J_UNIT_EXT = "androidx.test.ext:junit:${Versions.J_UNIT_EXT}"
    private const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"

    val coreDependencies = listOf(
        CORE_KTX,
        APP_COMPAT,
        MATERIAL
    )

    val testDependencies = listOf(
        J_UNIT
    )

    val androidTestDependencies = listOf(
        J_UNIT_EXT,
        ESPRESSO
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