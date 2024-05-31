package com.example.nusa_guide.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.component.PaketPremiumItem
import com.example.nusa_guide.component.RekomendasiItem
import com.example.nusa_guide.model.DummyData
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.ui.theme.black51
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray700

@Composable
fun HomeScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .padding(14.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ProfileAndNotificationRow(navController)
        }
        item {
            SearchBar(navController)
        }
        item {
            CategorySection()
        }
        item {
            RekomendasiSection(navController)
        }
        item {
            PaketPremiumSection(navController)
        }
        item {
            PaketRegularSection(navController)
        }
    }
}

@Composable
fun ProfileAndNotificationRow(
    navController: NavController
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProfileImage()
        Spacer(modifier = Modifier.width(8.dp))
        ProfileText()
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.icon_cart),
            contentDescription = "icon-keranjang",
            modifier = Modifier
                .size(24.dp)
                .clickable {
navController.navigate(
    NavigationTourScreen.CartScreen.name
)
                }
        )
        Spacer(modifier = Modifier.width(10.dp))
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
        painter = painterResource(id = R.drawable.icon_notification),
        contentDescription = "Notification Icon",
        modifier = Modifier.size(24.dp)
    )
}

@Composable
fun SearchBar(navController: NavController) {
    Spacer(modifier = Modifier.height(10.dp))
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable {
                navController.navigate(
                    NavigationTourScreen.SearchScreen.name
                )
            },
        border = BorderStroke(
            width = 1.dp,
            color = black51
        ),
        shape = RoundedCornerShape(
            size = 10.dp
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = "Cari tour guide Anda",
                color = gray700,
            )
        }
    }
}

@Composable
fun CategorySection() {
    Column(modifier = Modifier.padding(2.dp)) {
        Text(
            text = "Kategori",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
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
                title = "Alam"
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
            .padding(2.dp),
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
fun RekomendasiSection(navController: NavController) {
    Column(modifier = Modifier.padding(2.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
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
            }
            Text(
                text = "Lihat Semua >",
                color = brandPrimary500,
                fontSize = 14.sp,
                modifier = Modifier
                    .clickable {
                        navController.navigate(
                            NavigationTourScreen.RekomendasiScreen.name
                        )
                    }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(DummyData.rekomendasiList) { rekomendasi ->
                RekomendasiItem(rekomendasi, onClick = {
                    navController.navigate(
                        NavigationTourScreen.DetailScreen.name
                    )
                })
            }
        }
    }
}

@Composable
fun PaketPremiumSection(navController: NavController) {
    Column(modifier = Modifier.padding(2.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Paket Premium",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "Paket Wisata Terbaik Buat Kamu",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
            Text(
                text = "Lihat Semua >",
                color = brandPrimary500,
                fontSize = 14.sp,
                modifier = Modifier
                    .clickable {
                        navController.navigate(
                            NavigationTourScreen.PaketPremiumScreen.name
                        )
                    }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            items(DummyData.paketPremiumList) { paketpremium ->
                PaketPremiumItem(paketpremium)
            }
        }
    }
}


@Composable
fun PaketRegularSection(navController: NavController) {
    Column(modifier = Modifier.padding(2.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Paket Reguler",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "Paket Wisata Terjangkau Buat Kamu",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
            Text(
                text = "Lihat Semua >",
                color = brandPrimary500,
                fontSize = 14.sp,
                modifier = Modifier
                    .clickable {
                        navController.navigate(
                            NavigationTourScreen.PaketRegulerScreen.name
                        )
                    }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            items(DummyData.paketRegularList) { paketRegular ->
                PaketRegularItem(paketRegular)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}
