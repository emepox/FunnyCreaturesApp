package com.example.funnycreaturesapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.dp
import com.example.funnycreaturesapp.ui.viewModels.UserSettingsViewModel
import kotlinx.coroutines.launch

@Composable
fun SignUp(
    onAccountCreated: () -> Unit,
    viewModel: UserSettingsViewModel,
) {

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
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
            placeholder = { Text(text = "Username") },
            onValueChange = {
                username = it
            })
        TextField(
            value = email,
            placeholder = { Text(text = "Email") },
            onValueChange = {
                email = it
            })
        TextField(
            value = password,
            placeholder = { Text(text = "Password") },
            onValueChange = {
                password = it
            })
        Button(
            onClick = {
                scope.launch {
                    viewModel.signUp(
                        username = username,
                        password = password,
                        email = email,
                    )
                }
                onAccountCreated()
            },
            modifier = Modifier
                .padding(top = 10.dp)
                .width(250.dp)
        ) {
            Text(text = "Save")
        }
    }
}