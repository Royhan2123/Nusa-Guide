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
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nusa_guide.R
import com.example.nusa_guide.ui.theme.Gray80



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Profile", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 20.dp)
        ) {
            ProfileHeader()
            Spacer(modifier = Modifier.height(24.dp))
            AccountSection()
            Spacer(modifier = Modifier.height(36.dp))
            FavoriteSection()
        }
    }

}

@Composable
fun ProfileHeader() {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = "Kim Jiwon", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "kimjin@gmail.com", fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.ic_edit_profile),
            contentDescription = null,

            modifier = Modifier.clickable { /* Handle edit click */ }.height(40.dp)
        )
    }
}

@Composable
fun AccountSection() {
    Column {
        Text(text = "Akun", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        ProfileMenuItem("Keamanan Akun", R.drawable.ic_security_safe)
        Divider()
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Favoritmu", fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}

@Composable
fun ProfileMenuItem(title: String, drawable: Int) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = title,
            color = Gray80,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 30.dp, end = 180.dp),
        )
        TextButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
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
        R.drawable.pantai_1,
        R.drawable.pantai_2,
        R.drawable.pantai_3,
        R.drawable.pantai_4,
        R.drawable.pantai_5,
        R.drawable.pantai_6
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


// encase if needed
@Composable
fun LogoutButton() {
    Button(
        onClick = { /* TODO: Add navigation logic */ },
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF469CAD)),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Text(text = "Keluar", fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }

}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}