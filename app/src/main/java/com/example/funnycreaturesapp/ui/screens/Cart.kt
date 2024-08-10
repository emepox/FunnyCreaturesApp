package com.example.funnycreaturesapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.funnycreaturesapp.models.ArticleInCartModel
import com.example.funnycreaturesapp.ui.common.ArticleInCart
import com.example.funnycreaturesapp.ui.viewModels.CartViewModel

@Composable
fun Cart(
    listOfArticlesInCart: List<ArticleInCartModel>
) {
    val viewModel: CartViewModel =
        viewModel(factory = CartViewModel.cartViewModelFactory(listOfArticlesInCart))

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 180.dp)
        ) {
            items(
                count = listOfArticlesInCart.size,
                itemContent = { index ->
                    ArticleInCart(article = viewModel.listOfArticlesInCart[index])
                    if (listOfArticlesInCart[index] != listOfArticlesInCart[0]) {
                        HorizontalDivider()
                    }
                }
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .background(
                    color = Color.LightGray,
                    shape = RoundedCornerShape(topStartPercent = 10, topEndPercent = 10))
                .fillMaxWidth()
                .padding(start = 15.dp, top = 15.dp, end = 15.dp, bottom = 5.dp)
        ) {
            Totals()
        }
    }
}

@Composable
fun Totals() {

    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Subtotal")
            Text(text = "300€")
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Gastos de envío")
            Text(text = "100€")
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Discount")
            Text(text = "25%")
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "TOTAL",
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "1.000€",
                fontWeight = FontWeight.Bold,
            )
        }
    }

    Button(
        modifier = Modifier.fillMaxWidth().padding(top = 5.dp),
        onClick = { /*TODO*/ }
    ) {
        Text(text = "Checkout for 2.000€")
    }

}
