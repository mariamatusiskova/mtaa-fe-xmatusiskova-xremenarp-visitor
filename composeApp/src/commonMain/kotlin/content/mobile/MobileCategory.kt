package content.mobile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun loadMobileCategory() {
    LazyColumn {
        items(1) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.End
            ) {
                Button(
                    onClick = { /* Handle login button click */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.contrast) Color.Black else if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = if (navigationState.lokalization) "Jedlo" else "MEALS",
                        color = if (navigationState.contrast) Color.White else Color(0xFFE4E4E4),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    onClick = { /* Handle login button click */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.contrast) Color.Black else if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = if (navigationState.lokalization) "Ubytovanie" else "ACCOMODATION",
                        color = if (navigationState.contrast) Color.White else Color(0xFFE4E4E4),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    onClick = { /* Handle login button click */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.contrast) Color.Black else if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = if (navigationState.lokalization) "Šport" else "SPORT",
                        color = if (navigationState.contrast) Color.White else Color(0xFFE4E4E4),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    onClick = { /* Handle login button click */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.contrast) Color.Black else if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = if (navigationState.lokalization) "Vychádzka" else "HIKING",
                        color = if (navigationState.contrast) Color.White else Color(0xFFE4E4E4),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    onClick = { /* Handle login button click */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.contrast) Color.Black else if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = if (navigationState.lokalization) "Zábava" else "FUN",
                        color = if (navigationState.contrast) Color.White else Color(0xFFE4E4E4),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    onClick = { /* Handle login button click */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.contrast) Color.Black else if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = if (navigationState.lokalization) "Udalosti" else "EVENTS",
                        color = if (navigationState.contrast) Color.White else Color(0xFFE4E4E4),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}