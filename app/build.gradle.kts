plugins {

    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")

}

android {
    compileSdk = AppVersions.compileSDK

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = AppVersions.minSDK
        targetSdk = AppVersions.targetSDK
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }

        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
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
        jvmTarget = AppVersions.jvmTarget
    }


    defaultConfig {
        // Enabling multidex support.
        multiDexEnabled = true

    }

}


// to solve Expected @AndroidEntryPoint to have a value. Did you forget to apply the Gradle Plugin?

kapt {
    javacOptions {
        option("-Adagger.hilt.android.internal.disableAndroidSuperclassValidation=true")
    }
}


kapt {
    correctErrorTypes = true
}
dependencies {

    implementation(Libs.coreExt)
    implementation(Libs.appCompat)
    implementation(Libs.material)
    implementation(Libs.constraintLayout)
    implementation(Libs.legacySupport)
    testImplementation(TestLibs.junit)
    androidTestImplementation(TestLibs.junitExt)
    androidTestImplementation(TestLibs.espresso)

    //support multidex
    implementation(Libs.multidex)

    //Room
    implementation(Libs.roomVersion)
    kapt(Libs.roomCompiler)
    implementation(Libs.roomKtx)

    // design
    implementation(Libs.sdp)
    implementation(Libs.ssp)
    implementation(Libs.recyclerview)

    // coroutines
    implementation(Libs.coroutines)

    // viewmodel
    implementation(Libs.lifecycleViewModel)
    implementation(Libs.lifecycleRuntime)

    implementation(Libs.activityKtx)
    implementation(Libs.kotlinStdLib)
    implementation(Libs.coreExt)

    // nav lib
    implementation(Libs.navigationRuntime)
    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUi)

    //Dagger hilt
    implementation(Libs.hiltAndroid)
    kapt(Libs.hiltAndroidCompiler)

    // work manager
    implementation(Libs.workManagerRunTimeKtx)
    implementation(Libs.workManagerRunTime)
    implementation(Libs.workManagerStartupRuntime)
    implementation(Libs.hiltWorkManager)
    kapt(Libs.hiltKapt)

    // surface view
    implementation(Libs.surfaceView)
    // code scanner
    implementation(Libs.codeScanner)

    // DataStore
    implementation(Libs.dateStore)

    // permissions
    implementation(Libs.permissionx)

    // gson
    implementation(Libs.gson)


    // local unit testing
    testImplementation(TestLibs.googleTruth)
    // for InstantTaskExecutorRule
    testImplementation(TestLibs.archCoreTesting)
    testImplementation(TestLibs.coroutinesTest)
    testImplementation(TestLibs.mockito)
    testImplementation(TestLibs.powermockCore)
    testImplementation(TestLibs.powermockModuleTestng)
    testImplementation(TestLibs.powermockApiMockito2)
    testImplementation(TestLibs.mockitoCore)
    testImplementation(TestLibs.mockitoKotlin2)
    testImplementation(TestLibs.powermockInline)

    // Instrumented Unit Tests
    androidTestImplementation(TestLibs.archCoreTesting)
    androidTestImplementation(TestLibs.coroutinesTest)


}


