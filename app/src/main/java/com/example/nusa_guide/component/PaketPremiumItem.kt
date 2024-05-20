package com.example.nusa_guide.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
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
import com.example.nusa_guide.R
import com.example.nusa_guide.model.PaketPremium
import com.example.nusa_guide.ui.theme.NusaGuideTheme

@Composable
fun PaketPremiumItem(paketPremium: PaketPremium) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column {
            Box {
                // Bagian Gambar
                Image(
                    painter = painterResource(id = paketPremium.gambar),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                )
                // Ikon Rating dan Favorite
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.White)
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.star),
                                contentDescription = "Rating",
                                tint = Color.Yellow,
                                modifier = Modifier.size(16.dp)
                            )
                            Text(
                                text = "4.5",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.Black,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.White)
                            .padding(8.dp)
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
            }
            // Bagian Teks
            Column(modifier = Modifier.padding(8.dp)) {
                // Jarak dan Durasi
                Text(
                    text = "${paketPremium.jarak} km - 4 menit",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
                // Judul
                Text(
                    text = paketPremium.nama,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 4.dp)
                )
                // Informasi Detail
                Column(modifier = Modifier.padding(top = 4.dp)) {
                    Text(
                        text = "Premium",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                    Text(
                        text = "Wisata, Budaya",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                    Text(
                        text = "Include penginapan",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                    Text(
                        text = "Tersedia penjemputan",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
                // Harga
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                ) {
                    Text(
                        text = "Rp. ${paketPremium.harga} / Orang",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaketItemPreview() {
    NusaGuideTheme {
        PaketPremiumItem(
            paketPremium = PaketPremium(
                1,
                "5 Wisata - 3 Hari",
                R.drawable.bg_on_boarding, // Ganti dengan ID gambar yang sesuai di folder res/drawable
                350000,
                0.64.toInt()
            )
        )
    }
}
