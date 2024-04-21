import android.os.Build
import endpoints.IApiService
import sk.mtaa.xremenarp.xmatusiskova.AndroidApi

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override fun create(): IApiService {
        return AndroidApi.create()
    }
}

actual fun getPlatform(): Platform = AndroidPlatform()