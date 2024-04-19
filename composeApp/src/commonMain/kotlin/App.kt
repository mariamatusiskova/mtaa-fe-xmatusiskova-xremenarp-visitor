import androidx.compose.runtime.Composable
import login.loadLoginScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {

    loadLoginScreen()
}


