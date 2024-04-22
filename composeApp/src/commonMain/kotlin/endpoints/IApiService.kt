package endpoints

import endpoints.dto.requests.LoginRequest
import endpoints.dto.requests.SignupRequest
import endpoints.dto.responses.DetailResponse

interface IApiService {
    suspend fun getPosts(): List<DetailResponse>
    suspend fun postSignup(signupRequest: SignupRequest): DetailResponse? // could be null in case sth goes wrong
    suspend fun postLogin(loginRequest: LoginRequest): String?
}