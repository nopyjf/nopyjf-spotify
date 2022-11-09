plugins {
    id(AppDependencies.ANDROID_LIBRARY)
    id(AppDependencies.JETBRAINS_KOTLIN_ANDROID)
}

android {
    namespace = AppConfig.MODEL_ID
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
}


dependencies {
    implementation(AppDependencies.coreDependencies)
}