package com.example.nusa_guide.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
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
import com.example.nusa_guide.model.PaketRegular
import com.example.nusa_guide.ui.theme.NusaGuideTheme
import com.example.nusa_guide.ui.theme.brandPrimary500

@Composable
fun PaketRegularItem(paketRegular: PaketRegular) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(8.dp)
            .width(220.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            ) {
                Image(
                    painter = painterResource(id = paketRegular.gambar),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.TopStart)
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.star), // Replace with your star icon resource
                        contentDescription = null,
                        tint = Color(0xFFFFD700),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = paketRegular.rating.toString(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier
                        .padding(6.dp)
                        .align(Alignment.TopEnd)
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(4.dp)
                        .size(20.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = paketRegular.nama,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "${paketRegular.jarak} km - 4 menit",
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_location), // Replace with your location icon resource
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Reguler",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_wisata), // Replace with your tour icon resource
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Wisata",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Rp ${paketRegular.harga} /orang",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = brandPrimary500,
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                    .padding(4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaketRegularItemPreview() {
    NusaGuideTheme {
        val dummyData = PaketRegular(
            id = 1,
            nama = "3 Wisata - 2 Hari",
            gambar = R.drawable.tour_image_1,
            harga = 350000,
            jarak = 0.64,
            rating = 4.5f
        )
        PaketRegularItem(paketRegular = dummyData)
    }
}
