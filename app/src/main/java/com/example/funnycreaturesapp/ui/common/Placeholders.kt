package com.example.funnycreaturesapp.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RectangleShape(
    size: RectangleShapeSize,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .wrapContentSize(Alignment.Center)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
            .size(rectangleSizeResolver(size))
            .clip(androidx.compose.ui.graphics.RectangleShape)
            .background(Color.LightGray)
        ) {
            Text(text = text)
        }
    }
}

fun rectangleSizeResolver(size: RectangleShapeSize): Dp =
    when(size) {
        RectangleShapeSize.BIG -> 120.dp
        RectangleShapeSize.MEDIUM -> 70.dp
        RectangleShapeSize.SMALL -> 30.dp
    }

enum class RectangleShapeSize {
    BIG, MEDIUM, SMALL,
}