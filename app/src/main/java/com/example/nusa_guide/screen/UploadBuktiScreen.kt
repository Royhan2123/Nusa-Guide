package com.example.nusa_guide.screen

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.provider.OpenableColumns
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.ui.theme.black51
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.brandPrimary600
import com.example.nusa_guide.ui.theme.gray
import com.example.nusa_guide.ui.theme.gray400
import com.example.nusa_guide.ui.theme.gray700
import com.example.nusa_guide.ui.theme.lightGray
import com.example.nusa_guide.widget.ButtonStyle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.DecimalFormat

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UploadBuktiScreen(navController: NavController) {
    var currentProgress by remember { mutableFloatStateOf(0f) }
    var loading by remember { mutableStateOf(false) }
    var fileName by remember { mutableStateOf("") }
    var fileSize by remember { mutableLongStateOf(0L) }
    val scope = rememberCoroutineScope()

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.data?.let { uri ->
                val context = navController.context
                val cursor = context.contentResolver.query(uri, null, null, null, null)
                cursor?.use {
                    if (it.moveToFirst()) {
                        val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                        fileName = if (nameIndex != -1) it.getString(nameIndex) else "Unknown"
                        val sizeIndex = it.getColumnIndex(OpenableColumns.SIZE)
                        fileSize = if (sizeIndex != -1) it.getLong(sizeIndex) else 0L
                    }
                }
                // Start the progress loading coroutine
                scope.launch {
                    loading = true
                    loadProgress { progress -> currentProgress = progress }
                    loading = false
                }
            }
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Upload Bukti",
                        color = gray700,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
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
                    top = 100.dp
                )
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "Upload Bukti",
                color = gray700,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Upload bukti pembayaran mu disini",
                color = gray,
                fontSize = 15.sp,
            )
            Spacer(modifier = Modifier.height(30.dp))
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
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
                            painter = painterResource(id = R.drawable.icon_upload),
                            contentDescription = "icon-camera",
                            tint = brandPrimary500,
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Drop buktimu disini",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = gray700
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "PNG, JPG, JPEG",
                            fontSize = 13.sp,
                            color = gray400
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Surface(
                            modifier = Modifier
                                .width(130.dp)
                                .height(45.dp)
                                .border(
                                    width = 1.dp,
                                    color = gray,
                                    shape = RoundedCornerShape(10.dp),
                                )
                                .clickable {
                                    val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                                        type = "image/*"
                                        addCategory(Intent.CATEGORY_OPENABLE)
                                    }
                                    launcher.launch(intent)
                                },
                            shape = RoundedCornerShape(10.dp),
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = "Upload File",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = gray700,
                                    textAlign = TextAlign.Center,
                                )
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
            if (fileName.isNotEmpty()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Upload File",
                        color = gray700,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.icon_copy),
                        contentDescription = "icon_copy",
                        modifier = Modifier
                            .size(25.dp),
                        tint = gray700
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    border = BorderStroke(
                        width = 1.dp,
                        color = gray,
                    ),
                    shape = RoundedCornerShape(
                        size = 10.dp,
                    ),
                    color = lightGray
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_photo),
                            contentDescription = "icon-photo",
                            modifier = Modifier.size(30.dp),
                            tint = gray700,
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Column(
                            horizontalAlignment = Alignment.Start,
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Text(
                                    text = fileName,
                                    fontSize = 14.sp,
                                    color = gray700,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "remove-icon",
                                    modifier = Modifier
                                        .size(25.dp)
                                        .clickable {
                                            fileName = ""
                                            fileSize = 0L
                                            currentProgress = 0f
                                        },
                                    tint = gray
                                )
                            }
                            Spacer(modifier = Modifier.height(5.dp))
                            LinearProgressIndicator(
                                progress = { currentProgress },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(5.dp),
                                color = brandPrimary500,
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = formatFileSize(fileSize),
                                    fontSize = 12.sp,
                                    color = gray700,
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Box(
                                    modifier = Modifier
                                        .size(6.dp)
                                        .background(
                                            color = gray, shape = CircleShape
                                        )
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "Upload File",
                                    fontSize = 12.sp,
                                    color = gray700,
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(50.dp))
            }
            Spacer(modifier = Modifier.weight(1f))
            ButtonStyle(onClicked = { /*TODO*/ }, text = "Kirim")
        }
    }
}

suspend fun loadProgress(updateProgress: (Float) -> Unit) {
    for (i in 1..100) {
        updateProgress(i.toFloat() / 100)
        delay(100)
    }
}

fun formatFileSize(size: Long): String {
    val df = DecimalFormat("#.##")
    val sizeKb = size / 1024.0
    val sizeMb = sizeKb / 1024.0
    return when {
        sizeMb >= 1 -> "${df.format(sizeMb)} MB"
        sizeKb >= 1 -> "${df.format(sizeKb)} KB"
        else -> "$size B"
    }
}

@Composable
@Preview
fun PreviewUploadBukti() {
    UploadBuktiScreen(navController = rememberNavController())
}
