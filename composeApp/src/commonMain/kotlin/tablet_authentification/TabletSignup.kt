/**
 * The tablet module for signup screen with needed/related components.
 */

package authentification

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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import endpoints.dto.requests.SignupRequest
import getPlatform
import kotlinx.coroutines.launch
import menu.navigationState
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Cross-platform function to display signup screen to register user into app.
 *
 * User's input contains username, email, password and confirm password.
 * The by button Signup will be send request into the system to register user.
 *
 * @sample authentification.tabletloadSignupScreen
 */
@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun tabletloadSignupScreen() {

    val scope = rememberCoroutineScope()
    val platform = getPlatform()
    val client = platform.create()

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirm_password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA1A556))
    ) {

        Text(
            "Create\naccount",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            fontSize = 50.sp,
            color = Color(0xFFE4E4E4),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp, start = 30.dp)
        )

        TextButton(
            onClick = {
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
            modifier = Modifier
                .padding(top = 20.dp, end = 16.dp)
                .align(Alignment.TopEnd)
        ) {
            Text(
                text = "X",
                color = Color(0xFFE4E4E4),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 200.dp)
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
                            fontSize = 25.sp,
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
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(
                        "Email",
                        style = TextStyle(
                            fontSize = 25.sp,
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
                            fontSize = 25.sp,
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
                value = confirm_password,
                onValueChange = { confirm_password = it },
                label = {
                    Text(
                        "Confirm password",
                        style = TextStyle(
                            fontSize = 25.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Normal
                        )
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
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

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {
                        scope.launch {
                            val signup = SignupRequest(username, email, password, confirm_password)
                            client.postSignup(signup)
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
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFA1A556)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .size(width = 450.dp,height = 65.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Sign up",
                    color = Color(0xFFE4E4E4),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            TextButton(
                onClick = {
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
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 30.dp)
            ) {
                Text(
                    text = "Sign in",
                    color = Color(0xFFA1A556),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                )
            }

            Text(
                text = "Already have an account?",
                color = Color(0xFFE4E4E4),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 30.dp)
            )

        }
    }
}