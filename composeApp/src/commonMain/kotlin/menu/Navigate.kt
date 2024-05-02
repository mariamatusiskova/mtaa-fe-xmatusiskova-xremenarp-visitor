/**
 * The module which handles preview of the screens.
 * Controlling visibility of different screens.
 */

package menu

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * Class responsible for managing the navigation state of the application.
 * Each property represents a screen and its visibility status.
 * The default screen with state true is Login page.
 */
class NavigationState {
    var signup by mutableStateOf(false)
    var login by mutableStateOf(true)
    var resetPassword by mutableStateOf(false)
    var allPlaces by mutableStateOf(false)
    var favouritePlaces by mutableStateOf(false)
    var gpsPlaces by mutableStateOf(false)
    var editProfile by mutableStateOf(false)
    var settings by mutableStateOf(false)
    var category by mutableStateOf(false)
    var darkmode by mutableStateOf(false)
    var notifications by mutableStateOf(true)
    var lokalization by mutableStateOf(true)
    var contrast by mutableStateOf(false)
}

/**
 * Singleton instance of NavigationState to be used throughout the application.
 * To handle screens visibility.
 */
val navigationState = NavigationState()