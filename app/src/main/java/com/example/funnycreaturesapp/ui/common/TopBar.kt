package com.example.funnycreaturesapp.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgeDefaults
import androidx.compose.material3.BadgeDefaults.containerColor
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.ui.FunnyCreaturesAppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    currentScreen: FunnyCreaturesAppScreens,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    articlesInCart: Int,
    modifier: Modifier = Modifier,
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
        ) {
            Text(
                text = "Funny Creatures",
                fontWeight = FontWeight.Bold,
                letterSpacing = 10.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Monospace,
                color = Color.DarkGray,
            )
        }

        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = currentScreen.title),
                    fontSize = 15.sp,
                )
            },
            actions = {
                BadgedBox(
                    modifier = Modifier,
                    badge = {
                        Text(
                            modifier = Modifier
                                .background(Color.Red),
                            text = if (articlesInCart == 0) "" else articlesInCart.toString(),
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace,
                        )
                    },
                    content = {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = "Items in cart",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                )
            },
            navigationIcon = {
                if (canNavigateBack) {
                    IconButton(onClick = navigateUp) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_button)
                        )
                    }
                }
            },
            expandedHeight = 40.dp,
            windowInsets = WindowInsets(top = 0.dp, bottom = 0.dp),
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.LightGray
            ),
            modifier = Modifier
                .padding(bottom = 10.dp)
                .clip(shape = RoundedCornerShape(30))
        )
    }
}


