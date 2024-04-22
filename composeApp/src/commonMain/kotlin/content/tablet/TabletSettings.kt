package content.tablet

import TokenManagerProvider
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import menu.navigationState
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun loadTabletSettings(context: Any?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = if (navigationState.darkmode) Color.Black else Color(0xFFA1A556))
    ) {
        Text(
            if (navigationState.lokalization) "Nastavenia" else "Settings",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            fontSize = 60.sp,
            color = if (navigationState.darkmode) Color.White else Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp, start = 30.dp)
        )

        Spacer(modifier = Modifier.height(45.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 200.dp)
                .background(
                    color = if (navigationState.darkmode) Color.DarkGray else Color(0xFFBCBE9A),
                    shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp)
                ),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = if (navigationState.lokalization) "Notifikácie" else "Notifications",
                        color = Color(0xFFE4E4E4),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Switch(
                        checked = navigationState.notifications,
                        onCheckedChange = { navigationState.notifications = !navigationState.notifications },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = if (navigationState.lokalization) "Tmavý režim" else "Darkmode",
                        color = Color(0xFFE4E4E4),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Switch(
                        checked = navigationState.darkmode,
                        onCheckedChange = { navigationState.darkmode = !navigationState.darkmode },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = if (navigationState.lokalization) "SK" else "EN",
                        color = Color(0xFFE4E4E4),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Switch(
                        checked = navigationState.lokalization,
                        onCheckedChange = { navigationState.lokalization = !navigationState.lokalization },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { /* Handle help and support button click */ },
                colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .size(width = 450.dp, height = 65.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = if (navigationState.lokalization) "Pomoc a podpora" else "Help and support",
                    color = Color(0xFFE4E4E4),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { /* Handle about button click */ },
                colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .size(width = 450.dp, height = 65.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = if (navigationState.lokalization) "O nás" else "About",
                    color = Color(0xFFE4E4E4),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    val tokenManager = context?.let { TokenManagerProvider.provideTokenManager(it) }
                    if (tokenManager != null) {
                        tokenManager.clearJwtToken()
                    }
                    navigationState.settings = false
                    navigationState.allPlaces = false
                    navigationState.editProfile = false
                    navigationState.gpsPlaces = false
                    navigationState.favouritePlaces = false
                    navigationState.category = false
                    navigationState.resetPassword = false
                    navigationState.signup = false
                    navigationState.login = true
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .size(width = 250.dp, height = 35.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = if (navigationState.lokalization) "Odhlásiť" else "Log out",
                    color = Color(0xFFE4E4E4),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

        }
    }
}