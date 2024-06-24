package com.example.nusa_guide.screen

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.nusa_guide.data.DataStoreManager
import com.example.nusa_guide.model.UserModel
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.repository.AuthRepository
import com.example.nusa_guide.ui.theme.Gray80
import com.example.nusa_guide.viewModel.AuthViewModel
import com.example.nusa_guide.viewModel.AuthViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
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
    val user by authViewModel.user.observeAsState()

    // Fetch user data when the composable is launched
    LaunchedEffect(Unit) {
        authViewModel.getUser()
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Profil", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 10.dp)
        ) {
            ProfileHeader(navController, user) // Pass user to ProfileHeader
            Spacer(modifier = Modifier.height(24.dp))
            AccountSection()
            Spacer(modifier = Modifier.height(36.dp))
            FavoriteSection()
        }
    }
}
@Composable
fun ProfileHeader(navController: NavController, user: UserModel?) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier
                .size(64.dp)
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
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = user?.username ?: "User Pengguna",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = user?.email ?: "User Email",
                fontSize = 14.sp
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.ic_edit_profile),
            contentDescription = null,
            modifier = Modifier.clickable {
                navController.navigate(
                    NavigationTourScreen.AboutProfileScreen.name
                )
            }
                .size(70.dp)
        )
    }
}


@Composable
fun AccountSection() {
    Column {
        Text(text = "Akun", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        ProfileMenuItem("Keamanan Akun", R.drawable.ic_security_safe)
        HorizontalDivider()
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Favoritmu", fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}

@Composable
fun ProfileMenuItem(title: String, drawable: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = title,
            color = Gray80,
            fontSize = 16.sp,
        )
        Spacer(modifier = Modifier.weight(1f))
        TextButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .padding(bottom = 5.dp)
            )
        }
    }
}

@Composable
fun FavoriteSection() {
    val images = listOf(
        R.drawable.aktifitas_air,
        R.drawable.tour,
    )

    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(18.dp),
        modifier = Modifier.fillMaxSize(),
        content = {
            items(images) { imageResId ->
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(rememberNavController())
}
