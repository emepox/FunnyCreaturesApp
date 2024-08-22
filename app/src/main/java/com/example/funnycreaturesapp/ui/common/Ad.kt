package com.example.funnycreaturesapp.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.imageLoader
import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.utils.AdvertisementCreator.*

@Composable
fun Ad(
    ad: Advertisement,
    onAddClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .background(Color.LightGray, shape = RoundedCornerShape(10))
            .fillMaxWidth()
            .height(150.dp)
            .padding(10.dp)
            .clickable {
                onAddClicked(ad.article)
            },
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            Text(
                text = stringResource(R.string.article_in_offer, ad.article),
                textAlign = TextAlign.Center,
                fontSize = 35.sp,
                lineHeight = 35.sp,
            )

            Text(
                text = stringResource(R.string.discount_amount, ad.discount),
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(Color.Gray, shape = RoundedCornerShape(50))
                    .padding(10.dp)
            )
        }

        AsyncImage(
            model = ad.articleImage,
            contentDescription = ad.article,
            imageLoader = LocalContext.current.imageLoader,
            alignment = Alignment.Center,
            modifier = Modifier
                .weight(0.75f)
        )
    }
}



