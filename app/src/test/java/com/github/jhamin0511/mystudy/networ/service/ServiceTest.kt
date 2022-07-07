package com.github.jhamin0511.mystudy.networ.service

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import java.net.HttpURLConnection
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import okio.buffer
import okio.source
import org.junit.Before
import org.junit.Rule
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class ServiceTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mockWebServer: MockWebServer = MockWebServer()

    lateinit var retrofit: Retrofit

    @Before
    internal open fun setUp() {
        val client = OkHttpClient.Builder().apply {
        }.build()

        retrofit = Retrofit.Builder().apply {
            client(client)
            baseUrl(mockWebServer.url("/"))
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }

    @Before
    internal fun tearDown() {
        mockWebServer.shutdown()
    }

    private fun loadFile(fileName: String): String {
        val name = if (fileName.contains(".json")) {
            fileName
        } else {
            "$fileName.json"
        }
        val inputStream = javaClass.classLoader!!.getResourceAsStream("api-response/$name")
        val source = inputStream.source().buffer()

        return source.readString(Charsets.UTF_8)
    }

    private fun create(
        fileName: String,
        headers: Map<String, String> = emptyMap()
    ): MockResponse {
        val body = loadFile(fileName)
        val mockResponse = MockResponse()
        for ((key, value) in headers) {
            mockResponse.addHeader(key, value)
        }

        return mockResponse.setBody(body)
    }

    protected fun success(
        fileName: String,
        headers: Map<String, String> = emptyMap()
    ): MockResponse {
        return create(fileName, headers)
            .setResponseCode(HttpURLConnection.HTTP_OK)
    }

    protected fun failure(
        fileName: String,
        headers: Map<String, String> = emptyMap()
    ): MockResponse {
        return create(fileName, headers)
            .setResponseCode(HttpURLConnection.HTTP_INTERNAL_ERROR)
    }

    protected fun requestBody(
        fileName: String
    ): JsonObject {
        val jsonString = loadFile(fileName)

        return JsonParser().parse(jsonString).asJsonObject
    }

    protected fun requestBody(request: RecordedRequest): JsonObject {
        return JsonParser().parse(request.body.readUtf8()).asJsonObject
    }
}
