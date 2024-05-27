package com.example.nusa_guide.screen.detail_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
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
import com.example.nusa_guide.R
import com.example.nusa_guide.ui.theme.brandPrimary500

@Composable
fun DetailPremiumScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Gambar Utama
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.tour_image_1), // Ganti dengan URL atau resource lokal yang sesuai
                contentDescription = "Foto Utama",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_back), // Ganti dengan resource ikon yang sesuai
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(Color.Gray.copy(alpha = 0.5f))
                        .padding(8.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.icon_favorite_border), // Ganti dengan resource ikon yang sesuai
                    contentDescription = "Favorite",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.Gray.copy(alpha = 0.5f))
                        .padding(8.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Judul dan Harga
        Text(
            text = "10 Wisata - 9 Hari",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Rp 150.000 /orang",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = brandPrimary500,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        // Lokasi
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_premium),
                contentDescription = null,
            )
            Text(
                text = "Premium",
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_wisata),
                contentDescription = null,
            )
            Text(
                text = "Wisata Budaya",
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        // Waktu
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_include),
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Text(
                text = "Include Penginapan",
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        // Jarak
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_car),
                contentDescription = null
            )
            Text(
                text = "Tersedia Penjemputan",
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Divider(modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.height(16.dp))
        // Deskripsi
        Text(
            text = "Deskripsi",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = "Pantai Bias Tugel tidak kalah indah dengan pantai-pantai lainnya di Bali...",
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Divider(modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.height(16.dp))
        // Cuplikan Foto
        Text(
            text = "Cuplikan Foto",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.tour_image_1),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.tour_image_1),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.tour_image_1),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Divider(modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.height(16.dp))
        // Informasi Tour Guide
        Text(
            text = "Informasi Tour Guide",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Percayakan wisata Anda kepada ahlinya! Kami akan memilihkan pemandu wisata terbaik di Nusa Penisa untuk menemani Anda. Tak perlu ragu lagi, Anda akan mendapatkan pengalaman wisata yang tak terlupakan dan penuh petualangan.",
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Harga sudah Termasuk:",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = "• Penjemputan dan pengantaran dari titik pertemuan yang ditentukan\n• Biaya tiket wisata\n• Air mineral dan makanan ringan",
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Divider(modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.height(16.dp))
        // Rating & Review
        Text(
            text = "Rating & Review",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "4.0/5 (1RB Ulasan)",
                fontSize = 16.sp
            )
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
            ) {
                Text(
                    text = "Lihat Semua",
                    fontSize = 16.sp,
                    color = Color.Blue
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Divider(modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.height(16.dp))
        // Review Item
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.tour_image_1),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = "Jonathan Kaje",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "10 Minggu lalu",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Tour Guide Rekomendasi Puollll untuk dipesan muantappp....",
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.tour_image_1),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.tour_image_1),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.tour_image_1),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DetailPremiumPreview() {
    DetailPremiumScreen()
}
