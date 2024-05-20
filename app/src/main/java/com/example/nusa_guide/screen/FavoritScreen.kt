package com.example.nusa_guide.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun FavoritScreen(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Favorit Screen")
    }
}

@Preview
@Composable
fun PreviewFavoritScreen() {
    FavoritScreen(
        navController = rememberNavController()
    )
}