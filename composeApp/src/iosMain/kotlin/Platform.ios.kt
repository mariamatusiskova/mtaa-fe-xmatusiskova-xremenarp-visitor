import endpoints.IApiService
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override fun create(): IApiService {
        TODO("Not yet implemented")
    }
}

actual fun getPlatform(): Platform = IOSPlatform()