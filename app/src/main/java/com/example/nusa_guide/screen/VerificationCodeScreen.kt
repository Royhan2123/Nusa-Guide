package com.example.nusa_guide.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.nusa_guide.ui.theme.gray700
import com.example.nusa_guide.widget.ButtonStyle


@Composable
fun VerificationCodeScreen(navController: NavController) {
    var code1 by remember { mutableStateOf("") }
    var code2 by remember { mutableStateOf("") }
    var code3 by remember { mutableStateOf("") }
    var code4 by remember { mutableStateOf("") }

    Box(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp, vertical = 20.dp)
    ) {
        Text(
            text = "Verifikasi Kode",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = gray700,
            textAlign = TextAlign.Center
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))


        val imagePainter = painterResource(id = R.drawable.verification_code_img)
        Image(
            painter = imagePainter, contentDescription = null, modifier = Modifier.size(400.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Masukkan kode verifikasi yang sudah kami kirimkan ke email yang sudah kamu masukkan!",
            fontSize = 16.sp,
            color = Color(0xFF6B7280),
            modifier = Modifier.padding(horizontal = 16.dp),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Kode Verifikasi",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedTextField(
                value = code1,
                shape = RoundedCornerShape(10.dp),
                onValueChange = { if (it.length <= 1) code1 = it },
                modifier = Modifier
                    .size(80.dp)
                    .padding(1.dp),
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center, fontSize = 24.sp
                )
            )
            OutlinedTextField(
                value = code2,
                shape = RoundedCornerShape(10.dp),
                onValueChange = { if (it.length <= 1) code2 = it },
                modifier = Modifier
                    .size(80.dp)
                    .padding(1.dp),
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center, fontSize = 24.sp
                )
            )
            OutlinedTextField(
                value = code3,
                shape = RoundedCornerShape(10.dp),
                onValueChange = { if (it.length <= 1) code3 = it },
                modifier = Modifier
                    .size(80.dp)
                    .padding(1.dp),
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center, fontSize = 24.sp
                )
            )
            OutlinedTextField(
                value = code4,
                shape = RoundedCornerShape(10.dp),
                onValueChange = { if (it.length <= 1) code4 = it },
                modifier = Modifier
                    .size(80.dp)
                    .padding(1.dp),
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center, fontSize = 24.sp
                )
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        ButtonStyle(onClicked = {
            navController.navigate(
                NavigationTourScreen.ChangePasswordSuccessScreen.name
            )
        }, text = "Konfirmasi")

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = {
            navController.popBackStack()
        }) {
            Text(
                text = "Kembali",
                color = Color(0xFF469CAD),
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
    }
}


@Preview
@Composable
fun VerificationCodeScreenPreview() {
    VerificationCodeScreen(rememberNavController())
}