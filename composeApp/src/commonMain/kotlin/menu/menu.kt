package menu


import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import authentification.loadLoginScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import visitor.composeapp.generated.resources.Res
import visitor.composeapp.generated.resources.logo

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun menu() {

    var all_places by remember { mutableStateOf(true) }
    var favourite_places by remember { mutableStateOf(false) }
    var gps_places by remember { mutableStateOf(false) }
    var edit_profile by remember { mutableStateOf(false) }
    var settings by remember { mutableStateOf(false) }
    var category by remember { mutableStateOf(false) }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AnimatedVisibility(all_places) {
                LazyColumn{
                    items(1) {
                        val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
                        for (x in cars) {
                            Spacer(modifier = Modifier.height(10.dp))

                            Button(
                                onClick = { /* Handle login button click */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .size(width = 250.dp,height = 35.dp)
                                    .align(Alignment.CenterHorizontally)
                            ) {
                                Text(
                                    text = x,
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
            AnimatedVisibility(favourite_places) {
                LazyColumn {
                    items(1) {
                        val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
                        for (x in cars) {
                            Spacer(modifier = Modifier.height(10.dp))

                            Button(
                                onClick = { /* Handle login button click */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .size(width = 250.dp,height = 35.dp)
                                    .align(Alignment.CenterHorizontally)
                            ) {
                                Text(
                                    text = x,
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
            AnimatedVisibility(gps_places) {
                LazyColumn {
                    items(1) {
                        val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
                        for (x in cars) {
                            Spacer(modifier = Modifier.height(10.dp))

                            Button(
                                onClick = { /* Handle login button click */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .size(width = 250.dp,height = 35.dp)
                                    .align(Alignment.CenterHorizontally)
                            ) {
                                Text(
                                    text = x,
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
            AnimatedVisibility(edit_profile) {
                LazyColumn {
                    items(1) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color(0xFFA1A556))
                        ) {

                            Image(
                                modifier = Modifier
                                    .size(width = 150.dp, height = 150.dp)
                                    .padding(top = 35.dp)
                                    .fillMaxSize(1f)
                                    .align(Alignment.TopCenter),
                                painter = painterResource(Res.drawable.logo),
                                contentDescription = "Logo"
                            )

                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(top = 300.dp)
                                    .background(
                                        color = Color(0xFFBCBE9A),
                                        shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp)
                                    ),
                                verticalArrangement = Arrangement.Center
                            ) {

                                TextField(
                                    value = username,
                                    onValueChange = { username = it },
                                    label = {
                                        Text(
                                            "Username",
                                            style = TextStyle(
                                                color = Color.Gray,
                                                fontWeight = FontWeight.Normal
                                            )
                                        )
                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Text,
                                        imeAction = ImeAction.Next
                                    ),
                                    colors = TextFieldDefaults.textFieldColors(
                                        textColor = Color.DarkGray,
                                        backgroundColor = Color(0xFFBCBE9A),
                                        cursorColor = Color.Gray,
                                        focusedIndicatorColor = Color.Gray,
                                        unfocusedIndicatorColor = Color.Gray
                                    ),
                                    textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 60.dp)
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                TextField(
                                    value = password,
                                    onValueChange = { password = it },
                                    label = {
                                        Text(
                                            "Password",
                                            style = TextStyle(
                                                color = Color.Gray,
                                                fontWeight = FontWeight.Normal,
                                            )
                                        )
                                    },
                                    visualTransformation = PasswordVisualTransformation(),
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Password,
                                        imeAction = ImeAction.Done
                                    ),
                                    colors = TextFieldDefaults.textFieldColors(
                                        textColor = Color.DarkGray,
                                        backgroundColor = Color(0xFFBCBE9A),
                                        cursorColor = Color.Gray,
                                        focusedIndicatorColor = Color.Gray,
                                        unfocusedIndicatorColor = Color.Gray
                                    ),
                                    textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 60.dp)
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                TextField(
                                    value = email,
                                    onValueChange = { email = it },
                                    label = {
                                        Text(
                                            "email",
                                            style = TextStyle(
                                                color = Color.Gray,
                                                fontWeight = FontWeight.Normal,
                                            )
                                        )
                                    },
                                    visualTransformation = PasswordVisualTransformation(),
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Password,
                                        imeAction = ImeAction.Done
                                    ),
                                    colors = TextFieldDefaults.textFieldColors(
                                        textColor = Color.DarkGray,
                                        backgroundColor = Color(0xFFBCBE9A),
                                        cursorColor = Color.Gray,
                                        focusedIndicatorColor = Color.Gray,
                                        unfocusedIndicatorColor = Color.Gray
                                    ),
                                    textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 60.dp)
                                )

                                Spacer(modifier = Modifier.height(40.dp))

                                Button(
                                    onClick = { /* Handle login button click */ },
                                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFA1A556)),
                                    shape = RoundedCornerShape(20.dp),
                                    modifier = Modifier
                                        .size(width = 250.dp,height = 35.dp)
                                        .align(Alignment.CenterHorizontally)
                                ) {
                                    Text(
                                        text = "Edit profile",
                                        color = Color(0xFFE4E4E4),
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Spacer(modifier = Modifier.height(250.dp))

                            }
                        }
                    }
                }
            }
            AnimatedVisibility(settings) {
                LazyColumn {
                    items(1) {
                        Button(
                            onClick = { /* Handle login button click */ },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFA1A556)),
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .size(width = 250.dp,height = 35.dp)
                                .align(Alignment.CenterHorizontally)
                        ) {
                            Text(
                                text = "SETTINGS",
                                color = Color(0xFFE4E4E4),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
            AnimatedVisibility(category) {
                LazyColumn {
                    items(1) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.End
                        ) {
                            Button(
                                onClick = { /* Handle login button click */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .padding(end = 16.dp, bottom = 8.dp)
                            ) {
                                Text(
                                    text = "MEALS",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Button(
                                onClick = { /* Handle login button click */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .padding(end = 16.dp, bottom = 8.dp)
                            ) {
                                Text(
                                    text = "ACCOMODATION",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Button(
                                onClick = { /* Handle login button click */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .padding(end = 16.dp, bottom = 8.dp)
                            ) {
                                Text(
                                    text = "SPORT",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Button(
                                onClick = { /* Handle login button click */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .padding(end = 16.dp, bottom = 8.dp)
                            ) {
                                Text(
                                    text = "HIKING",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Button(
                                onClick = { /* Handle login button click */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .padding(end = 16.dp, bottom = 8.dp)
                            ) {
                                Text(
                                    text = "FUN",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Button(
                                onClick = { /* Handle login button click */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .padding(end = 16.dp, bottom = 8.dp)
                            ) {
                                Text(
                                    text = "EVENTS",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
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
                onClick = { all_places = !all_places
                    edit_profile = false
                    gps_places=false
                    favourite_places=false
                    category = false
                    settings = false   }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Person, contentDescription = "Person") },
                selected = false,
                onClick = { edit_profile = !edit_profile
                            all_places = false
                            gps_places=false
                            favourite_places=false
                            category = false
                            settings = false   }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.LocationOn, contentDescription = "Location") },
                selected = false,
                onClick = { gps_places = !gps_places
                            all_places = false
                            edit_profile=false
                            favourite_places=false
                            category = false
                            settings = false  }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Add, contentDescription = "Add") },
                selected = false,
                onClick = { /* Handle notifications navigation */ }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = "Favorite") },
                selected = false,
                onClick = { favourite_places = !favourite_places
                            all_places = false
                            edit_profile=false
                            gps_places=false
                            category = false
                            settings = false  }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Menu, contentDescription = "CATEGORY") },
                selected = false,
                onClick = { category = !category
                            all_places = false
                            edit_profile=false
                            gps_places=false
                            favourite_places = false
                            settings = false }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") },
                selected = false,
                onClick = { settings = !settings
                            all_places = false
                            edit_profile=false
                            gps_places=false
                            favourite_places = false
                            category = false }
            )
        }
    }
}

