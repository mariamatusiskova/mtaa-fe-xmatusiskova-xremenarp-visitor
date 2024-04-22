package menu

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


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

val navigationState = NavigationState()