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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
    listOfArticlesInCart: List<ArticleInCartModel>,
    onIncreaseUnitClicked: (ArticleInCartModel) -> Unit,
    onDecreaseUnitClicked: (ArticleInCartModel) -> Unit,
    onRemoveArticleClicked: (ArticleInCartModel) -> Unit,
    onCheckoutClicked: () -> Unit,
) {

    val viewModel: CartViewModel =
      viewModel(factory = CartViewModel.cartViewModelFactory(listOfArticlesInCart))

    LaunchedEffect(listOfArticlesInCart) {
        viewModel.updateArticles(listOfArticlesInCart)
    }

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
                    ArticleInCart(
                        article = listOfArticlesInCart[index],
                        onIncreaseAmountClicked = { article ->
                            onIncreaseUnitClicked(article)
                        },
                        onDecreaseAmountClicked = { article ->
                            onDecreaseUnitClicked(article)
                        },
                        onRemoveArticleClicked = { article ->
                            onRemoveArticleClicked(article)
                        }
                    )
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
                    shape = RoundedCornerShape(topStartPercent = 10, topEndPercent = 10)
                )
                .fillMaxWidth()
                .padding(start = 15.dp, top = 15.dp, end = 15.dp, bottom = 5.dp)
        ) {
            Totals(viewModel, onCheckoutClicked)
        }
    }
}

@Composable
fun Totals(
    viewModel: CartViewModel,
    onCheckoutClicked: () -> Unit,
) {
    val subtotal by viewModel.subtotal.collectAsState()
    val gastosDeEnvio by viewModel.gastosDeEnvio.collectAsState()
    val discount by viewModel.discount.collectAsState()
    val total by viewModel.total.collectAsState()

    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Subtotal")
            Text(text = subtotal.toString())
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Gastos de envío")
            Text(text = gastosDeEnvio.toString())
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Discount")
            Text(text = discount.toString())
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
                text = total.toString(),
                fontWeight = FontWeight.Bold,
            )
        }
    }

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp),
        onClick = { onCheckoutClicked() }
    ) {
        Text(text = "Checkout for ${total}€")
    }

}
