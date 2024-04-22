
import androidx.compose.runtime.Composable
import menu.mobile_tablet
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview

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


