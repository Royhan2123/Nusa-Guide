package com.example.nusa_guide.screen


import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.example.nusa_guide.ui.theme.gray700
import com.example.nusa_guide.ui.theme.grayText
import com.example.nusa_guide.widget.ButtonStyle

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TransactionSuccessScreen(navController: NavController) {
    val context = LocalContext.current
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(R.drawable.image_ulasan_succes),
                contentDescription = "image-ulasan-succes",
                modifier = Modifier.height(280.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Pembayaran Anda Berhasil",
                fontSize = 24.sp,
                color = Color(0XFF1F2A37),
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Anda telah berhasil melakukan pembayaran. Silahkan klik button dibawah untuk melanjutkan aktivitas Anda !!!",
                fontSize = 15.sp,
                color = grayText,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            ButtonStyle(
                onClicked = {
                    startWhatsApp(context)
                }, text = "Chat Tour Guide", modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            TextButton(onClick = {
                navController.navigate(
                    NavigationTourScreen.HalamanBottom.name
                )
            }) {
                Text(
                    text = "Jelajahi Nusa Guide",
                    color = gray700,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

fun startWhatsApp(context: android.content.Context) {
    val phoneNumber = "6287765667855"
    val message = "Halooo\nApakah kamu bersedia menjadi jasa tour guide saya."
    val url = "https://api.whatsapp.com/send?phone=$phoneNumber&text=${Uri.encode(message)}"
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = Uri.parse(url)
    context.startActivity(intent)
}

@Preview
@Composable
fun PreviewTransaction(){
    TransactionSuccessScreen(navController = rememberNavController())
}
