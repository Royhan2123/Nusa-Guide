package com.example.nusa_guide.viewModel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nusa_guide.R
import com.example.nusa_guide.ui.theme.brandPrimary500
import com.example.nusa_guide.ui.theme.gray
import com.example.nusa_guide.ui.theme.gray700

data class SearchItemList(
    val image: Int,
    val nameTour: String,
    val detail1: String,
    val detail2: String,
    val detail3: String,
    val detail4: String,
    val hargaTour: String,
    val hargaAsli: String,
    val diskon: String,
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "$image",
            nameTour,
            detail1,
            detail2,
            detail3,
            detail4,
            hargaTour,
            diskon,
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}

@Composable
fun SearchLazyColumn(items: List<SearchItemList>) {
    LazyColumn {
        items(items) { item ->
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 14.dp, bottom = 14.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = item.image),
                        contentDescription = null,
                        modifier = Modifier
                            .height(120.dp)
                            .width(110.dp)
                            .clip(shape = RoundedCornerShape(4.dp))
                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 18.dp)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = item.nameTour,
                            fontSize = 17.sp,
                            color = gray700,
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row {
                            Icon(
                                modifier = Modifier.size(16.dp),
                                painter = painterResource(id = R.drawable.icon_right_arrow),
                                contentDescription = "icon-right",
                                tint = brandPrimary500

                            )
                            Spacer(modifier = Modifier.padding(end = 6.dp))
                            Text(
                                text = item.detail1,
                                fontSize = 13.sp,
                                color = gray700
                            )
                        }
                        Row {
                            Icon(
                                modifier = Modifier.size(16.dp),
                                painter = painterResource(id = R.drawable.icon_right_arrow),
                                contentDescription = "icon-right",
                                tint = brandPrimary500
                            )
                            Spacer(modifier = Modifier.padding(end = 6.dp))
                            Text(
                                text = item.detail2,
                                fontSize = 13.sp,
                                color = gray700
                            )
                        }
                        Row {
                            Icon(
                                modifier = Modifier.size(16.dp),
                                painter = painterResource(id = R.drawable.icon_right_arrow),
                                contentDescription = "icon-right",
                                tint = brandPrimary500

                            )
                            Spacer(modifier = Modifier.padding(end = 6.dp))
                            Text(
                                text = item.detail3,
                                fontSize = 13.sp,
                                color = gray700
                            )
                        }
                        Row {
                            Icon(
                                modifier = Modifier.size(16.dp),
                                painter = painterResource(id = R.drawable.icon_right_arrow),
                                contentDescription = "icon-right",
                                tint = brandPrimary500

                            )
                            Spacer(modifier = Modifier.padding(end = 6.dp))
                            Text(
                                text = item.detail4,
                                fontSize = 13.sp,
                                color = gray700
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Rp. ${item.hargaTour}",
                        color = brandPrimary500,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Rp. ${item.hargaAsli}",
                        color = gray,
                        fontSize = 16.sp,
                        textDecoration = TextDecoration.LineThrough
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Surface (
                        modifier = Modifier
                            .width(70.dp)
                            .height(22.dp),
                        color = Color(0XFFFBD5D5),
                        shape = RoundedCornerShape(
                            size = 6.dp
                        )
                    ) {
                        Text(
                            text = item.diskon,
                            color = Color.Red,
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
            HorizontalDivider(thickness = 1.dp, color = gray)
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewLazyColumn() {
    val items = listOf(
        SearchItemList(
            nameTour = "Paket Tour Bali 1 Bedugul",
            image = R.drawable.image_begudul,
            detail1 = "Pura Ulun Danu Beratan",
            detail2 = "Agrowisata Kopi Luwak",
            detail3 = "Cocoa Land",
            detail4 = "Pura Tanah Lot",
            hargaTour = "535.000",
            diskon = "25%",
            hargaAsli = "600.000"
        ),
        SearchItemList(
            nameTour = "Paket Tour Bali 1 Bedugul",
            image = R.drawable.image_begudul,
            detail1 = "Pura Ulun Danu Beratan",
            detail2 = "Agrowisata Kopi Luwak",
            detail3 = "Cocoa Land",
            detail4 = "Pura Tanah Lot",
            hargaTour = "535.000",
            diskon = "25%",
            hargaAsli = "600.000"

        ),
        SearchItemList(
            nameTour = "Paket Tour Bali 1 Bedugul",
            image = R.drawable.image_begudul,
            detail1 = "Pura Ulun Danu Beratan",
            detail2 = "Agrowisata Kopi Luwak",
            detail3 = "Cocoa Land",
            detail4 = "Pura Tanah Lot",
            hargaTour = "535.000",
            diskon = "25%",
            hargaAsli = "600.000"

        ),
        SearchItemList(
            nameTour = "Paket Tour Bali 1 Bedugul",
            image = R.drawable.image_begudul,
            detail1 = "Pura Ulun Danu Beratan",
            detail2 = "Agrowisata Kopi Luwak",
            detail3 = "Cocoa Land",
            detail4 = "Pura Tanah Lot",
            hargaTour = "535.000",
            diskon = "25%",
            hargaAsli = "600.000"

        )
    )
    SearchLazyColumn(items = items)
}