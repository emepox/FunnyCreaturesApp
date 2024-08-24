package com.example.funnycreaturesapp.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.models.Category

@Composable
fun Categories(
    onCategoryClicked: (Category) -> Unit,
    onSeeAllClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier.padding(vertical = 10.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.categories))
            Text(
                text = stringResource(id = R.string.see_all),
                modifier = Modifier.clickable {
                    onSeeAllClicked()
                }
            )
        }
        LazyRow {
            val categories = Category.entries

            items(categories.size) {
                FilterChip(
                    selected = false,
                    onClick = {
                        onCategoryClicked(categories[it])
                    },
                    label = {
                        Text(
                            text = categories[it].name,
                            fontWeight = FontWeight.Bold,
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        labelColor = Color.White
                    ),
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                )
            }
        }

    }
}

