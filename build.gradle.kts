// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
  repositories {
    google()
    mavenCentral()
  }
  dependencies {
    classpath(libs.android.gradle)
    classpath(libs.kotlin.gradle)

    // NOTE: Do not place your application dependencies here; they belong
    // in the individual module build.gradle files
  }
}

tasks.create<Delete>("clean") {
  delete(rootProject.buildDir)
}
