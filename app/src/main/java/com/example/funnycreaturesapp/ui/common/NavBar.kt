package com.example.funnycreaturesapp.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.ui.FunnyCreaturesAppScreens

@Composable
fun NavBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Divider()
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.baseline_home
            ),
            contentDescription = "Home",
            modifier = modifier
                .size(30.dp)
                .clickable {
                navController.navigate(FunnyCreaturesAppScreens.Home.name)
            }
        )
        Image(
            painter = painterResource(
                id = R.drawable.baseline_manage_search
            ),
            contentDescription = "Search",
            modifier = modifier
                .size(30.dp)
                .clickable {
                navController.navigate(FunnyCreaturesAppScreens.Search.name)
            }
        )
        Image(
            painter = painterResource(
                id = R.drawable.baseline_favorite
            ),
            contentDescription = "Favourites",
            modifier = modifier
                .size(30.dp)
                .clickable {
                navController.navigate(FunnyCreaturesAppScreens.Favourites.name)
            }
        )
        Image(
            painter = painterResource(
                id = R.drawable.baseline_profile_circle
            ),
            contentDescription = "Profile",
            modifier = modifier
                .size(30.dp)
                .clickable {
                navController.navigate(FunnyCreaturesAppScreens.Profile.name)
            }
        )
    }

}