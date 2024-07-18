package com.example.funnycreaturesapp.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.funnycreaturesapp.data.DataSourceArticle.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Categories(
    onCategoryClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier.padding(vertical = 5.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Categories")
            Text(
                text = "See all",
                modifier = Modifier.clickable {
                    // TODO
                }
            )
        }
        LazyRow {
            val categories = Category.entries

            items(categories.size) {
                FilterChip(
                    selected = false,
                    onClick = { onCategoryClicked() },
                    label = {
                        Text(text = categories[it].name)
                    },
                    modifier = Modifier.padding(horizontal = 5.dp)
                )
            }
        }

    }
}

