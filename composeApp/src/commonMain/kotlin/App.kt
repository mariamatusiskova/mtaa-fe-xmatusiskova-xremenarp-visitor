import androidx.compose.runtime.Composable
import authentification.loadLoginScreen
import authentification.loadSignupScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {

    //loadLoginScreen()
    loadSignupScreen()
}


