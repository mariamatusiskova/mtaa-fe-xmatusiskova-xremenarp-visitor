package endpoints

import endpoints.dto.responses.DetailResponse
import endpoints.dto.requests.LoginRequest
import endpoints.dto.requests.SignupRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.runBlocking

class ApiServiceImpl(
    private val client: HttpClient
) : IApiService {

    override suspend fun postSignup(signupRequest: SignupRequest): DetailResponse? {
        return try {
            runBlocking {
                val response: HttpResponse = client.post(HttpRoutes.SIGNUP_POST) {
                    contentType(ContentType.Application.Json)
                    setBody(signupRequest)
                }

                client.close()
                response.body<DetailResponse>()
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

    override suspend fun postLogin(loginRequest: LoginRequest): DetailResponse? {
        return try {
            runBlocking {
                val response: HttpResponse = client.post(HttpRoutes.LOGIN_POST) {
                    contentType(ContentType.Application.Json)
                    setBody(loginRequest)
                }

                client.close()
                response.body<DetailResponse>()
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

    override suspend fun getPosts(): List<DetailResponse> {
        return try {
            client.get(HttpRoutes.SIGNUP_POST).body()
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
}