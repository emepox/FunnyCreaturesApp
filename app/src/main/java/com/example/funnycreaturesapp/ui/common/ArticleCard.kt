package com.example.funnycreaturesapp.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.imageLoader
import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.data.DataSource
import com.example.funnycreaturesapp.data.DataSourceArticle
import com.example.funnycreaturesapp.data.DataSourceImpl
import com.example.funnycreaturesapp.data.mappers.DataSourceArticleToUiArticle
import com.example.funnycreaturesapp.ui.viewModels.ArticleUI

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleCard(
    onItemClicked: (String) -> Unit,
    item: ArticleUI,
) {
    Card(
        onClick = {
            onItemClicked(item.id)
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
                        .aspectRatio(1f)
                ) {
                    println("TESTING - " +item.img)
                    AsyncImage(
                        model = item.img,
                        contentDescription = item.name,
                        imageLoader = LocalContext.current.imageLoader,
                        contentScale = ContentScale.Crop,
                    )
                    Image(
                        painter = painterResource(
                            id = if (item.isFavourite) R.drawable.baseline_favorite else R.drawable.baseline_favorite_empty
                        ),
                        contentDescription = "Is favourite",
                        modifier = Modifier
                            .padding(5.dp)
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
                        text = item.price + "€",
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
                            text = item.rating,
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
    ArticleCard(
        item = DataSourceArticleToUiArticle.mapToUiModel(DataSourceImpl.dataSourceArticles[0]),
        onItemClicked = {}
    )
}
