package com.example.nusa_guide.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SearchScreen(navController: NavController) {

//    val rekomendasiRepository = remember { RekomendasiRepository() }
//    val rekomendasiViewModel: RekomendasiViewModel = viewModel(
//        factory = RekomendasiViewModelFactory(rekomendasiRepository)
//    )
//    val state by rekomendasiViewModel.state.collectAsState()
//    var txfSearch by remember {
//        mutableStateOf("")
//    }
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(horizontal = 20.dp, vertical = 20.dp)
//    ) {
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Icon(
//                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
//                contentDescription = "icon-back",
//                modifier = Modifier
//                    .size(25.dp)
//                    .clickable {
//                        navController.popBackStack()
//                    },
//                tint = black51
//            )
//            OutlinedTextField(
//                value = txfSearch,
//                onValueChange = {
//                    txfSearch = it
//                    rekomendasiViewModel.searchRekomendasi(it)
//                },
//                placeholder = {
//                    Text(
//                        text = "cari wisata destinasimu",
//                        fontSize = 15.sp,
//                        color = gray
//                    )
//                },
//                singleLine = true,
//                modifier = Modifier
//                    .height(53.dp)
//                    .width(259.dp),
//                textStyle = TextStyle(
//                    color = black51,
//                    fontSize = 14.sp,
//                ),
//                leadingIcon = {
//                    Icon(
//                        imageVector = Icons.Default.Search,
//                        contentDescription = "icon-back",
//                        modifier = Modifier.size(24.dp),
//                        tint = gray
//                    )
//                },
//                colors = OutlinedTextFieldDefaults.colors(
//                    focusedBorderColor = black51,
//                    unfocusedBorderColor = gray
//                ),
//                keyboardOptions = KeyboardOptions.Default.copy(
//                    keyboardType = KeyboardType.Text
//                )
//            )
//            Icon(
//                painter = painterResource(id = R.drawable.icon_filtering),
//                contentDescription = "icon-filtering",
//                modifier = Modifier
//                    .size(22.dp)
//                    .clickable {
//                        navController.navigate(
//                            NavigationTourScreen.FilteringScreen.name
//                        )
//                    },
//                tint = black51,
//            )
//        }
//        Spacer(modifier = Modifier.height(50.dp))
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(2),
//            verticalArrangement = Arrangement.spacedBy(16.dp),
//            horizontalArrangement = Arrangement.spacedBy(16.dp),
//        ) {
//            if (state.isEmpty()) {
//                item(span = { GridItemSpan(2) }) {
//                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                        CircularProgressIndicator()
//                    }
//                }
//            }
//            items(state) { rekomendasi ->
//                CardRekomendasiItem(rekomendasi = rekomendasi) {
//                    /*TODO NOT FUNCTION */
//                }
//            }
//        }
//    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSearchScreen() {
    SearchScreen(navController = rememberNavController())
}