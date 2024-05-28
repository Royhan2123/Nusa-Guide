package com.example.nusa_guide.screen

import android.widget.Space
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nusa_guide.ui.theme.Gray60
import com.example.nusa_guide.ui.theme.Gray70


@Composable
fun DetailTransactionScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBarDetailTransactionScreen()
        Spacer(modifier = Modifier.height(24.dp))
        TransactionDetailItem(
            label = "Detail Tagihan",
            description = "Total pesanan",
            price = "Rp 300.000",
            showIcon = false
        )
        Spacer(modifier = Modifier.height(24.dp))
        TransactionDetailItem(
            label = "Biaya Transaksi",
            description = "Biaya layanan",
            price = "Rp 1.000",
            showIcon = true
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Total Bayar", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Gray70)
            Text("Rp 301.000", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Gray70)

        }
        Spacer(modifier = Modifier.height(24.dp))
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text("Dibayar dengan", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Gray70)
            Spacer(modifier = Modifier.height(10.dp))
            Text("Transfer Bank BCA", fontSize = 18.sp, color = Gray60)
        }
    }
}


@Composable
fun TopBarDetailTransactionScreen() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp, horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            Icons.Default.Close, contentDescription = null, modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(30.dp))
        Text("Detail Tagihan", fontWeight = FontWeight.Bold, fontSize = 28.sp)

    }
}


@Composable
fun TransactionDetailItem(label: String, description: String, price: String, showIcon: Boolean) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(label, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Gray70)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(description, fontSize = 16.sp, color = Gray60)
                Spacer(modifier = Modifier.width(8.dp))
                if (showIcon) {
                    Icon(
                        Icons.Outlined.Info,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Text(price, fontSize = 16.sp, color = Gray60)
        }
    }
}


@Preview
@Composable
fun DetailTransactionScreenPreview() {
    DetailTransactionScreen()
}
