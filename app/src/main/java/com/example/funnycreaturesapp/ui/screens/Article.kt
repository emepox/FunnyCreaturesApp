package com.example.funnycreaturesapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import coil.compose.AsyncImage
import coil.imageLoader
import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.models.Article

@Composable
fun Article(
    selectedArticle: Article,
    onAddClicked: (Article, Int) -> Unit,
    isFavourite: Boolean,
    onFavouriteClicked: (Article) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        bottomBar = {
            HorizontalDivider()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                var amount by remember { mutableStateOf("1") }

                Text(
                    text = selectedArticle.price.toString() + stringResource(id = R.string.euro),
                    fontSize = 30.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )

                TextField(
                    value = amount,
                    onValueChange = { input ->
                        if (input.length <= 2 && input.isDigitsOnly())
                            amount = input
                    },
                    modifier = Modifier.width(50.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true,
                    placeholder = { 
                        Text(text = stringResource(id = R.string.one)) 
                    }
                )

                Button(
                    onClick = {
                        onAddClicked(selectedArticle, amount.toInt())
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier,
                ) {
                    Text(
                        text = stringResource(id = R.string.add),
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier.padding(5.dp)
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
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .border(BorderStroke(2.dp, Color.Gray))
            ) {
                AsyncImage(
                    model = selectedArticle.img,
                    contentDescription = selectedArticle.name,
                    imageLoader = LocalContext.current.imageLoader,
                    )
                Icon(
                    imageVector = if (isFavourite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = stringResource(id = R.string.is_favourite),
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            onFavouriteClicked(selectedArticle)
                        }
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = selectedArticle.name,
                    fontSize = 25.sp,
                )
                if (selectedArticle.isInOffer) {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Red,
                        ),
                    ) {
                        Text(
                            text = stringResource(id = R.string.on_sale),
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
                        Text(text = selectedArticle.rating)
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Star,
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = stringResource(id = R.string.rating),
                        )
                    },
                )
            }
            Text(text = selectedArticle.description)

        }

    }

}