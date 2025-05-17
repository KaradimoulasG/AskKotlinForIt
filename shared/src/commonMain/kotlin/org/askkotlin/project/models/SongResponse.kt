package org.askkotlin.project.models

import kotlinx.serialization.Serializable

@Serializable
data class SongResponse(
    val id: Int,
    val title: String,
    val artist: String,
    val album: String? = null,
    val releaseYear: Int? = null,
    val confidence: Double? = null
)
