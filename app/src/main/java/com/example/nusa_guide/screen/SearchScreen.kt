package com.example.nusa_guide.screen

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.ui.theme.black51
import com.example.nusa_guide.ui.theme.gray
import com.example.nusa_guide.viewModel.SearchLazyColumn
import com.example.nusa_guide.viewModel.SearchViewModel

@Composable
fun SearchScreen(navController: NavController) {
    val viewModel = viewModel<SearchViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val products by viewModel.products.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
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
            OutlinedTextField(
                value = searchText,
                onValueChange = viewModel::onSearchTextChange,
                placeholder = {
                    Text(
                        text = "Bedugul",
                        fontSize = 15.sp,
                        color = gray
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .height(53.dp)
                    .width(259.dp),
                textStyle = TextStyle(
                    color = black51,
                    fontSize = 14.sp,
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "icon-back",
                        modifier = Modifier.size(24.dp),
                        tint = gray
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = black51,
                    unfocusedBorderColor = gray
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text
                )
            )
            Icon(
                painter = painterResource(id = R.drawable.icon_filtering),
                contentDescription = "icon-filtering",
                modifier = Modifier.size(22.dp),
                tint = black51,
            )
        }
        Spacer(modifier = Modifier.height(50.dp))

        if (isSearching) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        } else {
            SearchLazyColumn(items = products)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSearchScreen() {
    SearchScreen(navController = rememberNavController())
}