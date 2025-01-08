@file:Suppress("UnstableApiUsage")

import dz.nexatech.trila.AndroidBuild
import dz.nexatech.trila.GlobalBuild

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
}

kotlin {

    jvmToolchain {
        vendor = GlobalBuild.jvmVendor
        languageVersion = GlobalBuild.jvmVersion
    }

    androidLibrary {
        namespace = GlobalBuild.packageName
        compileSdk = AndroidBuild.compileSdk
        minSdk = AndroidBuild.minSdk

        withHostTestBuilder {
        }

        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = AndroidBuild.AndroidJUnitRunner
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    jvm()

    sourceSets {
        commonMain.dependencies {
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}