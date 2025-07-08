package com.example.caffeine.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.Urbanist

@Composable
fun CustomizationScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomTopAppBar("Latte")

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Milk",
                style = TextStyle(
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color(0x99000000),
                    letterSpacing = 0.25.sp,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Composable
fun CustomTopAppBar(
    caffeineType: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier
                .size(48.dp),
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Color(0xFFF5F5F5)
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.arrow_left),
                contentDescription = null
            )
        }
        Text(
            text = caffeineType,
            modifier = Modifier
                .padding(start = 12.dp),
            style = TextStyle(
                fontFamily = Urbanist,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color(0xDE1F1F1F),
                letterSpacing = 0.25.sp
            )
        )

    }
}

@Preview(showBackground = true)
@Composable
fun CustomPrev() {
    CustomizationScreen()
}