import endpoints.IApiService

interface Platform {
    val name: String
    fun create(): IApiService
}

expect fun getPlatform(): Platform

expect fun saveJwtTokenAfterLogin(token: String)

expect class TokenManager {
    fun saveJwtToken(token: String)
    fun getJwtToken(): String?
    fun clearJwtToken()
}