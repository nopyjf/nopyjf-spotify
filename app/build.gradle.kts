plugins {
    id(AppDependencies.ANDROID_APPLICATION)
    id(AppDependencies.JETBRAINS_KOTLIN_ANDROID)
}

android {
    namespace = AppConfig.APPLICATION_ID
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        applicationId = AppConfig.APPLICATION_ID
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK

        versionCode = Versions.CODE_VERSION
        versionName = Versions.VERSION_NAME

        testInstrumentationRunner = AppConfig.INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName(AppConfig.RELEASE) {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(AppConfig.PROGUARD_TXT),
                AppConfig.PROGUARD_RULES
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = Versions.JVM_TARGET
    }
}

dependencies {
    implementation(AppDependencies.coreDependencies)
    testImplementation(AppDependencies.testDependencies)
    androidTestImplementation(AppDependencies.androidTestDependencies)
}