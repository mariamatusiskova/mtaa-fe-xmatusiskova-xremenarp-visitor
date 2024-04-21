package endpoints

import endpoints.dto.DetailResponse
import endpoints.dto.LoginRequest
import endpoints.dto.SignupRequest

interface IApiService {
    suspend fun getPosts(): List<DetailResponse>
    suspend fun postSignup(signupRequest: SignupRequest): DetailResponse? // could be null in case sth goes wrong
    suspend fun postLogin(loginRequest: LoginRequest): DetailResponse?
}