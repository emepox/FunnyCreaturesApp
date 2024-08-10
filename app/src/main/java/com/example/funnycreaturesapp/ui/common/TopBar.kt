package com.example.funnycreaturesapp.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
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
    Column() {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
                .background(Color.DarkGray)
        ) {
            Text(
                text = "Funny Creatures",
                fontWeight = FontWeight.Bold,
                letterSpacing = 10.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Monospace,
                color = Color.White,
            )
        }

        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = currentScreen.title),
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            actions = {
                BadgedBox(
                    modifier = Modifier.padding(start = 15.dp),
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
                            modifier = Modifier.size(30.dp)
                        )
                    }
                )
            },
            navigationIcon = {
                if (canNavigateBack) {
                    IconButton(onClick = navigateUp) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_button),
                            modifier = Modifier

                        )
                    }
                }
            },
            expandedHeight = 30.dp,
            windowInsets = WindowInsets(top = 0.dp, bottom = 0.dp),
            modifier = Modifier.offset(x = ((-10).dp))
        )
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 5.dp)
        )
    }
}


