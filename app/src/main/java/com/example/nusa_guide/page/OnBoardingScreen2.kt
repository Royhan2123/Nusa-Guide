package com.example.nusa_guide.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray700
import com.example.nusa_guide.ui.theme.white
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.pager.HorizontalPager
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen2(navController: NavController) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    val titleUser = listOf(
        stringResource(id = R.string.titleUser),
        stringResource(id = R.string.titleTour),
    )
    val deskUser = listOf(
        stringResource(id = R.string.deskUser),
        stringResource(id = R.string.deskTour),
    )

    val imageList = listOf(
        painterResource(id = R.drawable.img_on_boarding1),
        painterResource(id = R.drawable.img_on_boarding2),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalPager(
            count = titleUser.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(25.dp)
            ) {
                Image(
                    painter = imageList[page],
                    contentDescription = null,
                    modifier = Modifier
                        .height(211.dp)
                        .width(165.dp)
                )
                Spacer(modifier = Modifier.height(50.dp))
                Text(
                    text = titleUser[page],
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = gray700
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = deskUser[page],
                    textAlign = TextAlign.Center,
                    color = gray700,
                    fontSize = 17.sp,
                )
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    repeat(titleUser.size) { indicatorPage ->
                        val color =
                            if (pagerState.currentPage == indicatorPage) brandPrimary500 else Color.Gray
                        Box(
                            modifier = Modifier
                                .size(18.dp)
                                .padding(4.dp)
                                .background(color, shape = CircleShape)
                        )
                    }
                }
            }
        }
        ElevatedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.elevatedButtonColors(
                brandPrimary500
            ),
            shape = RoundedCornerShape(
                size = 8.dp
            )
        ) {
            Text(
                text = "Pengguna",
                color = white,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        ElevatedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .border(
                    width = 2.dp,
                    color = brandPrimary500,
                    shape = RoundedCornerShape(
                        size = 8.dp
                    )
                ),
            colors = ButtonDefaults.elevatedButtonColors(
                white
            ),
            shape = RoundedCornerShape(
                size = 8.dp
            )
        ) {
            Text(
                text = "Tour Guide",
                color = brandPrimary500,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

    LaunchedEffect(pagerState.currentPage) {
        if (pagerState.currentPage < titleUser.size - 1) {
            delay(3000L)
            coroutineScope.launch {
                pagerState.animateScrollToPage(pagerState.currentPage + 1)
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewOnBoardingScreen2() {
    OnBoardingScreen2(navController = rememberNavController())
}