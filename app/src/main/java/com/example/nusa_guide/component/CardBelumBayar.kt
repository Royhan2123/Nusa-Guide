package com.example.nusa_guide.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray
import com.example.nusa_guide.ui.theme.gray700
import com.example.nusa_guide.ui.theme.lightGray
import com.example.nusa_guide.ui.theme.white
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.HorizontalDivider
import com.example.nusa_guide.model.CardBelumBayarModel
import org.w3c.dom.Text
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun CardBelumBayar(
    card: CardBelumBayarModel,
    showAdditionalCharge: Boolean,
    showButton: Boolean,
    colorTextButton: Color,
    colorBorderButton: Color,
    colorBorderSurface: Color,
    titleElevatedButton: String,
    onClick: () -> Unit
) {
    val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    val formattedTime = timeFormat.format(card.waktuPemesanan)

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = colorBorderSurface,
                shape = RoundedCornerShape(20.dp),
            ),
        shape = RoundedCornerShape(20.dp),
        color = Color.White,
        shadowElevation = 1.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "${card.targetWisata} Tujuan Wisata",
                        color = gray700,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = card.noPemesanan,
                            fontSize = 14.sp,
                            color = Color.Gray,
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .background(
                                    color = gray, shape = CircleShape
                                )
                        )
                        Spacer(modifier = Modifier.width(5.dp))

                        val dateFormat = SimpleDateFormat("d MMM", Locale.getDefault())
                        val formattedDate = dateFormat.format(card.tanggalPemesanan)
                        Text(
                            text = formattedDate,
                            fontSize = 14.sp,
                            color = Color.Gray,
                        )
                        Spacer(modifier = Modifier.width(5.dp))

                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .background(
                                    color = gray, shape = CircleShape
                                )
                        )
                        Spacer(modifier = Modifier.width(5.dp))

                        Text(
                            text = formattedTime,
                            fontSize = 14.sp,
                            color = Color.Gray,
                        )
                    }
                }
                Text(
                    text = formatCurrency(card.hargaWisata),
                    color = gray700,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Jumlah Tiket",
                    fontSize = 16.sp,
                    color = gray,
                )
                Text(
                    text = card.jumlahTiket.toString(),
                    color = gray700,
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(
                thickness = 1.dp,
                color = lightGray,
            )
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Item",
                    fontSize = 16.sp,
                    color = gray,
                )
                Text(
                    text = "Paket Bundling",
                    color = gray700,
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(
                thickness = 1.dp,
                color = lightGray,
            )
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Tour Guide",
                    fontSize = 16.sp,
                    color = gray,
                )
                Text(
                    text = card.namaTourGuide,
                    color = gray700,
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(
                thickness = 1.dp,
                color = lightGray,
            )
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Total",
                    fontSize = 16.sp,
                    color = gray,
                )
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Text(
                        text = formatCurrency(card.totalHarga),
                        color = gray700,
                        fontSize = 17.sp,

                        )
                    Spacer(modifier = Modifier.height(5.dp))
                    if (showAdditionalCharge) {
                        Text(
                            text = "+${formatCurrency(card.tambahanHarga)}",
                            color = Color.Gray,
                            fontSize = 13.sp,
                            textAlign = TextAlign.End,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(
                thickness = 1.dp,
                color = lightGray,
            )
            Spacer(modifier = Modifier.height(20.dp))
            if (showButton) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    ElevatedButton(
                        onClick = onClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .border(
                                width = 2.dp,
                                color = colorBorderButton,
                                shape = RoundedCornerShape(
                                    size = 34.dp
                                )
                            ),
                        colors = ButtonDefaults.elevatedButtonColors(
                            white
                        ),
                        shape = RoundedCornerShape(
                            size = 34.dp
                        )
                    ) {
                        Text(
                            text = titleElevatedButton,
                            color = colorTextButton,
                            fontSize = 15.sp,
                        )
                    }
                }
            }
        }
    }
}

fun formatCurrency(amount: Int): String {
    val formatter = DecimalFormat("###,###,###")
    val symbols = DecimalFormatSymbols()
    symbols.groupingSeparator = '.'
    formatter.decimalFormatSymbols = symbols
    return "Rp ${formatter.format(amount)}"
}

@Preview(showBackground = true)
@Composable
fun PreviewCardBelumBayar() {
    val now = Date()
    CardBelumBayar(
        card = CardBelumBayarModel(
            targetWisata = 3,
            hargaWisata = 150000,
            jumlahTiket = 3,
            namaTourGuide = "Jason Susanto",
            totalHarga = 500000,
            tambahanHarga = 50000,
            noPemesanan = "W-345890",
            tanggalPemesanan = now,
            waktuPemesanan = now
        ),
        showAdditionalCharge = true,
        showButton = true,
        colorBorderButton = brandPrimary500,
        colorTextButton = brandPrimary500,
        colorBorderSurface = brandPrimary500,
        titleElevatedButton = "Hubungi Tour Guide",
        onClick = {}
    )
}
