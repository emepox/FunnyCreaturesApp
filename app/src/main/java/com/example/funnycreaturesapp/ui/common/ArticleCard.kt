package com.example.funnycreaturesapp.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.Navigator
import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.data.Article
import com.example.funnycreaturesapp.data.DataSourceImpl
import com.example.funnycreaturesapp.ui.FunnyCreaturesAppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleCard(
    onItemClicked: (Int) -> Unit,
    item: Article,
) {
    Card(
        onClick = {
            onItemClicked(0)
        },
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp),
        modifier = Modifier
            .height(230.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(5.dp)
        ) {
            Column {
                Box(
                    contentAlignment = Alignment.BottomEnd,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(Color.Yellow)
                ) {
                    // TODO Image
                    Image(
                        painter = painterResource(
                            id = if (item.isFavourite) R.drawable.baseline_favorite else R.drawable.baseline_favorite_empty
                        ),
                        contentDescription = "Is favourite",
                    )
                }

            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = item.name,
                    modifier = Modifier
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = item.price.toString() + "€",
                    )
                    Row(
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_grade),
                            contentDescription = "Rating"
                        )
                        Text(
                            text = item.rating.toString(),
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ArticlePreview() {
    ArticleCard(item = DataSourceImpl.articles[0], onItemClicked = {})
}
