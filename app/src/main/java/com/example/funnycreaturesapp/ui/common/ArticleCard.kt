package com.example.funnycreaturesapp.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.imageLoader
import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.data.DataSourceImpl
import com.example.funnycreaturesapp.data.mappers.DataSourceArticleToUiArticle
import com.example.funnycreaturesapp.models.ArticleUI

@Composable
fun ArticleCard(
    onItemClicked: (String) -> Unit,
    item: ArticleUI,
    isFavourite: Boolean,
    onFavouriteClicked: (ArticleUI) -> Unit,
) {
    Card(
        onClick = {
            onItemClicked(item.id)
        },
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .height(230.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Column {
                Box(
                    contentAlignment = Alignment.BottomEnd,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                ) {
                    AsyncImage(
                        model = item.img,
                        contentDescription = item.name,
                        imageLoader = LocalContext.current.imageLoader,
                        contentScale = ContentScale.Crop,
                    )
                    Icon(
                        imageVector = if (isFavourite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        contentDescription = stringResource(id = R.string.is_favourite),
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable {
                                onFavouriteClicked(item)
                            }
                    )
                }

            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp, vertical = 2.dp)
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
                        text = item.price.toString() + stringResource(id = R.string.euro),
                    )
                    Row(
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = stringResource(id = R.string.is_favourite),
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
        onItemClicked = {},
        onFavouriteClicked = {},
        isFavourite = true,
    )
}
