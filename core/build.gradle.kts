plugins {
    id(AppDependencies.ANDROID_LIBRARY)
    id(AppDependencies.JETBRAINS_KOTLIN_ANDROID)
    id(AppDependencies.ANDROID_HILT)
    id(AppDependencies.PARCELIZE)
    kotlin(AppDependencies.KAPT)
}

android {
    namespace = AppConfig.CORE_ID
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK

        testInstrumentationRunner = AppConfig.INSTRUMENTATION_RUNNER
        consumerProguardFiles(AppConfig.PROGUARD_CONSUMER_RULES)
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

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(AppDependencies.coreDependencies)
    implementationProject(AppDependencies.coreProjectDependencies)
    kapt(AppDependencies.kaptDependencies)
}