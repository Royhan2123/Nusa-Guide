package com.example.nusa_guide.screen

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.nusa_guide.R
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.grayText
import com.example.nusa_guide.widget.ButtonStyle

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ChangePasswordSuccessScreen(
    navController: NavController
) {

    val context = LocalContext.current
    val lottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.succes_animation)
    )

    val progress by animateLottieCompositionAsState(
        composition = lottieComposition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
            .padding(
                horizontal = 20.dp
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            LottieAnimation(
                composition = lottieComposition,
                progress = progress,
                modifier = Modifier.size(125.dp)
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Penggantian Kata Sandi Terkirim",
            fontSize = 20.sp,
            color = Color(0XFF1F2A37),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Silakan cek akun Gmail Anda untuk melanjutkan proses pergantian kata sandi melalui tautan yang telah dikirimkan.",
            fontSize = 13.sp,
            color = grayText,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(127.dp))
        ButtonStyle(
            onClicked = {
                openGmail(context)
            },
            text = "Masuk ke Gmail",
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextButton(onClick = {
            navController.navigate(NavigationTourScreen.LoginScreen.name)
        }) {
            Text(
                text = "Login",
                fontSize = 16.sp,
                color = brandPrimary500,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

fun openGmail(context: Context) {
    val intent = context.packageManager.getLaunchIntentForPackage("com.google.android.gm")
    if (intent != null) {
        context.startActivity(intent)
    } else {
        Toast.makeText(context, "Gagal membuka Gmail", Toast.LENGTH_SHORT).show()
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewChangePasswordSuccessScreen() {
    ChangePasswordSuccessScreen(rememberNavController())
}
