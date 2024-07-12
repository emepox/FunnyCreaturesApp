package com.example.funnycreaturesapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.funnycreaturesapp.R

@Composable
fun Profile(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        Card(
            modifier = Modifier.padding(bottom = 10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_profile_circle),
                contentDescription = "Profile picture",
                modifier = Modifier.size(100.dp)
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
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(top = 10.dp)
                .width(250.dp)
        ) {
            Text(text = "Save")
        }

    }
}