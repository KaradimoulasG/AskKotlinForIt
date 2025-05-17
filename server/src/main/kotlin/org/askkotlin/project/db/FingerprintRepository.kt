package com.example.db

import org.askkotlin.project.models.Fingerprint
import org.askkotlin.project.models.Fingerprints
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder
import org.jetbrains.exposed.sql.batchInsert
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select

class FingerprintRepository {
    suspend fun create(fingerprint: Fingerprint): Fingerprint {
        var id = 0
        DatabaseFactory.dbQuery {
            id = Fingerprints.insert {
                it[songId] = fingerprint.songId
                it[hash] = fingerprint.hash
                it[offset] = fingerprint.offset
            }[Fingerprints.id]
        }
        return fingerprint.copy(id = id)
    }

    suspend fun createBatch(fingerprints: List<Fingerprint>) {
        DatabaseFactory.dbQuery {
            Fingerprints.batchInsert(fingerprints) { fingerprint ->
                this[Fingerprints.songId] = fingerprint.songId
                this[Fingerprints.hash] = fingerprint.hash
                this[Fingerprints.offset] = fingerprint.offset
            }
        }
    }

    suspend fun findMatchesByHashes(hashes: List<String>): Map<Int, List<Pair<String, Int>>> {
        println("Hashes = $hashes, type = ${hashes::class}")

        return DatabaseFactory.dbQuery {
            val results = Fingerprints.select {
                with(SqlExpressionBuilder) {
                    Fingerprints.hash.inList(hashes)
                }
            }.map {
                Triple(
                    it[Fingerprints.songId],
                    it[Fingerprints.hash],
                    it[Fingerprints.offset]
                )
            }

            results.groupBy(
                { it.first },
                { Pair(it.second, it.third) }
            )
        }
    }


    private fun toFingerprint(row: ResultRow): Fingerprint =
        Fingerprint(
            id = row[Fingerprints.id],
            songId = row[Fingerprints.songId],
            hash = row[Fingerprints.hash],
            offset = row[Fingerprints.offset]
        )
}