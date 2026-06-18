
plugins {
id("com.google.gms.google-services") version "4.4.0" apply false
}

allprojects {
repositories {
google()
mavenCentral()
}
}

val newBuildDir = rootProject.layout.buildDirectory.dir("../build").get()

rootProject.layout.buildDirectory.set(newBuildDir)

subprojects {
layout.buildDirectory.set(
newBuildDir.dir(name)
)
}

subprojects {
evaluationDependsOn(":app")
}

tasks.register<Delete>("clean") {
delete(rootProject.layout.buildDirectory)
}
