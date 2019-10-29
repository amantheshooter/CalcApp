package com.sample.mynewapplication

import com.sample.mynewapplication.retrofit.APIClient
import com.sample.mynewapplication.retrofit.ApiInterface
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import java.util.concurrent.TimeUnit
import okhttp3.mockwebserver.MockResponse
import okhttp3.HttpUrl
import okhttp3.mockwebserver.RecordedRequest
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit


/**
 * ResultModel local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Rule
    @JvmField
    var server = MockWebServer()

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    private lateinit var apiService: APIClient

    @Before
    fun setup() {
        server.start()

        apiService = Retrofit.Builder()
            .baseUrl(server.url("/"))
            .build()
            .create(APIClient::class.java)
    }

    @After
    fun teardown() {
        server.shutdown()
    }
    @Test
    fun test(){
        server.enqueue(MockResponse().setBody("hello, world!"))
        // Start the server.
        server.start();

        // Ask the server for its URL. You'll need this to make HTTP requests.
        val baseUrl = server.url("https://c8r.azurewebsites.net")

        // Exercise your application code, which should make those HTTP requests.
        // Responses are returned in the same order that they are enqueued.
        val request1 = server.takeRequest()
        assertEquals("/api/add?code=aKHx1nNzQpgy9WXzNOJnJR4a/KpX05PTepvQeCvoq7CbanG84Ng81A==", request1.path)
        assertNotNull(request1.getHeader("Authorization"))

        // Ask the server for its URL. You'll need this to make HTTP requests.
        server.shutdown();
    }

    @Test
    fun defaultMockResponse() {
        val response = MockResponse()
            .addHeader("Content-Type", "application/json; charset=utf-8")
            .addHeader("Postman-Token", "8f9e63b9-1409-5e1e-bbc1-7c00b7f3b886")
            .addHeader("Cache-Control", "no-cache")
            .setBody("[1,2]")

        response.throttleBody(1024, 1, TimeUnit.SECONDS);

    }
}