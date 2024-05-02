/**
 * The starter of the app.
 */
import androidx.compose.runtime.Composable
import menu.mobile_tablet
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview


/**
 * A cross-platform function representing the main entry point of the application.
 *
 * @param[context] Any (instance) to handle OS of device.
 * @param[screenWidth] The width of the screen, in pixels,
 *  used for determining the layout type (mobile or tablet).
 */
@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App(context: Any?,screenWidth: kotlin.Int) {

    //loadLoginScreen()
    //loadSignupScreen()
    //loadResetPassword()
    //menu_mobile(context)
    //menu_tablet(context)
    mobile_tablet(context,screenWidth)
}


