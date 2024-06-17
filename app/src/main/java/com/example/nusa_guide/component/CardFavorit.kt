package com.example.nusa_guide.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nusa_guide.R
import com.example.nusa_guide.model.FavoritModel
import com.example.nusa_guide.ui.theme.black51
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray
import com.example.nusa_guide.ui.theme.gray700
import com.example.nusa_guide.ui.theme.white
import java.text.NumberFormat
import java.util.Locale

@Composable
fun CardFavorit(
    favorit: FavoritModel
) {
    var isSelected by remember {
        mutableStateOf(true)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = favorit.image),
                    contentDescription = favorit.title,
                    modifier = Modifier
                        .width(135.dp)
                        .height(110.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = favorit.title,
                        fontSize = 16.sp,
                        color = gray700,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_time),
                            contentDescription = "icon-time",
                            modifier = Modifier.size(15.dp),
                            tint = black51,
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "${formatTime(favorit.waktu)} - ${formatTime(favorit.waktuSelesai)} WITA",
                            fontSize = 14.sp,
                            color = gray700,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_location),
                            contentDescription = "icon-location",
                            modifier = Modifier.size(15.dp),
                            tint = black51,
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "${favorit.km} km - ${favorit.menit} menit",
                            fontSize = 12.sp,
                            color = gray700,
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_star_outlined),
                            contentDescription = "icon-star",
                            modifier = Modifier.size(15.dp),
                            tint = black51,
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "${favorit.rating}",
                            fontSize = 12.sp,
                            color = gray700,
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { isSelected = !isSelected }) {
                    if (isSelected) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "icon-favorit-filled",
                            tint = Color.Red,
                            modifier = Modifier.size(25.dp)
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = "icon-favorit-outlined",
                            tint = gray,
                            modifier = Modifier.size(25.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Rp ${formatHarga(favorit.harga)}",
                    color = brandPrimary500,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Rp ${formatHarga(favorit.potonganHarga)}",
                    color = gray,
                    fontSize = 16.sp,
                    textDecoration = TextDecoration.LineThrough
                )
                Spacer(modifier = Modifier.width(10.dp))
                Surface(
                    modifier = Modifier
                        .width(50.dp)
                        .height(22.dp),
                    color = Color(0XFFFBD5D5),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "${favorit.diskon}%",
                            color = Color.Red,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                ElevatedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .height(34.dp)
                        .width(85.dp),
                    colors = ButtonDefaults.buttonColors(
                        brandPrimary500
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Beli",
                        fontSize = 14.sp,
                        color = white,
                    )
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            HorizontalDivider(thickness = 1.dp, color = gray)
        }
    }
}

@SuppressLint("DefaultLocale")
fun formatTime(time: Double): String {
    val hours = time.toInt()
    val minutes = ((time - hours) * 60).toInt()
    return String.format("%02d:%02d", hours, minutes)
}

fun formatHarga(harga: Int): String {
    val numberFormat = NumberFormat.getNumberInstance(Locale("id", "ID"))
    return numberFormat.format(harga)
}

@Preview
@Composable
fun PreviewCardFavorit() {
    val favoritModel = FavoritModel(
        id = 1,
        title = "Pantai Pandawa",
        waktu = 6.00,
        waktuSelesai = 18.00,
        km = 1,
        rating = 4.5,
        harga = 150000,
        potonganHarga = 500000,
        diskon = 50,
        image = R.drawable.alam,
        menit = 20
    )
    CardFavorit(favorit = favoritModel)
}
