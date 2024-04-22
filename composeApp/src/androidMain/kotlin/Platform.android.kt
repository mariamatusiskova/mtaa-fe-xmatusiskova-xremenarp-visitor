import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import endpoints.IApiService
import sk.mtaa.xremenarp.xmatusiskova.AndroidApi

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override fun create(): IApiService {
        return AndroidApi.create()
    }
}

// chatGPT
actual fun getPlatform(): Platform = AndroidPlatform()

class AndroidTokenManager(private val context: Context) : TokenManager {
    private val preferences: SharedPreferences = context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
    private val KEY_JWT_TOKEN = "jwtToken"

    override fun saveJwtToken(token: String) {
        preferences.edit().putString(KEY_JWT_TOKEN, token).apply()
    }

    override fun getJwtToken(): String? {
        return preferences.getString(KEY_JWT_TOKEN, null)
    }

    override fun clearJwtToken() {
        preferences.edit().remove(KEY_JWT_TOKEN).apply()
    }
}

actual object TokenManagerProvider {
    actual fun provideTokenManager(context: Any): TokenManager {
        if (context !is Context) {
            throw IllegalArgumentException("Expected Android Context")
        }
        return AndroidTokenManager(context)
    }
}

//