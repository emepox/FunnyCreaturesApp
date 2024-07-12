package com.example.funnycreaturesapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.data.Article

@Composable
fun Article(
    article: Article,
    modifier: Modifier = Modifier,
    isInOffer: Boolean = true,
) {
    Scaffold(
        bottomBar = {
            Divider()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = article.price.toString() + "€",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(20.dp)
                )
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Green
                    ),
                    modifier = Modifier,
                ) {
                    Text(
                        text = "Add to cart",
                        fontSize = 20.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }

        },
        contentWindowInsets = WindowInsets(0.dp)
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .verticalScroll(
                    state = ScrollState(rememberScrollState().value)
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color.Yellow)
                    .border(BorderStroke(2.dp, Color.Gray))
            ) {}
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = article.name,
                    fontSize = 25.sp,
                )
                if (isInOffer) {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Red,
                        ),
                    ) {
                        Text(
                            text = "On Sale",
                            color = Color.White,
                            modifier = Modifier.padding(5.dp),
                        )
                    }
                }
            }
            Row(Modifier.fillMaxWidth()) {
                AssistChip(
                    onClick = { },
                    label = {
                        Text(text = article.rating.toString())
                    },
                    leadingIcon = { Image(
                        painter = painterResource(id = R.drawable.baseline_grade),
                        contentDescription = "Rating"
                    )},
                )
            }
            Text(text = article.description)

        }

    }

}