import dz.nexatech.trila.AndroidBuild
import dz.nexatech.trila.GlobalBuild

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.compose.compiler)
}

android {

    kotlin {
        jvmToolchain {
            vendor = AndroidBuild.jvmVendor
            languageVersion = AndroidBuild.jvmVersion
        }
    }

    namespace = GlobalBuild.packageName
    compileSdk = AndroidBuild.compileSdk

    defaultConfig {
        applicationId = GlobalBuild.packageName
        minSdk = AndroidBuild.minSdk
        targetSdk = AndroidBuild.compileSdk
        versionCode = GlobalBuild.versionCode
        versionName = GlobalBuild.versionName
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {

        debug {
            this.isMinifyEnabled = false
            this.isShrinkResources = false

            this.isDebuggable = true
            this.isProfileable = false
            this.isCrunchPngs = false
            this.isEmbedMicroApp = false
            this.isDefault = true
        }

        release {
            this.isMinifyEnabled = true
            this.isShrinkResources = true

            this.isDebuggable = false
            this.isProfileable = true
            this.isCrunchPngs = false
            this.isEmbedMicroApp = false
            this.isDefault = false
        }
    }
}

dependencies {
    implementation(projects.frontend)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.compose.foundation)
    implementation(libs.androidx.activity.compose)
    debugImplementation(libs.compose.ui.tooling)
}