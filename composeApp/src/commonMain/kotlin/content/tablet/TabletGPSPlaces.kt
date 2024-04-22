package content.tablet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
fun loadTabletGpsPlaces() {
    LazyColumn {
        items(1) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
                for (x in cars) {
                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = { /* Handle login button click */ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .size(width = 450.dp,height = 65.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = x,
                            color = Color(0xFFE4E4E4),
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}