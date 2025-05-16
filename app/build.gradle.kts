plugins {
    alias(libs.plugins.android.application)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.chatapp_mobile"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.chatapp_mobile"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.messaging)
    implementation(libs.firebase.firestore)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(platform(libs.firebase.bom))
    // Scalable Size Unit (support for different screen sizes)
    implementation(libs.sdp.android)
    implementation(libs.ssp.android)

    // Rounded ImageView
    implementation(libs.roundedimageview)

    // Multidex
    implementation(libs.multidex)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.scalars)
}
