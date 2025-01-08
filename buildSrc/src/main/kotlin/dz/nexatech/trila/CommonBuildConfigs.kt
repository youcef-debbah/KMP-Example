package dz.nexatech.trila

import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.jvm.toolchain.JvmVendorSpec
import kotlin.math.min

private val defaultVendor = JvmVendorSpec.AZUL

object AndroidBuild {
    val jvmVendor: JvmVendorSpec = defaultVendor

    val jvmVersion = JavaLanguageVersion.of(8)

    const val minSdk = 26
    const val compileSdk = 35

    const val AndroidJUnitRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object DesktopBuild {
    val jvmVendor: JvmVendorSpec = defaultVendor

    val jvmVersion = JavaLanguageVersion.of(21)
}

object FrontendBuild {
    val jvmVendor: JvmVendorSpec = defaultVendor

    val jvmVersion = JavaLanguageVersion.of(min(AndroidBuild.jvmVersion.asInt(), DesktopBuild.jvmVersion.asInt()))
}

object BackendBuild {
    val jvmVendor: JvmVendorSpec = defaultVendor

    val jvmVersion = JavaLanguageVersion.of(21)
}

object GlobalBuild {

    val jvmVendor: JvmVendorSpec = defaultVendor

    val jvmVersion = JavaLanguageVersion.of(min(FrontendBuild.jvmVersion.asInt(), BackendBuild.jvmVersion.asInt()))

    const val packageName = "dz.nexatech.trila"

    const val versionCode = 1

    const val versionName = "1.0.$versionCode"
}