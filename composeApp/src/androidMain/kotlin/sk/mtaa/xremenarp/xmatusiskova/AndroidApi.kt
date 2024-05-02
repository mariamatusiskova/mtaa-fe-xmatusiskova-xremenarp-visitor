/**
 * The module to handle API requests on Android platform.
 */

package sk.mtaa.xremenarp.xmatusiskova

import endpoints.ApiServiceImpl
import endpoints.IApiService
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import io.ktor.http.ContentType
import io.ktor.client.request.header
import io.ktor.client.request.accept
import kotlinx.serialization.ExperimentalSerializationApi

// https://rhythamnegi.com/http-request-with-ktor-client-jetpack-compose-android-project-example
/**
 * Singleton object for handling API service on Android platform.
 * It configures an HttpClient with necessary plugins and settings for making HTTP requests.
 */
object AndroidApi {

    /**
     * Implements [IApiService] suitable for Android platform.
     *
     * @return an instance of ApiService configured for Android.
     */
    fun create(): IApiService {
        return ApiServiceImpl(
            client = HttpClient(Android) {
            install(Logging) {
                level = LogLevel.ALL
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 15000L
                connectTimeoutMillis = 15000L
                socketTimeoutMillis = 15000L
            }
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        prettyPrint = true
                        isLenient = true
                        explicitNulls = false
                    }
                )
            }
            install(DefaultRequest) {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
        })

    }
}
//