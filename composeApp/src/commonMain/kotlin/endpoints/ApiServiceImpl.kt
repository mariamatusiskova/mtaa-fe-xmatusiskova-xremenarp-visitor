package endpoints

import TokenManager
import endpoints.dto.requests.LoginRequest
import endpoints.dto.requests.SignupRequest
import endpoints.dto.responses.DetailResponse
import endpoints.dto.responses.GetAllPlacesResponse
import endpoints.dto.responses.LoginResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

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

    override suspend fun postLogin(loginRequest: LoginRequest): String? {
        return try {
            runBlocking {

                val response: HttpResponse = client.post(HttpRoutes.LOGIN_POST) {
                    contentType(ContentType.Application.Json)
                    setBody(loginRequest)
                }

                val json = response.bodyAsText()
                val loginResponse = Json.decodeFromString<LoginResponse>(json)

                client.close()
                loginResponse.jwtToken
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

    override suspend fun apiGetAllPlaces(tokenManager: TokenManager): List<GetAllPlacesResponse> {
        return try {

            runBlocking {
                val response: HttpResponse = client.get(HttpRoutes.API_GET_ALL_PLACES) {

                    val token = tokenManager.getJwtToken()

                    if (!token.isNullOrBlank()) {
                        header(HttpHeaders.Authorization, "Bearer $token")
                    }
                }

                client.close()
                response.body() ?: emptyList()
            }
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