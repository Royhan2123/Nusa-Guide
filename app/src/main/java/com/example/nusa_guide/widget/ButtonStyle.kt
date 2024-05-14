@file:Suppress("UNUSED_EXPRESSION")

package com.example.nusa_guide.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.white

@Composable
fun ButtonStyle(
    onClicked : @Composable () -> Unit,
    modifier: Modifier = Modifier,
    text: String,
) {
    ElevatedButton(
        onClick = { onClicked },
        modifier
            .fillMaxWidth()
            .height(51.dp),
        colors = ButtonDefaults.elevatedButtonColors(
            brandPrimary500
        ),
        shape = RoundedCornerShape(
            size = 8.dp
        )
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = white
        )
    }
}