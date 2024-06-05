package com.example.nusa_guide.screen.detail_screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.ui.theme.black51
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray
import com.example.nusa_guide.ui.theme.gray700
import com.example.nusa_guide.ui.theme.orange
import com.example.nusa_guide.ui.theme.white

@Composable
fun DetailScreen(navController: NavController) {
    var isSelected by remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier.fillMaxSize()) {


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
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "icon-back",
                            modifier = Modifier
                                .size(40.dp)
                                .clickable {
                                    navController.popBackStack()
                                }
                                .clip(CircleShape),
                            tint = black51
                        )
                    }
                    IconButton(onClick = { isSelected = !isSelected }) {
                        if (isSelected) {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "icon-favorit-filled",
                                tint = Color.Red,
                                modifier = Modifier
                                    .size(35.dp)
                                    .clip(CircleShape),
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Outlined.FavoriteBorder,
                                contentDescription = "icon-favorit-outlined",
                                tint = gray700,
                                modifier = Modifier
                                    .size(35.dp)
                                    .clip(CircleShape),
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Judul dan Harga
            Text(
                text = "Nusa Penida",
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
                    painter = painterResource(id = R.drawable.icon_location),
                    contentDescription = null,
                )
                Text(
                    text = "Denpasar, Bali",
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
                    painter = painterResource(id = R.drawable.icon_time),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = "06.00 - 18.00 WITA",
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
                    painter = painterResource(id = R.drawable.icon_wisata),
                    contentDescription = null
                )
                Text(
                    text = "5 km - 20 menit",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            // Deskripsi
            Text(
                text = "Deskripsi",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Pantai Bias Tugel tidak kalah indah dengan pantai-pantai lainnya di Bali. Pantai Bias Tugel Bali terletak di Desa Padangbai, Kecamatan Manggis, Karangasem, Bali. Dari Bandara Internasional Ngurah Rai sekitar 57 km dengan waktu tempuh 1.5 jam perjalanan dengan menggunakan kendaraan bermotor. ",
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 16.dp),
                color = gray700
            )
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
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
            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
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
            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            // Rating & Review
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Rating & Review",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_star),
                        contentDescription = "icon-Star",
                        modifier = Modifier.size(20.dp),
                        tint = orange
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.icon_star),
                        contentDescription = "icon-Star",
                        modifier = Modifier.size(20.dp),
                        tint = orange
                    )
                    Spacer(modifier = Modifier.width(10.dp))

                    Icon(
                        painter = painterResource(id = R.drawable.icon_star),
                        contentDescription = "icon-Star",
                        modifier = Modifier.size(20.dp),
                        tint = orange
                    )
                    Spacer(modifier = Modifier.width(10.dp))

                    Icon(
                        painter = painterResource(id = R.drawable.icon_star),
                        contentDescription = "icon-Star",
                        modifier = Modifier.size(20.dp),
                        tint = orange
                    )
                    Spacer(modifier = Modifier.width(10.dp))

                    Icon(
                        painter = painterResource(id = R.drawable.icon_star_outlined),
                        contentDescription = "icon-Star",
                        modifier = Modifier.size(20.dp),
                        tint = gray
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {}
                    ) {
                        Text(
                            text = "Lihat Semua",
                            fontSize = 14.sp,
                            color = brandPrimary500,
                        )
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "icon-arrow-right",
                            modifier = Modifier.size(20.dp),
                            tint = brandPrimary500
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "4.0/5 (1RB Ulasan)",
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            // Review Item
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Image(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
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
            Spacer(modifier = Modifier.height(80.dp))
        }
        SurfaceBottom(navController)
    }
}

@Composable
fun SurfaceBottom(
    navController: NavController
) {
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shadowElevation = 10.dp,
            color = white,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier
                        .height(50.dp)
                        .width(45.dp)
                        .border(
                            width = 1.dp,
                            color = brandPrimary500,
                            shape = RoundedCornerShape(size = 10.dp),
                        ),
                    shape = RoundedCornerShape(size = 10.dp),
                    color = white
                ) {
                    IconButton(
                        onClick = { startWhatsApp(context) },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_message),
                            contentDescription = "icon-message",
                            tint = brandPrimary500,
                            modifier = Modifier.size(25.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Surface(
                    modifier = Modifier
                        .height(50.dp)
                        .width(45.dp)
                        .border(
                            width = 1.dp,
                            color = brandPrimary500,
                            shape = RoundedCornerShape(size = 10.dp),
                        ),
                    shape = RoundedCornerShape(size = 10.dp),
                    color = white
                ) {
                    IconButton(
                        onClick = {
                            navController.navigate(
                                NavigationTourScreen.CartScreen.name
                            )
                        },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_cart_blue),
                            contentDescription = "icon-cart",
                            tint = brandPrimary500,
                            modifier = Modifier.size(25.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                ElevatedButton(
                    onClick = {
                        navController.navigate(
                            NavigationTourScreen.PaymentScreen.name
                        )
                    },
                    modifier = Modifier
                        .width(145.dp)
                        .height(45.dp),
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = brandPrimary500
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text(text = "Pesan (1)")
                }
            }
        }
    }
}

fun startWhatsApp(context: android.content.Context) {
    val phoneNumber = "6287765667855"
    val message = "Halooo\nApakah kamu bersedia menjadi jasa tour guide saya."
    val url = "https://api.whatsapp.com/send?phone=$phoneNumber&text=${Uri.encode(message)}"
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = Uri.parse(url)
    context.startActivity(intent)
}

@Preview(showSystemUi = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen(rememberNavController())
}
