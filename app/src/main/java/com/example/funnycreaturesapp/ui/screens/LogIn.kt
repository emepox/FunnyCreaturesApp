package com.example.funnycreaturesapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LogIn(
    onCreateAccountClicked: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        TextField(value = "Email", onValueChange = {})
        TextField(value = "Password", onValueChange = {})
        Button(
            onClick = { /*TODO*/ },
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