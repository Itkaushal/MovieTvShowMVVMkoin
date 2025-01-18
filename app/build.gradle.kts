plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)

}

android {
    namespace = "com.app.kaushalprajapati.movieandshowsapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.app.kaushalprajapati.movieandshowsapp"
        minSdk = 26
        targetSdk = 35
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

    implementation ("androidx.navigation:navigation-compose:2.8.5")

    //core dependency
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Retrofit for networking
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // RxJava and RxKotlin
    implementation ("io.reactivex.rxjava3:rxjava:3.1.5")
    implementation ("io.reactivex.rxjava3:rxkotlin:3.0.1")
    implementation ("io.reactivex.rxjava3:rxandroid:3.0.2")


    // Retrofit adapter for RxJava3
    implementation ("com.squareup.retrofit2:adapter-rxjava3:2.9.0")

    // Koin for Dependency Injection
    implementation ("io.insert-koin:koin-android:3.4.2")
    implementation ("io.insert-koin:koin-androidx-compose:3.4.2")

    // Coil for image loading
    implementation ("io.coil-kt:coil-compose:2.4.0")
    implementation(libs.androidx.runtime.livedata)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.benchmark.common)

    implementation ("androidx.compose.ui:ui:1.4.3")
    implementation ("androidx.compose.material:material:1.4.3")
    implementation ("androidx.navigation:navigation-compose:2.5.3")

    // Compose Shimmer dependencies
    implementation ("com.valentinilk.shimmer:compose-shimmer:1.0.2")


    /* // Flow Layout
     implementation ("com.google.accompanist:accompanist-flowlayout:0.17.0")

     // KotlinX Serialization
     implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.*/


    //testing related
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}