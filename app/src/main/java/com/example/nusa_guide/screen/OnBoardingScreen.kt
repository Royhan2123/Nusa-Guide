package com.example.nusa_guide.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.ui.theme.gray50
import com.example.nusa_guide.ui.theme.gray700
import com.example.nusa_guide.widget.ButtonStyle

@Composable
fun OnBoardingScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.bg_on_boarding
            ),
            contentDescription = "onBoarding2",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 32.dp,
                            topEnd = 32.dp
                        )
                    ),
                color = gray50
            ) {
                Column(
                    modifier = Modifier.padding(
                        top = 25.dp,
                        start = 30.dp,
                        end = 30.dp,
                        bottom = 20.dp
                    )
                ) {
                    Column {
                        Text(
                            text = "Find Your",
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            color = gray700,
                            textAlign = TextAlign.Left,
                        )
                        Text(
                            text = "Adventure!",
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            color = gray700,
                            textAlign = TextAlign.Left,
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Jelajahi keajaiban alam dan warisan budaya yang kaya.",
                        fontSize = 16.sp,
                        color = Color.Black,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ButtonStyle(
                        onClicked = {
                            navController.navigate(
                                NavigationTourScreen.OnBoardingScreen2.name
                            )
                        },
                        text = stringResource(id = R.string.mulai)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen(navController = rememberNavController())
}