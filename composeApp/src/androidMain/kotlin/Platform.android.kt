/**
 * The main module for Android app platform.
 */

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import endpoints.IApiService
import sk.mtaa.xremenarp.xmatusiskova.AndroidApi


/**
 * Represents the Android platform implementation of [Platform].
 */
class AndroidPlatform : Platform {

    /**
     * Gets the name of the Android platform along with its SDK version.
     */
    override val name: String = "Android ${Build.VERSION.SDK_INT}"

    /**
     * Creates an instance of [IApiService] specific to Android platform.
     */
    override fun create(): IApiService {
        return AndroidApi.create()
    }
}

// chatGPT
/**
 * Returns the [Platform] representing the Android platform.
 */
actual fun getPlatform(): Platform = AndroidPlatform()


/**
 * Manages the jwt token on Android platform.
 * @param[context] It is a context of the Android application,
 *  which will be send to commonMain.
 */
class AndroidTokenManager(private val context: Context) : TokenManager {
    private val preferences: SharedPreferences = context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
    private val KEY_JWT_TOKEN = "jwtToken"

    /**
     * Saves the jwt token securely.
     * @param[token] The jwt token to be saved into the Android system.
     */
    override fun saveJwtToken(token: String) {
        preferences.edit().putString(KEY_JWT_TOKEN, token).apply()
    }

    /**
     * Gets the jwt token.
     * @return The jwt token if available, otherwise null.
     */
    override fun getJwtToken(): String? {
        return preferences.getString(KEY_JWT_TOKEN, null)
    }

    /**
     * Clears the saved jwt token from the Android system.
     */
    override fun clearJwtToken() {
        preferences.edit().remove(KEY_JWT_TOKEN).apply()
    }
}

/**
 * Provides the TokenManager implementation for Android platform from commonMain directory.
 */
actual object TokenManagerProvider {
    /**
     * Provides an instance of [TokenManager] specific to Android platform.
     * @param[context] The Context of Any class (instance) of the Android application.
     * @return An instance of TokenManager.
     * @throws[IllegalArgumentException] If the provided context is not of type Context.
     */
    actual fun provideTokenManager(context: Any): TokenManager {
        if (context !is Context) {
            throw IllegalArgumentException("Expected Android Context")
        }
        return AndroidTokenManager(context)
    }
}

//