package com.example.nusa_guide.screen.payment

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.RadioButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.ui.theme.BrandPrimary400
import com.example.nusa_guide.ui.theme.NusaGuideTheme
import com.example.nusa_guide.ui.theme.black51
import com.example.nusa_guide.ui.theme.gray700

@Composable
fun BottomBar(totalTagihan: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 16.dp), // Added padding to bottom for better visibility
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Total tagihan\nRp %,d".format(totalTagihan),
                fontSize = 18.sp,
                color = BrandPrimary400
            )
            Button(
                onClick = { /* TODO: Handle payment */ },
                modifier = Modifier
                    .height(48.dp)
                    .width(120.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF00ADEF))
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_shield_tick),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Bayar", color = Color.White)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PaymentScreen(navController: NavController) {
    var selectedMethod by remember { mutableStateOf("BCA") }
    val paymentMethods = listOf("BCA", "Mandiri")
    val totalPesanan = 301000
    val hargaSebelumDiskon = 320000
    val biayaLayanan = 1000
    val diskon = 20000
    val totalTagihan = totalPesanan + biayaLayanan - diskon

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    androidx.compose.material3.Text(
                        text = "Edit Profil", fontWeight = FontWeight.Bold, fontSize = 20.sp
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "icon-back",
                        modifier = Modifier
                            .size(25.dp)
                            .clickable {
                                navController.popBackStack()
                            },
                        tint = black51
                    )
                }
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "Metode pembayaran",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    paymentMethods.forEach { method ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = (method == selectedMethod),
                                    onClick = { selectedMethod = method }
                                )
                                .padding(vertical = 8.dp)
                        ) {
                            val imageResource = if (method == "BCA") {
                                R.drawable.icon_bca
                            } else {
                                R.drawable.icon_mandiri
                            }

                            Image(
                                painter = painterResource(id = imageResource),
                                contentDescription = null,
                                modifier = Modifier.size(48.dp)
                            )

                            Spacer(modifier = Modifier.width(16.dp))

                            Text(
                                text = if (method == "BCA") "Transfer Bank BCA" else "Transfer Bank Mandiri",
                                modifier = Modifier.weight(1f),
                                fontSize = 16.sp
                            )

                            RadioButton(
                                selected = (method == selectedMethod),
                                onClick = { selectedMethod = method }
                            )
                        }
                    }
                    Divider(color = gray700, thickness = 2.dp)

                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        "Ringkasan pembayaran",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    SummaryItem(
                        label = "Total pesanan",
                        amount = totalPesanan,
                        originalAmount = hargaSebelumDiskon
                    )
                    SummaryItem(label = "Biaya layanan", amount = biayaLayanan)
                    SummaryItem(label = "Diskon", amount = -diskon)

                    Divider(color = gray700, thickness = 2.dp)
                }
            }
            BottomBar(totalTagihan)
        }
    }
}

@Composable
fun SummaryItem(label: String, amount: Int, isTotal: Boolean = false, originalAmount: Int? = null) {
    val color = LocalContentColor.current
    val fontSize = 16.sp

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, fontSize = fontSize,
            color = gray700)
        Row {
            originalAmount?.let {
                Text(
                    text = "Rp %,d".format(it),
                    color = Color.Gray,
                    fontSize = fontSize,
                    textDecoration = TextDecoration.LineThrough,
                    modifier = Modifier.padding(end = 4.dp)
                )
            }
            Text(
                text = "Rp %,d".format(amount),
                color = color,
                fontSize = fontSize
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentScreenPreview() {
    NusaGuideTheme {
        PaymentScreen(rememberNavController())
    }
}
