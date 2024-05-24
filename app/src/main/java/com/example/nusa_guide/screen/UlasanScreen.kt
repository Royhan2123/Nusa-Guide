package com.example.nusa_guide.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun UlasanScreen(navController: NavController) {
    Column (
        modifier = Modifier.padding(20.dp)
            .fillMaxSize()
    ) {

    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewUlasanScreen() {
    UlasanScreen(navController = rememberNavController())
}