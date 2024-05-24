package com.example.nusa_guide.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Checkbox
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.ui.theme.black51
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.brandPrimary600
import com.example.nusa_guide.ui.theme.gray
import com.example.nusa_guide.ui.theme.gray700

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UlasanScreen(navController: NavController) {
    var isSelected by remember {
        mutableStateOf(false)
    }
    var inputUlsan by remember {
        mutableStateOf("")
    }
    val (checkedState, onStateChange) = remember { mutableStateOf(true) }
    val (checkedState2, onStateChange2) = remember { mutableStateOf(true) }
    val (checkedState3, onStateChange3) = remember { mutableStateOf(true) }
    val (checkedState4, onStateChange5) = remember { mutableStateOf(true) }

    val keyboardController = LocalSoftwareKeyboardController.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Berikan Review",
                        color = gray700,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.Center)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "icon-back",
                            modifier = Modifier
                                .size(25.dp)
                                .clickable {
                                    navController.popBackStack()
                                },
                            tint = black51
                        )
                    }
                },
                modifier = Modifier.shadow(
                    elevation = 8.dp,
                )
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    bottom = 20.dp,
                    top = 80.dp
                ),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "Berikan ratingmu disini",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = gray700
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                IconButton(onClick = { isSelected = !isSelected }) {
                    Icon(
                        imageVector = if (isSelected) Icons.Filled.Star else Icons.Outlined.StarBorder,
                        contentDescription = "icon-Star",
                        tint = if (isSelected) Color.Yellow else gray,
                        modifier = Modifier.size(50.dp)
                    )
                }
                IconButton(onClick = { isSelected = !isSelected }) {
                    Icon(
                        imageVector = if (isSelected) Icons.Filled.Star else Icons.Outlined.StarBorder,
                        contentDescription = "icon-Star",
                        tint = if (isSelected) Color.Yellow else gray,
                        modifier = Modifier.size(50.dp)
                    )
                }
                IconButton(onClick = { isSelected = !isSelected }) {
                    Icon(
                        imageVector = if (isSelected) Icons.Filled.Star else Icons.Outlined.StarBorder,
                        contentDescription = "icon-Star",
                        tint = if (isSelected) Color.Yellow else gray,
                        modifier = Modifier.size(50.dp)
                    )
                }
                IconButton(onClick = { isSelected = !isSelected }) {
                    Icon(
                        imageVector = if (isSelected) Icons.Filled.Star else Icons.Outlined.StarBorder,
                        contentDescription = "icon-Star",
                        tint = if (isSelected) Color.Yellow else gray,
                        modifier = Modifier.size(50.dp)
                    )
                }
                IconButton(onClick = { isSelected = !isSelected }) {
                    Icon(
                        imageVector = if (isSelected) Icons.Filled.Star else Icons.Outlined.StarBorder,
                        contentDescription = "icon-Star",
                        tint = if (isSelected) Color.Yellow else gray,
                        modifier = Modifier.size(50.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .drawBehind {
                        val dashWidth = 10.dp.toPx()
                        val dashGap = 10.dp.toPx()
                        val strokeWidth = 2.dp.toPx()

                        val paint = Stroke(
                            width = strokeWidth,
                            pathEffect = PathEffect.dashPathEffect(
                                floatArrayOf(dashWidth, dashGap),
                                0f
                            )
                        )

                        drawRoundRect(
                            color = brandPrimary500,
                            size = size,
                            cornerRadius = CornerRadius(
                                15.dp.toPx(),
                                15.dp.toPx()
                            ),
                            style = paint
                        )
                    },
                shape = RoundedCornerShape(size = 15.dp),
                color = brandPrimary600
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Filled.CameraAlt,
                            contentDescription = "icon-camera",
                            tint = brandPrimary500,
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Tambahkan Foto",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = brandPrimary500
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(35.dp))
            Text(
                text = "Berikan Ulasanmu Disini",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = gray700
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = inputUlsan,
                onValueChange = {
                    inputUlsan = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(115.dp),
                shape = RoundedCornerShape(
                    size = 15.dp
                ),
                placeholder = {
                    Text(
                        text = "Bagaikan pengalamanmu dan bantu Pengguna lain membuat pilihan wisatanya",
                        fontSize = 14.sp,
                        color = gray,
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = brandPrimary500,
                    unfocusedBorderColor = gray
                ),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Text
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                    }
                ),
                textStyle = TextStyle(
                    fontSize = 15.sp,
                    color = gray700
                )
            )
            Spacer(modifier = Modifier.height(35.dp))
            Text(
                text = "Apa keunggulan dari tempat ini?",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = gray700
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .toggleable(
                        value = checkedState,
                        onValueChange = { onStateChange(!checkedState) },
                        role = Role.Checkbox
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Checkbox(
                        checked = checkedState,
                        onCheckedChange = null,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "Option selection",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
                Row {
                    Checkbox(
                        checked = checkedState,
                        onCheckedChange = null,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "Option selection",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .toggleable(
                        value = checkedState,
                        onValueChange = { onStateChange(!checkedState) },
                        role = Role.Checkbox
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Checkbox(
                        checked = checkedState,
                        onCheckedChange = null,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "Option selection",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
                Row {
                    Checkbox(
                        checked = checkedState,
                        onCheckedChange = null,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "Option selection",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .toggleable(
                        value = checkedState,
                        onValueChange = { onStateChange(!checkedState) },
                        role = Role.Checkbox
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row {
                    Checkbox(
                        checked = checkedState,
                        onCheckedChange = null,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "Option selection",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                ElevatedButton(
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(
                        brandPrimary500
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    shape = RoundedCornerShape(
                        size = 8.dp
                    )
                ) {
                    Text(
                        text = "Kirim Ulasan",
                        fontSize = 15.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewUlasanScreen() {
    UlasanScreen(navController = rememberNavController())
}