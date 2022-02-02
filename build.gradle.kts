// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    val kotlin_version by extra( "1.5.21")
    val hilt_version by extra( "2.38.1")
    val dataStoreVersion by extra( "1.0.0-alpha02")
    val navigationVersion by extra( "2.3.1")

    repositories {
        google()
        mavenCentral()
        maven (url ="https://maven.google.com")


    }
    dependencies {
        classpath( "com.android.tools.build:gradle:7.0.0")
        classpath( "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath( "com.google.dagger:hilt-android-gradle-plugin:$hilt_version")
        classpath( "androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion")


        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}