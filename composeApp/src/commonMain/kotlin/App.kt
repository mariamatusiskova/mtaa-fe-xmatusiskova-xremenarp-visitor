import androidx.compose.runtime.Composable
import authentification.loadLoginScreen
import authentification.loadResetPassword
import authentification.loadSignupScreen
import menu.menu_mobile
import menu.menu_tablet
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {

    //loadLoginScreen()
    //loadSignupScreen()
    //loadResetPassword()
    menu_mobile()
    //menu_tablet()
}


