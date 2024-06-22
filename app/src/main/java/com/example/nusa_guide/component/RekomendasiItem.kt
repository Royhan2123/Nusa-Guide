package com.example.nusa_guide.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.nusa_guide.R
import com.example.nusa_guide.model.WisataModel
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray700
import com.example.nusa_guide.ui.theme.lightGray
import java.text.NumberFormat
import java.util.Locale

@Composable
fun CardRekomendasiItem(
    rekomendasi: WisataModel,
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
                color = Color.Gray
            )
            .height(260.dp),
        shape = RoundedCornerShape(10.dp),
    ) {

        Box {
            Column {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = rememberAsyncImagePainter(rekomendasi.gambar1),
                        contentDescription = rekomendasi.nama,
                        modifier = Modifier
                            .height(100.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp, vertical = 10.dp),
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Surface(
                                modifier = Modifier
                                    .width(40.dp)
                                    .height(20.dp),
                                color = lightGray,
                                shadowElevation = 8.dp,
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center,
                                ) {
                                        Icon(
                                            imageVector = Icons.Default.Star,
                                            contentDescription = "icon-star",
                                            modifier = Modifier.size(15.dp),
                                            tint = Color.Yellow
                                        )
                                        Text(
                                            text = rekomendasi.rating.toString(),
                                            fontSize = 13.sp,
                                            color = gray700,
                                            fontWeight = FontWeight.SemiBold
                                        )
                                }
                            }
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
                                            tint = Color.Gray
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
                }
                Column(
                    modifier = Modifier.padding(
                        horizontal = 10.dp,
                        vertical = 10.dp
                    )
                ) {
                    Text(
                        text = "- ${rekomendasi.jarakLokasi}",
                        color = Color.Gray,
                        fontSize = 10.sp,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    rekomendasi.nama?.let {
                        Text(
                            text = it,
                            color = Color.Gray,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_location),
                            contentDescription = "icon-location",
                            modifier = Modifier.size(13.dp),
                            tint = Color.Gray
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        rekomendasi.lokasi?.let {
                            Text(
                                text = it,
                                color = Color.Gray,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(7.dp))

                    // Handle harga formatting and potential errors
                    val formattedHarga = try {
                        rekomendasi.harga?.let {
                            NumberFormat.getNumberInstance(Locale("in", "ID")).format(it)
                        } ?: "Harga tidak tersedia"
                    } catch (e: Exception) {
                        "Harga tidak valid"
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Rp $formattedHarga",
                            color = brandPrimary500,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "/orang",
                            color = Color.Gray,
                            fontSize = 12.sp,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewCardRekomendasi() {
    CardRekomendasiItem(
        rekomendasi = WisataModel(
            id = 1,
            nama = "Jatiluwih Rice Terraces in Bali",
            lokasi = "Tabanan",
            jamBuka = "08:00:00",
            jamTutup = "18:00:00",
            jarakLokasi = "56,7 km",
            harga = 250000,
            deskripsi = "Sawah terasering Jatiluwih mencakup lebih dari 600 hektar sawah yang tersebar di lereng gunung Batukaru dan cenderung lebih sepi daripada Tegallalang. Anda juga akan menemukan lebih sedikit pengagum wisata di sini, sehingga lebih mudah untuk berjalan-jalan dan menjelajahi tanpa gangguan.",
            gambar1 = "https://i.pinimg.com/236x/a2/7e/c5/a27ec55e489abbbd8369f5048c69e6f1.jpg",
            gambar2 = "https://i.pinimg.com/236x/99/b6/d5/99b6d5698cfcb9b46a2ff0a1e304243e.jpg",
            gambar3 = "https://i.pinimg.com/236x/75/f5/d8/75f5d8767c547a0d11c551f6a3f02a7c.jpg",
            gambar4 = "https://i.pinimg.com/236x/12/c0/3b/12c03bbd3fb11f56c3a25b68709e6cb3.jpg",
            informasiTourguide = "Tour guide kami adalah profesional berpengalaman dengan pengetahuan mendalam tentang sejarah, budaya, dan tempat wisata lokal. Mahir dalam berbagai bahasa, mereka ramah, bersertifikasi, dan mendapat banyak testimoni positif dari wisatawan. Dengan kemampuan menyesuaikan itinerary sesuai keinginan Anda, mereka memastikan perjalanan Anda nyaman, informatif, dan tak terlupakan.",
            hargaTermasuk = "Mobil Avanza Private (TIDAK digabung dengan group lain) + BBM + Supir/Guide, Tiket masuk objek wisata, Makan Siang, Asuransi Jiwa, Kain, Selendang, dan Payung, Parkir dan Retribusi",
            kategori = "alam",
            paymentLink = "https://app.sandbox.midtrans.com/payment-links/1718439912442",
            rating = 4
        )
    ) {}
}