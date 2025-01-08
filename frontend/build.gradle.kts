@file:Suppress("UnstableApiUsage", "OPT_IN_USAGE")

import dz.nexatech.trila.AndroidBuild
import dz.nexatech.trila.FrontendBuild
import dz.nexatech.trila.GlobalBuild
import org.jetbrains.compose.resources.ResourcesExtension.ResourceClassGeneration


plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.kotlinCocoapods)
}

kotlin {

    jvmToolchain {
        vendor = FrontendBuild.jvmVendor
        languageVersion = FrontendBuild.jvmVersion
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

    jvm("desktop")

    cocoapods {
        version = GlobalBuild.versionName
        summary = "This lib contains the core Trila code, which is a Compose Multiplatform app " +
                "that is shared between all Trila clients: iOS, Android and Desktop)"
        homepage = "https://github.com/youcef-debbah/Trila"
        ios.deploymentTarget = "16.0"
        podfile = project.file("../iosTrila/Podfile")
        framework {
            baseName = "trila"
            isStatic = true
            transitiveExport = false
            export(projects.global)
        }
    }

    sourceSets {
        commonMain.configure {
            val composeResDirs = resources.srcDirs
                .map { it.absolutePath }
                .filter { it.endsWith("/resources") }
                .map { it.substring(0, it.length - 9) + "composeResources" }
            resources.srcDirs(composeResDirs)
        }
        commonMain.dependencies {
            api(projects.global)
            api(compose.runtime)
            api(compose.foundation)
            api(compose.material3)
            api(compose.ui)
            api(compose.components.resources)
            api(compose.components.uiToolingPreview)
            api(libs.androidx.lifecycle.viewmodel)
            api(libs.androidx.lifecycle.runtime.compose)
        }
        commonTest.dependencies {
            api(libs.kotlin.test)
        }
    }
}

compose.resources {
    this.packageOfResClass = GlobalBuild.packageName
    this.publicResClass = true
    this.generateResClass = ResourceClassGeneration.Always
}