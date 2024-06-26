/**
 * The module which handles components activity.
 */

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
import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import android.location.Address
import android.location.Geocoder
import android.location.Location
import org.jetbrains.compose.resources.ExperimentalResourceApi
import visitor.composeapp.generated.resources.Res
import java.util.*

val screenWidth = 0

/**
 * Class responsible for the application components and lifecycle.
 */
class MainActivity : ComponentActivity() {
    lateinit var fusedLocationClient : FusedLocationProviderClient

    /**
     * Called when the activity is starting.
     *
     * @param[savedInstanceState] Saves data from the application when the app
     *  is re-initialized ot shut down.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val screenWidth = getScreenWidth()
        setContent {
            App(context = applicationContext,screenWidth)
        }
        //showNotification(applicationContext, "Version",if (screenWidth<1500) "Mobile version is on" else "Tablet version is on",2)
        scheduleNotifications(applicationContext)
        //code from line 38 to line 76 and from 82 to 115 was generated by chatgpt
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(applicationContext)
        if (ContextCompat.checkSelfPermission(applicationContext,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions( this,arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION
            )
        } else {
            requestLocationUpdates()
        }
    }

    /**
     * Requests location updates.
     */
    @SuppressLint("MissingPermission")
    private fun requestLocationUpdates() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {
                    val latitude = location.latitude
                    val longitude = location.longitude
                    // Do something with latitude and longitude
                } else {
                    Toast.makeText(
                        this,
                        "Location not available",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    /**
     * Retrieves the city name from the device location.
     */
    @SuppressLint("MissingPermission")
    fun getCityNameFromLocation() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {
                    val geocoder = Geocoder(applicationContext, Locale.getDefault())
                    val locaton_information: MutableList<Address>? = geocoder.getFromLocation(location.latitude, location.longitude, 1)
                    if (locaton_information?.get(0)?.locality != null){
                        showNotification(applicationContext, "Visitor", "What are you going to do today at " + locaton_information.get(0).locality,1)
                    }
                } else {
                    Toast.makeText(
                        this,
                        "Location not available",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    /**
     * Handles the result of a permission request.
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    requestLocationUpdates()
                } else {
                    Toast.makeText(
                        this,
                        "Location permission denied",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                return
            }
        }
    }
    companion object {
        private const val PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1
    }

    /**
     * Pauses the activity.
     */
    override fun onPause() {
        super.onPause()
        //showNotification(applicationContext, "Visitor","Didn't you find what you are looking for? Let's try it agan!",0)
        getCityNameFromLocation()
    }

    /**
     * Retrieves the screen width of the device.
     */
    private fun getScreenWidth(): Int {
        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }
}

/**
 * Preview function for the main activity.
 */
@Preview
@Composable
fun AppAndroidPreview() {
    App(context = null, screenWidth)
}
