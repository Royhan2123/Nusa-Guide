package com.example.nusa_guide.screen.payment

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.ui.theme.BrandPrimary400
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray700
import kotlinx.coroutines.delay

@SuppressLint("DefaultLocale")
@Composable
fun PaymentDetailsUI(
    navController: NavController
) {
    var timeLeft by remember { mutableIntStateOf(3600) }
    var showAlert by remember { mutableStateOf(false) }

    LaunchedEffect(timeLeft) {
        if (timeLeft > 0) {
            delay(1000L)
            timeLeft -= 1
        } else {
            showAlert = true
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            Button(
                onClick = {
                    navController.navigate(
                       NavigationTourScreen.UploadBuktiScreen.name
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(brandPrimary500),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Upload Bukti",
                    fontSize = 16.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            if (showAlert) {
                AlertDialog(
                    onDismissRequest = { /* Do nothing */ },
                    title = { Text(text = "Waktu Habis") },
                    text = { Text("Waktu pembayaran sudah habis.") },
                    confirmButton = {
                        Button(onClick = { showAlert = false }) {
                            Text("OK")
                        }
                    }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Batas Pembayaran",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = "14 Mei 2024, 19:00 PM",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
                Surface(
                    modifier = Modifier.width(100.dp),
                    color = Color.Red,
                    shadowElevation = 8.dp,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_timer), // Ensure you have icon_timer in your drawable folder
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        val hours = timeLeft / 3600
                        val minutes = (timeLeft % 3600) / 60
                        val seconds = timeLeft % 60
                        val timeText = String.format("%02d : %02d : %02d", hours, minutes, seconds)

                        Text(
                            text = timeText,
                            fontSize = 12.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(thickness = 2.dp, color = gray700)

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Transfer Bank BCA",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Image(
                    painter = painterResource(id = R.drawable.icon_bca), // Ensure you have bca_logo in your drawable folder
                    contentDescription = "BCA Logo",
                    modifier = Modifier
                        .size(50.dp)
                        .padding(start = 8.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Nomor Rekening",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "1234567890",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                TextButton(
                    onClick = { /* TODO: Handle copy action */ },
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                ) {
                    Text(
                        text = "Salin",
                        fontSize = 14.sp,
                        color = BrandPrimary400
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Total Tagihan",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Rp 301.000",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                TextButton(
                    onClick = {
                              navController.navigate(
                                  NavigationTourScreen.DetailTransactionScreen.name
                              )
                    },
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                ) {
                    Text(
                        text = "Lihat Detail",
                        fontSize = 14.sp,
                        color = BrandPrimary400
                    )
                }
            }

            Button(
                onClick = {
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
            ) {
                Text(
                    text = "Lihat Cara Bayar",
                    fontSize = 16.sp,
                    color = BrandPrimary400,
                    textAlign = TextAlign.Center
                )
            }
            HorizontalDivider(thickness = 2.dp, color = gray700)
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Pesananmu baru diproses ke tour guide\nsetelah pembayaran terverifikasi",
                fontSize = 14.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPaymentDetailsUI() {
    PaymentDetailsUI(rememberNavController())
}