@file:Suppress("UNUSED_EXPRESSION")

package com.example.nusa_guide.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Chip
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.ui.theme.black51
import com.example.nusa_guide.ui.theme.blue
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray
import com.example.nusa_guide.ui.theme.gray400
import com.example.nusa_guide.ui.theme.gray700
import com.example.nusa_guide.ui.theme.lightGray
import com.example.nusa_guide.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FilteringScreen(navController: NavController) {
    var selectedRating by remember { mutableStateOf<Int?>(null) }
    var isChipSelected by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Filter Rating",
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
                    top = 100.dp
                ),
        ) {
            isChipSelected = selectedRating != null
            val onClickAction = if (isChipSelected) {
                {
                    navController.navigate(
                        NavigationTourScreen.SearchScreen.name
                    )
                }
            } else {
                {}
            }
            Text(
                text = "Rating Tour Guide",
                color = gray700,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                RatingChip(
                    rating = 1,
                    isSelected = selectedRating == 1,
                    onChipClicked = { selectedRating = 1 }
                )
                RatingChip(
                    rating = 2,
                    isSelected = selectedRating == 2,
                    onChipClicked = { selectedRating = 2 }
                )
                RatingChip(
                    rating = 3,
                    isSelected = selectedRating == 3,
                    onChipClicked = { selectedRating = 3 }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                RatingChip(
                    rating = 4,
                    isSelected = selectedRating == 4,
                    onChipClicked = { selectedRating = 4 }
                )
                RatingChip(
                    rating = 5,
                    isSelected = selectedRating == 5,
                    onChipClicked = { selectedRating = 5 }
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                ElevatedButton(
                    onClick = {
                        onClickAction
                    },
                    colors = ButtonDefaults.buttonColors(
                        if (isChipSelected) brandPrimary500 else gray
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    shape = RoundedCornerShape(
                        size = 8.dp
                    )
                ) {
                    Text(
                        text = "Tampilkan Tour Guide",
                        fontSize = 15.sp,
                        color = if (isChipSelected) Color.White else lightGray
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RatingChip(
    rating: Int,
    isSelected: Boolean,
    onChipClicked: () -> Unit
) {
    Chip(
        onClick = onChipClicked,
        modifier = Modifier
            .height(35.dp)
            .clip(
                shape = RoundedCornerShape(
                    size = 10.dp
                )
            ),
        colors = ChipDefaults.chipColors(
            if (isSelected) blue else white
        ),
        border = BorderStroke(
            width = 1.dp,
            color = if (isSelected) brandPrimary500 else gray
        ),
        leadingIcon = {
            Row {
                repeat(rating) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "icon-Star",
                        tint = if (isSelected) Color.Yellow else gray400,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    ) {
        Text(
            text = "$rating/5",
            fontSize = 15.sp,
            color = if (isSelected) Color.White else gray400
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFilteringScreen() {
    FilteringScreen(navController = rememberNavController())
}