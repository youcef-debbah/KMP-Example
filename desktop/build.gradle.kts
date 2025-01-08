import dz.nexatech.trila.DesktopBuild
import dz.nexatech.trila.GlobalBuild
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.compose.resources.ResourcesExtension.ResourceClassGeneration

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.compose.compiler)
}

kotlin {

    jvmToolchain {
        vendor = DesktopBuild.jvmVendor
        languageVersion = DesktopBuild.jvmVersion
    }

    jvm("desktop")

    sourceSets {
        val desktopMain by getting
        desktopMain.dependencies {
            implementation(projects.frontend)
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
        }
    }
}

compose.resources {
    this.packageOfResClass = GlobalBuild.packageName
    this.publicResClass = false
    this.generateResClass = ResourceClassGeneration.Never
}

compose.desktop {
    application {
        mainClass = GlobalBuild.packageName + ".MainWindowKt"
        jvmArgs("-XX:+AllowEnhancedClassRedefinition")

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi)
            packageName = GlobalBuild.packageName
            packageVersion = GlobalBuild.versionName
        }
    }
}