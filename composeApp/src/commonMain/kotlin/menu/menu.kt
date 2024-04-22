package menu


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import authentification.loadLoginScreen
import authentification.loadResetPassword
import authentification.loadSignupScreen
import content.mobile.loadMobileAllPlaces
import content.mobile.loadMobileCategory
import content.mobile.loadMobileEditProfile
import content.mobile.loadMobileFavouritePlaces
import content.mobile.loadMobileGpsPlaces
import content.mobile.loadMobileSettings
import content.tablet.loadTabletAllPlaces
import content.tablet.loadTabletCategory
import content.tablet.loadTabletEditProfile
import content.tablet.loadTabletFavouritePlaces
import content.tablet.loadTabletGpsPlaces
import content.tablet.loadTabletSettings
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun mobile_tablet(context: Any?,screenWidth: kotlin.Int){
    if (screenWidth<1500){
        menu_mobile(context)
    }
    else{
        menu_tablet(context)
    }
}


@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun menu_mobile(context: Any?) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (navigationState.darkmode) Color.Black else Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AnimatedVisibility(navigationState.login) {
                loadLoginScreen(context)
            }
            AnimatedVisibility(navigationState.signup) {
                loadSignupScreen()
            }
            AnimatedVisibility(navigationState.resetPassword) {
                loadResetPassword()
            }
            AnimatedVisibility(navigationState.allPlaces) {
                loadMobileAllPlaces(context)
            }
            AnimatedVisibility(navigationState.favouritePlaces) {
                loadMobileFavouritePlaces()
            }
            AnimatedVisibility(navigationState.gpsPlaces) {
                loadMobileGpsPlaces()
            }
            AnimatedVisibility(navigationState.editProfile) {
                loadMobileEditProfile(context)
            }
            AnimatedVisibility(navigationState.settings) {
                loadMobileSettings(context)
            }
            AnimatedVisibility(navigationState.category) {
                loadMobileCategory()
            }
        }
        BottomNavigation(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.BottomCenter),
            backgroundColor = Color.White
        ) {
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Home, contentDescription = "ALL") },
                selected = false,
                onClick = { navigationState.allPlaces = !navigationState.allPlaces
                    navigationState.editProfile = false
                    navigationState.gpsPlaces=false
                    navigationState.favouritePlaces=false
                    navigationState.category = false
                    navigationState.settings = false
                    navigationState.resetPassword = false
                    navigationState.signup = false
                    navigationState.login = false
                }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Person, contentDescription = "Person") },
                selected = false,
                onClick = { navigationState.editProfile = !navigationState.editProfile
                    navigationState.allPlaces = false
                    navigationState.gpsPlaces=false
                    navigationState.favouritePlaces=false
                    navigationState.category = false
                    navigationState.settings = false
                    navigationState.resetPassword = false
                    navigationState.signup = false
                    navigationState.login = false
                }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.LocationOn, contentDescription = "Location") },
                selected = false,
                onClick = { navigationState.gpsPlaces = !navigationState.gpsPlaces
                    navigationState.allPlaces = false
                    navigationState.editProfile=false
                    navigationState.favouritePlaces=false
                    navigationState.category = false
                    navigationState.settings = false
                    navigationState.resetPassword = false
                    navigationState.signup = false
                    navigationState.login = false
                }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Menu, contentDescription = "CATEGORY") },
                selected = false,
                onClick = { navigationState.category = !navigationState.category
                    navigationState.allPlaces = false
                    navigationState.editProfile=false
                    navigationState.gpsPlaces=false
                    navigationState.favouritePlaces = false
                    navigationState.settings = false
                    navigationState.resetPassword = false
                    navigationState.signup = false
                    navigationState.login = false
                }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") },
                selected = false,
                onClick = { navigationState.settings = !navigationState.settings
                    navigationState.allPlaces = false
                    navigationState.editProfile=false
                    navigationState.gpsPlaces=false
                    navigationState.favouritePlaces = false
                    navigationState.category = false
                    navigationState.resetPassword = false
                    navigationState.signup = false
                    navigationState.login = false
                }
            )
        }

    }
}
@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun menu_tablet(context: Any?) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (navigationState.darkmode) Color.Black else Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AnimatedVisibility(navigationState.login) {
                loadLoginScreen(context)
            }
            AnimatedVisibility(navigationState.signup) {
                loadSignupScreen()
            }
            AnimatedVisibility(navigationState.resetPassword) {
                loadResetPassword()
            }
            AnimatedVisibility(navigationState.allPlaces) {
               loadTabletAllPlaces(context)
            }
            AnimatedVisibility(navigationState.favouritePlaces) {
                loadTabletFavouritePlaces()
            }
            AnimatedVisibility(navigationState.gpsPlaces) {
                loadTabletGpsPlaces()
            }
            AnimatedVisibility(navigationState.editProfile) {
                loadTabletEditProfile()
            }
            AnimatedVisibility(navigationState.settings) {
               loadTabletSettings(context)
            }
            AnimatedVisibility(navigationState.category) {
                loadTabletCategory()
            }
        }
        // Bottom Navigation
        BottomNavigation(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.BottomCenter),
            backgroundColor = Color.White
        ) {
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Home, contentDescription = "ALL") },
                selected = false,
                onClick = { navigationState.allPlaces = !navigationState.allPlaces
                    navigationState.editProfile = false
                    navigationState.gpsPlaces=false
                    navigationState.favouritePlaces=false
                    navigationState.category = false
                    navigationState.settings = false
                    navigationState.resetPassword = false
                    navigationState.signup = false
                    navigationState.login = false
                }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Person, contentDescription = "Person") },
                selected = false,
                onClick = { navigationState.editProfile = !navigationState.editProfile
                    navigationState.allPlaces = false
                    navigationState.gpsPlaces=false
                    navigationState.favouritePlaces=false
                    navigationState.category = false
                    navigationState.settings = false
                    navigationState.resetPassword = false
                    navigationState.signup = false
                    navigationState.login = false
                }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.LocationOn, contentDescription = "Location") },
                selected = false,
                onClick = { navigationState.gpsPlaces = !navigationState.gpsPlaces
                    navigationState.allPlaces = false
                    navigationState.editProfile=false
                    navigationState.favouritePlaces=false
                    navigationState.category = false
                    navigationState.settings = false
                    navigationState.resetPassword = false
                    navigationState.signup = false
                    navigationState.login = false
                }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Menu, contentDescription = "CATEGORY") },
                selected = false,
                onClick = { navigationState.category = !navigationState.category
                    navigationState.allPlaces = false
                    navigationState.editProfile=false
                    navigationState.gpsPlaces=false
                    navigationState.favouritePlaces = false
                    navigationState.settings = false
                    navigationState.resetPassword = false
                    navigationState.signup = false
                    navigationState.login = false
                }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") },
                selected = false,
                onClick = { navigationState.settings = !navigationState.settings
                    navigationState.allPlaces = false
                    navigationState.editProfile=false
                    navigationState.gpsPlaces=false
                    navigationState.favouritePlaces = false
                    navigationState.category = false
                    navigationState.resetPassword = false
                    navigationState.signup = false
                    navigationState.login = false
                }
            )
        }
    }
}