/**
 * The tablet module for showing category options to user -> screen with needed/related components.
 */

package content.tablet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import menu.navigationState
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview


/**
 * Loads the mobile category screen with buttons for various places.
 *
 * This screen is showing buttons with different categories of places.
 * For example:
 *  - meals
 *  - accommodation
 *  - sports
 *  - hiking
 *  - fun
 *  - events
 *
 *  The design is implemented in light, dark and contrast mode.
 */
@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun loadTabletCategory() {
    LazyColumn {
        items(1) {
            Spacer(modifier = Modifier.height(25.dp))

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.End
            ) {
                Button(
                    onClick = { /* Handle login button click */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = if (navigationState.lokalization) "Jedlo" else "MEALS",
                        color = Color(0xFFE4E4E4),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    onClick = { /* Handle login button click */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = if (navigationState.lokalization) "Ubytovanie" else "ACCOMODATION",
                        color = Color(0xFFE4E4E4),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    onClick = { /* Handle login button click */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = if (navigationState.lokalization) "Šport" else "SPORT",
                        color = Color(0xFFE4E4E4),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    onClick = { /* Handle login button click */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = if (navigationState.lokalization) "Vychádzka" else "HIKING",
                        color = Color(0xFFE4E4E4),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    onClick = { /* Handle login button click */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = if (navigationState.lokalization) "Zábava" else "FUN",
                        color = Color(0xFFE4E4E4),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    onClick = { /* Handle login button click */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = if (navigationState.lokalization) "Udalosti" else "EVENTS",
                        color = Color(0xFFE4E4E4),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}