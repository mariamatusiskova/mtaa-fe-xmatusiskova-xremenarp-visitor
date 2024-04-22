package sk.mtaa.xremenarp.xmatusiskova

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

class TokenManager(context: Context)  {
    private val preferences: SharedPreferences = context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)

    fun saveJwtToken(token: String) {
        preferences.edit().putString("jwtToken", token).apply()
    }

    fun getJwtToken(): String? {
        return preferences.getString("jwtToken", null)
    }

    fun clearJwtToken() {
        preferences.edit().remove("jwtToken").apply()
    }
}

@Composable
fun saveJwtTokenAfterLogin(token: String) {
    val context = LocalContext.current
    val tokenManager = TokenManager(context)

    tokenManager.saveJwtToken(token)

    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val observer = LifecycleEventObserver { _, event ->
        if (event == Lifecycle.Event.ON_DESTROY) {
            tokenManager.clearJwtToken()
        }
    }

    lifecycle.addObserver(observer)
}
