package com.example.nusa_guide.screen

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.api.RetrofitInstance
import com.example.nusa_guide.component.CardRekomendasiItem
import com.example.nusa_guide.data.DataStoreManager
import com.example.nusa_guide.model.WisataModel
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.repository.AuthRepository
import com.example.nusa_guide.repository.RekomendasiRepository
import com.example.nusa_guide.ui.theme.gray
import com.example.nusa_guide.ui.theme.gray50
import com.example.nusa_guide.ui.theme.gray700
import com.example.nusa_guide.ui.theme.grayText
import com.example.nusa_guide.viewModel.AuthViewModel
import com.example.nusa_guide.viewModel.AuthViewModelFactory
import com.example.nusa_guide.viewModel.RekomendasiViewModel
import com.example.nusa_guide.viewModel.RekomendasiViewModelFactory

@SuppressLint("RememberReturnType")
@Composable
fun HomeScreen(
    navController: NavController,
    authViewModel: AuthViewModel = viewModel(
        factory = AuthViewModelFactory(
            repository = AuthRepository(
                apiService = RetrofitInstance.api,
                dataStoreManager = DataStoreManager.getInstance(context = LocalContext.current)
            )
        )
    )
) {

    val context = LocalContext.current
    val dataStoreManager = DataStoreManager.getInstance(context)
    val apiService = RetrofitInstance.api

    val rekomendasiRepository = remember { RekomendasiRepository(apiService, dataStoreManager) }
    val rekomendasiViewModel: RekomendasiViewModel = viewModel(
        factory = RekomendasiViewModelFactory(rekomendasiRepository)
    )

    val state by rekomendasiViewModel.state.collectAsState()
    var selectedCategory by remember { mutableStateOf("") }

    val user by authViewModel.user.observeAsState()

    // Mendapatkan data user setelah login
    LaunchedEffect(Unit) {
        authViewModel.getUser()
    }

    LaunchedEffect(selectedCategory) {
        if (selectedCategory.isNotEmpty()) {
            rekomendasiViewModel.getWisataByKategori(selectedCategory)
        }
    }

    LazyColumn(
        modifier = Modifier
            .padding(vertical = 20.dp, horizontal = 16.dp)
            .fillMaxSize()
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier
                        .size(60.dp)
                        .clickable {
                            navController.navigate(
                                NavigationTourScreen.AboutProfileScreen.name
                            )
                        },
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "icon-circle",
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = user?.username ?: "User Pengguna",
                        fontSize = 16.sp,
                        color = gray700,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Mari eksplore indahnya Bali",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_cart),
                        contentDescription = "icon-cart",
                        modifier = Modifier
                            .size(25.dp)
                            .clickable {
                                navController.navigate(
                                    NavigationTourScreen.CartScreen.name
                                )
                            }
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.icon_notification),
                        contentDescription = "icon-notification",
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .border(
                        width = 2.dp,
                        color = gray,
                        shape = RoundedCornerShape(10.dp),
                    )
                    .clickable {
                        navController.navigate(
                            NavigationTourScreen.SearchScreen.name
                        )
                    },
                shape = RoundedCornerShape(10.dp),
                color = gray50,
                shadowElevation = 5.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp, horizontal = 17.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "icon-search",
                        modifier = Modifier.size(30.dp),
                        gray700
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Cari Tour Guide Anda",
                        color = grayText,
                        fontSize = 17.sp,
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Kategori",
                fontSize = 20.sp,
                color = gray700,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(25.dp))
        }

        item {
            // Kategori
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CategoryItem(
                    imageRes = R.drawable.alam,
                    label = "Alam",
                    isSelected = selectedCategory == "alam",
                    onClick = { selectedCategory = "alam" },
                )
                CategoryItem(
                    imageRes = R.drawable.budaya,
                    label = "Budaya",
                    isSelected = selectedCategory == "budaya",
                    onClick = { selectedCategory = "budaya" },
                )
                CategoryItem(
                    imageRes = R.drawable.tour,
                    label = "Tour",
                    isSelected = selectedCategory == "tour",
                    onClick = { selectedCategory = "tour" },
                )
                CategoryItem(
                    imageRes = R.drawable.aktifitas_air,
                    label = "Aktifitas Air",
                    isSelected = selectedCategory == "aktivitas-air",
                    onClick = { selectedCategory = "aktivitas-air" },
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
        }

        item {
            // Rekomendasi
            RekomendasiGrid(state)
        }
    }
}

@Composable
fun RekomendasiGrid(state: List<WisataModel>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.height(600.dp)  // Tentukan tinggi agar dapat digulirkan dalam LazyColumn
    ) {
        if (state.isEmpty()) {
            item(span = { GridItemSpan(2) }) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
        }
        items(state) { rekomendasi ->
            CardRekomendasiItem(rekomendasi = rekomendasi) {
                /*TODO NOT FUNCTION */
            }
        }
    }
}

@Composable
fun CategoryItem(
    @DrawableRes imageRes: Int,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.height(100.dp)
    ) {
        Surface(
            modifier = Modifier
                .size(70.dp)
                .border(
                    width = if (isSelected) 2.dp else 1.dp,
                    color = if (isSelected) gray700 else gray,
                    shape = RoundedCornerShape(10.dp)
                )
                .clickable { onClick() },
            shape = RoundedCornerShape(10.dp),
            shadowElevation = 20.dp
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = label,
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = label,
            fontSize = 14.sp,
            color = grayText
        )
    }
}
@Preview(showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(
        navController = rememberNavController(),
    )
}
