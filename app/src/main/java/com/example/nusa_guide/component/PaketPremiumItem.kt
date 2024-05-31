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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import com.example.nusa_guide.model.InformasiPaket
import com.example.nusa_guide.model.PaketPremium
import com.example.nusa_guide.model.Ulasan
import com.example.nusa_guide.ui.theme.NusaGuideTheme
import com.example.nusa_guide.ui.theme.brandPrimary500


@Composable
fun PaketPremiumItem(
    paketPremium: PaketPremium
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(10.dp)
            .width(220.dp)
//            .clickable { onItemClicked(paketPremium.id) }
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
                    RowWithIconAndText(text = "Premium", iconId = R.drawable.icon_premium)
                    RowWithIconAndText(text = "Wisata, Budaya", iconId = R.drawable.icon_wisata)
                    RowWithIconAndText(text = "Include penginapan", iconId = R.drawable.icon_include)
                    RowWithIconAndText(text = "Tersedia penjemputan", iconId = R.drawable.icon_car)
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
                        color = brandPrimary500
                    )
                }
            }
        }
    }
}

@Composable
fun RowWithIconAndText(text: String, iconId: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(16.dp).padding(end = 8.dp)
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
fun PaketItemPreview() {
    NusaGuideTheme {
        PaketPremiumItem(
            paketPremium = PaketPremium(
                id = 1,
                nama = "5 Wisata - 3 Hari",
                gambar = R.drawable.bg_on_boarding, // Ganti dengan ID gambar yang sesuai di folder res/drawable
                harga = 350000,
                hariBerlibur = "3 Hari",
                jarak = 0.64,
                deskripsi = "Deskripsi paket wisata",
                cuplikanPhotos = listOf(
                    R.drawable.pantai_1, R.drawable.pantai_2
                ),
                informasiTourGuide = "Informasi tentang tour guide",
                informasiHarga = "Harga termasuk akomodasi",
                ratingReview = 5.0,
                ulasan = listOf(
                    Ulasan(
                        nama = "Jonathan Kaje",
                        tanggal = "20 Minggu lalu",
                        rating = 4.0,
                        deskripsi = "Tour Guide Rekomendasi! Puoll!! untuk dipesan muantapp...",
                        images = listOf(R.drawable.pantai_1)
                    )
                ),
                informasiPaket = InformasiPaket(
                    include = listOf(
                        "Penjemputan dan pengantaran dari titik pertemuan yang ditentukan",
                        "Hotel",
                        "Supir",
                        "Tour Guide"
                    ),
                    exclude = listOf(
                        "Tip tour guide (min. Rp 50.000/hari)",
                        "Tip supir (min. Rp 75.000/hari)"
                    )
                )
            )
        )
    }
}
