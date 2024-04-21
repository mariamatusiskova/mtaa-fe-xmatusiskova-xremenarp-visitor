package endpoints

import endpoints.dto.PostRequest
import endpoints.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.client.statement.readText
import io.ktor.http.*
import kotlinx.coroutines.runBlocking

class ApiServiceImpl(
    private val client: HttpClient
) : IApiService {
    override suspend fun getPosts(): List<PostResponse> {
        return try {
            client.get(HttpRoutes.POSTS).body()
        } catch (e: RedirectResponseException) {
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ClientRequestException) {
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ServerResponseException) {
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
    }

    override suspend fun createPost(postRequest: PostRequest): PostResponse? {
        return try {
            runBlocking {
                val response: HttpResponse = client.post(HttpRoutes.POSTS) {
                    contentType(ContentType.Application.Json)
                    setBody(postRequest)
                }
                val responseBody: String = response.bodyAsText()

                // Close the client here after receiving the response
                client.close()


                println("Response: $responseBody")

                // Return the response body
                response.body<PostResponse>()
            }

        } catch (e: RedirectResponseException) {
            println("Error: ${e.response.status.description}")
            null
        } catch (e: ClientRequestException) {
            println("Error: ${e.response.status.description}")
            null
        } catch (e: ServerResponseException) {
            println("Error: ${e.response.status.description}")
            null
        } catch (e: Exception) {
            println("Error: ${e.message}")
            null
        }
    }
}