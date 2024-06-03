package com.example.nusa_guide.screen.cameraX

import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cameraswitch
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.nusa_guide.ui.theme.white
import java.io.File

@Composable
fun CameraXScreen(navController: NavController) {
    var lensFacing by remember { mutableIntStateOf(CameraSelector.LENS_FACING_BACK) }
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }

    val previewView = remember { PreviewView(context) }
    var imageCapture: ImageCapture? by remember { mutableStateOf(null) }

    LaunchedEffect(lensFacing) {
        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder().build().also {
                it.setSurfaceProvider(previewView.surfaceProvider)
            }
            val cameraSelector = CameraSelector.Builder()
                .requireLensFacing(lensFacing)
                .build()

            imageCapture = ImageCapture.Builder().build()

            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(
                    lifecycleOwner,
                    cameraSelector,
                    preview,
                    imageCapture
                )
            } catch (exc: Exception) {
                Log.e("CameraXApp", "Use case binding failed", exc)
            }
        }, ContextCompat.getMainExecutor(context))
    }

    Column {
        CameraPreview(
            previewView = previewView,
            modifier = Modifier.weight(1f),
            onCaptureClick = { imageCapture?.let { captureImage(context, it) { uri -> imageUri = uri } } },
            onSwitchClick = {
                lensFacing = if (lensFacing == CameraSelector.LENS_FACING_BACK)
                    CameraSelector.LENS_FACING_FRONT
                else
                    CameraSelector.LENS_FACING_BACK
            }
        )
        imageUri?.let { uri ->
            Image(
                painter = rememberAsyncImagePainter(model = uri),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun CameraPreview(
    previewView: PreviewView,
    modifier: Modifier = Modifier,
    onCaptureClick: () -> Unit,
    onSwitchClick: () -> Unit
) {
    Box(modifier = modifier) {
        AndroidView(factory = { previewView }, modifier = Modifier.fillMaxSize())
        Icon(
            imageVector = Icons.Default.Cameraswitch,
            contentDescription = "Switch Camera",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 20.dp, top = 16.dp)
                .size(45.dp)
                .clickable { onSwitchClick() },
            tint = white
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
                .size(60.dp)
                .background(Color.White, shape = CircleShape)
                .clickable { onCaptureClick() }
        )
    }
}

fun captureImage(
    context: Context,
    imageCapture: ImageCapture,
    onImageSaved: (Uri) -> Unit
) {
    val photoFile = File(
        context.filesDir,
        "photo_${System.currentTimeMillis()}.jpg"
    )
    val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()
    imageCapture.takePicture(
        outputOptions,
        ContextCompat.getMainExecutor(context),
        object : ImageCapture.OnImageSavedCallback {
            override fun onError(exc: ImageCaptureException) {
                Log.e("CameraXApp", "Photo capture failed: ${exc.message}", exc)
            }

            override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                val savedUri = Uri.fromFile(photoFile)
                Toast.makeText(context, "Photo capture succeeded: $savedUri", Toast.LENGTH_SHORT)
                    .show()
                onImageSaved(savedUri)
            }
        }
    )
}

@androidx.compose.ui.tooling.preview.Preview
@Composable
fun PreviewCameraX() {
    CameraXScreen(navController = rememberNavController())
}
