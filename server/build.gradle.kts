plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    application
    alias(libs.plugins.kotlin.plugin.serialization)
}

group = "org.askkotlin.project"
version = "1.0.0"
application {
    mainClass.set("org.askkotlin.project.ApplicationKt")
    
    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

dependencies {
    implementation(projects.shared)

    implementation(libs.ktor.server.host.common)
    implementation(libs.ktor.server.status.pages)
    implementation(libs.ktor.server.call.logging)
    implementation(libs.h2)
    implementation(libs.ktor.server.config.yaml)

    //Ktor Server
    implementation(libs.ktor.serverCore)
    implementation(libs.ktor.serverNetty)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.server.content.negotiation)

    //Database
    implementation(libs.exposed.core)
    implementation(libs.exposed.jdbc)
    implementation(libs.exposed.dao) //0.61.0
    implementation(libs.postgresql)
    implementation(libs.postgresql)
    implementation(libs.hikaricp)

    // Audio processing
    implementation(libs.jlayer)
    implementation(libs.commons.math3) // For the FFT I'm not going to reinvent the wheel


    // Logging
    implementation(libs.logback.classic.v147)

    //Tests
    testImplementation(libs.ktor.serverTestHost)
    testImplementation(libs.kotlin.testJunit)
}