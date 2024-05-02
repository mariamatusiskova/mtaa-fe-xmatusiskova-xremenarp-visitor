/**
 * The mobile module for login screen with needed/related components.
 */

package authentification

import TokenManagerProvider
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedButton
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import endpoints.dto.requests.LoginRequest
import getPlatform
import kotlinx.coroutines.launch
import menu.navigationState
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import visitor.composeapp.generated.resources.Res
import visitor.composeapp.generated.resources.logo

/**
 * Composable function to load the login screen.
 *
 * @param[context] Any (instance) context object representing which OS is current.
 * @sample authentification.loadLoginScreen
 */
@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun loadLoginScreen(context: Any?) {

    val scope = rememberCoroutineScope()
    val platform = getPlatform()
    val client = platform.create()

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {
                    scope.launch {
                        val login = LoginRequest(username, password)
                        val loginResponse = client.postLogin(login)
                        loginResponse?.let { token ->
                            saveJwtTokenAfterLogin(token, context)
                            if (token.isNotEmpty()) {
                                navigationState.settings = false
                                navigationState.allPlaces = true
                                navigationState.editProfile = false
                                navigationState.gpsPlaces = false
                                navigationState.favouritePlaces = false
                                navigationState.category = false
                                navigationState.resetPassword = false
                                navigationState.signup = false
                                navigationState.login = false
                            }
                        }
                    }
                },
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

            TextButton(
                onClick = {
                    navigationState.settings = false
                    navigationState.allPlaces = false
                    navigationState.editProfile = false
                    navigationState.gpsPlaces = false
                    navigationState.favouritePlaces = false
                    navigationState.category = false
                    navigationState.resetPassword = true
                    navigationState.signup = false
                    navigationState.login = false
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Forgotten password?",
                    color = Color(0xFFE4E4E4),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedButton(
                onClick = {
                    navigationState.settings = false
                    navigationState.allPlaces = false
                    navigationState.editProfile = false
                    navigationState.gpsPlaces = false
                    navigationState.favouritePlaces = false
                    navigationState.category = false
                    navigationState.resetPassword = false
                    navigationState.signup = true
                    navigationState.login = false
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                border = BorderStroke(2.dp, Color(0xFFA1A556)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Sign up",
                    color = Color(0xFFA1A556),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


/**
 * Saves the JWT token after login into the system memory.
 *
 * @param[token] The JWT token string.
 * @param[context] Any context object.
 */
fun saveJwtTokenAfterLogin(token: String, context: Any?) {
    val tokenManager = context?.let { TokenManagerProvider.provideTokenManager(it) }

    if (tokenManager != null) {
        tokenManager.saveJwtToken(token)
    }
}


/**
 * Retrieves the JWT token from the system memory.
 *
 * @param[context] Any (instance) context object.
 * @return The JWT token string.
 */
fun getJwtToken(context: Any?): String? {
    val tokenManager = context?.let { TokenManagerProvider.provideTokenManager(it) }

    return tokenManager?.getJwtToken()
}


/**
 * Clears the JWT token from the system memory.
 *
 * @param[context] Any (instance) context object.
 */
fun clearJwtToken(context: Any?) {
    val tokenManager = context?.let { TokenManagerProvider.provideTokenManager(it) }

    tokenManager?.clearJwtToken()
}

