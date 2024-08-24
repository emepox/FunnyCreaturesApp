package com.example.funnycreaturesapp.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.ui.FunnyCreaturesAppScreens

@Composable
fun NavBar(
    navController: NavHostController,
    activeSession: Boolean,
    modifier: Modifier = Modifier,
) {
    HorizontalDivider()
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Filled.Home,
            contentDescription = stringResource(id = R.string.home),
            modifier = modifier
                .size(30.dp)
                .clickable {
                    navController.navigate(FunnyCreaturesAppScreens.Home.name)
                }
        )
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.search),
            modifier = modifier
                .size(30.dp)
                .clickable {
                    navController.navigate(FunnyCreaturesAppScreens.Search.name)
                }
        )
        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription = stringResource(id = R.string.favourites),
            modifier = modifier
                .size(30.dp)
                .clickable {
                    navController.navigate(FunnyCreaturesAppScreens.Favourites.name)
                }
        )
        Icon(
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = stringResource(id = R.string.profile),
            tint = if (activeSession) MaterialTheme.colorScheme.primary else Color.Black,
            modifier = modifier
                .size(30.dp)
                .clickable {
                    if (activeSession) {
                        navController.navigate(FunnyCreaturesAppScreens.Profile.name)
                    } else {
                        navController.navigate(FunnyCreaturesAppScreens.LogIn.name)
                    }
                }
        )
    }
}