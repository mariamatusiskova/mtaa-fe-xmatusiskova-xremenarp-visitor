package endpoints

import TokenManager
import endpoints.dto.requests.LoginRequest
import endpoints.dto.requests.SignupRequest
import endpoints.dto.responses.DetailResponse
import endpoints.dto.responses.GetAllPlacesResponse

interface IApiService {
    suspend fun apiGetAllPlaces(tokenManager: TokenManager): List<GetAllPlacesResponse>
    suspend fun postSignup(signupRequest: SignupRequest): DetailResponse? // could be null in case sth goes wrong
    suspend fun postLogin(loginRequest: LoginRequest): String?
}