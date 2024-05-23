package com.example.nusa_guide.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.model.DummyData.paketPremiumList
import com.example.nusa_guide.model.DummyData.paketRegularList
import com.example.nusa_guide.model.DummyData.rekomendasiList
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray400

sealed class BottomNavigationScreen(
    val title: String,
    val iconOutlined: Int,
    val iconFilled: Int,
) {
    data object HomeScreen : BottomNavigationScreen("Home", R.drawable.icon_home, R.drawable.icon_home_filled)
    data object RiwayatScreen : BottomNavigationScreen("Riwayat", R.drawable.icon_riwayat, R.drawable.icon_riwayat_filled)
   data object FavoritScreen : BottomNavigationScreen("Favorit", R.drawable.icon_favorit, R.drawable.icon_favorit_filled)
   data object ProfileScreen : BottomNavigationScreen("Profil", R.drawable.icon_profil, R.drawable.icon_profil_filled)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HalamanBottom() {
    val navController = rememberNavController()

    val items = listOf(
        BottomNavigationScreen.HomeScreen,
        BottomNavigationScreen.RiwayatScreen,
        BottomNavigationScreen.FavoritScreen,
        BottomNavigationScreen.ProfileScreen,
    )

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White,
                elevation = 10.dp
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach { screen ->
                    val icon = if (currentRoute == screen.title) screen.iconFilled else screen.iconOutlined
                    BottomNavigationItem(
                        selected = currentRoute == screen.title,
                        onClick = {
                            navController.navigate(screen.title) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = icon),
                                contentDescription = screen.title,
                                tint = if (currentRoute == screen.title) brandPrimary500 else gray400,
                                modifier = Modifier
                                    .size(22.dp)
                                    .padding(bottom = 4.dp)
                            )
                        },
                        label = {
                            Text(
                                text = screen.title,
                                color = if (currentRoute == screen.title) brandPrimary500 else gray400,
                            )
                        },
                        alwaysShowLabel = false
                    )
                }
            }
        },
        content = { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = BottomNavigationScreen.HomeScreen.title,
                modifier = Modifier.padding(innerPadding) // Apply innerPadding to NavHost
            ) {
                composable(BottomNavigationScreen.HomeScreen.title) {
                    HomeScreen(navController = navController)
                }
                composable(BottomNavigationScreen.RiwayatScreen.title) {
                    RiwayatScreen(navController = navController)
                }
                composable(BottomNavigationScreen.FavoritScreen.title) {
                    FavoritScreen(navController = navController)
                }
                composable(BottomNavigationScreen.ProfileScreen.title) {
                    ProfileScreen(navController = navController)
                }
                composable(NavigationTourScreen.RekomendasiScreen.name) {
                    RekomendasiScreen(navController, rekomendasiList)
                }
                composable(NavigationTourScreen.PaketPremiumScreen.name) {
                    PaketPremiumScreen(navController, paketPremiumList)
                }
                composable(NavigationTourScreen.PaketRegulerScreen.name) {
                    PaketRegularScreen(navController, paketRegularList)
                }
                composable(NavigationTourScreen.SearchScreen.name) {
                    SearchScreen(navController)
                }
                composable(NavigationTourScreen.AboutProfileScreen.name) {
                    AboutProfileScreen()
                }
            }
        }
    )
}

@Preview
@Composable
fun PreviewHalamanBottom() {
    HalamanBottom()
}
