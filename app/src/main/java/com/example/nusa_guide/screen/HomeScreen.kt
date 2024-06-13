package com.example.nusa_guide.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.repository.RekomendasiRepository
import com.example.nusa_guide.ui.theme.gray
import com.example.nusa_guide.ui.theme.gray50
import com.example.nusa_guide.ui.theme.gray700
import com.example.nusa_guide.ui.theme.grayText
import com.example.nusa_guide.viewModel.RekomendasiViewModel
import com.example.nusa_guide.viewModel.RekomendasiViewModelFactory

@SuppressLint("RememberReturnType")
@Composable
fun HomeScreen(
    navController: NavController,
) {
    val rekomendasiRepository = remember { RekomendasiRepository() }
    val rekomendasiViewModel: RekomendasiViewModel = viewModel(
        factory = RekomendasiViewModelFactory(rekomendasiRepository)
    )
    val rekomendasiItems by rekomendasiViewModel.rekomendasiItems.observeAsState()

    var isSelected by remember {
        mutableStateOf(true)
    }
    Column(
        modifier = Modifier
            .padding(
                vertical = 20.dp,
                horizontal = 16.dp,
            )
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
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
                    text = "Muhammad Al Kahfi",
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
                    shape = RoundedCornerShape(
                        size = 10.dp
                    ),
                )
                .clickable {
                    navController.navigate(
                        NavigationTourScreen.SearchScreen.name
                    )
                },
            shape = RoundedCornerShape(
                size = 10.dp
            ),
            color = gray50,
            shadowElevation = 5.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = 10.dp,
                        horizontal = 17.dp
                    ),
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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.height(100.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .size(70.dp)
                        .border(
                            width = if (isSelected) 1.dp else 2.dp,
                            color = if (isSelected) gray else gray700,
                            shape = RoundedCornerShape(
                                size = 10.dp
                            )
                        )
                        .clickable {
                            isSelected = !isSelected
                        },
                    shape = RoundedCornerShape(
                        size = 10.dp
                    ),
                    shadowElevation = 20.dp
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.alam),
                        contentDescription = "image-terdekat",
                        contentScale = ContentScale.Crop,
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Alam",
                    fontSize = 14.sp,
                    color = gray700,
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.height(100.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .size(70.dp)
                        .border(
                            width = if (isSelected) 1.dp else 2.dp,
                            color = if (isSelected) gray else gray700,
                            shape = RoundedCornerShape(
                                size = 10.dp
                            )
                        )
                        .clickable {
                            isSelected = !isSelected
                        },
                    shape = RoundedCornerShape(
                        size = 10.dp
                    ),
                    shadowElevation = 10.dp
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.budaya),
                        contentDescription = "image-terdekat",
                        contentScale = ContentScale.Crop,
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Budaya",
                    fontSize = 14.sp,
                    color = gray700,
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.height(100.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .size(70.dp)
                        .border(
                            width = if (isSelected) 1.dp else 2.dp,
                            color = if (isSelected) gray else gray700,
                            shape = RoundedCornerShape(
                                size = 10.dp
                            )
                        )
                        .clickable {
                            isSelected = !isSelected
                        },
                    shape = RoundedCornerShape(
                        size = 10.dp
                    ),
                    shadowElevation = 10.dp
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.tour),
                        contentDescription = "image-terdekat",
                        contentScale = ContentScale.Crop,
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Tour",
                    fontSize = 14.sp,
                    color = gray700,
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.height(100.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .size(70.dp)
                        .border(
                            width = if (isSelected) 1.dp else 2.dp,
                            color = if (isSelected) gray else gray700,
                            shape = RoundedCornerShape(
                                size = 10.dp
                            )
                        )
                        .clickable {
                            isSelected = !isSelected
                        },
                    shape = RoundedCornerShape(
                        size = 10.dp
                    ),
                    shadowElevation = 10.dp
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.aktifitas_air),
                        contentDescription = "image-terdekat",
                        contentScale = ContentScale.Crop,
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Aktifitas Air",
                    fontSize = 14.sp,
                    color = gray700,
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
//        LazyRow {
//            items(rekomendasiItems) { rekomendasi ->
//                CardRekomendasiItem(rekomendasi = rekomendasi) {
//                    // Handle click
//                }
//            }
//        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(
        navController = rememberNavController(),
    )
}
