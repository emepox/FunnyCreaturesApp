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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.models.ArticleInCartModel
import com.example.funnycreaturesapp.ui.common.ArticleInCart
import com.example.funnycreaturesapp.ui.viewModels.CartViewModel

@Composable
fun Cart(
    listOfArticlesInCart: List<ArticleInCartModel>,
    onIncreaseUnitClicked: (ArticleInCartModel) -> Unit,
    onDecreaseUnitClicked: (ArticleInCartModel) -> Unit,
    onRemoveArticleClicked: (ArticleInCartModel) -> Unit,
    onGoBackButtonClicked: () -> Unit,
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
        
        if(listOfArticlesInCart.isEmpty()) {
            Text(
                text = stringResource(id = R.string.empty_cart),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            )
        }
        
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
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(topStartPercent = 10, topEndPercent = 10)
                )
                .fillMaxWidth()
                .padding(start = 15.dp, top = 15.dp, end = 15.dp, bottom = 5.dp)
        ) {
            if(listOfArticlesInCart.isNotEmpty()) {
                Totals(viewModel, onCheckoutClicked)
            } else {
                Button(
                    onClick = { onGoBackButtonClicked() },
                    modifier = Modifier.fillMaxWidth(),
                )
                {
                    Text(text = stringResource(id = R.string.go_back))
                }
            }
        }
    }
}

@Composable
fun Totals(
    viewModel: CartViewModel,
    onCheckoutClicked: () -> Unit,
) {
    val subtotal by viewModel.subtotal.collectAsState()
    val gastosDeEnvio by viewModel.shippingCosts.collectAsState()
    val discount by viewModel.discount.collectAsState()
    val total by viewModel.total.collectAsState()

    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.subtotal))
            Text(text = subtotal.toString())
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.shipping))
            Text(text = gastosDeEnvio.toString())
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.discount))
            Text(text = discount.toString())
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.total),
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
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),
        onClick = {
            onCheckoutClicked()
        }
    ) {
        Text(text = stringResource(id = R.string.checkout_amount, total))
    }

}
