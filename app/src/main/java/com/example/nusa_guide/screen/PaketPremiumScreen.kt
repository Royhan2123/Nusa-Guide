package com.example.nusa_guide.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.component.PaketPremiumItem
import com.example.nusa_guide.model.PaketPremium
import com.example.nusa_guide.ui.theme.NusaGuideTheme

@Composable
fun PaketPremiumScreen(
    navController: NavController,
    paketPremiumList: List<PaketPremium>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(140.dp),
        contentPadding = PaddingValues(2.dp)
    ) {
        items(paketPremiumList.size) { index ->
            PaketPremiumItem(paketPremium = paketPremiumList[index])
        }
    }
}




@Preview(showBackground = true)
@Composable
fun PaketPremiumScreenPreview() {
    NusaGuideTheme {
        val dummyData = listOf(
            PaketPremium(
                id = 1,
                nama = "10 Wisata - 9 Hari",
                gambar = R.drawable.tour_image_1,
                harga = 350000,
                jarak = 64
            ),
            PaketPremium(
                id = 2,
                nama = "7 Wisata - 7 Hari",
                gambar = R.drawable.tour_image_1,
                harga = 400000,
                jarak = 64
            ),
            PaketPremium(
                id = 3,
                nama = "15 Wisata - 10 Hari",
                gambar = R.drawable.tour_image_1,
                harga = 450000,
                jarak = 64
            ),
            PaketPremium(
                id = 4,
                nama = "7  Wisata - 6 Hari",
                gambar = R.drawable.tour_image_1,
                harga = 500000,
                jarak = 64
            ),
            PaketPremium(
                id = 5,
                nama = "10 Wisata - 9 Hari",
                gambar = R.drawable.tour_image_1,
                harga = 550000,
                jarak = 64
            ),
            PaketPremium(
                id = 6,
                nama = "7 Wisata - 7 Hari",
                gambar = R.drawable.tour_image_1,
                harga = 550000,
                jarak = 64
            ),
        )
        PaketPremiumScreen(rememberNavController(), dummyData)
    }
}