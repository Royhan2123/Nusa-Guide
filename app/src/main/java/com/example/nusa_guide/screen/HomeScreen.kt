package com.example.nusa_guide.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nusa_guide.R
import com.example.nusa_guide.model.DummyData
import com.example.nusa_guide.model.Rekomendasi

@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ProfileAndNotificationRow()
        }
        item {
            SearchBar()
        }
        item {
            CategorySection()
        }
        item {
            RekomendasiScreen()
        }
    }
}

@Composable
fun ProfileAndNotificationRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProfileImage()
        Spacer(modifier = Modifier.width(8.dp))
        ProfileText()
        Spacer(modifier = Modifier.weight(1f))
        NotificationIcon()
    }
}

@Composable
fun ProfileImage() {
    Image(
        painter = painterResource(id = R.drawable.img_on_boarding1),
        contentDescription = "Profile Image",
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ProfileText() {
    Column {
        Text(
            text = "Muhammad Al Kahfi",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Mari eksplore indahnya Bali",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun NotificationIcon() {
    Icon(
        painter = painterResource(id = R.drawable.icon_account),
        contentDescription = "Notification Icon",
        modifier = Modifier.size(24.dp)
    )
}

@Composable
fun SearchBar() {
    val searchText = remember { mutableStateOf("") }

    OutlinedTextField(
        value = searchText.value,
        onValueChange = { newText -> searchText.value = newText },
        label = { Text("Cari tour guide Anda") },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CategorySection() {
    Column(modifier = Modifier.padding(2.dp)) {
        Text(
            text = "Kategori",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CategoryItem(
                imageRes = R.drawable.bg_on_boarding,
                title = "Terdekat"
            )
            CategoryItem(
                imageRes = R.drawable.bg_on_boarding,
                title = "Populer"
            )
            CategoryItem(
                imageRes = R.drawable.bg_on_boarding,
                title = "Samudra"
            )
            CategoryItem(
                imageRes = R.drawable.bg_on_boarding,
                title = "Kuliner"
            )
        }
    }
}

@Composable
fun CategoryItem(imageRes: Int, title: String) {
    Column(
        modifier = Modifier
            .width(80.dp)
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.LightGray),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Gray
        )
    }
}

@Composable
fun RekomendasiScreen() {
    Column(modifier = Modifier.padding(2.dp)) {
        Text(
            text = "Rekomendasi",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "Rekomendasi Wisata Terbaik Buat Kamu",
            fontSize = 12.sp,
            color = Color.Gray
        )
        LazyRow {
            items(DummyData.rekomendasiList) { rekomendasi ->
                RekomendasiItem(rekomendasi)
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

@Composable
fun RekomendasiItem(rekomendasi: Rekomendasi) {
    Column(
        modifier = Modifier
            .width(200.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = rekomendasi.gambar),
            contentDescription = null,
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = rekomendasi.nama, fontWeight = FontWeight.Bold, fontSize = 16.sp)
//        Text(text = "Jarak: ${rekomendasi.jarak} km", fontSize = 14.sp, color = Color.Gray)
        Text(text = "Rp ${rekomendasi.harga}", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.Black)
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
