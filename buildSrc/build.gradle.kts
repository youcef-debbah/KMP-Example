@file:Suppress("UnstableApiUsage")

plugins {
    `kotlin-dsl`
}

repositories {
    google {
        mavenContent {
            includeGroupAndSubgroups("androidx")
            includeGroupAndSubgroups("com.android")
            includeGroupAndSubgroups("com.google")
        }
    }
    mavenCentral()
}

java {
    toolchain {
        vendor = JvmVendorSpec.AZUL
        languageVersion = JavaLanguageVersion.of(21)
    }
}