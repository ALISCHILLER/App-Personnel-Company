import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(dependency.plugins.serialization)
    alias(dependency.plugins.ksp)
    alias(dependency.plugins.room)
    alias(libs.plugins.compose.compiler)
}

kotlin {

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    jvm("desktop")

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
            implementation(dependency.ktor.client.okhttp)
            implementation(dependency.kotlinx.coroutines.android)
            implementation(dependency.koin.android)
            implementation(dependency.coil.compose)
//            implementation("io.coil-kt.coil3:coil-compose:3.0.0-alpha06")

        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            //room
            implementation(dependency.room.runtime)
            implementation(dependency.sqlite.bundle)


            // precompose
            api(dependency.precompose)
            api(dependency.precompose.viewmodel)
            api(dependency.precompose.koin)

            // ktor
            implementation(dependency.ktor.client.core)
            implementation(dependency.ktor.negotiation)
            implementation(dependency.ktor.json)

            // coroutines
            implementation(dependency.kotlinx.coroutines.core)

            // koin
            implementation(dependency.koin.core)
            implementation(dependency.koin.compose)


            // datetime
            implementation(dependency.kotlinx.datetime)

            // log
            implementation(dependency.slf4j.api)
            implementation(dependency.logback.classic)


            // coil
            implementation(dependency.coil.compose)
            implementation(dependency.coil.network.ktor)
//            implementation("io.coil-kt.coil3:coil-compose:3.0.0-alpha06")
//            implementation("io.coil-kt.coil3:coil-network-ktor:3.0.0-alpha06")
//            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
//            implementation(dependency.coil.compose)
//            implementation(dependency.coil.compose.core)
//            implementation(dependency.coil.mp)
//            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
//            implementation(dependency.coil.network)

        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(dependency.ktor.client.cio)
            implementation(dependency.coil.compose)
//            implementation("io.coil-kt.coil3:coil-compose:3.0.0-alpha06")
        }
        iosMain.dependencies {
            // ktor
            implementation(dependency.ktor.client.darwin)
            implementation(dependency.coil.compose)
//            implementation("io.coil-kt.coil3:coil-compose:3.0.0-alpha06")
        }
    }

    task("testClasses")
}

android {
    namespace = "com.zarholding.zar"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "com.zarholding.zar"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}

room {
    schemaDirectory("$projectDir/schemas")
}

dependencies {
    ksp(dependency.room.compiler)
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb, TargetFormat.Exe)
            packageName = "zar"
            packageVersion = "1.0.0"
//./gradlew createDistributable
//            windows {
//                iconFile.set(project.file("src/desktopMain/resources/icon.ico"))
//            }
        }
    }
}
