package login

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import visitor.composeapp.generated.resources.Res
import visitor.composeapp.generated.resources.logo

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun loadLoginScreen() {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA1A556))
    ) {

        Image(
            modifier = Modifier.fillMaxSize(1f),
            painter = painterResource(Res.drawable.logo),
            contentDescription = "Logo"
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
//                    .padding(horizontal = 16.dp)
                .padding(top = 200.dp)
                .background(
                    color = Color(0xFFBCBE9A),
                    shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp)
                ),
            verticalArrangement = Arrangement.Center
        ) {

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { /* Handle login button click */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.Red,
                    )
            ) {
                Text(text = "Log in")
            }
        }
    }
}
