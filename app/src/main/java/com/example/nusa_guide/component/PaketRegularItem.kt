package com.example.nusa_guide.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.model.PaketRegular
import com.example.nusa_guide.ui.theme.NusaGuideTheme

@Composable
fun PaketRegularItem(paketRegular: PaketRegular) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(16.dp)
            .width(200.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            ) {
                Image(
                    painter = painterResource(id = paketRegular.gambar),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.TopStart)
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.star), // Replace with your star icon resource
                        contentDescription = null,
                        tint = Color(0xFFFFD700),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = paketRegular.rating.toString(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier
                        .padding(6.dp)
                        .align(Alignment.TopEnd)
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(4.dp)
                        .size(20.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = paketRegular.nama,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "${paketRegular.jarak} km - 4 menit",
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_location), // Replace with your location icon resource
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Reguler",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_wisata), // Replace with your tour icon resource
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Wisata",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Rp ${paketRegular.harga} /orang",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                    .padding(4.dp)
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PaketRegularCardPreview() {
    NusaGuideTheme {
        val navController = rememberNavController()
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
        PaketRegularScreen(navController = navController, paketRegularList = dummyData)
    }
}
