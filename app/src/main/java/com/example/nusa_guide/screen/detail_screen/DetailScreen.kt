package com.example.nusa_guide.screen.detail_screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nusa_guide.R
import com.example.nusa_guide.model.WisataModel
import com.example.nusa_guide.ui.theme.black51
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray300
import com.example.nusa_guide.ui.theme.gray700

@Composable
fun DetailScreen(
    navController: NavController,
    wisata: WisataModel
) {
    var isSelected by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            HeaderImage(navController, isSelected) { isSelected = !isSelected }
            Spacer(modifier = Modifier.height(16.dp))
            TitleAndPrice()
            Spacer(modifier = Modifier.height(8.dp))
            LocationInfo()
            Spacer(modifier = Modifier.height(8.dp))
            TimeInfo()
            Spacer(modifier = Modifier.height(8.dp))
            DistanceInfo()
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            DescriptionSection()
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            PhotoSnippets()
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            TourGuideInfo()
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            RatingAndReview()
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            ReviewItem()
            Spacer(modifier = Modifier.height(80.dp))
        }
        SurfaceBottom(navController, Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun HeaderImage(navController: NavController, isSelected: Boolean, onFavoriteClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.alam),
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
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "icon-back",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable { navController.popBackStack() }
                        .clip(CircleShape),
                    tint = black51
                )
            }
            IconButton(onClick = onFavoriteClick) {
                if (isSelected) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "icon-favorit-filled",
                        tint = Color.Red,
                        modifier = Modifier
                            .size(35.dp)
                            .clip(CircleShape)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = "icon-favorit-outlined",
                        tint = gray700,
                        modifier = Modifier
                            .size(35.dp)
                            .clip(CircleShape)
                    )
                }
            }
        }
    }
}

@Composable
fun TitleAndPrice() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "Nusa Penida",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Rp 150.000 /orang",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = brandPrimary500
        )
    }
}

@Composable
fun LocationInfo() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Icon(painter = painterResource(id = R.drawable.icon_location), contentDescription = null)
        Text(text = "Denpasar, Bali", fontSize = 16.sp, modifier = Modifier.padding(start = 8.dp))
    }
}

@Composable
fun TimeInfo() {
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
}

@Composable
fun DistanceInfo() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Icon(painter = painterResource(id = R.drawable.icon_wisata), contentDescription = null)
        Text(text = "5 km - 20 menit", fontSize = 16.sp, modifier = Modifier.padding(start = 8.dp))
    }
}

@Composable
fun DescriptionSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = "Deskripsi", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Pantai Bias Tugel tidak kalah indah dengan pantai-pantai lainnya di Bali. Pantai Bias Tugel Bali terletak di Desa Padangbai, Kecamatan Manggis, Karangasem, Bali. Dari Bandara Internasional Ngurah Rai sekitar 57 km dengan waktu tempuh 1.5 jam perjalanan dengan menggunakan kendaraan bermotor.",
            fontSize = 16.sp,
            color = gray700
        )
    }
}

@Composable
fun PhotoSnippets() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = "Cuplikan Foto", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.alam),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.alam),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.alam),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun TourGuideInfo() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = "Informasi Tour Guide", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Percayakan wisata Anda kepada ahlinya! Kami akan memilihkan pemandu wisata terbaik di Nusa Penida untuk menemani Anda. Tak perlu ragu lagi, Anda akan mendapatkan pengalaman wisata yang tak terlupakan dan penuh petualangan.",
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Harga sudah Termasuk:", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Text(
            text = "• Penjemputan dan pengantaran dari titik pertemuan yang ditentukan\n• Biaya tiket wisata\n• Air mineral dan makanan ringan",
            fontSize = 16.sp,
            color = gray700
        )
    }
}

@Composable
fun RatingAndReview() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = "Rating dan Ulasan", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "4.8", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(8.dp))
                repeat(5) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_star),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
            TextButton(onClick = {}) {
                Text(text = "Lihat semua review", fontSize = 16.sp, color = brandPrimary500)
            }
        }
    }
}

@Composable
fun ReviewItem() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = "John Doe", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Row {
                    repeat(5) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_star),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "1 minggu lalu", fontSize = 14.sp, color = gray700)
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Sangat menyenangkan! Pemandu wisata sangat ramah dan profesional. Kami mengunjungi banyak tempat indah dan mendapatkan pengalaman yang tak terlupakan.",
            fontSize = 16.sp,
            color = gray700
        )
    }
}

@Composable
fun SurfaceBottom(navController: NavController, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp),
        color = Color.White,
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Rp 150.000 /orang",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = brandPrimary500
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Denpasar, Bali", fontSize = 16.sp, color = gray700)
            }
            Button(
                onClick = {
                    val url = "https://www.google.com"
                    val intent = Intent(Intent.ACTION_VIEW).apply { data = Uri.parse(url) }
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(brandPrimary500)
            ) {
                Text(text = "Pesan Sekarang", color = Color.White)
            }
        }
    }
}

@Composable
fun HorizontalDivider(modifier: Modifier = Modifier) {
    Divider(color = gray300, modifier = modifier.height(1.dp))
}

//@Preview(showBackground = true)
//@Composable
//fun DetailScreenPreview() {
//    DetailScreen(navController = rememberNavController())
//}
