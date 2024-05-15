package com.example.nusa_guide.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.sp
import com.example.nusa_guide.R

@Composable
fun HomeScreen() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
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
        painter = painterResource(id = R.drawable.img_on_boarding1), // Ganti dengan ID gambar yang sesuai
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

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()

}
