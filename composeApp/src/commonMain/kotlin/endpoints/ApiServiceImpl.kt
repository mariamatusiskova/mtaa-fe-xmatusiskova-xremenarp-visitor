/**
 * The module for API requests.
 */

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
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject

/**
 * Implementation of [IApiService] responsible for making API calls using HttpClient.
 *
 * @property[client] The HttpClient (instance) used for making HTTP requests.
 */
class ApiServiceImpl(
    private val client: HttpClient
) : IApiService {

    /**
     * Registers a new user with POST request.
     *
     * @param[signupRequest] data class which contains user signup data.
     * @return A DetailResponse containing registration status and details, null if an error occurs.
     */
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

    /**
     * Logins user into app with his credentials by POST request.
     *
     * @param[loginRequest] data class which contains user login data.
     * @return A String containing jwt token of user, null if an error occurs.
     */
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

    /**
     * Retrieves all places from the server or client database by GET request.
     *
     * @param[tokenManager] TokenManager instance for authentication, where handles user's jwt token.
     * @return A SList<GetAllPlacesResponse> containing all retrieved places.
     */
    override suspend fun apiGetAllPlaces(tokenManager: TokenManager): List<GetAllPlacesResponse> {
        return try {
            runBlocking {
                val response: HttpResponse = client.get(HttpRoutes.SERVER_GET_ALL_PLACES) {
                    val token = tokenManager.getJwtToken()
                    if (!token.isNullOrBlank()) {
                        header(HttpHeaders.Authorization, "Bearer $token")
                    }
                }

                client.close()

                if (response.status.isSuccess()) {
                    val json = response.bodyAsText()
                    val jsonTree = Json.parseToJsonElement(json)
                    val itemsArray = jsonTree.jsonObject["items"]?.jsonArray

                    if (itemsArray != null) {
                        val placesList = mutableListOf<GetAllPlacesResponse>()
                        for (item in itemsArray) {
                            val place = Json.decodeFromJsonElement<GetAllPlacesResponse>(item)
                            placesList.add(place)
                        }
                        placesList
                    } else {
                        emptyList()
                    }
                } else {
                    emptyList()
                }
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

    /**
     * Updates the user's profile by sending a PATCH request.
     *
     * @param[tokenManager] TokenManager instance for authentication, where handles user's jwt token.
     * @param[editProfileRequest] The data class containing the edited profile data.
     * @return A DetailResponse indicating the result of the profile update, or null if an error occurs.
     */
    override suspend fun patchEditProfile(tokenManager: TokenManager, editProfileRequest: Any): DetailResponse? {
        return try {
            runBlocking {
                val response: HttpResponse = client.patch(HttpRoutes.EDIT_PROFILE) {
                    val token = tokenManager.getJwtToken()
                    if (!token.isNullOrBlank()) {
                        header(HttpHeaders.Authorization, "Bearer $token")
                    }
                    contentType(ContentType.Application.Json)
                    setBody(editProfileRequest)
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

    /**
     * Deletes the user account by sending a DELETE request.
     *
     * @param[tokenManager] The TokenManager used to manage JWT tokens for authorization.
     * @return A DetailResponse indicating the result of the account deletion, or null if an error occurs.
     */
    override suspend fun deleteAccount(tokenManager: TokenManager): DetailResponse? {
        return try {
            runBlocking {
                val response: HttpResponse = client.delete(HttpRoutes.DELETE_ACCOUNT) {
                    val token = tokenManager.getJwtToken()
                    if (!token.isNullOrBlank()) {
                        header(HttpHeaders.Authorization, "Bearer $token")
                    }
                }

                client.close()

                tokenManager.clearJwtToken()
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
}