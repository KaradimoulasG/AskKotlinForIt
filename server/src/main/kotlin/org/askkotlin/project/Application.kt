package org.askkotlin.project

import com.example.misc.configureDatabases
import com.example.misc.configureMonitoring
import com.example.misc.configureSerialization
import com.example.routes.configureRouting
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json

fun main() {
    embeddedServer(Netty, port = SERVER_PORT, host = HOST_NUM) {
        module()
    }.start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
        })
    }

    configureMonitoring()
    configureSerialization()
    configureDatabases()
    configureRouting()
}