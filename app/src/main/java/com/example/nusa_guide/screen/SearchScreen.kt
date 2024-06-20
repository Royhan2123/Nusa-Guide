package com.example.nusa_guide.screen

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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
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
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.repository.RekomendasiRepository
import com.example.nusa_guide.ui.theme.black51
import com.example.nusa_guide.ui.theme.gray
import com.example.nusa_guide.viewModel.RekomendasiViewModel
import com.example.nusa_guide.viewModel.RekomendasiViewModelFactory

@Composable
fun SearchScreen(navController: NavController) {
    val context = LocalContext.current
    val dataStoreManager = DataStoreManager.getInstance(context)

    val apiService = RetrofitInstance.api

    val rekomendasiRepository = remember { RekomendasiRepository(apiService, dataStoreManager) }

    val rekomendasiViewModel: RekomendasiViewModel = viewModel(
        factory = RekomendasiViewModelFactory(rekomendasiRepository)
    )
    val state by rekomendasiViewModel.state.collectAsState()
    var txfSearch by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
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
            OutlinedTextField(
                value = txfSearch,
                onValueChange = {
                    txfSearch = it
                    rekomendasiViewModel.searchRekomendasi(it)
                },
                placeholder = {
                    Text(
                        text = "cari wisata destinasimu",
                        fontSize = 15.sp,
                        color = gray
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .height(53.dp)
                    .width(245.dp),
                textStyle = TextStyle(
                    color = black51,
                    fontSize = 14.sp,
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "icon-back",
                        modifier = Modifier.size(24.dp),
                        tint = gray
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = black51,
                    unfocusedBorderColor = gray
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text
                )
            )
            Icon(
                painter = painterResource(id = R.drawable.icon_filtering),
                contentDescription = "icon-filtering",
                modifier = Modifier
                    .size(18.dp)
                    .clickable {
                        navController.navigate(
                            NavigationTourScreen.FilteringScreen.name
                        )
                    },
                tint = black51,
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
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
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSearchScreen() {
    SearchScreen(navController = rememberNavController())
}