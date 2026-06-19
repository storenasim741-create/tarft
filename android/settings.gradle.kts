import java.util.Properties
import java.io.File

pluginManagement {
    val properties = Properties()
    val localPropertiesFile = File(settingsDir, "local.properties")

    if (localPropertiesFile.exists()) {
        localPropertiesFile.inputStream().use {
            properties.load(it)
        }
    }

    var flutterSdkPath = properties.getProperty("flutter.sdk")

    if (flutterSdkPath == null) {
        flutterSdkPath = System.getenv("FLUTTER_ROOT")
    }

    require(flutterSdkPath != null) {
        "Flutter SDK not found."
    }

    includeBuild("$flutterSdkPath/packages/flutter_tools/gradle")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("dev.flutter.flutter-plugin-loader") version "1.0.0"
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.22" apply false
    id("com.google.gms.google-services") version "4.4.0" apply false
}

include(":app")