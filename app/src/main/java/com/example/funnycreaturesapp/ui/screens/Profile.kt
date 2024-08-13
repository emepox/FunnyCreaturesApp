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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Profile(
    onLogOutClicked: () -> Unit,
    onSaveNewCredentials: () -> Unit,
    modifier: Modifier = Modifier
) {
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
        TextField(value = "Name", onValueChange = {})
        TextField(value = "Email", onValueChange = {})
        TextField(value = "Password", onValueChange = {})
        Button(
            onClick = {
                onSaveNewCredentials()
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
                    onLogOutClicked()
                }
        )
    }
}