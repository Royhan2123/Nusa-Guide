package com.example.nusa_guide.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.ui.theme.Gray70
import com.example.nusa_guide.ui.theme.GrayTextField
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray
import com.example.nusa_guide.ui.theme.gray700
import com.example.nusa_guide.ui.theme.grayText
import com.example.nusa_guide.widget.ButtonStyle

@Composable
fun ForgotPasswordScreen(navController: NavController) {
    val emailState = remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(36.dp))

        Text(
            text = "Lupa Kata Sandi?",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = gray700,
        )

        Spacer(modifier = Modifier.height(40.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_avatar),
                contentDescription = "Avatar",
                modifier = Modifier.height(280.dp)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Masukkan email yang kamu gunakan, kami akan mengirimkan kode OTP ke email yang kamu masukkan",
            fontSize = 15.sp,
            color = grayText
        )

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "Email",
            fontSize = 17.sp,
            color = Color(0XFF1F2A37),
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            placeholder = {
                Text(text = "Input your email here", color = Color(0xFFABABAB))
            },
            value = emailState.value,
            onValueChange = { emailState.value = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    tint = gray,
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = brandPrimary500,
                unfocusedBorderColor = gray
            ),
            shape = RoundedCornerShape(10.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            textStyle = TextStyle(
                fontSize = 15.sp,
                color = Color.Black
            ),
        )

        Spacer(modifier = Modifier.height(16.dp))

        ButtonStyle(
            onClicked = {
                navController.navigate(
                    NavigationTourScreen.VerificationCodeScreen.name
                )
            },
            text = "Kirim"
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewForgotPasswordScreen() {
    ForgotPasswordScreen(rememberNavController())
}
