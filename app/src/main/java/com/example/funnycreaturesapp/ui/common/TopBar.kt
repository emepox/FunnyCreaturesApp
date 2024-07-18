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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
                .background(Color.Red)
                .fillMaxWidth()
        ) {
            Text(text = "Funny Creatures")
        }

        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = currentScreen.title),
                    fontSize = 20.sp,
                )
            },
            actions = {
                Box(
                    contentAlignment = Alignment.BottomEnd,
                    modifier = Modifier
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_shopping_basket),
                        contentDescription = "shopping basket",
                    )
                    Text(
                        text = articlesInCart.toString(),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.background(Color.Red)
                    )
                }

            },
            navigationIcon = {
                if (canNavigateBack) {
                    IconButton(onClick = navigateUp) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_button)
                        )
                    }
                }
            },
            windowInsets = WindowInsets(top = 0.dp, bottom = 0.dp),
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.LightGray
            ),
            modifier = Modifier.padding(bottom = 10.dp)
        )
    }

}


/*
Row(
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically,
    modifier = modifier
) {
    Column {
        Text(text = "Funny Creatures")
        Text(text = stringResource(id = currentScreen.title), fontSize = 20.sp)
    }
    Image(
        painter = painterResource(id = R.drawable.baseline_shopping_basket),
        contentDescription = "shopping basket",
    )
}

 */


