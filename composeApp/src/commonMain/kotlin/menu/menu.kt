package menu


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
//import androidx.compose.ui.res.stringResource
//import androidx.navigation.NavHostController
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import visitor.composeapp.generated.resources.Res
import visitor.composeapp.generated.resources.logo

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun menu() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Horizontal scrolling space for images
            LazyColumn {
                items(50) {
                    Button(
                        onClick = { /* Handle login button click */ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFA1A556)),
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .size(width = 250.dp,height = 35.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = "Log in",
                            color = Color(0xFFE4E4E4),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }


        }
        // Bottom Navigation
        BottomNavigation(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 800.dp), // Adjust as needed
            backgroundColor = Color.White
        ) {
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Person, contentDescription = "Person") },
                selected = false,
                onClick = { /* Handle home navigation */ }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.LocationOn, contentDescription = "Location") },
                selected = false,
                onClick = { /* Handle search navigation */ }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Add, contentDescription = "Add") },
                selected = false,
                onClick = { /* Handle notifications navigation */ }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = "Favorite") },
                selected = false,
                onClick = { /* Handle notifications navigation */ }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Menu, contentDescription = "Menu") },
                selected = false,
                onClick = { /* Handle notifications navigation */ }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") },
                selected = false,
                onClick = { /* Handle notifications navigation */ }
            )
        }
    }
}
