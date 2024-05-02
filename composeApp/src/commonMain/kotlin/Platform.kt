/**
 * Defines the Platform interface, representing a platform for creating API services.
 * Also TokenManager interface for handling jwt token.
 */
import endpoints.IApiService

interface Platform {
    /**
     * Name of the platform.
     */
    val name: String

    /**
     * Creates an instance of the [IApiService] associated with this platform.
     *
     * @return An instance of the IApiService.
     */
    fun create(): IApiService
}

/**
 * Platform provider function declaration for multiplatform support.
 *
 * @return An implementation of [Platform].
 */
expect fun getPlatform(): Platform

interface TokenManager {
    /**
     * Saves the jwt token securely.
     *
     * @param[token] The jwt token to save.
     */
    fun saveJwtToken(token: String)

    /**
     * Retrieves the saved jwt token.
     *
     * @return The saved jwt token if available, null otherwise.
     */
    fun getJwtToken(): String?

    /**
     * Clears the saved jwt token from the system.
     */
    fun clearJwtToken()
}


/**
 * Provider object for obtaining an instance of TokenManager.
 */
expect object TokenManagerProvider {

    /**
     * Provides a TokenManager instance based on the provided context.
     *
     * @param[context] Context object relevant to the OS environment.
     * @return An implementation of TokenManager.
     */
    fun provideTokenManager(context: Any): TokenManager
}