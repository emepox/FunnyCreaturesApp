package com.example.funnycreaturesapp.ui.common

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.funnycreaturesapp.data.DataSamples
import com.example.funnycreaturesapp.models.ArticleInCartModel
import com.example.funnycreaturesapp.utils.RemoteImageUploader

@Composable
fun ArticleInCart(article: ArticleInCartModel) {

    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .padding(vertical = 10.dp)
        ,
    ) {
        AsyncImage(
            model = RemoteImageUploader.uploadRemoteImage(article.img),
            contentDescription = article.img,
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(start = 20.dp).fillMaxSize()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
                modifier = Modifier.fillMaxWidth().weight(1f).padding(vertical = 10.dp)
            ) {
                Column {
                    Text(
                        text = article.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                    )
                    Text(
                        text = article.category.toString(),
                        color = Color.Gray,
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Italic,
                    )
                }
                Icon(
                    imageVector = Icons.Filled.Clear,
                    contentDescription = "Remove article",
                    modifier = Modifier
                        .clickable {

                    }
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.fillMaxWidth().weight(0.5f)
            ) {
                Text(
                    text = article.price+"€",
                    fontSize = 20.sp,

                )
                CartCounter()
            }
        }
    }

}

@Composable
fun CartCounter() {
    Row {
        Icon(
            imageVector = Icons.Filled.KeyboardArrowDown,
            contentDescription = "Remove",
            modifier = Modifier
                .border(1.dp, color = Color.Gray)
                .clickable {

            }
        )
        Text(
            text = "0",
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        Icon(
            imageVector = Icons.Filled.KeyboardArrowUp,
            contentDescription = "Add",
            modifier = Modifier
                .border(1.dp, color = Color.Gray)
                .clickable {

            }
        )
    }
}

@Preview
@Composable
fun ArticleInCartPreview() {
    ArticleInCart(
        article = DataSamples.sampleOfCartArticles[0]
    )
}