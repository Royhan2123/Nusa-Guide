package com.example.nusa_guide.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.nusa_guide.R
import com.example.nusa_guide.model.RekomendasiModel
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray
import com.example.nusa_guide.ui.theme.gray700
import java.text.NumberFormat
import java.util.Locale

@Composable
fun CardRekomendasiItem(
    rekomendasi: RekomendasiModel,
    onClick: () -> Unit,
) {
    var isSelected by remember {
        mutableStateOf(true)
    }
    Surface(
        modifier = Modifier
            .width(200.dp)
            .clickable { onClick() }
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(10.dp),
                color = gray
            )
            .height(260.dp),
        shape = RoundedCornerShape(10.dp),
    ) {
        Box {
            Column {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = rememberAsyncImagePainter(model = rekomendasi.gambar1),
                        contentDescription = rekomendasi.nama,
                        modifier = Modifier
                            .height(100.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp, vertical = 5.dp),
                        contentAlignment = Alignment.TopEnd
                    ) {
                        Surface(
                            modifier = Modifier
                                .height(20.dp)
                                .width(20.dp),
                            shape = CircleShape,
                            color = Color.White
                        ) {
                            IconButton(onClick = { isSelected = !isSelected }) {
                                if (isSelected) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.icon_favorit_red),
                                        contentDescription = "icon-favorit",
                                        modifier = Modifier
                                            .size(20.dp)
                                            .padding(5.dp),
                                        tint = gray700
                                    )
                                } else {
                                    Icon(
                                        painter = painterResource(id = R.drawable.icon_favorit_red),
                                        contentDescription = "icon-favorit",
                                        modifier = Modifier
                                            .size(20.dp)
                                            .padding(5.dp),
                                        tint = Color.Red
                                    )
                                }
                            }
                        }

                    }
                }
                Column(
                    modifier = Modifier.padding(
                        horizontal = 10.dp,
                        vertical = 10.dp
                    )
                ) {
                    Text(
                        text = "- ${rekomendasi.jarakLokasi}",
                        color = gray,
                        fontSize = 10.sp,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    rekomendasi.nama?.let {
                        Text(
                            text = it,
                            color = gray700,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Spacer(modifier = Modifier.height(7.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_location),
                            contentDescription = "icon-location",
                            modifier = Modifier.size(13.dp),
                            tint = gray700
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        rekomendasi.lokasi?.let {
                            Text(
                                text = it,
                                color = gray700,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(7.dp))
                    val formattedHarga =
                        NumberFormat.getNumberInstance(Locale("in", "ID")).format(rekomendasi.harga)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Rp $formattedHarga",
                            color = brandPrimary500,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "/ orang",
                            color = gray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}
