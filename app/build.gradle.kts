plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    // Add the Google services Gradle plugin
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.nusa_guide"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.nusa_guide"
        minSdk = 29
        targetSdk = 34
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.firebase.crashlytics.buildtools)
    implementation(libs.androidx.runtime.livedata)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    //noinspection UseTomlInstead
    implementation(platform("com.google.firebase:firebase-bom:33.1.0"))
    //noinspection UseTomlInstead
    implementation("com.google.firebase:firebase-analytics")
    //noinspection UseTomlInstead
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    //noinspection UseTomlInstead
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.1")

    //noinspection UseTomlInstead
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.1")

    //noinspection UseTomlInstead
    implementation("androidx.compose.material:material:1.6.7")
    //noinspection UseTomlInstead
    implementation("com.google.android.material:material:1.12.0")

    // navigation compose
    //noinspection UseTomlInstead
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // viewModel
    //noinspection UseTomlInstead
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.1")

    // Coroutines
    //noinspection UseTomlInstead
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    //noinspection UseTomlInstead
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    //noinspection UseTomlInstead
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3")

    // Coil
    //noinspection UseTomlInstead
    implementation("io.coil-kt:coil-compose:2.4.0")

    //noinspection UseTomlInstead
    debugImplementation("androidx.compose.material:material-icons-extended")

    // Firebase Cloud Firestore
    //noinspection UseTomlInstead
    implementation("com.google.firebase:firebase-firestore-ktx:25.0.0")

    // Firebase Authentication
    //noinspection UseTomlInstead
    implementation("com.google.firebase:firebase-auth-ktx:23.0.0")
    // Firebase Storage
    //noinspection UseTomlInstead
    implementation("com.google.firebase:firebase-storage-ktx:21.0.0")

    //noinspection UseTomlInstead
    implementation("com.google.accompanist:accompanist-pager-indicators:0.14.0")
    //noinspection UseTomlInstead
    implementation("com.google.accompanist:accompanist-pager:0.14.0")

    //noinspection UseTomlInstead
    implementation("com.google.accompanist:accompanist-pager:0.28.0")
    //noinspection UseTomlInstead
    implementation("com.google.accompanist:accompanist-pager-indicators:0.28.0")
    //noinspection UseTomlInstead
    implementation("com.google.accompanist:accompanist-insets:0.23.0")
    //noinspection UseTomlInstead
    implementation("com.google.accompanist:accompanist-pager:0.24.13-rc")
    //noinspection UseTomlInstead
    implementation("com.google.accompanist:accompanist-pager-indicators:0.24.13-rc")
    //noinspection UseTomlInstead
    implementation ("com.google.accompanist:accompanist-flowlayout:0.23.0")


    // CAMERA X DEPENDECIES
    //noinspection UseTomlInstead
    implementation("androidx.camera:camera-core:1.3.3")
    //noinspection UseTomlInstead
    implementation("androidx.camera:camera-camera2:1.3.3")
    //noinspection UseTomlInstead
    implementation("androidx.camera:camera-lifecycle:1.3.3")
    //noinspection UseTomlInstead
    implementation("androidx.camera:camera-view:1.3.3")

}