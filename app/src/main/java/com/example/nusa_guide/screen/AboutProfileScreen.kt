package com.example.nusa_guide.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.api.RetrofitInstance
import com.example.nusa_guide.api.response.AuthResult
import com.example.nusa_guide.data.DataStoreManager
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.repository.AuthRepository
import com.example.nusa_guide.ui.theme.BlueButton
import com.example.nusa_guide.ui.theme.BrandPrimary400
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray
import com.example.nusa_guide.ui.theme.lightGray
import com.example.nusa_guide.viewModel.AuthViewModel
import com.example.nusa_guide.viewModel.AuthViewModelFactory


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutProfileScreen(
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

    val logoutResult by authViewModel.logoutResult.observeAsState()

    var txfUsername by remember {
        mutableStateOf("")
    }
    var txfEmail by remember {
        mutableStateOf("")
    }
    var txfNoTelpon by remember {
        mutableStateOf("")
    }
    var txfKataSandi by remember {
        mutableStateOf("")
    }

    var obscureText by remember { mutableStateOf(true) }


    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Edit Profil", fontWeight = FontWeight.Bold, fontSize = 20.sp
                )
            },
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
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
            Surface(
                modifier = Modifier.size(150.dp),
                shape = CircleShape,
                shadowElevation = 12.dp,
                color = gray
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.CameraAlt,
                        contentDescription = "icon-camera",
                        modifier = Modifier.size(50.dp),
                        tint = lightGray
                    )
                }
            }
            Text(
                text = "Tambah Foto",
                color = BrandPrimary400,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(vertical = 20.dp),
            )
            Spacer(modifier = Modifier.height(14.dp))
            OutlinedTextField(
                value = txfUsername,
                onValueChange = {
                    txfUsername = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(top = 5.dp),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(
                    fontSize = 15.sp,
                    color = Color.Black
                ),
                placeholder = {
                    Text(
                        text = "Nama Lengkap",
                        fontSize = 14.sp,
                        color = gray
                    )
                },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Text
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                    }
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = brandPrimary500,
                    unfocusedBorderColor = gray
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = txfEmail,
                onValueChange = {
                    txfEmail = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(top = 5.dp),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(
                    fontSize = 15.sp,
                    color = Color.Black
                ),
                placeholder = {
                    Text(
                        text = "Email",
                        fontSize = 14.sp,
                        color = gray
                    )
                },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Email
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                    }
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = brandPrimary500,
                    unfocusedBorderColor = gray
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = txfNoTelpon,
                onValueChange = {
                    txfNoTelpon = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(top = 5.dp),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(
                    fontSize = 15.sp,
                    color = Color.Black
                ),
                placeholder = {
                    Text(
                        text = "No Telpon",
                        fontSize = 14.sp,
                        color = gray
                    )
                },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Number
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                    }
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = brandPrimary500,
                    unfocusedBorderColor = gray
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = txfKataSandi,
                onValueChange = {
                    txfKataSandi = it
                },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(top = 5.dp),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(
                    fontSize = 15.sp,
                    color = Color.Black
                ),
                placeholder = {
                    Text(
                        text = "enter your password",
                        fontSize = 16.sp,
                        color = gray
                    )
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                    }
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = brandPrimary500,
                    unfocusedBorderColor = gray
                ),
                visualTransformation = if (obscureText) PasswordVisualTransformation() else VisualTransformation.None,
            )
            Spacer(modifier = Modifier.height(25.dp))
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
            Spacer(modifier = Modifier.height(10.dp))
            TextButton(onClick = {
                authViewModel.logout()
            }) {
                Text(
                    text = "Logout",
                    fontSize = 16.sp,
                    color = brandPrimary500,
                    fontWeight = FontWeight.SemiBold
                )
            }
            logoutResult?.let {
                if (it is AuthResult.Success) {
                    navController.navigate(NavigationTourScreen.LoginScreen.name) {
                        popUpTo(0)  // Remove all back stack
                    }
                } else if (it is AuthResult.Error) {
                    Text(text = it.message)
                }
            }
        }
    }
}

@Preview
@Composable
fun AboutProfileScreenPreview() {
    AboutProfileScreen(
        rememberNavController(),
    )
}