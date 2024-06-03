package com.example.nusa_guide.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nusa_guide.R
import com.example.nusa_guide.model.Rekomendasi
import com.example.nusa_guide.ui.theme.NusaGuideTheme
import com.example.nusa_guide.ui.theme.brandPrimary500

@Composable
fun RekomendasiItem(
    rekomendasi: Rekomendasi,
    onClick: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(10.dp)
            .width(220.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Box {
                GradientImage(painterResource(id = rekomendasi.gambar))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    RatingBox(rating = "4.5")
                    FavoriteIcon()
                }
            }
            RekomendasiInfo(rekomendasi)
        }
    }
}

@Composable
fun GradientImage(painter: Painter) {
    Box {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.3f))
                    )
                )
        )
    }
}

@Composable
fun RatingBox(rating: String) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.White)
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.star),
                contentDescription = "Rating",
                tint = Color.Yellow,
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = rating,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}

@Composable
fun FavoriteIcon() {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.White)
            .padding(2.dp)
    ) {
        IconButton(
            onClick = { /* TODO: Handle favorite click */ },
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "Favorite",
                tint = Color.Black,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun RekomendasiInfo(rekomendasi: Rekomendasi) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = "${rekomendasi.jarak} km - 4 menit",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        Text(
            text = rekomendasi.nama,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 4.dp)
        )
        Column(modifier = Modifier.padding(top = 4.dp)) {
            IconAndText(text = "Denpasar, Bali", iconId = R.drawable.icon_location)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
        ) {
            Text(
                text = "Rp. ${rekomendasi.harga} / orang",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = brandPrimary500
            )
        }
    }
}

@Composable
fun IconAndText(text: String, iconId: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier
                .size(16.dp)
                .padding(end = 8.dp)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RekomendasiItemPreview() {
    NusaGuideTheme {
        RekomendasiItem(
            rekomendasi = Rekomendasi(
                id = 1,
                nama = "Nusa Penida",
                gambar = R.drawable.bg_on_boarding,
                harga = 150000,
                jarak = 0.64,
                deskripsi = "Sebuah pulau indah di Bali.",
                cuplikanPhoto = R.drawable.pantai_1,
                informasiTourGuide = "Pemandu tur berpengalaman.",
                informasiHarga = "Harga termasuk makan siang.",
                ratingReview = 4,
                ulasan = 120,
                ulasanTitle = "Ulasan Terbaik",
                ulasanImage = R.drawable.pantai_2,
                deskripsiUlasan = "Tempat ini luar biasa!",
                cuplikanPhotoUlasan = listOf(
                    R.drawable.pantai_1,
                    R.drawable.pantai_2,
                    R.drawable.pantai_3
                ),
                km = 7,
                waktuKeberangkatan = 18.00,
                lokasi = "Bali",
            ),
            onClick = {},
        )
    }
}