package com.example.nusa_guide.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.model.PaketRegular
import com.example.nusa_guide.ui.theme.NusaGuideTheme

@Composable
fun PaketRegularScreen(
    navController: NavController,
    paketRegularList: List<PaketRegular>
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(140.dp),
        contentPadding = PaddingValues(2.dp)
    ) {
        items(paketRegularList) { paket ->
            PaketRegularItem(paketRegular = paket)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaketRegularScreenPreview() {
    NusaGuideTheme {
        val dummyData = listOf(
            PaketRegular(
                id = 1,
                nama = "3 Wisata - 2 Hari",
                gambar = R.drawable.tour_image_1,
                harga = 350000,
                jarak = 0.64,
                rating = 4.5f
            ),
            PaketRegular(
                id = 2,
                nama = "2 Wisata - 1 Hari",
                gambar = R.drawable.tour_image_1,
                harga = 250000,
                jarak = 0.34,
                rating = 4.0f
            ),
            PaketRegular(
                id = 3,
                nama = "4 Wisata - 3 Hari",
                gambar = R.drawable.tour_image_1,
                harga = 450000,
                jarak = 1.0,
                rating = 4.8f
            ),
            PaketRegular(
                id = 4,
                nama = "5 Wisata - 4 Hari",
                gambar = R.drawable.tour_image_1,
                harga = 500000,
                jarak = 1.5,
                rating = 4.7f
            ),
            PaketRegular(
                id = 5,
                nama = "6 Wisata - 5 Hari",
                gambar = R.drawable.tour_image_1,
                harga = 550000,
                jarak = 2.0,
                rating = 4.9f
            ),
            PaketRegular(
                id = 6,
                nama = "7 Wisata - 6 Hari",
                gambar = R.drawable.tour_image_1,
                harga = 600000,
                jarak = 2.5,
                rating = 5.0f
            ),
        )
        PaketRegularScreen(rememberNavController(), dummyData)
    }
}
