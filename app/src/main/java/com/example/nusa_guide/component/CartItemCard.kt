package com.example.nusa_guide.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nusa_guide.R
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.brandPrimary600
import com.example.nusa_guide.ui.theme.gray
import com.example.nusa_guide.ui.theme.gray700

@Composable
fun CartItemCard(
    imageResource: Int,
    title: String,
    price: Int,
    quantity: Int,
    onAdd: () -> Unit,
    onRemove: () -> Unit,
    onDelete: () -> Unit,
    isSelected: Boolean,
    onSelectionChange: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Selection Checkbox
                Checkbox(
                    checked = isSelected,
                    colors = CheckboxDefaults.colors(
                        checkedColor = brandPrimary500,
                        uncheckedColor = brandPrimary500,
                        checkmarkColor = brandPrimary600
                    ),
                    onCheckedChange = { onSelectionChange() },
                )

                // Image
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = title,
                    modifier = Modifier
                        .height(95.dp)
                        .width(115.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.FillBounds
                )

                Spacer(modifier = Modifier.width(10.dp))
                // Texts Column
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = gray700,
                        maxLines = 1,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "${price.formatCurrency()}/orang",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = brandPrimary500
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Surface (
                            modifier = Modifier
                                .size(30.dp)
                                .border(
                                    width = 1.dp,
                                    color = gray,
                                    shape = CircleShape
                                ),
                            shape = CircleShape,
                        ) {
                            IconButton(onClick = onRemove) {
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_minus),
                                    contentDescription = "Decrease quantity",
                                    tint = Color(0xFF008080),
                                    modifier = Modifier.size(15.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "$quantity",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.width(10.dp))

                        Surface (
                            modifier = Modifier
                                .size(30.dp)
                                .border(
                                    width = 1.dp,
                                    color = gray,
                                    shape = CircleShape
                                ),
                            shape = CircleShape,
                        ) {
                            IconButton(onClick = onAdd) {
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_plus),
                                    contentDescription = "Increase quantity",
                                    tint = Color(0xFF008080),
                                    modifier = Modifier.size(15.dp)
                                )
                            }
                        }

                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = onDelete) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete item",
                        tint = Color(0xFF008080)
                    )
                }

            }
            Spacer(modifier = Modifier.height(50.dp))
            HorizontalDivider(thickness = 1.dp, color = gray)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartItemCardPreview() {
    CartItemCard(
        imageResource = R.drawable.alam,
        title = "Pantai Bias",
        price = 150000,
        quantity = 1,
        onAdd = {},
        onRemove = {},
        onDelete = {},
        isSelected = true,
        onSelectionChange = {}
    )
}

fun Int.formatCurrency(): String {
    return String.format("%,d", this).replace(",", ".")
}
