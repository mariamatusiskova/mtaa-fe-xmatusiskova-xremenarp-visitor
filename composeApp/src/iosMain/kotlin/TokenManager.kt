import platform.Foundation.NSUserDefaults

actual class TokenManager {

    private val userDefaults: NSUserDefaults = NSUserDefaults.standardUserDefaults()

    actual fun saveJwtToken(token: String) {
        userDefaults.setObject(token, "jwtToken")
    }

    actual fun getJwtToken(): String? {
        return userDefaults.stringForKey("jwtToken")
    }

    actual fun clearJwtToken() {
        userDefaults.removeObjectForKey("jwtToken")
    }
}


actual fun saveJwtTokenAfterLogin(token: String) {
    val userDefaults = NSUserDefaults.standardUserDefaults()
    userDefaults.setObject(token, "jwtToken")
}

