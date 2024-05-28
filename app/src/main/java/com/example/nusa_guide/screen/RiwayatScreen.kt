package com.example.nusa_guide.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.component.CardBelumBayar
import com.example.nusa_guide.model.CardBelumBayarModel
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.ui.theme.black51
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray
import com.example.nusa_guide.ui.theme.gray700
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

@SuppressLint("AutoboxingStateCreation")
@Composable
 fun RiwayatScreen(navController: NavController) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    val tabLabels = listOf("Belum Bayar", "Proses", "Selesai", "Semua")

    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale("id", "ID"))
    val formattedDate = currentDate.format(formatter)
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Riwayat",
                    color = gray700,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = formattedDate,
                    fontSize = 15.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Icon(
                imageVector = Icons.Default.History,
                contentDescription = "icon-history",
                modifier = Modifier.size(35.dp),
                tint = Color.Gray
            )
        }

        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            edgePadding = 16.dp,
            indicator = { tabPositions ->
                SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = brandPrimary500
                )
            },
            modifier = Modifier.fillMaxWidth(),
            contentColor = Color.Gray,
            divider = {}
        ) {
            tabLabels.forEachIndexed { index, label ->
                Tab(
                    text = label,
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index }
                )
            }
        }

        when (selectedTabIndex) {
            0 -> BelumBayarScreen(
                card = CardBelumBayarModel(
                    targetWisata = 3,
                    hargaWisata = 150000,
                    jumlahTiket = 3,
                    namaTourGuide = "Jason Susanto",
                    totalHarga = 500000,
                    tambahanHarga = 50000,
                    noPemesanan = "W-345890",
                    tanggalPemesanan = Date(),
                    waktuPemesanan = Date()
                )
            )

            1 -> ProsesScreen()
            2 -> SelesaiScreen(
                card = CardBelumBayarModel(
                    targetWisata = 3,
                    hargaWisata = 150000,
                    jumlahTiket = 3,
                    namaTourGuide = "Jason Susanto",
                    totalHarga = 500000,
                    tambahanHarga = 50000,
                    noPemesanan = "W-345890",
                    tanggalPemesanan = Date(),
                    waktuPemesanan = Date(),
                ),
                navController
            )
            3 -> SemuaScreen()
        }
    }
}

@Composable
fun Tab(text: String, selected: Boolean, onClick: () -> Unit) {
    Text(
        text = text,
        color = if (selected) brandPrimary500 else gray,
        fontSize = 16.sp,
        fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable(onClick = onClick)
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewRiwayatScreen() {
    RiwayatScreen(navController = rememberNavController())
}

@Preview(showSystemUi = true)
@Composable
fun PreviewBelumBayar() {
    val cardData = CardBelumBayarModel(
        targetWisata = 3,
        hargaWisata = 150000,
        jumlahTiket = 3,
        namaTourGuide = "Jason Susanto",
        totalHarga = 500000,
        tambahanHarga = 50000,
        noPemesanan = "W-345890",
        tanggalPemesanan = Date(),
        waktuPemesanan = Date()
    )

    BelumBayarScreen(card = cardData)
}

@Composable
fun BelumBayarScreen(
    card: CardBelumBayarModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 20.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        CardBelumBayar(
            card = CardBelumBayarModel(
                targetWisata = 3,
                hargaWisata = 150000,
                jumlahTiket = 3,
                namaTourGuide = "Jason Susanto",
                totalHarga = 500000,
                tambahanHarga = 50000,
                noPemesanan = "W-345890",
                tanggalPemesanan = Date(),
                waktuPemesanan = Date()
            ),
            showAdditionalCharge = true,
            showButton = true,
            colorTextButton = brandPrimary500,
            colorBorderButton = brandPrimary500,
            colorBorderSurface = brandPrimary500,
            titleElevatedButton = "Hubungi Tour Guide",
            onClick = {}
        )
        Spacer(modifier = Modifier.height(20.dp))
        CardBelumBayar(
            card = CardBelumBayarModel(
                targetWisata = 3,
                hargaWisata = 150000,
                jumlahTiket = 3,
                namaTourGuide = "Jason Susanto",
                totalHarga = 500000,
                tambahanHarga = 50000,
                noPemesanan = "W-345890",
                tanggalPemesanan = Date(),
                waktuPemesanan = Date()
            ),
            showAdditionalCharge = false,
            showButton = false,
            colorTextButton = brandPrimary500,
            colorBorderButton = brandPrimary500,
            colorBorderSurface = brandPrimary500,
            titleElevatedButton = "Hubungi Tour Guide",
            onClick = {}
        )
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSelesai() {
    val cardData = CardBelumBayarModel(
        targetWisata = 3,
        hargaWisata = 150000,
        jumlahTiket = 3,
        namaTourGuide = "Jason Susanto",
        totalHarga = 500000,
        tambahanHarga = 50000,
        noPemesanan = "W-345890",
        tanggalPemesanan = Date(),
        waktuPemesanan = Date()
    )

    SelesaiScreen(card = cardData, navController = rememberNavController())
}

@Composable
fun ProsesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 20.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        Text(text = "Proses Pemesanan")
    }
}

@Composable
fun SemuaScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 20.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        Text(text = "Semua Screen")
    }
}

@Composable
fun SelesaiScreen(
    card: CardBelumBayarModel,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 20.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        CardBelumBayar(
            card = CardBelumBayarModel(
                targetWisata = 3,
                hargaWisata = 150000,
                jumlahTiket = 3,
                namaTourGuide = "Jason Susanto",
                totalHarga = 500000,
                tambahanHarga = 50000,
                noPemesanan = "W-345890",
                tanggalPemesanan = Date(),
                waktuPemesanan = Date()
            ),
            showAdditionalCharge = true,
            showButton = true,
            colorTextButton = black51,
            colorBorderButton = gray700,
            colorBorderSurface = gray,
            titleElevatedButton = "Beri Ulasan",
            onClick = {
                navController.navigate(
                    NavigationTourScreen.UlasanScreen.name
                )
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        CardBelumBayar(
            card = CardBelumBayarModel(
                targetWisata = 3,
                hargaWisata = 150000,
                jumlahTiket = 3,
                namaTourGuide = "Jason Susanto",
                totalHarga = 500000,
                tambahanHarga = 50000,
                noPemesanan = "W-345890",
                tanggalPemesanan = Date(),
                waktuPemesanan = Date()
            ),
            showAdditionalCharge = false,
            showButton = false,
            colorTextButton = brandPrimary500,
            colorBorderButton = brandPrimary500,
            colorBorderSurface = brandPrimary500,
            titleElevatedButton = "Beri Ulasan",
            onClick = {}
        )
        Spacer(modifier = Modifier.height(50.dp))
    }
}
