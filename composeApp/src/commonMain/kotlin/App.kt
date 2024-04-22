
import androidx.compose.runtime.Composable
import menu.menu_mobile
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App(context: Any?) {

    //loadLoginScreen()
    //loadSignupScreen()
    //loadResetPassword()
    menu_mobile(context)
    //menu_tablet()
}


