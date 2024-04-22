import endpoints.IApiService

interface Platform {
    val name: String
    fun create(): IApiService
}

expect fun getPlatform(): Platform

interface TokenManager {
    fun saveJwtToken(token: String)
    fun getJwtToken(): String?
    fun clearJwtToken()
}

expect object TokenManagerProvider {
    fun provideTokenManager(context: Any): TokenManager
}