package com.example.funnycreaturesapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.funnycreaturesapp.ui.viewModels.UserSettingsViewModel
import kotlinx.coroutines.launch

@Composable
fun LogIn(
    onCreateAccountClicked: () -> Unit,
    onLogInSuccessful: () -> Unit,
    viewModel: UserSettingsViewModel
) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        TextField(
            value = username,
            onValueChange = { username = it },
            placeholder = { Text(text = "Username")}
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text(text = "Password")}

        )
        Button(
            onClick = {
                scope.launch {
                    if (viewModel.logIn(username, password)) onLogInSuccessful()
                }
            },
            modifier = Modifier
                .padding(top = 10.dp)
                .width(250.dp)
        ) {
            Text(text = "Log in")
        }
        Text(
            text = "Create an account",
            color = Color.Blue,
            modifier = Modifier
                .padding(10.dp)
                .clickable {
                    onCreateAccountClicked()
                }
        )
    }
}