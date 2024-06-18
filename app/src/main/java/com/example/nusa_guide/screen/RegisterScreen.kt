package com.example.nusa_guide.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.nusa_guide.R
import com.example.nusa_guide.api.RetrofitInstance
import com.example.nusa_guide.api.response.AuthResult
import com.example.nusa_guide.data.DataStoreManager
import com.example.nusa_guide.model.RegisterModel
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.repository.AuthRepository
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray
import com.example.nusa_guide.ui.theme.gray700
import com.example.nusa_guide.ui.theme.gray900
import com.example.nusa_guide.ui.theme.primary700
import com.example.nusa_guide.viewModel.AuthViewModel
import com.example.nusa_guide.viewModel.AuthViewModelFactory
import com.example.nusa_guide.widget.ButtonStyle

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: AuthViewModel = viewModel(
        factory = AuthViewModelFactory(
            repository = AuthRepository(
                apiService = RetrofitInstance.api,
                dataStoreManager = DataStoreManager.getInstance(context = LocalContext.current)
            )
        )
    )

) {

    var txfUsername by rememberSaveable { mutableStateOf("") }

    var txfEmail by rememberSaveable { mutableStateOf("") }

    var txfPassword by rememberSaveable { mutableStateOf("") }

    var obscureText by remember { mutableStateOf(true) }

    val registerResult by viewModel.registerResult.observeAsState()

    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = R.string.daftar),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = gray700
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = stringResource(id = R.string.deskRegister),
            fontSize = 15.sp,
            color = gray700
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = stringResource(id = R.string.username),
            fontSize = 15.sp,
            color = gray900,
            fontWeight = FontWeight.SemiBold
        )
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
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.icon_account),
                    contentDescription = stringResource(id = R.string.username),
                    modifier = Modifier.size(25.dp),
                    tint = gray
                )
            },
            textStyle = TextStyle(fontSize = 15.sp, color = Color.Black),
            placeholder = {
                Text(
                    text = "enter your name",
                    fontSize = 14.sp,
                    color = gray
                )
            },
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
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(id = R.string.email),
            fontSize = 15.sp,
            color = gray900,
            fontWeight = FontWeight.SemiBold
        )
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
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.icon_email),
                    contentDescription = stringResource(id = R.string.email),
                    modifier = Modifier.size(25.dp),
                    tint = gray
                )
            },
            textStyle = TextStyle(fontSize = 15.sp, color = Color.Black),
            placeholder = {
                Text(
                    text = "name@example.com",
                    fontSize = 14.sp,
                    color = gray
                )
            },
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
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(id = R.string.kata_sandi),
            fontSize = 15.sp,
            color = gray900,
            fontWeight = FontWeight.SemiBold
        )
        OutlinedTextField(
            value = txfPassword,
            onValueChange = {
                txfPassword = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(top = 5.dp),
            shape = RoundedCornerShape(10.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.icon_password),
                    contentDescription = stringResource(id = R.string.kata_sandi),
                    modifier = Modifier.size(25.dp),
                    tint = gray
                )
            },
            textStyle = TextStyle(fontSize = 15.sp, color = Color.Black),
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
            trailingIcon = {
                IconButton(onClick = {
                    obscureText = !obscureText
                }) {
                    val visibilityIcon =
                        if (obscureText) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
                    val description = if (obscureText) "Hide Password" else "Show Password"
                    Icon(
                        imageVector = visibilityIcon,
                        contentDescription = description,
                        tint = gray
                    )
                }
            },
        )
        Spacer(modifier = Modifier.height(22.dp))

        ButtonStyle(
            onClicked = {
                viewModel.register(
                    RegisterModel(
                        username = txfUsername,
                        email = txfEmail,
                        password = txfPassword
                    )
                )
            },
            text = stringResource(id = R.string.register),
        )

        // Menampilkan pesan sukses atau error setelah registrasi
        registerResult?.let { result ->
            when (result) {
                is AuthResult.Success -> {
                    // Jika registrasi berhasil, navigasi ke halaman login
                    navController.navigate(
                        NavigationTourScreen.HalamanBottom.name
                    )
                    Toast.makeText(LocalContext.current, "Berhasil Registrasi", Toast.LENGTH_SHORT)
                        .show()
                }

                is AuthResult.Error -> {
                    // Handle error jika registrasi gagal
                    // Misalnya, tampilkan pesan kesalahan kepada pengguna
                    Toast.makeText(LocalContext.current, result.message, Toast.LENGTH_SHORT).show()
                }

                AuthResult.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(40.dp),
                            color = brandPrimary500
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(id = R.string.sudahPunyaAkun),
                    fontSize = 14.sp,
                )
                TextButton(onClick = {
                    navController.navigate(NavigationTourScreen.LoginScreen.name)
                }) {
                    Text(
                        text = stringResource(id = R.string.masuk),
                        color = primary700,
                        fontSize = 14.sp,
                    )
                }
            }
        }
    }

}