package com.example.funnycreaturesapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.funnycreaturesapp.R
import com.example.funnycreaturesapp.ui.viewModels.UserSettingsViewModel
import kotlinx.coroutines.launch

@Composable
fun Profile(
    onLogOutClicked: () -> Unit,
    viewModel: UserSettingsViewModel,
    isSessionActive: Boolean,
    modifier: Modifier = Modifier
) {

    val scope = rememberCoroutineScope()

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val activeUserUsername by viewModel.username.collectAsState()
    val activeUserEmail by viewModel.email.collectAsState()
    val activeUserPassword by viewModel.password.collectAsState()

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                colors = CardDefaults.cardColors(
                     containerColor = MaterialTheme.colorScheme.secondary
                ),
            ) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = stringResource(id = R.string.profile_picture),
                    tint = Color.Black,
                    modifier = Modifier.size(100.dp),
                )
                Text(
                    text = stringResource(id = R.string.change_image),
                    color = Color.Black,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable { }
                )
            }
            if (isSessionActive) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(start = 10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = Color.Black,
                    )
                ) {

                    Text(
                        text = stringResource(id = R.string.your_data),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp)
                    )
                    Column(modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)) {
                        Text(
                            text = stringResource(id = R.string.username),
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = activeUserUsername
                        )
                        HorizontalDivider()
                    }

                    Column(modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)) {
                        Text(
                            text = stringResource(id = R.string.email),
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = activeUserEmail
                        )
                        HorizontalDivider()
                    }
                    Column(modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)) {
                        Text(
                            text = stringResource(id = R.string.password),
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = activeUserPassword
                        )
                    }

                }
            }
        }

        Card(
            modifier = Modifier,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = Color.Black,
            )
        ) {
            Text(
                text = stringResource(id = R.string.change_data),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
            )
            TextField(
                value = username,
                onValueChange = { username = it },
                placeholder = {
                    Text(
                        text = stringResource(
                            id = R.string.username
                        ),
                    )
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
            )
            TextField(
                value = email,
                onValueChange = { email = it },
                placeholder = {
                    Text(
                        text = stringResource(
                            id = R.string.email
                        ),
                    )
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)

            )
            TextField(
                value = password,
                onValueChange = { password = it },
                placeholder = {
                    Text(
                        text = stringResource(
                            id = R.string.password
                        ),
                    )
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp, bottom = 10.dp)
            )
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth()
        ) {
            Button(
                onClick = {
                    scope.launch {
                        viewModel.saveNewData(
                            username = username,
                            email = email,
                            password = password,
                        )
                    }
                },
                modifier = Modifier
                    .padding(top = 10.dp)
                    .width(250.dp)
            ) {
                Text(text = stringResource(id = R.string.save))
            }
            Text(
                text = stringResource(id = R.string.log_out),
                color = Color.Blue,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .clickable {
                        scope.launch {
                            viewModel.logOut()
                        }
                        onLogOutClicked()
                    }
            )
        }
    }
}