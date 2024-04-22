package sk.mtaa.xremenarp.xmatusiskova

import App
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import android.util.DisplayMetrics
import android.view.WindowManager

val screenWidth = 0

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val screenWidth = getScreenWidth()
        setContent {
            App(context = applicationContext,screenWidth)
        }
    }
    private fun getScreenWidth(): Int {
        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App(context = null, screenWidth)
}
