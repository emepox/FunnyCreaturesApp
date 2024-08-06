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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.imageLoader
import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.ui.viewModels.ArticleUI
import com.example.funnycreaturesapp.ui.viewModels.ArticleViewModel

@Composable
fun Article(
    selectedArticle: ArticleUI,
    onAddClicked: (ArticleUI, Int) -> Unit,
    modifier: Modifier = Modifier,
) {

    val viewModel: ArticleViewModel =
        viewModel(factory = ArticleViewModel.articleViewModelFactory(selectedArticle))

    val state by viewModel.articleUI.collectAsState()

    Scaffold(
        bottomBar = {
            Divider()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                var amount by remember { mutableStateOf("1") }

                Text(
                    text = state.price + "€",
                    fontSize = 40.sp,
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
                    modifier = Modifier.width(60.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true,
                    placeholder = { Text(text = "1") }
                )

                Button(
                    onClick = {
                        onAddClicked(selectedArticle, amount.toInt())
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Green
                    ),
                    modifier = Modifier,
                ) {
                    Text(
                        text = "Add",
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
                Image(
                    painter = painterResource(
                        id = if (selectedArticle.isFavourite) R.drawable.baseline_favorite else R.drawable.baseline_favorite_empty
                    ),
                    contentDescription = "Is favourite",
                    modifier = Modifier.padding(10.dp),
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
                    text = state.name,
                    fontSize = 25.sp,
                )
                if (state.isInOffer) {
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
                        Text(text = state.rating)
                    },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_grade),
                            contentDescription = "Rating"
                        )
                    },
                )
            }
            Text(text = state.description)

        }

    }

}