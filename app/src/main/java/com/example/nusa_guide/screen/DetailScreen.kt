package com.example.nusa_guide.screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.nusa_guide.R
import com.example.nusa_guide.api.RetrofitInstance
import com.example.nusa_guide.data.DataStoreManager
import com.example.nusa_guide.model.WisataModel
import com.example.nusa_guide.repository.RekomendasiRepository
import com.example.nusa_guide.ui.theme.*
import com.example.nusa_guide.viewModel.RekomendasiViewModel
import com.example.nusa_guide.viewModel.RekomendasiViewModelFactory

@Composable
fun DetailScreen(
    navController: NavController,
    wisataId: String,
    viewModel: RekomendasiViewModel = viewModel(factory = RekomendasiViewModelFactory(
        RekomendasiRepository(RetrofitInstance.api, DataStoreManager.getInstance(LocalContext.current))
    ))
) {
    val wisataDetail by produceState<WisataModel?>(initialValue = null, wisataId) {
        value = viewModel.getWisataDetail(wisataId.toInt())
    }

    if (wisataDetail != null) {
        DetailContent(navController, wisataDetail!!)
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun DetailContent(navController: NavController, wisata: WisataModel) {
    var isSelected by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            HeaderImage(navController, wisata.gambar1, isSelected) { isSelected = !isSelected }
            Spacer(modifier = Modifier.height(16.dp))
            TitleAndPrice(wisata.nama, wisata.harga)
            Spacer(modifier = Modifier.height(8.dp))
            LocationInfo(wisata.lokasi)
            Spacer(modifier = Modifier.height(8.dp))
            TimeInfo(wisata.jamBuka, wisata.jamTutup)
            Spacer(modifier = Modifier.height(8.dp))
            DistanceInfo(wisata.jarakLokasi)
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            DescriptionSection(wisata.deskripsi)
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            PhotoSnippets(wisata.gambar2, wisata.gambar3, wisata.gambar4)
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            TourGuideInfo(wisata.informasiTourguide, wisata.hargaTermasuk)
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
        SurfaceBottom(navController, wisata.harga, wisata.lokasi, wisata.paymentLink, Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun HeaderImage(navController: NavController, imageUrl: String?, isSelected: Boolean, onFavoriteClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
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
fun TitleAndPrice(nama: String?, harga: Int?) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = nama ?: "N/A",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Rp ${harga ?: 0} /orang",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = brandPrimary500
        )
    }
}

@Composable
fun LocationInfo(lokasi: String?) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Icon(painter = painterResource(id = R.drawable.icon_location), contentDescription = null)
        Text(text = lokasi ?: "N/A", fontSize = 16.sp, modifier = Modifier.padding(start = 8.dp))
    }
}

@Composable
fun TimeInfo(jamBuka: String?, jamTutup: String?) {
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
            text = "${jamBuka ?: "N/A"} - ${jamTutup ?: "N/A"}",
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
fun DistanceInfo(jarakLokasi: String?) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Icon(painter = painterResource(id = R.drawable.icon_wisata), contentDescription = null)
        Text(text = jarakLokasi ?: "N/A", fontSize = 16.sp, modifier = Modifier.padding(start = 8.dp))
    }
}

@Composable
fun DescriptionSection(deskripsi: String?) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = "Deskripsi", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = deskripsi ?: "N/A",
            fontSize = 16.sp,
            color = gray700
        )
    }
}

@Composable
fun PhotoSnippets(gambar2: String?, gambar3: String?, gambar4: String?) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = "Cuplikan Foto", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Image(
                painter = rememberAsyncImagePainter(gambar2),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = rememberAsyncImagePainter(gambar3),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = rememberAsyncImagePainter(gambar4),
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
fun TourGuideInfo(informasiTourguide: String?, hargaTermasuk: String?) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = "Informasi Tour Guide", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = informasiTourguide ?: "N/A",
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Harga sudah Termasuk:", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Text(
            text = hargaTermasuk ?: "N/A",
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
fun SurfaceBottom(navController: NavController, harga: Int?, lokasi: String?, paymentLink: String?, modifier: Modifier = Modifier) {
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
                    text = "Rp ${harga ?: 0} /orang",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = brandPrimary500
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = lokasi ?: "N/A", fontSize = 16.sp, color = gray700)
            }
            Button(
                onClick = {
                    paymentLink?.let {
                        val intent = Intent(Intent.ACTION_VIEW).apply { data = Uri.parse(it) }
                        context.startActivity(intent)
                    }
                },
                colors = ButtonDefaults.buttonColors(brandPrimary500),
                enabled = !paymentLink.isNullOrEmpty()
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
