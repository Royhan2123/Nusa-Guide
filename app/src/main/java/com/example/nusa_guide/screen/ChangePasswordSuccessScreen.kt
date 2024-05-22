package com.example.nusa_guide.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.ui.theme.grayText
import com.example.nusa_guide.widget.ButtonStyle

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ChangePasswordSuccessScreen(navController: NavController) {
    Surface {
        Scaffold {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_change_password_success),
                    contentDescription = "Avatar",
                    modifier = Modifier.height(280.dp)
                )
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = "Ubah Kata Sandi Berhasil!",
                    fontSize = 24.sp,
                    color = Color(0XFF1F2A37),
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Kata Sandi akun kamu telah berhasil diubah dan diverifikasi. Sekarang kamu dapat mengakses seluruh layanan dari Nusa Guide",
                    fontSize = 15.sp,
                    color = grayText,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(127.dp))
                ButtonStyle(
                    onClicked = {
                        navController.navigate(NavigationTourScreen.LoginScreen.name)
                    },
                    text = "Selanjutnya",
                    modifier = Modifier.fillMaxWidth().height(60.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewChangePasswordSuccessScreen() {
    ChangePasswordSuccessScreen(rememberNavController())
}
