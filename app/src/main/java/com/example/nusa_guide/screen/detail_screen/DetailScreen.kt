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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.nusa_guide.R
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray700
import com.example.nusa_guide.ui.theme.white
import com.example.nusa_guide.viewModel.RekomendasiViewModel


@Composable
fun DetailScreen(
    navController: NavController,
    rekomendasiId: String,
    rekomendasiViewModel: RekomendasiViewModel
) {
    val rekomendasi = rekomendasiViewModel.rekomendasi.observeAsState()
    var isSelected by remember { mutableStateOf(false) }


    LaunchedEffect(key1 = rekomendasiId) {
        rekomendasiViewModel.getRekomendasiById(rekomendasiId)
    }

    rekomendasi.value?.let {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                // Gambar dan tombol favorit
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(it.gambar),
                        contentDescription = "Foto Utama",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    // Tombol kembali
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    ) {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back",
                                modifier = Modifier.size(40.dp)
                            )
                        }
                        // Tombol favorit
                        IconButton(
                            onClick = { isSelected = !isSelected },
                            modifier = Modifier.size(35.dp)
                        ) {
                            Icon(
                                imageVector = if (isSelected) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                                contentDescription = "Favorite",
                                tint = if (isSelected) Color.Red else Color.Gray
                            )
                        }
                    }
                }

                // Judul dan harga
                Text(
                    text = it.nama,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Text(
                    text = "$${it.harga} / orang",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = brandPrimary500,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                // Lokasi
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_location),
                        contentDescription = null
                    )
                    Text(
                        text = it.lokasi,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

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
                        text = "${it.waktuKeberangkatan} WITA",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

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
                        text = "${it.km} km - ${it.jarak} menit",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

                // Deskripsi
                Text(
                    text = "Deskripsi",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
                )
                Text(
                    text = it.deskripsi,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = gray700
                )

                // Cuplikan Foto
                Text(
                    text = "Cuplikan Foto",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
                )
                LazyRow {
                    items(it.cuplikanPhoto) { photoUrl ->
                        Image(
                            painter = rememberImagePainter(data = photoUrl),
                            contentDescription = "Cuplikan Foto",
                            modifier = Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }
                }

                // Informasi Tour Guide
                Text(
                    text = "Informasi Tour Guide",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
                )
                Text(
                    text = it.informasiTourGuide,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                // Harga termasuk
                Text(
                    text = "Harga sudah Termasuk:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
                )
                it.informasiHarga.forEach { info ->
                    Text(
                        text = "• $info",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }

                // Rating & Review
                Text(
                    text = "Rating & Review",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
                )
                // Implementasi bintang dan ulasan di sini
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "${it.ratingReview}/5 (1RB Ulasan)",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            SurfaceBottom(navController)
        }
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
    DetailScreen(
        rememberNavController(),
        "1",
        viewModel()
    )
}
