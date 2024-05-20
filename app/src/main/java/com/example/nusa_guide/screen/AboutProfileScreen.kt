package com.example.nusa_guide.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nusa_guide.R
import com.example.nusa_guide.ui.theme.BlueButton
import com.example.nusa_guide.ui.theme.BrandPrimary400
import com.example.nusa_guide.ui.theme.Gray60
import com.example.nusa_guide.ui.theme.Gray80


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun AboutProfileScreen() {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Edit Profil", fontWeight = FontWeight.Bold, fontSize = 20.sp
                )
            },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector= Icons.Default.KeyboardArrowLeft,
                        contentDescription = null
                    )
                }
            },
        )
    }) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(55.dp))
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = null,
                modifier = Modifier
                    .size(158.dp)
                    .clip(CircleShape)
            )
            Text(
                text = "Tambah Foto",
                color = BrandPrimary400,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                modifier = Modifier
                    .clickable { }
                    .padding(vertical = 20.dp),
            )
            Spacer(modifier = Modifier.height(14.dp))
            ProfileTextField(label = "Nama Lengkap", value = "Kim Jiwon")
            ProfileTextField(label = "Email", value = "kimjin@gmail.com")
            ProfileTextField(label = "Nomor Telepon", value = "08123456")
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { /* Handle save */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
            ) {
                Text(text = "Simpan")
            }

        }
    }
}

@Composable
fun ProfileTextField(label: String, value: String) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = label, fontSize = 18.sp, color = Gray60)

        TextField(
            value = value,
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            textStyle = TextStyle.Default.copy(fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Gray80),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}


@Preview
@Composable
fun AboutProfileScreenPreview() {
    AboutProfileScreen()
}