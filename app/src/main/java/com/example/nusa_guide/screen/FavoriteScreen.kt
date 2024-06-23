package com.example.nusa_guide.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.api.RetrofitInstance
import com.example.nusa_guide.component.CardFavorit
import com.example.nusa_guide.data.DataStoreManager
import com.example.nusa_guide.model.FavoritModel
import com.example.nusa_guide.repository.FavoriteRepository
import com.example.nusa_guide.repository.RekomendasiRepository
import com.example.nusa_guide.ui.theme.gray700
import com.example.nusa_guide.viewModel.FavoriteViewModel
import com.example.nusa_guide.viewModel.FavoriteViewModelFactory
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun FavoriteScreen(navController: NavController) {
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale("id", "ID"))
    val formattedDate = currentDate.format(formatter)

    val context = LocalContext.current
    val dataStoreManager = DataStoreManager.getInstance(context)
    val apiService = RetrofitInstance.api
    val favoriteRepository = remember { FavoriteRepository(apiService, dataStoreManager) }
    val favoriteViewModel: FavoriteViewModel = viewModel(
        factory = FavoriteViewModelFactory(favoriteRepository)
    )
    val state by favoriteViewModel.favorite.collectAsState()

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
                    text = "Favorit",
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
        LazyColumn (
            modifier = Modifier.fillMaxSize()
        ){
            items(state) { favorite ->
                CardFavorit(favorit = favorite)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun FavoritScreenPreview() {
    FavoriteScreen(navController = rememberNavController())
}
