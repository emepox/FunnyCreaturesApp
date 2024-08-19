package com.example.funnycreaturesapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.funnycreaturesapp.models.UserSettings
import com.example.funnycreaturesapp.ui.viewModels.UserSettingsViewModel
import kotlinx.coroutines.launch

@Composable
fun Profile(
    onLogOutClicked: () -> Unit,
    viewModel: UserSettingsViewModel,
    activeUser: UserSettings?,
    modifier: Modifier = Modifier
) {

    val scope = rememberCoroutineScope()
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column {
        Card(
            modifier = Modifier.padding(bottom = 10.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "Profile picture",
                modifier = Modifier.size(100.dp),
            )
            Text(
                text = "Change image",
                modifier = Modifier
                    .padding(10.dp)
                    .clickable { } // TODO
            )
        }
        TextField(
            value = activeUser?.username ?: username,
            onValueChange = { username = it })
        TextField(
            value = activeUser?.email ?: email,
            onValueChange = { email = it })
        TextField(
            value = activeUser?.password ?: password,
            onValueChange = { password = it })
        Button(
            onClick = {
                scope.launch {
                    viewModel.signUp(
                        username, password, email
                    )
                }
            },
            modifier = Modifier
                .padding(top = 10.dp)
                .width(250.dp)
        ) {
            Text(text = "Save")
        }
        Text(
            text = "Log out",
            color = Color.Blue,
            modifier = Modifier
                .clickable {
                    scope.launch {
                        viewModel.logOut()
                    }
                    onLogOutClicked()
                }
        )
    }
}