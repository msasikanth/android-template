plugins {
  id("com.android.application")
  id("kotlin-android")
}

android {
  compileSdk = 31

  defaultConfig {
    applicationId = "dev.sasikanth.template.android"
    minSdk = 23
    targetSdk = 31
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = libs.versions.compose.get()
  }
  packagingOptions {
    resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
  }
}

dependencies {
  debugImplementation(libs.compose.ui.tooling)

  implementation(libs.appcompat)
  implementation(libs.bundles.compose)
  implementation(libs.bundles.mobius)
  implementation(libs.core)
  implementation(libs.lifecycle.runtime)
  implementation(libs.material)

  testImplementation(libs.junit)
  testImplementation(libs.mobius.test)

  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.compose.ui.test)
  androidTestImplementation(libs.espresso)
}
