package com.example.nusa_guide.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.nusa_guide.R
import com.example.nusa_guide.model.Rekomendasi
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray700

@Composable
fun RekomendasiItem(
    rekomendasi: Rekomendasi,
    onClick: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(10.dp)
            .width(250.dp)
            .height(300.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(
            4.dp
        )
    ) {
        Column {
            Box {
                GradientImage(rekomendasi.gambar)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    RatingBox(rating = rekomendasi.ratingReview)
                    FavoriteIcon()
                }
            }
            RekomendasiInfo(rekomendasi)
        }
    }
}


@Composable
fun GradientImage(imageUrl: String) {
    Box {
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.3f))
                    )
                )
        )
    }
}

@Composable
fun RatingBox(rating: String) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.White)
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.star),
                contentDescription = "Rating",
                tint = Color.Yellow,
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = rating,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}

@Composable
fun FavoriteIcon() {
    var isSelected by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.White)
            .padding(2.dp)
    ) {
        IconButton(
            onClick = {
                      isSelected = !isSelected
            },
            modifier = Modifier.size(24.dp)
        ) {
            if (isSelected) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Favorite",
                    tint = Color.Red,
                    modifier = Modifier.size(16.dp)
                )
            } else {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = Color.Black,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@Composable
fun RekomendasiInfo(rekomendasi: Rekomendasi) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = "${rekomendasi.jarak} km - 4 menit",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        Spacer(
            modifier = Modifier.height(5.dp)
        )
        Text(
            text = rekomendasi.nama,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
        )
        Column(modifier = Modifier.padding(top = 4.dp)) {
            IconAndText(text = rekomendasi.lokasi, iconId = R.drawable.icon_location)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
        ) {
            Text(
                text = "Rp. ${rekomendasi.harga} / orang",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = brandPrimary500
            )
        }
    }
}

@Composable
fun IconAndText(text: String, iconId: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier
                .size(16.dp)
                .padding(end = 8.dp)
        )
        Text(
            text = text,
            fontSize = 14.sp,
            color = gray700,
            fontWeight = FontWeight.SemiBold,
        )
    }
}