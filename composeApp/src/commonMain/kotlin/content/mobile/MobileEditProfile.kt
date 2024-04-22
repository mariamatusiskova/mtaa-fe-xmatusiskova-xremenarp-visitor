package content.mobile

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import menu.navigationState
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import visitor.composeapp.generated.resources.Res
import visitor.composeapp.generated.resources.logo

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun loadMobileEditProfile() {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (navigationState.darkmode) Color.Black else Color(0xFFA1A556))
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
                    color = if (navigationState.lokalization) Color.DarkGray else Color(0xFFBCBE9A),
                    shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp)
                ),
            verticalArrangement = Arrangement.Center
        ) {

            TextField(
                value = username,
                onValueChange = { username = it },
                label = {
                    Text(
                        if (navigationState.lokalization) "Prihlasovacie meno" else "Username",
                        style = TextStyle(
                            color = if (navigationState.darkmode) Color.White else Color.Gray,
                            fontWeight = FontWeight.Normal
                        )
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = if (navigationState.darkmode) Color.White else Color.DarkGray,
                    backgroundColor = if (navigationState.darkmode) Color.DarkGray else Color(0xFFBCBE9A),
                    cursorColor = if (navigationState.darkmode) Color.White else Color.Gray,
                    focusedIndicatorColor = if (navigationState.darkmode) Color.White else Color.Gray,
                    unfocusedIndicatorColor = if (navigationState.darkmode) Color.White else Color.Gray
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
                        if (navigationState.lokalization) "Heslo" else "Password",
                        style = TextStyle(
                            color = if (navigationState.darkmode) Color.White else Color.Gray,
                            fontWeight = FontWeight.Normal
                        )
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = if (navigationState.darkmode) Color.White else Color.DarkGray,
                    backgroundColor = if (navigationState.darkmode) Color.DarkGray else Color(0xFFBCBE9A),
                    cursorColor = if (navigationState.darkmode) Color.White else Color.Gray,
                    focusedIndicatorColor = if (navigationState.darkmode) Color.White else Color.Gray,
                    unfocusedIndicatorColor = if (navigationState.darkmode) Color.White else Color.Gray
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
                            color = if (navigationState.darkmode) Color.White else Color.Gray,
                            fontWeight = FontWeight.Normal
                        )
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = if (navigationState.darkmode) Color.White else Color.DarkGray,
                    backgroundColor = if (navigationState.darkmode) Color.DarkGray else Color(0xFFBCBE9A),
                    cursorColor = if (navigationState.darkmode) Color.White else Color.Gray,
                    focusedIndicatorColor = if (navigationState.darkmode) Color.White else Color.Gray,
                    unfocusedIndicatorColor = if (navigationState.darkmode) Color.White else Color.Gray
                ),
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 60.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = { /* Handle login button click */ },
                colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .size(width = 250.dp,height = 35.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = if (navigationState.lokalization) "Zmeniť údaje" else "Edit profile",
                    color = Color(0xFFE4E4E4),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Handle login button click */ },
                colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .size(width = 250.dp,height = 35.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = if (navigationState.lokalization) "Vymazať profil" else "Delete profile",
                    color = Color(0xFFE4E4E4),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(250.dp))

        }
    }

}