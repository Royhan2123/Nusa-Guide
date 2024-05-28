package com.example.nusa_guide.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.component.CartItemCard
import com.example.nusa_guide.ui.theme.black51
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.brandPrimary600
import com.example.nusa_guide.ui.theme.gray700
import com.example.nusa_guide.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CartScreen(navController: NavController) {
    val cartItems = listOf(
        CartItem("Pantai Bias", "Rp 150.000", R.drawable.pantai_1),
        CartItem("Pantai Bias", "Rp 150.000", R.drawable.pantai_1),
        CartItem("Pantai Bias", "Rp 150.000", R.drawable.pantai_1),
        CartItem("Pantai Bias", "Rp 150.000", R.drawable.pantai_1),
        CartItem("Pantai Bias", "Rp 150.000", R.drawable.pantai_1),
        CartItem("Pantai Bias", "Rp 150.000", R.drawable.pantai_1),
    )

    val selectedItems = remember { mutableStateOf(cartItems.map { false }.toMutableList()) }
    val selectedAll = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Keranjang Saya",
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
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = 100.dp,
                        start = 20.dp,
                        end = 20.dp,
                        bottom = 70.dp
                    )
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.Start
            ) {
                cartItems.forEachIndexed { index, cartItem ->
                    CartItemCard(
                        imageResource = cartItem.imageResource,
                        title = cartItem.title,
                        price = cartItem.price,
                        quantity = 1,
                        onAdd = {},
                        onRemove = {},
                        onDelete = {},
                        isSelected = selectedItems.value[index],
                        onSelectionChange = {
                            selectedItems.value[index] = !selectedItems.value[index]
                            selectedAll.value = selectedItems.value.all { it }
                        }
                    )
                }
            }
            SurfaceBottom(
                isSelected = selectedAll.value,
                onSelectionChange = {
                    val newValue = !selectedAll.value
                    selectedAll.value = newValue
                    selectedItems.value = selectedItems.value.map { newValue }.toMutableList()
                },
            )
        }
    }
}

@Composable
fun SurfaceBottom(
    isSelected: Boolean,
    onSelectionChange: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shadowElevation = 10.dp,
            color = white,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isSelected,
                    colors = CheckboxDefaults.colors(
                        checkedColor = brandPrimary500,
                        uncheckedColor = brandPrimary500,
                        checkmarkColor = brandPrimary600
                    ),
                    onCheckedChange = { onSelectionChange() },
                )
                Spacer(modifier = Modifier.width(25.dp))
                Column {
                    Text(text = "Total Tagihan")
                    Text(text = "Rp 300.000")
                }
                Spacer(modifier = Modifier.weight(1f))
                ElevatedButton(
                    onClick = { /* TODO: Add action */ },
                    modifier = Modifier
                        .width(145.dp)
                        .height(45.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = brandPrimary500
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text(text = "Pesan")
                }
            }
        }
    }
}

data class CartItem(
    val title: String,
    val price: String,
    val imageResource: Int
)

@Preview
@Composable
fun PreviewCartScreen() {
    CartScreen(navController = rememberNavController())
}
