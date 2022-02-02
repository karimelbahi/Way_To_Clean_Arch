
object Versions {
    val KOTLIN = "1.5.21"
    val COMPILE_SDK = 31
    val MIN_SDK_VERSION = 21
    val TARGET_SDK_VERSION = 31
    val VERSION_CODE = 1
    val VERSION_NAME = "1.0"
    val RXJAVA_VERSION = "2.2.13"
    val RX_ANDROID = "2.1.1"
    val GSON_VERSION = "2.8.7"
    val LIFE_CYCLE_VERSION = "2.2.0"
    val CONSTRAINT_LAYOUT = "2.1.3"
    val LEGACY_SUPPORT = "1.0.0"
    val ANDROID_GRADLE_VERSION = "4.0.1"
    val APP_COMPAT_VERSION = "1.4.1"
    val CORE_KTX = "1.7.0"
    val ARCH_CORE_TESTING_VER = "2.1.0"
    val TEST_RUNNER_VER = "1.1.0"
    val RULES_VER = "1.1.0"
    val TRUTH_VER = "1.1.0"
    val JUNIT_EXT_VER = "1.1.3"
    val MATERIAL_VERSION = "1.5.0"
    val MOCKITO = "3.11.2"
    val MOCKITO_CORE = "3.10.0"
    val MULTIDEX = "2.0.1"
    val JACOCO = "0.16.0"
    val HILT = "2.40.4"
    val HILT_COMPILER = "2.40.4"
    val FRAGMENT_KTX = "1.2.5"
    val RX_RETROFIT_ADAPTER = "2.6.1"
    val RETROFIT_VERSION = "2.7.1"
    val OKHTTP_LOGGING_INTERCEPTOR_VERSION = "3.12.1"
    val GSON_CONVERTER = "2.8.9"
    val ESPRESSO = "3.4.0"
    val TRUTH = "1.1.2"
    val COROUTINES_TEST = "1.6.0"
    val GOOGLE_MAP = "17.0.0"
    val LOCATION_SERVICES = "15.0.1"
    val TIMBER = "4.7.1"
    val PERMISSION_DISPATCHER = "4.8.0"
    val ROOM = "2.4.1"
    val SP_VERSION = "1.0.6"
    val RECYCLERVIEW_VERSION = "1.2.1"
    val COROUTINES_VERSION = "1.6.0"
    val VIEWMODEL_VERSION = "2.4.0"
    val NAVIGATION_VERSION = "2.3.5"
    val ACTIVTY_KTX = "1.4.0"
    val WORKMANAGER_RUMTIME = "2.7.1"
    val WORKMANAGER_STARTUP = "1.1.0"
    val WORKMANAGER_HILT = "1.0.0"
    val GMS_SERVICES_VISION = "20.1.3"
    val DATE_STORE = "1.2.0"
    val PERMISSIONX = "1.5.0"
    val CODE_SCANNER = "2.1.0"
    val POWERMOCK = "1.7.4"
    val MOCKITO_KOTLIN2 = "2.2.0"
    val MOCKITO_INLINE = "2.23.0"
}

object BuildPlugins {
    val androidGradle = "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_VERSION}"
    val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    val jacocoPlugin = "com.vanniktech:gradle-android-junit-jacoco-plugin:${Versions.JACOCO}"
    val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}"
}

object Android {
    val minSDK = Versions.MIN_SDK_VERSION
    val targetSDK = Versions.TARGET_SDK_VERSION
    val versionCode = Versions.VERSION_CODE
    val versionName = Versions.VERSION_NAME
    val compileSDK = Versions.COMPILE_SDK
    val applicationId = "com.example.task"
}

object Libs {
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"
    val rxVersion = "io.reactivex.rxjava2:rxjava:${Versions.RXJAVA_VERSION}"
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.RX_ANDROID}"
    val gson = "com.google.code.gson:gson:${Versions.GSON_VERSION}"

    val coreExt = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.APP_COMPAT_VERSION}"
    val material = "com.google.android.material:material:${Versions.MATERIAL_VERSION}"
    val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.LEGACY_SUPPORT}"
    val multidex = "androidx.multidex:multidex:${Versions.MULTIDEX}"
    val hiltAndroid = "com.google.dagger:hilt-android:${Versions.HILT}"
    val hiltAndroidCompiler = "com.google.dagger:hilt-compiler:${Versions.HILT_COMPILER}"
    val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
    val rxAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.RX_RETROFIT_ADAPTER}"
    val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP_LOGGING_INTERCEPTOR_VERSION}"
    val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.GSON_CONVERTER}"
    val googleMap = "com.google.android.gms:play-services-maps:${Versions.GOOGLE_MAP}"
    val locationServices =
        "com.google.android.gms:play-services-location:${Versions.LOCATION_SERVICES}"
    val timber = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    val permissionsDispatcher =
        "com.github.permissions-dispatcher:permissionsdispatcher:${Versions.PERMISSION_DISPATCHER}"
    val permissionsDispatcherProcessor =
        "com.github.permissions-dispatcher:permissionsdispatcher-processor:${Versions.PERMISSION_DISPATCHER}"
    val roomVersion = "androidx.room:room-runtime:${Versions.ROOM}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.ROOM}"
    val roomKtx = "androidx.room:room-ktx:${Versions.ROOM}"
    val sdp = "com.intuit.sdp:sdp-android:${Versions.SP_VERSION}"
    val ssp = "com.intuit.ssp:ssp-android:${Versions.SP_VERSION}"
    val recyclerview = "androidx.recyclerview:recyclerview:${Versions.RECYCLERVIEW_VERSION}"
    val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_VERSION}"
    val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.VIEWMODEL_VERSION}"
    val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.VIEWMODEL_VERSION}"
    val lifecycleLivedata =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFE_CYCLE_VERSION}"
    val navigationRuntime =
        "androidx.navigation:navigation-runtime-ktx:${Versions.NAVIGATION_VERSION}"
    val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION_VERSION}"
    val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION_VERSION}"
    val activityKtx = "androidx.activity:activity-ktx:${Versions.ACTIVTY_KTX}"
    val workManagerRunTimeKtx = "androidx.work:work-runtime-ktx:${Versions.WORKMANAGER_RUMTIME}"
    val workManagerRunTime = "androidx.work:work-runtime:${Versions.WORKMANAGER_RUMTIME}"
    val workManagerStartupRuntime =
        "androidx.startup:startup-runtime:${Versions.WORKMANAGER_STARTUP}"
    val hiltWorkManager = "androidx.hilt:hilt-work:${Versions.WORKMANAGER_HILT}"
    val hiltKapt = "androidx.hilt:hilt-compiler:${Versions.WORKMANAGER_HILT}"
    val surfaceView = "com.google.android.gms:play-services-vision:${Versions.GMS_SERVICES_VISION}"
    val dateStore = "androidx.preference:preference-ktx:${Versions.DATE_STORE}"
    val permissionx = "com.guolindev.permissionx:permissionx:${Versions.PERMISSIONX}"
    val codeScanner = "com.budiyev.android:code-scanner:${Versions.CODE_SCANNER}"


}

object TestLibs {
    val junit = "junit:junit:4.+"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    val googleTruth = "com.google.truth:truth:${Versions.TRUTH}"
    val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES_TEST}"
    val AndroidTruth = "androidx.test.ext:truth:${Versions.TRUTH_VER}"
    val archCoreTesting = "androidx.arch.core:core-testing:${Versions.ARCH_CORE_TESTING_VER}"
    val testRunner = "androidx.test:runner:${Versions.TEST_RUNNER_VER}"
    val rules = "androidx.test:rules:${Versions.RULES_VER}"
    val junitExt = "androidx.test.ext:junit:${Versions.JUNIT_EXT_VER}"
    val mockito = "org.mockito:mockito-core:${Versions.MOCKITO}"
    val powermockCore = "org.powermock:powermock-core:${Versions.POWERMOCK}"
    val powermockModuleTestng = "org.powermock:powermock-module-testng:${Versions.POWERMOCK}"
    val powermockApiMockito2= "org.powermock:powermock-api-mockito2:${Versions.POWERMOCK}"
    val mockitoKotlin2 = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.MOCKITO_KOTLIN2}"
    val powermockInline = "org.mockito:mockito-inline:${Versions.MOCKITO_INLINE}"
    val mockitoAndroid = "org.mockito:mockito-android:${Versions.MOCKITO}"
    val mockitoCore = "org.mockito:mockito-core:${Versions.MOCKITO_CORE}"

    // For instrumentation tests
    val hiltAndroidTest = "com.google.dagger:hilt-android-testing:${Versions.HILT}"
}