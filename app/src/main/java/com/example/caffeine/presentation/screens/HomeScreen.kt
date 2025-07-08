package com.example.caffeine.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.example.caffeine.R
import com.example.caffeine.domain.entity.Caffeine
import com.example.caffeine.presentation.components.CaffeineButton
import com.example.caffeine.presentation.components.HomeTopAppBar
import com.example.caffeine.ui.theme.Urbanist
import kotlin.math.absoluteValue

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val caffeineList = listOf(
                Caffeine("Espresso", painterResource(id = R.drawable.espresso)),
                Caffeine("Macchiato", painterResource(id = R.drawable.macchiato)),
                Caffeine("Latte", painterResource(id = R.drawable.latte)),
                Caffeine("Black", painterResource(id = R.drawable.black)),
            )
            val pagerState = rememberPagerState(
                initialPage = 1,
                pageCount = { caffeineList.size }
            )

            HomeTopAppBar()
            Text(
                text = "Good Morning",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 16.dp, top = 16.dp),
                style = TextStyle(
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.Bold,
                    fontSize = 36.sp,
                    color = Color(0xFFB3B3B3),
                    lineHeight = 50.sp,
                    letterSpacing = 0.25.sp
                )
            )
            Text(
                text = "Karim ☀",
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(Alignment.Start),
                style = TextStyle(
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.Bold,
                    fontSize = 36.sp,
                    color = Color(0xFF1F1F1F),
                    lineHeight = 50.sp,
                    letterSpacing = 0.25.sp
                )
            )
            Text(
                text = "What would you like to drink today?",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 16.dp, top = 4.dp),
                style = TextStyle(
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color(0xCC1F1F1F),
                    letterSpacing = 0.25.sp
                )
            )

            HorizontalPager(
                contentPadding = PaddingValues(horizontal = 85.dp , vertical = 16.dp), // Added to center the current page
                state = pagerState,
                modifier = Modifier.align(Alignment.CenterHorizontally).weight(1f)
            ) { page ->

                val pageOffset = (pagerState.currentPage - page) + pagerState
                    .currentPageOffsetFraction

                val scaleFactor = lerp(
                    start = 0.8f,
                    stop = 1.2f,
                    fraction = 1f - pageOffset.absoluteValue.coerceIn(0f, 1f)
                )

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = caffeineList[page].cupImg,
                        modifier = Modifier
                            .size(height = 244.dp, width = 194.dp)
                            .fillMaxWidth()
                            .graphicsLayer {
                                scaleX = scaleFactor
                                scaleY = scaleFactor
                                transformOrigin = TransformOrigin(0.5f,1f)
                            },
                        contentDescription = null,
                    )
                    Text(
                        text = caffeineList[page].type,
                        modifier = Modifier.padding(top = 16.dp),
                        style = TextStyle(
                            fontFamily = Urbanist,
                            fontWeight = FontWeight.Bold,
                            fontSize = 32.sp,
                            color = Color(0xFF1F1F1F),
                            letterSpacing = 0.25.sp
                        )
                    )
                }
            }
        }

        CaffeineButton(
            onClick = {},
            text = "Continue",
            painter = painterResource(id = R.drawable.arrow),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 32.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}