import dz.nexatech.trila.BackendBuild
import dz.nexatech.trila.GlobalBuild

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    application
}

group = GlobalBuild.packageName
version = GlobalBuild.versionName

application {
    mainClass.set(GlobalBuild.packageName + ".MainServerKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}")
}

java {
    toolchain {
        vendor = BackendBuild.jvmVendor
        languageVersion = BackendBuild.jvmVersion
    }
}

ktor {
    fatJar {
        archiveFileName.set("trila-server-$version.jar")
    }
}

dependencies {
    implementation(projects.global)
    implementation(libs.logback)
    implementation(libs.ktor.server.netty)
//    testImplementation(libs.ktor.server.tests)
//    testImplementation(libs.kotlin.test.junit)
}

tasks {
    register("stage") {
        dependsOn("installDist")
    }
}