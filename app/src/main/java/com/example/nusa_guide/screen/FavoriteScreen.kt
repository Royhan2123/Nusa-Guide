package com.example.nusa_guide.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.nusa_guide.R
import com.example.nusa_guide.ui.theme.BrandPrimary500
import com.example.nusa_guide.ui.theme.Gray70
import java.time.LocalDate


@Composable
fun FavoriteScreen() {
    Column(
        modifier = Modifier.fillMaxSize()

    ) {
        TopBar()
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(beachList) { beach ->
                BeachItem(beach = beach)
            }
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
        ) {
            Text(
                text = "Favorit", fontSize = 29.sp, fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = LocalDate.now().toString(),  // Replace with your preferred date format
                fontSize = 14.sp, color = Color.Gray
            )
        }
        Image(
            painterResource(id = R.drawable.ic_history),
            contentDescription = null,
            modifier = Modifier
                .padding(30.dp)
                .size(30.dp)
        )
    }
}

@Composable
fun BeachItem(beach: Beach) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {

            Column {
                Image(
                    painter = rememberAsyncImagePainter(model = beach.imageUrl),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .height(95.dp)
                        .width(110.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                Row(
                    horizontalArrangement = Arrangement.Absolute.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = beach.price,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = BrandPrimary500,
                        modifier = Modifier.padding(end = 10.dp)
                    )

                    Text(
                        text = beach.discountPrice,
                        fontSize = 12.sp,
                        color = Color.Gray,

                        style = TextStyle(textDecoration = TextDecoration.LineThrough),
                        modifier = Modifier.padding(end = 10.dp)
                    )

                    Text(
                        text = beach.discount,
                        fontSize = 12.sp,
                        color = Color.Red,
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .background(color = Color(0xFFFBD5D5))
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    Button(
                        onClick = { /* TODO: Add navigation logic */ },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF469CAD)),
                        modifier = Modifier
                            .height(35.dp)
                            .width(85.dp)
                    ) {
                        Text(text = "Beli", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = beach.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Gray70
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_hearts_fill),
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier.size(17.dp)
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_time_outline),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = beach.time, fontSize = 14.sp, color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_location_outline),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = beach.distance, fontSize = 14.sp, color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_star_outline),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = beach.rating.toString(), fontSize = 14.sp, color = Color.Gray
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun FavoriteScreenPreview() {
    FavoriteScreen()
}

data class Beach(
    val name: String,
    val imageUrl: Int,
    val rating: Double,
    val time: String,
    val distance: String,
    val price: String,
    val discount: String,
    val discountPrice: String
)

val beachList = listOf(
    Beach(
        "Pantai Pandawa",
        R.drawable.pantai_1,
        4.5,
        time = "06.00 - 18.00 WITA",
        distance = "5 km - 20 menit",
        price = "Rp. 150.000",
        discount = "50%",
        discountPrice = "Rp. 300.000"
    ), Beach(
        "Pantai Pandawa",
        R.drawable.pantai_2,
        4.5,
        time = "06.00 - 18.00 WITA",
        distance = "5 km - 20 menit",
        price = "Rp. 150.000",
        discount = "50%",
        discountPrice = "Rp. 300.000"
    ), Beach(
        "Pantai Pandawa",
        R.drawable.pantai_3,
        4.5,
        time = "06.00 - 18.00 WITA",
        distance = "5 km - 20 menit",
        price = "Rp. 150.000",
        discount = "50%",
        discountPrice = "Rp. 300.000"
    ), Beach(
        "Pantai Pandawa",
        R.drawable.pantai_4,
        4.5,
        time = "06.00 - 18.00 WITA",
        distance = "5 km - 20 menit",
        price = "Rp. 150.000",
        discount = "50%",
        discountPrice = "Rp. 300.000"
    )
)