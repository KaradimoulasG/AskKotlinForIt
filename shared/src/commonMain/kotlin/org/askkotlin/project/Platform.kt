package org.askkotlin.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform