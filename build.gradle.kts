plugins {
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.android.kotlin.multiplatform.library).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.composeMultiplatform).apply(false)
    alias(libs.plugins.kotlinCocoapods).apply(false)
    alias(libs.plugins.compose.compiler).apply(false)
    alias(libs.plugins.kotlinJvm).apply(false)
}

tasks.register<Delete>("clean") {
    delete(project.layout.buildDirectory)
}
