package com.example.nusa_guide.screen

<<<<<<< HEAD
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
=======
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
>>>>>>> cf1020ed00ac568b129a3e16336175fa6d1ed24b
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
<<<<<<< HEAD
=======
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
>>>>>>> cf1020ed00ac568b129a3e16336175fa6d1ed24b
import androidx.compose.material3.Text
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
<<<<<<< HEAD
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.ui.theme.grayText
import com.example.nusa_guide.widget.ButtonStyle


@Composable
fun ChangePasswordSuccessScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_change_password_success),
            contentDescription = "Avatar",
            modifier = Modifier.height(280.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Box(
            modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Ubah Kata Sandi Berhasil!",
                fontSize = 24.sp,
                color = Color(0XFF1F2A37),
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Kata Sandi akun kamu telah berhasil diubah dan diverifikasi. sekarang kamu dapat mengakses seluruh layanan dari Nusa Guide",
            fontSize = 15.sp,
            color = grayText,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(127.dp))
        ButtonStyle(
            onClicked = {
                navController.navigate(
                    NavigationTourScreen.LoginScreen.name
                )
            }, text = "Selanjutnya",
            modifier = Modifier.padding(horizontal = 16.dp)
        )
=======
import com.example.nusa_guide.R
import com.example.nusa_guide.ui.theme.BlueButton


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ChangePasswordSuccessScreen() {
    Surface {
        Scaffold {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .paddingFromBaseline(top = 500.dp)
            ) {

                Box (modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(R.drawable.ic_change_password_success),
                        contentDescription = "Avatar",
                        modifier = Modifier.height(350.dp)
                    )
                }
                Spacer(modifier = Modifier.height(40.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Ubah Kata Sandi Berhasil!",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Kata Sandi akun kamu telah berhasil diubah dan diverifikasi. sekarang kamu dapat mengakses seluruh layanan dari Nusa Guide",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(52.dp))
                Button(
                    onClick = { /* TODO: Add navigation logic */ },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)


                ) {
                    Text(
                        text = "Selanjutnya",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
            }
        }
>>>>>>> cf1020ed00ac568b129a3e16336175fa6d1ed24b
    }
}


@Preview
@Composable
fun PreviewChangePasswordSuccessScreen() {
<<<<<<< HEAD
    ChangePasswordSuccessScreen(rememberNavController())
=======
    ChangePasswordSuccessScreen()
>>>>>>> cf1020ed00ac568b129a3e16336175fa6d1ed24b
}