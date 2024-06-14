package com.example.nusa_guide.screen

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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray
import com.example.nusa_guide.ui.theme.gray700
import com.example.nusa_guide.ui.theme.gray900
import com.example.nusa_guide.ui.theme.primary700
import com.example.nusa_guide.widget.ButtonStyle


@Composable
fun LoginScreen(
    navController: NavController
) {

    var txfUsername by rememberSaveable { mutableStateOf("") }
    var txfPassword by rememberSaveable { mutableStateOf("") }
    var obscureText by remember { mutableStateOf(true) }


    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 16.dp,
            )
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = R.string.masuk),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = gray700
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = stringResource(id = R.string.deskLogin),
            fontSize = 15.sp,
            color = gray700
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = stringResource(id = R.string.email),
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
                .padding(
                    top = 5.dp
                ),
            shape = RoundedCornerShape(10.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.icon_email),
                    contentDescription = stringResource(
                        id = R.string.email
                    ),
                    modifier = Modifier.size(25.dp),
                    tint = gray
                )
            },
            textStyle = TextStyle(
                fontSize = 15.sp,
                color = Color.Black
            ),
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
                .padding(
                    top = 5.dp
                ),
            shape = RoundedCornerShape(10.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.icon_password),
                    contentDescription = stringResource(
                        id = R.string.kata_sandi
                    ),
                    modifier = Modifier.size(25.dp),
                    tint = gray
                )
            },
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
            visualTransformation = if (obscureText)
                PasswordVisualTransformation()
            else VisualTransformation.None,
            trailingIcon = {
                IconButton(onClick = {
                    obscureText = !obscureText
                }) {
                    val visibilityIcon = if (obscureText)
                        Icons.Filled.VisibilityOff
                    else Icons.Filled.Visibility

                    val description = if (obscureText)
                        "Hide Password"
                    else "Show Password"

                    Icon(
                        imageVector = visibilityIcon,
                        contentDescription = description,
                        tint = gray
                    )
                }
            },
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomEnd
        ) {
            TextButton(onClick = {
                navController.navigate(
                    NavigationTourScreen.ForgotPasswordScreen.name
                )
            }) {
                Text(
                    text = stringResource(id = R.string.lupaKataSandi),
                    color = primary700,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        ButtonStyle(
            onClicked = {
                navController.navigate(NavigationTourScreen.HomeScreen.name)
            },
            text = stringResource(id = R.string.masuk),
        )
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.belumPunyaAkun),
                    fontSize = 14.sp,
                )
                TextButton(onClick = {
                    navController.navigate(
                        NavigationTourScreen.RegisterScreen.name
                    )
                }) {
                    Text(
                        text = stringResource(id = R.string.daftar),
                        color = primary700,
                        fontSize = 14.sp,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        navController = rememberNavController(),
    )
}