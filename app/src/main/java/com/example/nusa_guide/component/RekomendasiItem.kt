package com.example.nusa_guide.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nusa_guide.R
import com.example.nusa_guide.model.Rekomendasi
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray
import com.example.nusa_guide.ui.theme.gray700
import java.text.NumberFormat
import java.util.Date
import java.util.Locale

@Composable
fun CardRekomendasiItem(
    rekomendasi: Rekomendasi,
    onClick: () -> Unit,
) {
    var isSelected by remember {
        mutableStateOf(true)
    }
    Surface(
        modifier = Modifier
            .width(200.dp)
            .clickable { onClick() }
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(10.dp),
                color = gray
            ),
        shape = RoundedCornerShape(10.dp),
    ) {
        Box {
            Column {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = rekomendasi.gambar1),
                        contentDescription = rekomendasi.nama,
                        modifier = Modifier
                            .height(100.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp, vertical = 5.dp),
                        contentAlignment = Alignment.TopEnd
                    ) {
                        Surface(
                            modifier = Modifier
                                .height(20.dp)
                                .width(20.dp),
                            shape = CircleShape,
                            color = Color.White
                        ) {
                            IconButton(onClick = { isSelected = !isSelected }) {
                                if (isSelected) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.icon_favorit_red),
                                        contentDescription = "icon-favorit",
                                        modifier = Modifier
                                            .size(20.dp)
                                            .padding(5.dp),
                                        tint = gray700
                                    )
                                } else {
                                    Icon(
                                        painter = painterResource(id = R.drawable.icon_favorit_red),
                                        contentDescription = "icon-favorit",
                                        modifier = Modifier
                                            .size(20.dp)
                                            .padding(5.dp),
                                        tint = Color.Red
                                    )
                                }
                            }
                        }

                    }
                }
                Column(
                    modifier = Modifier.padding(
                        horizontal = 10.dp,
                        vertical = 10.dp
                    )
                ) {
                    Text(
                        text = "- ${rekomendasi.jarakLokasi}",
                        color = gray,
                        fontSize = 10.sp,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = rekomendasi.nama,
                        color = gray700,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(7.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_location),
                            contentDescription = "icon-location",
                            modifier = Modifier.size(13.dp),
                            tint = gray700
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = rekomendasi.lokasi,
                            color = gray700,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Spacer(modifier = Modifier.height(7.dp))
                    val formattedHarga = NumberFormat.getNumberInstance(Locale("in", "ID")).format(rekomendasi.harga)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Rp $formattedHarga",
                            color = brandPrimary500,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "/ orang",
                            color = gray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun CardRekomendasiPreview() {
        CardRekomendasiItem(
            rekomendasi = Rekomendasi(
                id = 1,
                nama = "Jatiluwih Rice Terraces in Bali",
                lokasi = "Tabanan",
                jamBuka = Date(),
                jamTutup = Date(),
                jarakLokasi = "56,7 km",
                harga = 250000,
                deskripsi = "Sawah terasering Jatiluwih mencakup lebih dari 600 hektar sawah yang tersebar di lereng gunung Batukaru dan cenderung lebih sepi daripada Tegallalang. Anda juga akan menemukan lebih sedikit pengagum wisata di sini, sehingga lebih mudah untuk berjalan-jalan dan menjelajahi tanpa gangguan.",
                gambar1 = R.drawable.pantai_1,
                gambar2 = R.drawable.pantai_2,
                gambar3 = R.drawable.pantai_3,
                gambar4 = R.drawable.pantai_4,
                informasiTourguide = "Tour guide kami adalah profesional berpengalaman dengan pengetahuan mendalam tentang sejarah, budaya, dan tempat wisata lokal. Mahir dalam berbagai bahasa, mereka ramah, bersertifikasi, dan mendapat banyak testimoni positif dari wisatawan. Dengan kemampuan menyesuaikan itinerary sesuai keinginan Anda, mereka memastikan perjalanan Anda nyaman, informatif, dan tak terlupakan.",
                hargaTermasuk = "Mobil Avanza Private (TIDAK digabung dengan group lain) + BBM + Supir/Guide, Tiket masuk objek wisata, Makan Siang, Asuransi Jiwa, Kain, Selendang, dan Payung, Parkir dan Retribusi",
                kategori = "alam",
            ),
            onClick = {},
        )
}