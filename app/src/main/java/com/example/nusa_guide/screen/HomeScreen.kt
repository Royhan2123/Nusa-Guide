package com.example.nusa_guide.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.navigation.NavigationTourScreen


@Composable
fun HomeScreen(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        ProfileAndNotificationRow()
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(navController)
        Spacer(modifier = Modifier.height(16.dp))
        CategorySection()
        Spacer(modifier = Modifier.height(16.dp))

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
        contentScale = ContentScale.FillBounds
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
fun SearchBar(navController: NavController) {
    val searchText = remember { mutableStateOf("") }

    OutlinedTextField(
        value = searchText.value,
        onValueChange = { newText -> searchText.value = newText },
        label = { Text("Cari tour guide Anda") },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
            .clickable {
                navController.navigate(
                    NavigationTourScreen.SearchScreen.name
                )
            }
    )
}

@Composable
fun CategorySection() {
    Column(modifier = Modifier.padding(16.dp)) {
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
                title = "samudra"
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




@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}
