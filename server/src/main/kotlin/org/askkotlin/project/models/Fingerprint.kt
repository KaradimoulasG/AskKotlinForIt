package org.askkotlin.project.models

import kotlinx.serialization.Serializable

@Serializable
data class Fingerprint(
    val id: Int,
    val songId: Int,
    val hash: String,
    val offset: Int
)

object Fingerprints : Table() {
    val id = integer("id").autoIncrement()
    val songId = integer("song_id").references(Songs.id)
    val hash = varchar("hash", 255)
    val offset = integer("offset")

    override val primaryKey = PrimaryKey(id)
}
