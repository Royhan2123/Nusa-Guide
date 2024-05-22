package com.example.nusa_guide.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
<<<<<<< HEAD
=======
import androidx.compose.foundation.layout.Box
>>>>>>> cf1020ed00ac568b129a3e16336175fa6d1ed24b
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
<<<<<<< HEAD
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
=======
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
>>>>>>> cf1020ed00ac568b129a3e16336175fa6d1ed24b
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
<<<<<<< HEAD
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray700
import com.example.nusa_guide.ui.theme.grayText
import com.example.nusa_guide.widget.ButtonStyle
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import com.example.nusa_guide.ui.theme.gray

@Composable
fun VerificationCodeScreen(navController: NavController) {
=======
import com.example.nusa_guide.R
import com.example.nusa_guide.ui.theme.BlueButton
import com.example.nusa_guide.ui.theme.Gray70


@Composable
fun VerificationCodeScreen() {
>>>>>>> cf1020ed00ac568b129a3e16336175fa6d1ed24b
    var code1 by remember { mutableStateOf("") }
    var code2 by remember { mutableStateOf("") }
    var code3 by remember { mutableStateOf("") }
    var code4 by remember { mutableStateOf("") }

<<<<<<< HEAD
    val focusRequester1 = remember { FocusRequester() }
    val focusRequester2 = remember { FocusRequester() }
    val focusRequester3 = remember { FocusRequester() }
    val focusRequester4 = remember { FocusRequester() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp),
    ) {
        Spacer(modifier = Modifier.height(36.dp))
=======
    Box(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp, vertical = 20.dp)
    ) {
>>>>>>> cf1020ed00ac568b129a3e16336175fa6d1ed24b
        Text(
            text = "Verifikasi Kode",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
<<<<<<< HEAD
            color = gray700,
        )
        Spacer(modifier = Modifier.height(40.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val imagePainter = painterResource(id = R.drawable.verification_code_img)
            Image(
                painter = imagePainter,
                contentDescription = null,
                modifier = Modifier.size(280.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Masukkan kode verifikasi yang sudah kami kirimkan ke email yang sudah kamu masukkan!",
                fontSize = 16.sp,
                color = grayText,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Kode Verifikasi",
                fontSize = 17.sp,
                color = Color(0XFF1F2A37),
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedTextField(
                    value = code1,
                    shape = RoundedCornerShape(10.dp),
                    onValueChange = {
                        if (it.length <= 1) {
                            code1 = it
                            if (it.isNotEmpty()) focusRequester2.requestFocus()
                        }
                    },
                    modifier = Modifier
                        .size(60.dp)
                        .padding(1.dp)
                        .focusRequester(focusRequester1),
                    singleLine = true,
                    textStyle = TextStyle(
                        fontSize = 18.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center

                    ),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = brandPrimary500,
                        unfocusedBorderColor = gray
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    )
                )
                OutlinedTextField(
                    value = code2,
                    shape = RoundedCornerShape(10.dp),
                    onValueChange = {
                        if (it.length <= 1) {
                            code2 = it
                            if (it.isNotEmpty()) focusRequester3.requestFocus()
                        }
                    },
                    modifier = Modifier
                        .size(60.dp)
                        .padding(1.dp)
                        .focusRequester(focusRequester2),
                    singleLine = true,
                    textStyle = TextStyle(
                        fontSize = 18.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center

                    ),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = brandPrimary500,
                        unfocusedBorderColor = gray
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    )
                )
                OutlinedTextField(
                    value = code3,
                    shape = RoundedCornerShape(10.dp),
                    onValueChange = {
                        if (it.length <= 1) {
                            code3 = it
                            if (it.isNotEmpty()) focusRequester4.requestFocus()
                        }
                    },
                    modifier = Modifier
                        .size(60.dp)
                        .padding(1.dp)
                        .focusRequester(focusRequester3),
                    singleLine = true,
                    textStyle = TextStyle(
                        fontSize = 18.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center

                    ),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = brandPrimary500,
                        unfocusedBorderColor = gray
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    )
                )
                OutlinedTextField(
                    value = code4,
                    shape = RoundedCornerShape(10.dp),
                    onValueChange = { if (it.length <= 1) code4 = it },
                    modifier = Modifier
                        .size(60.dp)
                        .padding(1.dp)
                        .focusRequester(focusRequester4),
                    singleLine = true,
                    textStyle = TextStyle(
                        fontSize = 18.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    ),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = brandPrimary500,
                        unfocusedBorderColor = gray
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
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
                    color = brandPrimary500,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
            }
=======
            color = Gray70,
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

        Button(
            onClick = { /* TODO: Add navigation logic */ },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Text(
                text = "Konfirmasi",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = { /* TODO: Add back logic */ }) {
            Text(
                text = "Kembali",
                color = Color(0xFF469CAD),
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
>>>>>>> cf1020ed00ac568b129a3e16336175fa6d1ed24b
        }
    }
}

<<<<<<< HEAD
@Preview(showSystemUi = true)
@Composable
fun VerificationCodeScreenPreview() {
    VerificationCodeScreen(rememberNavController())
=======

@Preview
@Composable
fun VerificationCodeScreenPreview() {
    VerificationCodeScreen()
>>>>>>> cf1020ed00ac568b129a3e16336175fa6d1ed24b
}