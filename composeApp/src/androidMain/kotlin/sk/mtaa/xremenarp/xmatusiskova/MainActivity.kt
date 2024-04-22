package sk.mtaa.xremenarp.xmatusiskova

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import android.util.DisplayMetrics


val screenWidth = 0

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val screenWidth = getScreenWidth()
        setContent {
            App(context = applicationContext,screenWidth)
        }

        showNotification(applicationContext, "Version",if (screenWidth<1500) "Mobile version is on" else "Tablet version is on",1)
    }
    private fun getScreenWidth(): Int {
        val displayMetrics = DisplayMetrics()
        return displayMetrics.widthPixels
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App(context = null, screenWidth)
}
