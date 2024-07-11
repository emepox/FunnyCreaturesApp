package com.example.funnycreaturesapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.ui.theme.FunnyCreaturesAppTheme


@Composable
fun Home(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {

        Text(text = "Home")

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FunnyCreaturesAppTheme {
        Home()
    }
}