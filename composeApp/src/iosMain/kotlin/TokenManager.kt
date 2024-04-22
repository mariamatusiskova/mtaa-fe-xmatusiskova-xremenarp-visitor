import platform.Foundation.NSUserDefaults


// chatGPT
class iOSTokenManager : TokenManager {
    private val userDefaults: NSUserDefaults = NSUserDefaults.standardUserDefaults()
    private val KEY_JWT_TOKEN = "jwtToken"

    override fun saveJwtToken(token: String) {
        userDefaults.setObject(token, KEY_JWT_TOKEN)
    }

    override fun getJwtToken(): String? {
        return userDefaults.stringForKey(KEY_JWT_TOKEN)
    }

    override fun clearJwtToken() {
        userDefaults.removeObjectForKey(KEY_JWT_TOKEN)
    }
}

actual object TokenManagerProvider {
    actual fun provideTokenManager(context: Any): TokenManager {
        return iOSTokenManager()
    }
}
//