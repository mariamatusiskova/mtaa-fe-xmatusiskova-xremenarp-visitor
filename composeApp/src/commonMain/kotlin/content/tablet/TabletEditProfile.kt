package content.tablet

import TokenManagerProvider
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
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import endpoints.dto.requests.EditEmailRequest
import endpoints.dto.requests.EditPasswordRequest
import endpoints.dto.requests.EditUsernameRequest
import getPlatform
import kotlinx.coroutines.launch
import menu.navigationState
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import visitor.composeapp.generated.resources.Res
import visitor.composeapp.generated.resources.logo

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun loadTabletEditProfile(context: Any?) {

    var selectedOption by remember { mutableStateOf("Username") }
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var retype_password by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()
    val platform = getPlatform()
    val client = platform.create()

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
                .padding(top = 200.dp)
                .background(
                    color = if (navigationState.lokalization) Color.DarkGray else Color(0xFFBCBE9A),
                    shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp)
                ),
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.height(30.dp))

            var isMenuExpanded by remember { mutableStateOf(false) }

            Button(
                onClick = { isMenuExpanded = true },
                colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .size(width = 250.dp, height = 35.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = if (navigationState.lokalization) "Vyber možnosť" else "Select option",
                    color = Color(0xFFE4E4E4),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            DropdownMenu(
                expanded = isMenuExpanded,
                onDismissRequest = { isMenuExpanded = false }
            ) {
                DropdownMenuItem(onClick = {
                    selectedOption = "Username"
                    isMenuExpanded = false
                }) {
                    Text(
                        text = if (navigationState.lokalization) "Meno" else "Username",
                        style = TextStyle(
                            color = if (navigationState.darkmode) Color.White else Color.Gray,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                DropdownMenuItem(onClick = {
                    selectedOption = "Email"
                    isMenuExpanded = false
                }) {
                    Text(
                        text = if (navigationState.lokalization) "Email" else "Email",
                        style = TextStyle(
                            color = if (navigationState.darkmode) Color.White else Color.Gray,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                DropdownMenuItem(onClick = {
                    selectedOption = "Password"
                    isMenuExpanded = false
                }) {
                    Text(
                        text = if (navigationState.lokalization) "Heslo" else "Password",
                        style = TextStyle(
                            color = if (navigationState.darkmode) Color.White else Color.Gray,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
            }

            val buttonLabel = when (selectedOption) {
                "Username" -> if (navigationState.lokalization) "Zmeniť používateľské meno" else "Change Username"
                "Email" -> if (navigationState.lokalization) "Zmeniť email" else "Change Email"
                "Password" -> if (navigationState.lokalization) "Zmeniť heslo" else "Change Password"
                "ConfirmPassword" -> if (navigationState.lokalization) "Potvrdiť zmeny hesla" else "Confirm Password Change"
                else -> if (navigationState.lokalization) "Vyber možnosť" else "Select Option"
            }

            val placeholderText = when (selectedOption) {
                "Username" -> if (navigationState.lokalization) "Zadajte nové používateľské meno" else "Enter new username"
                "Email" -> if (navigationState.lokalization) "Zadajte nový email" else "Enter new email"
                "Password" -> if (navigationState.lokalization) "Zadajte nové heslo" else "Enter new password"
                "ConfirmPassword" -> if (navigationState.lokalization) "Potvrďte nové heslo" else "Confirm new password"
                else -> ""
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = when (selectedOption) {
                    "Username" -> username
                    "Email" -> email
                    "Password" -> password
                    "ConfirmPassword" -> retype_password
                    else -> ""
                },
                onValueChange = {
                    when (selectedOption) {
                        "Username" -> username = it
                        "Email" -> email = it
                        "Password" -> password = it
                        "ConfirmPassword" -> retype_password = it
                    }
                },
                label = {
                    Text(
                        text = placeholderText,
                        style = TextStyle(
                            color = if (navigationState.darkmode) Color.White else Color.Gray,
                            fontWeight = FontWeight.Normal
                        )
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = if (navigationState.darkmode) Color.White else Color.DarkGray,
                    backgroundColor = if (navigationState.darkmode) Color.DarkGray else Color(0xFFBCBE9A),
                    cursorColor = if (navigationState.darkmode) Color.White else Color.Gray,
                    focusedBorderColor = if (navigationState.darkmode) Color.White else Color.Gray,
                    unfocusedBorderColor = if (navigationState.darkmode) Color.White else Color.Gray
                ),
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                singleLine = true,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 60.dp)
            )

            if (selectedOption == "Password") {

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = retype_password,
                    onValueChange = { retype_password = it },
                    label = {
                        Text(
                            text = if (navigationState.lokalization) "Potvrďte nové heslo" else "Confirm new password",
                            style = TextStyle(
                                color = if (navigationState.darkmode) Color.White else Color.Gray,
                                fontWeight = FontWeight.Normal
                            )
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = if (navigationState.darkmode) Color.White else Color.DarkGray,
                        backgroundColor = if (navigationState.darkmode) Color.DarkGray else Color(0xFFBCBE9A),
                        cursorColor = if (navigationState.darkmode) Color.White else Color.Gray,
                        focusedBorderColor = if (navigationState.darkmode) Color.White else Color.Gray,
                        unfocusedBorderColor = if (navigationState.darkmode) Color.White else Color.Gray
                    ),
                    textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 60.dp)
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {
                    scope.launch {
                        when (selectedOption) {
                            "Username" -> {
                                val edit = EditUsernameRequest(username)
                                val tokenManager =
                                    context?.let { TokenManagerProvider.provideTokenManager(it) }
                                tokenManager?.let { it1 ->
                                    client.patchEditProfile(it1, edit)
                                }
                            }
                            "Email" -> {
                                val edit = EditEmailRequest(email)
                                val tokenManager =
                                    context?.let { TokenManagerProvider.provideTokenManager(it) }
                                tokenManager?.let { it1 ->
                                    client.patchEditProfile(it1, edit)
                                }
                            }
                            "Password" -> {
                                val edit = EditPasswordRequest(password, retype_password)
                                val tokenManager =
                                    context?.let { TokenManagerProvider.provideTokenManager(it) }
                                tokenManager?.let { it1 ->
                                    client.patchEditProfile(it1, edit)
                                }
                            }
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .size(width = 250.dp, height = 50.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = buttonLabel,
                    color = Color(0xFFE4E4E4),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = {
                    scope.launch {
                        val tokenManager =
                            context?.let { TokenManagerProvider.provideTokenManager(it) }
                        tokenManager?.let { it1 ->
                            client.deleteAccount(it1)
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
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .size(width = 250.dp, height = 35.dp)
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