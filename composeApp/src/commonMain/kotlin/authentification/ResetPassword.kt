/**
 * The mobile module for reset password screen with needed/related components.
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
import menu.navigationState
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview


/**
 * Cross-platform function to load reset password screen when user chose this option.
 *
 * This screen allows the user to reset his password by entering their email,
 * new password, and re-entering the new password for confirmation.
 * In the BE section these data will be checked. If the email exists
 * and the passwords are equal.
 *
 * @sample authentification.loadResetPassword
 */
@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun loadResetPassword() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var retype_password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA1A556))
    ) {

        Text(
            "Reset\npassword",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            fontSize = 40.sp,
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
                fontSize = 30.sp,
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
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(
                        "Email",
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
                value = retype_password,
                onValueChange = { retype_password = it },
                label = {
                    Text(
                        "Retype password",
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
                    .size(width = 250.dp,height = 35.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Continue",
                    color = Color(0xFFE4E4E4),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}