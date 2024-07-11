package com.example.funnycreaturesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.funnycreaturesapp.ui.FunnyCreaturesApp
import com.example.funnycreaturesapp.ui.theme.FunnyCreaturesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FunnyCreaturesAppTheme {
                FunnyCreaturesApp()
            }
        }
    }
}


