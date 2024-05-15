package com.example.nusa_guide.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
@Composable
fun HomeScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        // Menampilkan konten profil dan notifikasi terlebih dahulu
        ProfileAndNotificationRow()
        Spacer(modifier = Modifier.height(16.dp))  // Memberikan spacer untuk jarak antara konten dan SearchBar
        // Menempatkan SearchBar di bagian bawah
        SearchBar()
    }
}

@Composable
fun ProfileAndNotificationRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProfileImage()
        Spacer(modifier = Modifier.width(8.dp))
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
fun NotificationIcon() {
    Icon(
        painter = painterResource(id = R.drawable.icon_notification),
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

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
