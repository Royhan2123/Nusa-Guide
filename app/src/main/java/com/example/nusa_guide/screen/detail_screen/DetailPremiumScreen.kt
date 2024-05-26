package com.example.nusa_guide.screen.detail_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nusa_guide.R
import androidx.compose.foundation.shape.RoundedCornerShape
import com.example.nusa_guide.ui.theme.brandPrimary500

@Composable
fun DetailScreenPremium() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.tour_image_1), // Sesuaikan dengan ID gambar Anda
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "10 Wisata - 9 Hari",
            style = MaterialTheme.typography.h6
        )
        Text(
            text = "Rp 1.350.000 /orang",
            style = MaterialTheme.typography.h5.copy(color = brandPrimary500)
        )
        Row {
            Icon(imageVector = Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
            Icon(imageVector = Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
            Icon(imageVector = Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
            Icon(imageVector = Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
            Icon(imageVector = Icons.Default.StarHalf, contentDescription = null, tint = Color.Yellow)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Deskripsi",
            style = MaterialTheme.typography.h6
        )
        Text(
            text = "• Hari Pertama - Bedugul Tour\nPura Ulu Danau Beratan merupakan tempat... (dan seterusnya, tambahkan sesuai dengan teks pada gambar)",
            style = MaterialTheme.typography.body1
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Informasi Paket",
            style = MaterialTheme.typography.h6
        )
        Text(
            text = "• Paket premium adalah private tour, tidak digabung dengan kelompok lain\n• Harga sudah termasuk hotel bintang 4 di The One Legian\n(dan seterusnya, tambahkan sesuai dengan teks pada gambar)",
            style = MaterialTheme.typography.body1
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Rating & Review",
            style = MaterialTheme.typography.h6
        )
        Row {
            Icon(imageVector = Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
            Icon(imageVector = Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
            Icon(imageVector = Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
            Icon(imageVector = Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
            Icon(imageVector = Icons.Default.StarHalf, contentDescription = null, tint = Color.Yellow)
            Text(text = " 4.8/5 (1898 Ulasan)", style = MaterialTheme.typography.body1)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* TODO: Action for booking */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Pesan Sekarang")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPremiumPreview() {
    DetailScreenPremium()
}
