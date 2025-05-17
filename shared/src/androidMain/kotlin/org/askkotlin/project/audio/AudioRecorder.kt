package org.askkotlin.project.audio

import android.content.Context
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

//actual class AudioRecorder(private val context: Context) {
//    private var audioRecord: AudioRecord? = null
//    private var isRecording = false
//
//    private val sampleRate = 44100
//    private val channelConfig = AudioFormat.CHANNEL_IN_MONO
//    private val audioFormat = AudioFormat.ENCODING_PCM_16BIT
//
//    actual suspend fun startRecording(durationMs: Int): ByteArray = withContext(Dispatchers.IO) {
//        val bufferSize = AudioRecord.getMinBufferSize(sampleRate, channelConfig, audioFormat)
//        val buffer = ByteArray(bufferSize)
//        val output = ByteArrayOutputStream()
//
//        audioRecord = AudioRecord(
//            MediaRecorder.AudioSource.MIC,
//            sampleRate,
//            channelConfig,
//            audioFormat,
//            bufferSize
//        )
//
//        audioRecord?.startRecording()
//        isRecording = true
//
//        val endTime = System.currentTimeMillis() + durationMs
//
//        while (isRecording && System.currentTimeMillis() < endTime) {
//            val read = audioRecord?.read(buffer, 0, bufferSize) ?: 0
//            if (read > 0) {
//                output.write(buffer, 0, read)
//            }
//        }
//
//        stopRecording()
//        return@withContext output.toByteArray()
//    }
//
//    actual fun stopRecording() {
//        isRecording = false
//        audioRecord?.stop()
//        audioRecord?.release()
//        audioRecord = null
//    }
//
//    actual suspend fun saveRecording(bytes: ByteArray, filename: String): File = withContext(
//        Dispatchers.IO) {
//        val file = File(context.cacheDir, filename)
//        FileOutputStream(file).use { it.write(bytes) }
//        return@withContext file
//    }
//}