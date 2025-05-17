package org.askkotlin.project.networking

import io.ktor.client.HttpClient
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import io.ktor.client.call.body
import io.ktor.client.request.forms.formData
import io.ktor.client.request.forms.submitFormWithBinaryData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiClient(private val baseUrl: String = "http://10.0.2.2:8080") {

//    private val client = HttpClient {
//        install(ContentNegotiation) {
//            json(Json {
//                prettyPrint = true
//                isLenient = true
//                ignoreUnknownKeys = true
//            })
//        }
//    }
//
//    suspend fun identifySong(audioBytes: ByteArray): Song {
//        val response = client.submitFormWithBinaryData(
//            url = "$baseUrl/identify",
//            formData = formData {
//                append("file", audioBytes, Headers.build {
//                    append(HttpHeaders.ContentDisposition, "filename=audio.mp3")
//                })
//            }
//        )
//
//        return response.body()
//    }

//    suspend fun searchSongs(query: String): List<SongResponse> {
//        val response = client.get("$baseUrl/search") {
//            parameter("q", query)
//        }
//
//        return response.body()
//    }

//    fun close() {
//        client.close()
//    }
}