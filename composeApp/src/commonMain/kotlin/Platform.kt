import endpoints.IApiService

interface Platform {
    val name: String
    fun create(): IApiService
}

expect fun getPlatform(): Platform