package menu


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.Home
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
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
import authentification.loadLoginScreen
import authentification.loadResetPassword
import authentification.loadSignupScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import visitor.composeapp.generated.resources.Res
import visitor.composeapp.generated.resources.logo
import androidx.compose.foundation.layout.*
import androidx.compose.material.Switch
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons


@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun menu_mobile() {
    var all_places by remember { mutableStateOf(true) }
    var favourite_places by remember { mutableStateOf(false) }
    var gps_places by remember { mutableStateOf(false) }
    var edit_profile by remember { mutableStateOf(false) }
    var settings by remember { mutableStateOf(false) }
    var category by remember { mutableStateOf(false) }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var darkmode by remember { mutableStateOf(false) }
    var notifications by remember { mutableStateOf(true) }
    var lokalization by remember { mutableStateOf(true) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (darkmode) Color.Black else Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AnimatedVisibility(all_places) {
                LazyColumn{
                    items(1) {
                        Column (modifier = Modifier
                            .fillMaxSize(),
                            verticalArrangement = Arrangement.Center){
                            val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
                            for (x in cars) {
                                Spacer(modifier = Modifier.height(10.dp))

                                Button(
                                    onClick = { /* Handle login button click */ },
                                    colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
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
            }
            AnimatedVisibility(favourite_places) {
                LazyColumn {
                    items(1) {
                        Column (modifier = Modifier
                            .fillMaxSize(),
                            verticalArrangement = Arrangement.Center) {
                            val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
                            for (x in cars) {
                                Spacer(modifier = Modifier.height(10.dp))

                                Button(
                                    onClick = { /* Handle login button click */ },
                                    colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
                                    shape = RoundedCornerShape(20.dp),
                                    modifier = Modifier
                                        .size(width = 250.dp, height = 35.dp)
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
            }
            AnimatedVisibility(gps_places) {
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
                                    colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
                                    shape = RoundedCornerShape(20.dp),
                                    modifier = Modifier
                                        .size(width = 250.dp, height = 35.dp)
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
            }
            AnimatedVisibility(edit_profile) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(if (darkmode) Color.Black else Color(0xFFA1A556))
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
                                color = if (lokalization) Color.DarkGray else Color(0xFFBCBE9A),
                                shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp)
                            ),
                        verticalArrangement = Arrangement.Center
                    ) {

                        TextField(
                            value = username,
                            onValueChange = { username = it },
                            label = {
                                Text(
                                    if (lokalization) "Prihlasovacie meno" else "Username",
                                    style = TextStyle(
                                        color = if (darkmode) Color.White else Color.Gray,
                                        fontWeight = FontWeight.Normal
                                    )
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = if (darkmode) Color.White else Color.DarkGray,
                                backgroundColor = if (darkmode) Color.DarkGray else Color(0xFFBCBE9A),
                                cursorColor = if (darkmode) Color.White else Color.Gray,
                                focusedIndicatorColor = if (darkmode) Color.White else Color.Gray,
                                unfocusedIndicatorColor = if (darkmode) Color.White else Color.Gray
                            ),
                            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 60.dp)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        TextField(
                            value = username,
                            onValueChange = { username = it },
                            label = {
                                Text(
                                    if (lokalization) "Heslo" else "Password",
                                    style = TextStyle(
                                        color = if (darkmode) Color.White else Color.Gray,
                                        fontWeight = FontWeight.Normal
                                    )
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = if (darkmode) Color.White else Color.DarkGray,
                                backgroundColor = if (darkmode) Color.DarkGray else Color(0xFFBCBE9A),
                                cursorColor = if (darkmode) Color.White else Color.Gray,
                                focusedIndicatorColor = if (darkmode) Color.White else Color.Gray,
                                unfocusedIndicatorColor = if (darkmode) Color.White else Color.Gray
                            ),
                            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 60.dp)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        TextField(
                            value = username,
                            onValueChange = { username = it },
                            label = {
                                Text(
                                    "Email",
                                    style = TextStyle(
                                        color = if (darkmode) Color.White else Color.Gray,
                                        fontWeight = FontWeight.Normal
                                    )
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = if (darkmode) Color.White else Color.DarkGray,
                                backgroundColor = if (darkmode) Color.DarkGray else Color(0xFFBCBE9A),
                                cursorColor = if (darkmode) Color.White else Color.Gray,
                                focusedIndicatorColor = if (darkmode) Color.White else Color.Gray,
                                unfocusedIndicatorColor = if (darkmode) Color.White else Color.Gray
                            ),
                            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 60.dp)
                        )

                        Spacer(modifier = Modifier.height(40.dp))

                        Button(
                            onClick = { /* Handle login button click */ },
                            colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .size(width = 250.dp,height = 35.dp)
                                .align(Alignment.CenterHorizontally)
                        ) {
                            Text(
                                text = if (lokalization) "Zmeniť údaje" else "Edit profile",
                                color = Color(0xFFE4E4E4),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.height(250.dp))

                    }
                }


            }
            AnimatedVisibility(settings) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = if (darkmode) Color.Black else Color(0xFFA1A556))
                ) {
                    Text(
                        if (lokalization) "Nastavenia" else "Settings",
                        style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        fontSize = 40.sp,
                        color = if (darkmode) Color.White else Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 60.dp, start = 30.dp)
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 300.dp)
                            .background(
                                color = if (darkmode) Color.DarkGray else Color(0xFFBCBE9A),
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
                                    text = if (lokalization) "Notifikácie" else "Notifications",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 16.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Switch(
                                    checked = notifications,
                                    onCheckedChange = { notifications = !notifications },
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
                                    text = if (lokalization) "Tmavý režim" else "Darkmode",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 16.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Switch(
                                    checked = darkmode,
                                    onCheckedChange = { darkmode = !darkmode },
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
                                    text = if (lokalization) "SK" else "EN",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 16.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Switch(
                                    checked = lokalization,
                                    onCheckedChange = { lokalization = !lokalization },
                                    modifier = Modifier.align(Alignment.CenterVertically)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(
                            onClick = { /* Handle help and support button click */ },
                            colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .size(width = 250.dp, height = 35.dp)
                                .align(Alignment.CenterHorizontally)
                        ) {
                            Text(
                                text = if (lokalization) "Pomoc a podpora" else "Help and support",
                                color = Color(0xFFE4E4E4),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(
                            onClick = { /* Handle about button click */ },
                            colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .size(width = 250.dp, height = 35.dp)
                                .align(Alignment.CenterHorizontally)
                        ) {
                            Text(
                                text = if (lokalization) "O nás" else "About",
                                color = Color(0xFFE4E4E4),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))
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
                                colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .padding(end = 16.dp, bottom = 8.dp)
                            ) {
                                Text(
                                    text = if (lokalization) "Jedlo" else "MEALS",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Button(
                                onClick = { /* Handle login button click */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .padding(end = 16.dp, bottom = 8.dp)
                            ) {
                                Text(
                                    text = if (lokalization) "Ubytovanie" else "ACCOMODATION",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Button(
                                onClick = { /* Handle login button click */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .padding(end = 16.dp, bottom = 8.dp)
                            ) {
                                Text(
                                    text = if (lokalization) "Šport" else "SPORT",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Button(
                                onClick = { /* Handle login button click */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .padding(end = 16.dp, bottom = 8.dp)
                            ) {
                                Text(
                                    text = if (lokalization) "Vychádzka" else "HIKING",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Button(
                                onClick = { /* Handle login button click */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .padding(end = 16.dp, bottom = 8.dp)
                            ) {
                                Text(
                                    text = if (lokalization) "Zábava" else "FUN",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Button(
                                onClick = { /* Handle login button click */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .padding(end = 16.dp, bottom = 8.dp)
                            ) {
                                Text(
                                    text = if (lokalization) "Udalosti" else "EVENTS",
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
@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun menu_tablet() {
    var all_places by remember { mutableStateOf(true) }
    var favourite_places by remember { mutableStateOf(false) }
    var gps_places by remember { mutableStateOf(false) }
    var edit_profile by remember { mutableStateOf(false) }
    var settings by remember { mutableStateOf(false) }
    var category by remember { mutableStateOf(false) }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var darkmode by remember { mutableStateOf(false) }
    var notifications by remember { mutableStateOf(true) }
    var lokalization by remember { mutableStateOf(true) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (darkmode) Color.Black else Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AnimatedVisibility(all_places) {
                LazyColumn{
                    items(1) {
                        Column (modifier = Modifier
                            .fillMaxSize(),
                            verticalArrangement = Arrangement.Center){
                            val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
                            for (x in cars) {
                                Spacer(modifier = Modifier.height(10.dp))

                                Button(
                                    onClick = { /* Handle login button click */ },
                                    colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
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
            AnimatedVisibility(favourite_places) {
                LazyColumn {
                    items(1) {
                        Column (modifier = Modifier
                            .fillMaxSize(),
                            verticalArrangement = Arrangement.Center) {
                            val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
                            for (x in cars) {
                                Spacer(modifier = Modifier.height(10.dp))

                                Button(
                                    onClick = { /* Handle login button click */ },
                                    colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
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
            AnimatedVisibility(gps_places) {
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
                                    colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
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
            AnimatedVisibility(edit_profile) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(if (darkmode) Color.Black else Color(0xFFA1A556))
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
                                color = if (lokalization) Color.DarkGray else Color(0xFFBCBE9A),
                                shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp)
                            ),
                        verticalArrangement = Arrangement.Center
                    ) {

                        TextField(
                            value = username,
                            onValueChange = { username = it },
                            label = {
                                Text(
                                    if (lokalization) "Prihlasovacie meno" else "Username",
                                    fontSize = 25.sp,
                                    style = TextStyle(
                                        color = if (darkmode) Color.White else Color.Gray,
                                        fontWeight = FontWeight.Normal
                                    )
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = if (darkmode) Color.White else Color.DarkGray,
                                backgroundColor = if (darkmode) Color.DarkGray else Color(0xFFBCBE9A),
                                cursorColor = if (darkmode) Color.White else Color.Gray,
                                focusedIndicatorColor = if (darkmode) Color.White else Color.Gray,
                                unfocusedIndicatorColor = if (darkmode) Color.White else Color.Gray
                            ),
                            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 60.dp)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        TextField(
                            value = username,
                            onValueChange = { username = it },
                            label = {
                                Text(
                                    if (lokalization) "Heslo" else "Password",
                                    fontSize = 25.sp,
                                    style = TextStyle(
                                        color = if (darkmode) Color.White else Color.Gray,
                                        fontWeight = FontWeight.Normal
                                    )
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = if (darkmode) Color.White else Color.DarkGray,
                                backgroundColor = if (darkmode) Color.DarkGray else Color(0xFFBCBE9A),
                                cursorColor = if (darkmode) Color.White else Color.Gray,
                                focusedIndicatorColor = if (darkmode) Color.White else Color.Gray,
                                unfocusedIndicatorColor = if (darkmode) Color.White else Color.Gray
                            ),
                            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 60.dp)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        TextField(
                            value = username,
                            onValueChange = { username = it },
                            label = {
                                Text(
                                    "Email",
                                    fontSize = 25.sp,
                                    style = TextStyle(
                                        color = if (darkmode) Color.White else Color.Gray,
                                        fontWeight = FontWeight.Normal
                                    )
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = if (darkmode) Color.White else Color.DarkGray,
                                backgroundColor = if (darkmode) Color.DarkGray else Color(0xFFBCBE9A),
                                cursorColor = if (darkmode) Color.White else Color.Gray,
                                focusedIndicatorColor = if (darkmode) Color.White else Color.Gray,
                                unfocusedIndicatorColor = if (darkmode) Color.White else Color.Gray
                            ),
                            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 60.dp)
                        )

                        Spacer(modifier = Modifier.height(40.dp))

                        Button(
                            onClick = { /* Handle login button click */ },
                            colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .size(width = 450.dp,height = 65.dp)
                                .align(Alignment.CenterHorizontally)
                        ) {
                            Text(
                                text = if (lokalization) "Zmeniť údaje" else "Edit profile",
                                color = Color(0xFFE4E4E4),
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.height(250.dp))

                    }
                }


            }
            AnimatedVisibility(settings) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = if (darkmode) Color.Black else Color(0xFFA1A556))
                ) {
                    Text(
                        if (lokalization) "Nastavenia" else "Settings",
                        style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        fontSize = 60.sp,
                        color = if (darkmode) Color.White else Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 60.dp, start = 30.dp)
                    )

                    Spacer(modifier = Modifier.height(45.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 300.dp)
                            .background(
                                color = if (darkmode) Color.DarkGray else Color(0xFFBCBE9A),
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
                                    text = if (lokalization) "Notifikácie" else "Notifications",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 16.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Switch(
                                    checked = notifications,
                                    onCheckedChange = { notifications = !notifications },
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
                                    text = if (lokalization) "Tmavý režim" else "Darkmode",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 16.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Switch(
                                    checked = darkmode,
                                    onCheckedChange = { darkmode = !darkmode },
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
                                    text = if (lokalization) "SK" else "EN",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 16.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Switch(
                                    checked = lokalization,
                                    onCheckedChange = { lokalization = !lokalization },
                                    modifier = Modifier.align(Alignment.CenterVertically)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(
                            onClick = { /* Handle help and support button click */ },
                            colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .size(width = 450.dp, height = 65.dp)
                                .align(Alignment.CenterHorizontally)
                        ) {
                            Text(
                                text = if (lokalization) "Pomoc a podpora" else "Help and support",
                                color = Color(0xFFE4E4E4),
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(
                            onClick = { /* Handle about button click */ },
                            colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .size(width = 450.dp, height = 65.dp)
                                .align(Alignment.CenterHorizontally)
                        ) {
                            Text(
                                text = if (lokalization) "O nás" else "About",
                                color = Color(0xFFE4E4E4),
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
            AnimatedVisibility(category) {
                LazyColumn {
                    items(1) {
                        Spacer(modifier = Modifier.height(25.dp))

                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.End
                        ) {
                            Button(
                                onClick = { /* Handle login button click */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .padding(end = 16.dp, bottom = 8.dp)
                            ) {
                                Text(
                                    text = if (lokalization) "Jedlo" else "MEALS",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Button(
                                onClick = { /* Handle login button click */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .padding(end = 16.dp, bottom = 8.dp)
                            ) {
                                Text(
                                    text = if (lokalization) "Ubytovanie" else "ACCOMODATION",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Button(
                                onClick = { /* Handle login button click */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .padding(end = 16.dp, bottom = 8.dp)
                            ) {
                                Text(
                                    text = if (lokalization) "Šport" else "SPORT",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Button(
                                onClick = { /* Handle login button click */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .padding(end = 16.dp, bottom = 8.dp)
                            ) {
                                Text(
                                    text = if (lokalization) "Vychádzka" else "HIKING",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Button(
                                onClick = { /* Handle login button click */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .padding(end = 16.dp, bottom = 8.dp)
                            ) {
                                Text(
                                    text = if (lokalization) "Zábava" else "FUN",
                                    color = Color(0xFFE4E4E4),
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Button(
                                onClick = { /* Handle login button click */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = if (darkmode) Color.Gray else Color(0xFFA1A556)),
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .padding(end = 16.dp, bottom = 8.dp)
                            ) {
                                Text(
                                    text = if (lokalization) "Udalosti" else "EVENTS",
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
